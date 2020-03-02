package model.pieces.heroes;

import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero{
	private boolean armorUp;
	
	public Armored() {
		super();
		armorUp=true;
	}
	public Armored(Player player,Game game,String name) {
		super(player,game,name);
		armorUp=true;
	}
	public boolean isArmorUp() {
		return armorUp;
	}
	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
	

}
