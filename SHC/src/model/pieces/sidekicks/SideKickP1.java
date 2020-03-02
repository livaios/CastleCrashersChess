package model.pieces.sidekicks;

import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

public class SideKickP1 extends SideKick{

	public SideKickP1(Game game, String name) {
		super(game.getPlayer1(), game, name);
	}
	public void move(Direction r) throws InvalidMovementException, WrongTurnException,OccupiedCellException{
		if(getOwner().equals(getGame().getCurrentPlayer())) {
		switch (r) {
		   case LEFT: moveLeft(); break;
		   case RIGHT: moveRight(); break;
		   case UP: moveUp(); break;
		   case UPLEFT: moveUpLeft(); break;
		   case UPRIGHT:moveUpRight(); break;
		   default: throw new UnallowedMovementException("Invalid Movement",this, r);
		}
		getGame().checkWinner();
		getGame().switchTurns();
		}
		else
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
	
	}

}
