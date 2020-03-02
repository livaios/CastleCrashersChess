package model.pieces.sidekicks;

import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;

public class SideKickP2 extends SideKick{

	public SideKickP2(Game game, String name) {
		super(game.getPlayer2(), game, name);
		// TODO Auto-generated constructor stub
	}
	public void move(Direction r) throws InvalidMovementException, WrongTurnException,OccupiedCellException{
		if(getOwner().equals(getGame().getCurrentPlayer())) {
		switch (r) {
		   case DOWN: moveDown(); break;
		   case DOWNLEFT: moveDownLeft(); break;
		   case DOWNRIGHT: moveDownRight(); break;
		   case LEFT: moveLeft(); break;
		   case RIGHT: moveRight(); break;
		   default: throw new UnallowedMovementException("Invalid Movement",this, r);
		}

		getGame().checkWinner();
		getGame().switchTurns();
		}
		else
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
		
	}

}
