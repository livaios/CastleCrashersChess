package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import exceptions.InvalidMovementException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import view.Cells;
import view.DedIcon;
import view.ExceptionFrame;
import view.GameBoard;
import view.GameWindow;
import view.Winner;

public class MoveController implements ActionListener, KeyListener {
	private Cells cell;
	private GameWindow game;
	private Boolean useMove = true;
	private static Piece revive;
	private static Tech tech;
	private static Boolean flagTech = false;
	private static Piece currentPiece;
	private static Boolean flagLocation = false;
	private static Point location;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_S) {
			useMove = !useMove;
		}
		else {
			if (useMove) {
				if (!(currentPiece == null)) {
					if (e.getKeyCode() == KeyEvent.VK_Q) {
						try {
							currentPiece.move(Direction.UPLEFT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();
						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_W) {
						try {
							currentPiece.move(Direction.UP);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_E) {
						try {
							currentPiece.move(Direction.UPRIGHT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_A) {
						try {
							currentPiece.move(Direction.LEFT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_D) {
						try {
							currentPiece.move(Direction.RIGHT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_Z) {
						try {
							currentPiece.move(Direction.DOWNLEFT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_X) {
						try {
							currentPiece.move(Direction.DOWN);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (e.getKeyCode() == KeyEvent.VK_C) {
						try {
							currentPiece.move(Direction.DOWNRIGHT);
							((GameBoard) cell.getParent()).updateCells();
							game.updateData();

						} catch (InvalidMovementException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					}
				}
			} else if (!useMove) {
				if (flagTech) {
					if (currentPiece != null) {
						if (!flagLocation) {
							try {
								tech.usePower(null, currentPiece, null);
								flagTech = false;
							} catch (OccupiedCellException | InvalidPowerUseException | WrongTurnException e1) {
								new ExceptionFrame(e1.getMessage());
							}
						}
					} else if (flagLocation) {
						try {
							tech.usePower(null, currentPiece, location);
							flagTech = false;
							flagLocation = false;
						} catch (OccupiedCellException | InvalidPowerUseException | WrongTurnException e1) {
							// TODO Auto-generated catch block
							new ExceptionFrame(e1.getMessage());
						}
					} else if (currentPiece == null) {
						location = new Point(cell.getI(), cell.getJ());
						flagLocation = true;
					}

				} else if (!flagTech) {
					Piece hero = currentPiece;
					if (hero instanceof ActivatablePowerHero) {
						ActivatablePowerHero p = (ActivatablePowerHero) currentPiece;
						if ((p instanceof Ranged) || (p instanceof Super)) {
							if (e.getKeyCode() == KeyEvent.VK_Q) {
								try {
									p.usePower(Direction.UPLEFT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();

								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}
							} else if (e.getKeyCode() == KeyEvent.VK_W) {
								try {
									p.usePower(Direction.UP, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();

								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}

							} else if (e.getKeyCode() == KeyEvent.VK_E) {
								try {
									p.usePower(Direction.UPRIGHT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();

								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}

							} else if (e.getKeyCode() == KeyEvent.VK_A) {
								try {
									p.usePower(Direction.LEFT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();

								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}

							} else if (e.getKeyCode() == KeyEvent.VK_D) {
								try {
									p.usePower(Direction.RIGHT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();
								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}

							} else if (e.getKeyCode() == KeyEvent.VK_D) {
								try {
									p.usePower(Direction.RIGHT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();
								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}
							} else if (e.getKeyCode() == KeyEvent.VK_Z) {
								try {
									p.usePower(Direction.DOWNLEFT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();

								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}
							} else if (e.getKeyCode() == KeyEvent.VK_X) {
								try {
									p.usePower(Direction.DOWN, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();
								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}
							} else if (e.getKeyCode() == KeyEvent.VK_C) {
								try {
									p.usePower(Direction.DOWNRIGHT, null, null);
									((GameBoard) cell.getParent()).updateCells();
									game.updateData();
								} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
									new ExceptionFrame(e1.getMessage());
								}
							}
						} else if (p instanceof Medic) {
							if (revive != null) {
								if (e.getKeyCode() == KeyEvent.VK_Q) {
									try {
										p.usePower(Direction.UPLEFT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;

									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}
								} else if (e.getKeyCode() == KeyEvent.VK_W) {
									try {
										p.usePower(Direction.UP, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;

									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}

								} else if (e.getKeyCode() == KeyEvent.VK_E) {
									try {
										p.usePower(Direction.UPRIGHT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;

									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}

								} else if (e.getKeyCode() == KeyEvent.VK_A) {
									try {
										p.usePower(Direction.LEFT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;

									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}

								} else if (e.getKeyCode() == KeyEvent.VK_D) {
									try {
										p.usePower(Direction.RIGHT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;
									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}

								} else if (e.getKeyCode() == KeyEvent.VK_D) {
									try {
										p.usePower(Direction.RIGHT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;

									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}
								} else if (e.getKeyCode() == KeyEvent.VK_Z) {
									try {
										p.usePower(Direction.DOWNLEFT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;
									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}
								} else if (e.getKeyCode() == KeyEvent.VK_X) {
									try {
										p.usePower(Direction.DOWN, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;
									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}
								} else if (e.getKeyCode() == KeyEvent.VK_C) {
									try {
										p.usePower(Direction.DOWNRIGHT, revive, null);
										((GameBoard) cell.getParent()).updateCells();
										game.updateData();
										revive = null;
									} catch (OccupiedCellException | WrongTurnException | InvalidPowerUseException e1) {
										new ExceptionFrame(e1.getMessage());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof Cells) {
			cell = (Cells) e.getSource();
			currentPiece = cell.getPiece();
			game = (GameWindow) SwingUtilities.getRoot((Component) e.getSource());
			if (((Cells) e.getSource()).getPiece() instanceof Tech) {
				tech = (Tech) ((Cells) e.getSource()).getPiece();
				flagTech = true;
			}
		} else if (e.getSource() instanceof DedIcon) {
			revive = ((DedIcon) e.getSource()).getPiece();
		}
		NewWindow();
	}

	public void NewWindow() {
		Player pi = cell.checkWin();
		if (pi != null) {
			new Winner(pi);
			game.dispose();
		}

	}
}
