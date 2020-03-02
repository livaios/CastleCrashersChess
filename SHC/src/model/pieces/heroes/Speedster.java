package model.pieces.heroes;

import exceptions.OccupiedCellException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero{
	public Speedster() {
		
	}
	
	public Speedster(Player player,Game game,String name) {
		super(player,game,name);
	}
	
	public void moveDown() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if(i==6)
			movin(1,j,Direction.DOWN);
		else if(i==5)
			movin(0,j,Direction.DOWN);
		else {
			i+=2;
			movin(i,j,Direction.DOWN);
		}
		
	}
	
	public void moveDownLeft() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if((i==6)&&(j==0))
			movin(1,4,Direction.DOWNLEFT);
		else if ((i==5)&&(j==1))
			movin(0,5,Direction.DOWNLEFT);
		else if ((i==6)&&(j==1))
			movin(1,5,Direction.DOWNLEFT);
		else if ((i==5)&&(j==0))
			movin(0,4,Direction.DOWNLEFT);
		else if ((i==6)&&(j!=0)&&(j!=1)) {
			j-=2;
			movin(1,j,Direction.DOWNLEFT);
		}
		else if ((i==5)&&(j!=0)&&(j!=1)) {
			j-=2;
			movin(0,j,Direction.DOWNLEFT);
		}
		else if((j==0)&&(i!=6)&&(i!=5)) {
			i+=2;
			movin(i,4,Direction.DOWNLEFT);
		}
		else if ((j==1)&&(i!=6)&&(i!=5)) {
			i+=2;
			movin(i,5,Direction.DOWNLEFT);
		}
		else {
			i+=2;
			j-=2;
			movin(i,j,Direction.DOWNLEFT);
		}
		
	}
	
	public void moveDownRight() throws OccupiedCellException{
		int i = getPosI();
		int j = getPosJ();
		if((i==6)&&(j==5))
			movin(1,1,Direction.DOWNRIGHT);
		else if ((i==5)&&(j==4))
			movin(0,0,Direction.DOWNRIGHT);
		else if ((i==6)&&(j==4))
			movin(1,0,Direction.DOWNRIGHT);
		else if ((i==5)&&(j==5))
			movin(0,1,Direction.DOWNRIGHT);
		else if ((i==6)&&(j!=5)&&(j!=4)) {
			j+=2;
			movin(1,j,Direction.DOWNRIGHT);
		}
		else if ((i==5)&&(j!=5)&&(j!=4)) {
			j+=2;
			movin(0,j,Direction.DOWNRIGHT);
		}
		else if((j==5)&&(i!=6)&&(i!=5)) {
			i+=2;
			movin(i,1,Direction.DOWNRIGHT);
		}
		else if ((j==4)&&(i!=6)&&(i!=5)) {
			i+=2;
			movin(i,0,Direction.DOWNRIGHT);
		}
		else {
			i+=2;
			j+=2;
			movin(i,j,Direction.DOWNRIGHT);
		}
	}
	
	public void moveLeft() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if(j==0)
			movin(i,4,Direction.LEFT);
		else if(j==1)
			movin(i,5,Direction.LEFT);
		else {
			j-=2;
			movin(i,j,Direction.LEFT);
		}
			
	}
	public void moveRight() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if(j==4)
			movin(i,0,Direction.RIGHT);
		else if(j==5)
			movin(i,1,Direction.RIGHT);
		else {
			j+=2;
			movin(i,j,Direction.RIGHT);
		}
	}
	public void moveUp() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if(i==1)
			movin(6,j,Direction.UP);
		else if(i==0)
			movin(5,j,Direction.UP);
		else {
			i-=2;
			movin(i,j,Direction.UP);
		}
			
	}
	public void moveUpLeft() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if((i==0)&&(j==0))
			movin(5,4,Direction.UPLEFT);
		else if ((i==1)&&(j==1))
			movin(6,5,Direction.UPLEFT);
		else if ((i==0)&&(j==1))
			movin(5,5,Direction.UPLEFT);
		else if ((i==1)&&(j==0))
			movin(6,4,Direction.UPLEFT);
		else if ((i==0)&&(j!=0)&&(j!=1)) {
			j-=2;
			movin(5,j,Direction.UPLEFT);
		}
		else if ((i==1)&&(j!=0)&&(j!=1)) {
			j-=2;
			movin(6,j,Direction.UPLEFT);
		}
		else if((j==0)&&(i!=0)&&(i!=1)) {
			i-=2;
			movin(i,4,Direction.UPLEFT);
		}
		else if ((j==1)&&(i!=0)&&(i!=1)) {
			i-=2;
			movin(i,5,Direction.UPLEFT);
		}
		else {
			i-=2;
			j-=2;
			movin(i,j,Direction.UPLEFT);
		}
	}
	public void moveUpRight() throws OccupiedCellException {
		int i = getPosI();
		int j = getPosJ();
		if((i==0)&&(j==5))
			movin(5,1,Direction.UPRIGHT);
		else if ((i==1)&&(j==4))
			movin(6,0,Direction.UPRIGHT);
		else if ((i==0)&&(j==4))
			movin(5,0,Direction.UPRIGHT);
		else if ((i==1)&&(j==5))
			movin(6,1,Direction.UPRIGHT);
		else if ((i==0)&&(j!=5)&&(j!=4)) {
			j+=2;
			movin(5,j,Direction.UPRIGHT);
		}
		else if ((i==1)&&(j!=5)&&(j!=4)) {
			j+=2;
			movin(6,j,Direction.UPRIGHT);
		}
		else if((j==5)&&(i!=0)&&(i!=1)) {
			i-=2;
			movin(i,1,Direction.UPRIGHT);
		}
		else if ((j==4)&&(i!=0)&&(i!=1)) {
			i-=2;
			movin(i,0,Direction.UPRIGHT);
		}
		else {
			i-=2;
			j+=2;
			movin(i,j,Direction.UPRIGHT);
		}
	}
	

}
