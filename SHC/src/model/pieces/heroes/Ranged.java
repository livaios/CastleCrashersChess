package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
		super(player, game, name);
	}

	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, OccupiedCellException, InvalidPowerUseException {
		if (this.getOwner().equals(getGame().getCurrentPlayer())) {
			if (!powerUsed) {
				switch (d) {
				case UP: ShootUp(); break;
				case DOWN: ShootDown(); break;
				case LEFT: ShootLeft(); break;
				case RIGHT: ShootRight(); break;
				default: throw new InvalidPowerDirectionException("Ranged is not allowed to fire in this direction", this, d);
				}
				super.usePower(d, target, newPos);
			} else
				throw new PowerAlreadyUsedException(this);
		} else
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
	}

	public void ShootUp() throws InvalidPowerDirectionException {
		if (getPosI() == 0)
			throw new InvalidPowerDirectionException("You are hitting a wall.", this, Direction.UP);
		else {
			for (int i = getPosI() - 1; i >= 0; i--) {
				if (!getGame().getCellAt(i, getPosJ()).isEmpty()) {
					if ((getGame().getCellAt(i, getPosJ()).getPiece().getOwner()).equals(getGame().getCurrentPlayer()))
						throw new InvalidPowerDirectionException(
								"This direction will result in hitting a friendly piece.", this, Direction.UP);
					else {
						attack(getGame().getCellAt(i, getPosJ()).getPiece());
						return;
					}
				}
			}
			throw new InvalidPowerDirectionException("This direction will result in hitting no enemies.", this,
					Direction.UP);
		}
	}

	public void ShootDown() throws InvalidPowerDirectionException {
		if (getPosI() == 6)
			throw new InvalidPowerDirectionException("You are hitting a wall.", this, Direction.DOWN);
		else {
			for (int i = getPosI() + 1; i <= 6; i++) {
				if (!getGame().getCellAt(i, getPosJ()).isEmpty()) {
					if ((getGame().getCellAt(i, getPosJ()).getPiece().getOwner()).equals(getGame().getCurrentPlayer()))
						throw new InvalidPowerDirectionException(
								"This direction will result in hitting a friendly piece.", this, Direction.DOWN);
					else if (!getGame().getCellAt(i, getPosJ()).getPiece().getOwner()
							.equals(getGame().getCurrentPlayer())) {
						attack(getGame().getCellAt(i, getPosJ()).getPiece());
						return;
					}
				}
			}
			throw new InvalidPowerDirectionException("This direction will result in hitting no enemies.", this,
					Direction.DOWN);
		}
	}

	public void ShootLeft() throws InvalidPowerDirectionException {
		if (getPosJ() == 0)
			throw new InvalidPowerDirectionException("You are hitting a wall.", this, Direction.LEFT);
		else {
			for (int i = getPosJ() - 1; i >= 0; i--) {
				if (!getGame().getCellAt(getPosI(), i).isEmpty()) {
					if ((getGame().getCellAt(getPosI(), i).getPiece().getOwner()).equals(getGame().getCurrentPlayer()))
						throw new InvalidPowerDirectionException(
								"This direction will result in hitting a friendly piece.", this, Direction.LEFT);
					else if (!getGame().getCellAt(getPosI(), i).getPiece().getOwner()
							.equals(getGame().getCurrentPlayer())) {
						attack(getGame().getCellAt(getPosI(), i).getPiece());
						return;
					}
				}
			}
			throw new InvalidPowerDirectionException("This direction will result in hitting no enemies.", this,
					Direction.LEFT);
		}
	}

	public void ShootRight() throws InvalidPowerDirectionException {
		if (getPosJ() == 5)
			throw new InvalidPowerDirectionException("You are hitting a wall.", this, Direction.RIGHT);
		else {
			for (int i = getPosJ() + 1; i <= 5; i++) {
				if (!getGame().getCellAt(getPosI(), i).isEmpty()) {
					if ((getGame().getCellAt(getPosI(), i).getPiece().getOwner()).equals(getGame().getCurrentPlayer()))
						throw new InvalidPowerDirectionException(
								"This direction will result in hitting a friendly piece.", this, Direction.RIGHT);
					else if (!getGame().getCellAt(getPosI(), i).getPiece().getOwner()
							.equals(getGame().getCurrentPlayer()))
						attack(getGame().getCellAt(getPosI(), i).getPiece());
					return;
				}
			}
			throw new InvalidPowerDirectionException("This direction will result in hitting no enemies.", this,
					Direction.RIGHT);
		}
	}

}
