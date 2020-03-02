package model.game;

import model.pieces.Piece;

public class Cell {
	Piece piece;
	
	public Cell() {
		
	}
	
	public Cell(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public boolean isEmpty() {
		return piece==null;
	}
	public String toString() {
		if(piece != null)
			return piece.toString();
		return "_";
		}


}
