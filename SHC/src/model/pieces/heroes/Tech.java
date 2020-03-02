package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidMovementException;
import exceptions.InvalidPowerTargetException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Tech extends ActivatablePowerHero{

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	public void move(Direction r) throws InvalidMovementException, WrongTurnException{
		if(getOwner().equals(getGame().getCurrentPlayer())) {
		switch (r) {
		   case DOWNLEFT: moveDownLeft(); break;
		   case DOWNRIGHT: moveDownRight(); break;
		   case UPLEFT: moveUpLeft(); break;
		   case UPRIGHT:moveUpRight(); break;
		   default: throw new UnallowedMovementException("This movement is not allowed by the game rules.",this, r);
		}
		getGame().checkWinner();
		getGame().switchTurns();
		}
		else
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
	
	}
	public void usePower(Direction d,Piece target, Point point) throws PowerAlreadyUsedException, InvalidPowerUseException, InvalidPowerTargetException, WrongTurnException, OccupiedCellException {
	  if(getOwner().equals(getGame().getCurrentPlayer())) {	
	     if(!powerUsed) {
	    	   if((point!=null)&&(target.getOwner().equals(getOwner())))
	    		   Teleport(target,point);
	    	   else if((point==null)&&(target.getOwner().equals(getOwner())))
	    		   Unhack(target);
	    	   else if((point==null)&&(!target.getOwner().equals(getOwner())))
	    		   Hack(target);
	    	   else
	    		   throw new InvalidPowerTargetException("The target piece doesn’t belong to the same team cannot be teleported",this, target);
	      }
	     
	  else if(powerUsed)
		   throw new PowerAlreadyUsedException(this);
      }
	  else if(!getOwner().equals(getGame().getCurrentPlayer()))
		  throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
	  super.usePower(null, target , point);
	}
	
    public void Hack(Piece piece) throws InvalidPowerTargetException {
		if(piece.getOwner().equals(getGame().getCurrentPlayer())) 
		       throw new InvalidPowerTargetException("Cannot hack your own pieces.",this, piece);
		else if(piece instanceof NonActivatablePowerHero) { 
		    	 	if(piece instanceof Armored) {
		    	 		if (((Armored)piece).isArmorUp()) 
		    	 			((Armored)piece).setArmorUp(false);
		    	 		else 
		    	 			throw new InvalidPowerTargetException("The enemy has already used its power and cannot be hacked.", this, piece);
		    	 	}
		    	 	else
		              throw new InvalidPowerTargetException("The enemy speedster cannot be hacked",this, piece);
		     }
		     else if(((ActivatablePowerHero) piece).isPowerUsed()) 
		              throw new InvalidPowerTargetException("The enemy has already used its power and cannot be hacked.",this, piece);
		     else 
		       ((ActivatablePowerHero) piece).setPowerUsed(true);
		}
    
	public void Teleport(Piece piece, Point point) throws InvalidPowerTargetException {
		int initI = piece.getPosI();
		int initJ = piece.getPosJ();
		if(piece.getOwner().equals(getGame().getCurrentPlayer())) {
		      if(!getGame().getCellAt(point.x, point.y).isEmpty()) 
		           throw new InvalidPowerTargetException("The target location is occupied.",this, piece);
		      else {
		           getGame().place(point.x, point.y, piece);
		           getGame().getCellAt(initI,initJ).setPiece(null);
		           }
		      }
		else
			throw new InvalidPowerTargetException("The target piece doesn’t belong to the same team cannot be teleported",this, piece);
		}
	
	public void Unhack(Piece piece) throws InvalidPowerTargetException{
		if(!piece.getOwner().equals(getGame().getCurrentPlayer())) 
		        throw new InvalidPowerTargetException("Cannot restore powers of an enemy piece.",this, piece);
		else {
		     if(piece instanceof NonActivatablePowerHero) {
		    	     if(piece instanceof Armored) {
		    	 		   if (!((Armored)piece).isArmorUp()) 
		    	 			   ((Armored)piece).setArmorUp(true);
		    	 		   else 
		    	 			  throw new InvalidPowerTargetException("The target piece did not use its power yet.", this, piece);
		    	 	}
		    	     else     
		              throw new InvalidPowerTargetException("Speedster's powers cannot be restored.",this, piece);
		}
		else if(!((ActivatablePowerHero) piece).isPowerUsed()) 
		     throw new InvalidPowerTargetException("The target piece did not use its power yet.",this, piece);
		else 
		((ActivatablePowerHero) piece).setPowerUsed(false);
		 }
	}


}
