package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Super extends ActivatablePowerHero{

	public Super(Player player, Game game, String name) {
		super(player, game, name);
	}
	public void usePower(Direction d,Piece target,Point newPos) throws WrongTurnException, OccupiedCellException, InvalidPowerUseException{
		if(getOwner().equals(getGame().getCurrentPlayer())) {
		if(!powerUsed) {
			switch(d) {
			case UP: SmashUp();break;
			case DOWN: SmashDown();break;
			case LEFT: SmashLeft();break;
			case RIGHT: SmashRight(); break;
			default: throw new InvalidPowerDirectionException("This direction is not allowed by the game rules.",this, d);
			}
			super.usePower(d, null, null);
			
		}
		else 
			throw new PowerAlreadyUsedException("Already used powers",this);
		}
		else if(!getOwner().equals(getGame().getCurrentPlayer()))
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
		
	}

	public void SmashUp() throws OccupiedCellException {
		int i = getPosI() -1;
		if(i<0)
			return;
		if((!getGame().getCellAt(i,getPosJ()).isEmpty())&&(!getOwner().equals(getGame().getCellAt(i,getPosJ()).getPiece().getOwner())))
		                               attack(getGame().getCellAt(i,getPosJ()).getPiece());
		i--;
		if(i<0)
			return;
		if((!getGame().getCellAt(i,getPosJ()).isEmpty())&&(!getOwner().equals(getGame().getCellAt(i,getPosJ()).getPiece().getOwner())))
		                               attack(getGame().getCellAt(i,getPosJ()).getPiece());
	}
	
	public void SmashDown() throws OccupiedCellException {
		int i = getPosI() +1;
		if (i>6)
			return;
		if((!getGame().getCellAt(i,getPosJ()).isEmpty())&&(!getOwner().equals(getGame().getCellAt(i,getPosJ()).getPiece().getOwner())))
		         attack(getGame().getCellAt(i,getPosJ()).getPiece());
		i++;
		if (i>6)
			return;
		if((!getGame().getCellAt(i,getPosJ()).isEmpty())&&(!getOwner().equals(getGame().getCellAt(i,getPosJ()).getPiece().getOwner())))
		         attack(getGame().getCellAt(i,getPosJ()).getPiece());
	}
	
	public void SmashLeft() throws OccupiedCellException {
		int j = getPosJ()-1;
		if(j<0)
			return;
		if((!getGame().getCellAt(getPosI(),j).isEmpty())&&(!getOwner().equals(getGame().getCellAt(getPosI(),j).getPiece().getOwner())))
		            attack(getGame().getCellAt(getPosI(),j).getPiece());
		j--;
		if(j<0)
			return;
		if((!getGame().getCellAt(getPosI(),j).isEmpty())&&(!getOwner().equals(getGame().getCellAt(getPosI(),j).getPiece().getOwner())))
		            attack(getGame().getCellAt(getPosI(),j).getPiece());
	}
	
	public void SmashRight() throws OccupiedCellException {
		int j = getPosJ() +1;
		if(j>5)
			return;
		if((!getGame().getCellAt(getPosI(),j).isEmpty())&&(!getOwner().equals(getGame().getCellAt(getPosI(),j).getPiece().getOwner())))
		                         attack(getGame().getCellAt(getPosI(),j).getPiece());
		j++;
		if(j>5)
			return;
		if((!getGame().getCellAt(getPosI(),j).isEmpty())&&(!getOwner().equals(getGame().getCellAt(getPosI(),j).getPiece().getOwner())))
		                         attack(getGame().getCellAt(getPosI(),j).getPiece());
	}
	 
	public void move(Direction r) throws UnallowedMovementException, OccupiedCellException, WrongTurnException {
		if(getOwner().equals(getGame().getCurrentPlayer())) {
			switch (r) {
			   case DOWN: super.moveDown(); break;
			   case LEFT: super.moveLeft(); break;
			   case RIGHT: super.moveRight(); break;
			   case UP: super.moveUp(); break;
			   default: throw new UnallowedMovementException("This movement is not allowed by the game rules",this, r);
			}
			getGame().checkWinner();
			getGame().switchTurns();
			}
			else
				throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
		
	}

}
