package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.MoveController;
import model.game.Game;
import model.pieces.Piece;

public class GameBoard extends JPanel {
	private Cells[][] cells;
	private Game game;
	private MoveController m;

	public GameBoard(Game game,MoveController m) {
		super();
		this.m = m;
		this.setLayout(new GridLayout(7, 6));
		this.game = game;
		cells = new Cells[7][6];
		setEmptyBoard();
		updateCells();
		this.validate();
	}

	private void setEmptyBoard() {
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 5; j++) {
				cells[i][j] = new Cells(m,i,j);
				this.add(cells[i][j]);
			}
		}
		this.validate();
	}

	public void updateCells() {
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 5; j++) {
				if (!(game.getCellAt(i, j).isEmpty())) {
					Piece p = game.getCellAt(i, j).getPiece();
					cells[i][j].setName(p.getName());
					cells[i][j].setPiece(p);
					cells[i][j].setIcon(new ImageIcon("art/" + p.getName() + ".png"));
					cells[i][j].setToolTipText("<html><p width=\"90\">" + p.getOwner().getName() + "<br>"
							+ cells[i][j].getType(p) + "<br>" + " " + cells[i][j].powerStatus(p) + "</p></html>");
				} else {
					cells[i][j].setPiece(null);
					cells[i][j].setName(null);
					cells[i][j].setIcon(null);
					cells[i][j].setToolTipText(null);
				}
			}
		}
		this.validate();
	}

}
