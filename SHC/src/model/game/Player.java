package model.game;

import java.util.*;

import model.pieces.Piece;

public class Player {
	
	private String name;
	private int  payloadPos;
	private int sideKilled; 
	private ArrayList<Piece> deadCharacters; 
	
	public Player(String name) {
		this.name = name;
		deadCharacters = new ArrayList<Piece>();
	}

	public String getName() {
		return name;
	}

	public int getPayloadPos() {
		return payloadPos;
	}
	
	public void setPayloadPos(int payloadPos) {
		this.payloadPos = payloadPos;
	}
	
	public int getSideKilled() {
		return sideKilled;
	}
	
	public void setSideKilled(int sideKilled) {
		this.sideKilled = sideKilled;
	}
	
	public ArrayList<Piece> getDeadCharacters() {
		return deadCharacters;
	}

}
