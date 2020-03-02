package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
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

public class Medic extends ActivatablePowerHero{

	public Medic(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	public void move(Direction r) throws UnallowedMovementException, OccupiedCellException, WrongTurnException {
		if(getOwner().equals(getGame().getCurrentPlayer())) {
			switch (r) {
			   case DOWN: super.moveDown(); break;
			   case LEFT: super.moveLeft(); break;
			   case RIGHT: super.moveRight(); break;
			   case UP: super.moveUp(); break;
			   default: throw new UnallowedMovementException("Invalid Movement",this, r);
			}
			getGame().checkWinner();
			getGame().switchTurns();
			}
			else
				throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
		
	}
	
	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, OccupiedCellException, InvalidPowerUseException{
		if(!getOwner().equals(getGame().getCurrentPlayer())) 
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
		if(!target.getOwner().equals(getGame().getCurrentPlayer())) 
			throw new InvalidPowerTargetException("Can not resurrect enemy piece", this, target);
	    if (powerUsed) 
	    	   throw new PowerAlreadyUsedException("Already used its powers", this);
	    	resurrect(target);
	    switch(d){
	       case UP: resurrectUp(target); break;
	       case DOWN: resurrectDown(target); break;
	       case LEFT: resurrectLeft(target); break;
	       case RIGHT: resurrectRight(target); break;
	       case UPLEFT: resurrectUpLeft(target); break;
	       case DOWNLEFT: resurrectDownLeft(target); break;
	       case UPRIGHT: resurrectUpRight(target); break;
	       case DOWNRIGHT: resurrectDownRight(target); break;
	       default: throw new InvalidPowerDirectionException(this, d);
	    }
	    if(target instanceof ActivatablePowerHero)
	        	  ((ActivatablePowerHero) target).setPowerUsed(false);
	    if(target instanceof Armored)
	        	  ((Armored) target).setArmorUp(true);
		super.usePower(d,target, null);
	}
    
	public void resurrect(Piece target) throws InvalidPowerTargetException {
        if(getGame().getCurrentPlayer().getDeadCharacters().contains(target))
     	     getGame().getCurrentPlayer().getDeadCharacters().remove(getGame().getCurrentPlayer().getDeadCharacters().indexOf(target));      
        else throw new InvalidPowerTargetException("Can not resurrect alive piece.", this, target);
    }
	public void placer(int i, int j , Piece target) throws InvalidPowerTargetException {
		if(getGame().getCellAt(i, j).isEmpty())
			getGame().place(i, j, target);
		else
			throw new InvalidPowerTargetException("Cannot resurrect in occupied cell.", this, target);
	}
	    public void resurrectDownRight(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if((i==6)&&(j==5))
				placer(0,0,target);
			else if((i==6)&&(j!=5))
				placer(0,++j,target);
			else if((i!=6)&&(j==5))
				placer(++i,0,target);
			else 
				placer(++i,++j,target);
	}

		public void resurrectUpRight(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if((i==0)&&(j==5))
				placer(6,0,target);
			else if((i==0)&&(j!=5))
				placer(6,++j,target);
			else if((i!=0)&&(j==5))
				placer(--i,0,target);
			else 
				placer(--i,++j,target);
	}

		public void resurrectDownLeft(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if((i==6)&&(j==0))
				placer(0,5,target);
			else if((i==6)&&(j!=0))
				placer(0,--j,target);
			else if((i!=0)&&(j==0))
				placer(++i,5,target);
			else 
				placer(++i,--j,target);
	}

		public void resurrectUpLeft(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if((i==0)&&(j==0))
				placer(6,5,target);
			else if((i==0)&&(j!=0))
				placer(6,--j,target);
			else if((i!=0)&&(j==0))
				placer(--i,5,target);
			else 
				placer(--i,--j,target);
				
	}

		public void resurrectRight(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if(j==5)
				placer(i,0,target);
			else
				placer(i,++j,target);
	}

		public void resurrectLeft(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if(j==0)
				placer(i,5,target);
			else
				placer(i,--j,target);
	}

		public void resurrectDown(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if(i==6)
				placer(0,j,target);
			else
				placer(++i,j,target);
	}

		public void resurrectUp(Piece target) throws InvalidPowerTargetException {
			int i = getPosI();
			int j = getPosJ();
			if(i==0)
				placer(6,j,target);
			else
				placer(--i,j,target);
		
	}
		



}
