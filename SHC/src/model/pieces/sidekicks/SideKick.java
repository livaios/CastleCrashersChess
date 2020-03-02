package model.pieces.sidekicks;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

abstract public class SideKick extends Piece{
	
	public SideKick(Player player, Game game, String name) {
		super(player,game,name);
	}
	
	public void attack(Piece target) {
		if ((target instanceof Armored) && ((Armored) target).isArmorUp()) {
			((Armored) target).setArmorUp(false);
		}
        else {
    	        increasePayload(target);
		    if ((target instanceof Hero)) 
			    transform(target);
		}
		getGame().checkWinner();
	}
	
	public void transform(Piece target) {
		if (target instanceof Medic) {
			Medic m = new Medic(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), m);
		}
		else if (target instanceof Ranged) {
			Ranged r = new Ranged(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), r);
		}
		else if (target instanceof Speedster) {
			Speedster s = new Speedster(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), s);
		}
		else if (target instanceof Super) {
			Super s = new Super(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), s);
		}
		else if (target instanceof Tech) {
			Tech t = new Tech(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), t);
		}
		else if (target instanceof Armored) {
			Armored a = new Armored(getOwner(),getGame(),target.getName());
			getGame().place(getPosI(), getPosJ(), a);
		}
	}

}
