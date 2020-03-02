package model.pieces;

import exceptions.InvalidMovementException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.sidekicks.SideKick;

abstract public class Piece implements Movable{
	private String name;
	private Player owner;
	private Game game;
	private int posI;
	private int posJ;
	
	public Piece(Player player,Game game,String name) {
		this.name = name;
		this.owner = player;
		this.game = game;
	}
	
	public Piece() {
		
	}
	
	public String getName() {
		return name;
	}

	public Player getOwner() {
		return owner;
	}

	public Game getGame() {
		return game;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int posI) {
		this.posI = posI;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int posJ) {
		this.posJ = posJ;
	}
	
	public String toString() {
		return name;
	}

	public void increasePayload(Piece target) {
		if(target instanceof SideKick) {
			int sideDed = getOwner().getSideKilled();
			sideDed += 1;
			getOwner().setSideKilled(sideDed);
			if(sideDed%2==0) {
				int payload = owner.getPayloadPos();
				payload+=1;
				owner.setPayloadPos(payload);
			}  
		}
		else if(target instanceof Hero) {
			int payload = owner.getPayloadPos();
			payload+=1;
			owner.setPayloadPos(payload);
			
		}
		target.getOwner().getDeadCharacters().add(target);
		game.getCellAt(target.getPosI(),target.getPosJ()).setPiece(null);
	}
	
	public void attack(Piece target) {
		if ((target instanceof Armored) && ((Armored) target).isArmorUp()) 
				((Armored) target).setArmorUp(false);
	    else {
	    	    increasePayload(target);
	    	    game.checkWinner();
	    }
		
	}
	
	public void move(Direction r) throws InvalidMovementException, WrongTurnException, OccupiedCellException{
		if(owner.equals(game.getCurrentPlayer())) {	
		   switch (r) {
		   case DOWN: moveDown(); break;
		   case DOWNLEFT: moveDownLeft(); break;
		   case DOWNRIGHT: moveDownRight(); break;
		   case LEFT: moveLeft(); break;
		   case RIGHT: moveRight(); break;
		   case UP: moveUp(); break;
		   case UPLEFT: moveUpLeft(); break;
		   case UPRIGHT:moveUpRight(); break;
		   default: throw new UnallowedMovementException("This movement is not allowed by the game rules.",this, r);
		   }
		game.checkWinner();
        game.switchTurns();
		}
		else
			throw new WrongTurnException("Its "+ getGame().getCurrentPlayer().getName() + "'s turn.",this);
	}
	
	public void movin(int i,int j,Direction r) throws OccupiedCellException {
		int initI=posI;
		int initJ=posJ;
		if(!game.getCellAt(i, j).isEmpty()){
				if (!game.getCellAt(i, j).getPiece().getOwner().equals(owner)) {
					attack(game.getCellAt(i, j).getPiece());
					if(game.getCellAt(i, j).isEmpty()) {
			        game.place(i, j, game.getCellAt(initI, initJ).getPiece());
			        game.getCellAt(initI, initJ).setPiece(null);
				    }
				}
		        else  
		        	     throw new OccupiedCellException("This cell is occupied.",this,r);
		 }
		else {
            game.place(i, j, this);
            game.getCellAt(initI, initJ).setPiece(null);
            }
		}
		
		         

	
	public void moveDown() throws OccupiedCellException {
		int i=posI;
		int j=posJ;
			if(i==6)
				movin(0,j,Direction.DOWN);
			else
				movin(++i,j,Direction.DOWN);
	}
	
	public void moveDownLeft() throws OccupiedCellException {
	    int i = posI;
		int j = posJ;
		if((i==6)&&(j==0))
			movin(0,5,Direction.DOWNLEFT);
		else if ((i==6)&&(j!=0))
			movin(0,--j,Direction.DOWNLEFT);
		else if ((i!=6)&&(j==0))
			movin(++i,5,Direction.DOWNLEFT);
		else
			movin(++i,--j,Direction.DOWNLEFT);
	}
	
	public void moveDownRight() throws OccupiedCellException{
		int i = posI;
		int j = posJ;
		if((i==6)&&(j==5))
			movin(0,0,Direction.DOWNRIGHT);
		else if ((i==6)&&(j!=5))
			movin(0,++j,Direction.DOWNRIGHT);
		else if ((i!=6)&&(j==5))
			movin(++i,0,Direction.DOWNRIGHT);
		else
			movin(++i,++j,Direction.DOWNRIGHT);
	}
	
	public void moveLeft() throws OccupiedCellException {
		int i = posI;
		int j = posJ;
		if(j==0)
			movin(i,5,Direction.LEFT);
		else
			movin(i,--j,Direction.LEFT);
	}
	
	public void moveRight() throws OccupiedCellException {
		int i = posI;
		int j = posJ;
		if(j==5)
			movin(i,0,Direction.RIGHT);
		else
			movin(i,++j,Direction.RIGHT);
	}
	
	public void moveUp() throws OccupiedCellException {
		int i = this.getPosI();
		int j = this.getPosJ();
		if(i==0)
			movin(6,j,Direction.UP);
		else {
			movin(--i,j,Direction.UP);}
	}
	
	public void moveUpLeft() throws OccupiedCellException {
		int i = posI;
		int j = posJ;
		if((i==0)&&(j==0))
			movin(6,5,Direction.UPLEFT);
		else if((i==0)&&(j!=0))
			movin(6,--j,Direction.UPLEFT);
		else if((i!=0)&&(j==0))
			movin(--i,5,Direction.UPLEFT);
		else 
			movin(--i,--j,Direction.UPLEFT);
	}
	
	public void moveUpRight() throws OccupiedCellException {
		int i = posI;
		int j = posJ;
		if((i==0)&&(j==5))
			movin(6,0,Direction.UPRIGHT);
		else if((i==0)&&(j!=5))
			movin(6,++j,Direction.UPRIGHT);
		else if((i!=0)&&(j==5))
			movin(--i,0,Direction.UPRIGHT);
		else 
			movin(--i,++j,Direction.UPRIGHT);
	}


}
