package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import exceptions.InvalidMovementException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import view.Cells;
import view.GameBoard;
import view.GameWindow;

public class PowerController implements ActionListener, KeyListener {
	Cells cell;
	GameWindow game;

	PowerController(Cells cell, GameWindow game) {
		this.cell = cell;
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ActivatablePowerHero p = (ActivatablePowerHero) cell.getPiece();
		if ((p instanceof Ranged) || (p instanceof Super)) {
			if (e.getKeyCode() == KeyEvent.VK_Q) {
				try {
					p.usePower(Direction.UPLEFT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} else if (e.getKeyCode() == KeyEvent.VK_W) {
				try {
					p.usePower(Direction.UP, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			} else if (e.getKeyCode() == KeyEvent.VK_E) {
				try {
					p.usePower(Direction.UPRIGHT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				try {
					p.usePower(Direction.LEFT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				try {
					p.usePower(Direction.RIGHT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				try {
					p.usePower(Direction.RIGHT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} else if (e.getKeyCode() == KeyEvent.VK_Z) {
				try {
					p.usePower(Direction.DOWNLEFT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} else if (e.getKeyCode() == KeyEvent.VK_X) {
				try {
					p.usePower(Direction.DOWN, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} else if (e.getKeyCode() == KeyEvent.VK_C) {
				try {
					p.usePower(Direction.DOWNRIGHT, null, null);
					((GameBoard) cell.getParent()).updateCells();
					game.updateData();
				} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
		else if(p instanceof Medic) {
			
		}
		else if (p instanceof Tech) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
