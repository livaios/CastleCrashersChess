package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.MoveController;
import model.pieces.Piece;

public class DedIcon extends JButton{
	private ImageIcon icon;
	private Piece piece;
	
	public DedIcon(Piece piece, MoveController m) {
		    this.piece = piece;
			icon = new ImageIcon("art/"+ piece.getName() +".png");
			this.setIcon(icon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.addActionListener(m);
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
