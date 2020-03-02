package model.pieces.heroes;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

abstract public class Hero extends Piece{
	
	public Hero() {
		super();
	}

	public Hero(Player player, Game game, String name) {
		super(player, game, name);
		
	}


}
