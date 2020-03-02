package tests;

import exceptions.InvalidMovementException;
import exceptions.InvalidPowerUseException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.*;

public class Main {
	public static void main(String[] args) throws WrongTurnException, InvalidPowerUseException, InvalidMovementException {
		Player p1=new Player("Yestrex10");
		Player p2=new Player("Mama");
		Game test  = new Game(p1,p2);
		System.out.println(test);
		test.getCellAt(4,2).getPiece().move(Direction.UP);//p1
		System.out.println(test);
		/*test.getCellAt(2,5).getPiece().move(Direction.DOWN);//p2
		System.out.println(test);
		test.getCellAt(5,0).getPiece().move(Direction.UP);//p1
		System.out.println(test);
		test.getCellAt(1,0).getPiece().move(Direction.UPRIGHT);//p2
		System.out.println(test);
		((ActivatablePowerHero) test.getCellAt(4,0).getPiece()).usePower(Direction.UP, null, null);//p1
		System.out.println(test);*/
		//((ActivatablePowerHero) test.getCellAt(1,1).getPiece()).usePower(Direction.LEFT,null,null);
		//System.out.println(test); 
		
	}

}
