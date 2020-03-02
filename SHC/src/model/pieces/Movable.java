package model.pieces;

import exceptions.InvalidMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;

public interface Movable {
	public void move (Direction r)throws InvalidMovementException, WrongTurnException;
	
}
