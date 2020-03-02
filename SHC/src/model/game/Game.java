package model.game;

import java.util.Random;

import model.pieces.Piece;
import model.pieces.heroes.*;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Game {
    private final int payloadPosTarget = 6; 
    private final int boardWidth = 6;
    private final int boardHeight = 7; 
	private Player player1; 
	private Player player2;   
	private Player currentPlayer;  
	private Cell[][] board;
    
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board= new Cell[boardHeight][boardWidth];
		this.currentPlayer = player1;
		assemblePieces();
	}

	public int getPayloadPosTarget() {
		return payloadPosTarget;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public String toString() {
		String s = "";
		System.out.println("      " + getPlayer2().getName());
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		for (int i = 0; i < board.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null)
					System.out.print("n ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.print("| ");
		for (int i = 0; i < board[0].length; i++)
			System.out.print("--");
		System.out.println("|");
		System.out.println("    " + getPlayer1().getName());
		return s;
	}
	
	public void assemblePieces() {
		for (int i=0;i<boardHeight;i++) {
		    for (int j=0;j<boardWidth;j++) {
		         board[i][j]=new Cell();
		    }
		}
		
		Hero super1 = new Super(player1,this,"SwampDudeP1");
		Hero speedster1 = new Speedster(player1,this,"YellowDudeP1");
		Hero tech1 = new Tech(player1,this,"KingP1");
		Hero medic1 = new Medic(player1,this,"LoveKnightP1");
		Hero ranged1 = new Ranged(player1,this,"GreyKnightP1");
		Hero armored1 = new Armored(player1,this,"BlackSmithP1");
		   
		Hero super2 = new Super(player2,this,"LinaFavP2");
		Hero speedster2 = new Speedster(player2,this,"RhcpP2");
		Hero tech2 = new Tech(player2,this,"BigBossP2");
		Hero medic2 = new Medic(player2,this,"DedDudeP2");
		Hero ranged2 = new Ranged(player2,this,"IceEvilP2");
		Hero armored2 = new Armored(player2,this,"GreenEvilP2");
		        
		Hero[] Heroes1 = {super1,speedster1,tech1,medic1,ranged1,armored1};
		Hero[] Heroes2 = {super2,speedster2,tech2,medic2,ranged2,armored2};

		generateHeroes(Heroes1);
		generateHeroes(Heroes2);
		        
		SideKickP1[] SK1 = new SideKickP1[boardWidth];
		SideKickP2[] SK2 = new SideKickP2[boardWidth];
		        
		for(int i = 0 ; i<boardWidth ; i++) {
		   SK1[i] = new SideKickP1(this,"BasicLaithyP1");
		   SK2[i] = new SideKickP2(this,"BasicBrownP2");
		}
		        
		for(int j = 0 ; j<boardWidth ; j++) {
		    place(1,j,Heroes2[j]);
		    place(2,j,SK2[j]);
		    place(4,j,SK1[j]);
		    place(5,j,Heroes1[j]);
		}
	}
	
	public void place(int i, int j, Piece piece) {
		piece.setPosI(i);
		piece.setPosJ(j);
		getCellAt(i,j).setPiece(piece);	
	}
	
	public static void generateHeroes(Hero[]Heroes) {
		for (int i = 0; i < Heroes.length; i++) {
			Random randomNum = new Random();
			int n = randomNum.nextInt(Heroes.length);
			Hero tmp = Heroes[i];
			Heroes[i] = Heroes[n];
			Heroes[n] = tmp;
		}
	}

	public Cell getCellAt(int i, int j) {
		return board[i][j];
	}
	
	public void switchTurns() {
		if(currentPlayer.equals(player1))
			currentPlayer = player2;
		else
			currentPlayer = player1;
	}

	public boolean checkWinner() {
		return currentPlayer.getPayloadPos() == payloadPosTarget;
	}
	

}

