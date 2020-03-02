package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

abstract public class ActivatablePowerHero extends Hero{

	boolean powerUsed;
	
	public ActivatablePowerHero(Player player, Game game, String name) {
		super(player, game, name);
	}
	
	public ActivatablePowerHero() {
		super();
	}

	public boolean isPowerUsed() {
		return powerUsed;
	}

	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}
	
	public void usePower(Direction d, Piece target, Point newPos) throws InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException, OccupiedCellException, InvalidPowerUseException{
		setPowerUsed(true);
		if (!(this instanceof Tech)) {
			getGame().checkWinner();
			getGame().switchTurns();
		}
				
	}
	


}
