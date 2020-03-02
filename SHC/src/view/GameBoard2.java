package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MoveController;
import model.game.Game;

public class GameBoard2 extends JPanel{
	private MoveController m;
	private GameBoard gameBoard;
	public GameBoard2(Game game,MoveController m) {
		this.m=m;
		JLabel background = new JLabel(new ImageIcon("art/Board2.png"));
	    add(background);
	    gameBoard =  new GameBoard(game,m);
	    background.setLayout(new FlowLayout());
	    gameBoard.setOpaque(false);
	    background.add(gameBoard);
	    
	}
	public GameBoard getGame() {
		return gameBoard;
	}

}
