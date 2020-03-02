package view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import controller.MoveController;
import model.game.Cell;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public class Cells extends JButton {
	private Piece piece;
	private String name;
	private Icon icon;
	private int i;
	private int j;


	public Cells(MoveController m,int i, int j) {
		super();
		this.i=i;
		this.j=j;
		this.setText("");
		this.piece = null;
		this.setPreferredSize(new Dimension(120, 100));
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		this.addActionListener(m);
		this.addKeyListener(m);
		this.validate();

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public Player checkWin() {
		if (piece != null) {
			if (piece.getGame().checkWinner())
				return piece.getGame().getCurrentPlayer();
			else
				return null;
		}
		return null;
	}

	public String getType(Piece p) {
		if (p instanceof Medic) {
			return "Medic";
		} else if (p instanceof Armored) {
			return "Armored";
		} else if (p instanceof Ranged) {
			return "Ranged";
		} else if (p instanceof Super) {
			return "Super";
		} else if (p instanceof Tech) {
			return "Tech";
		} else if (p instanceof Speedster) {
			return "Speedster";
		} else
			return "Sidekick";
	}

	public String powerStatus(Piece p) {
		if (p instanceof Armored) {
			if (((Armored) p).isArmorUp())
				return "Armor Up";
			else
				return "Armor Down";
		} else if (p instanceof ActivatablePowerHero) {
			if (((ActivatablePowerHero) p).isPowerUsed())
				return "Power Used";
			else
				return "Power Not Used";
		} else
			return " ";
	}

	public Piece getPiece() {
		return piece;
	}

	public String getName() {
		return name;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void setName(String name) {
		this.name = name;
	}

}
