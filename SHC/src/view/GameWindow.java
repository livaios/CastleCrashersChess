package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import controller.MoveController;
import model.game.Game;
import model.game.Player;
import model.pieces.heroes.Super;

public class GameWindow extends JFrame implements ActionListener{
	
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public static int ScreenWidth = (int)(dim.getWidth());
	public static int ScreenHeight = (int)(dim.getHeight());
	private Player p1;
	private Player p2;
	private Game game;
	GameBoard2 gameBoard;
	
	public GameBoard getGameBoard() {
		return gameBoard.getGame();
	}

	private PlayerInfo info1;
	private PlayerInfo info2; 
	private SouthPanel south;
	private MoveController m = new MoveController();
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public SouthPanel getSouth() {
		return south;
	}

	public void setSouth(SouthPanel south) {
		this.south = south;
	}

	public GameWindow(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		game = new Game(p1,p2);
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0,0,ScreenWidth, ScreenHeight);
		setLayout(new BorderLayout());
		gameBoard =  new GameBoard2(game,m);
		Border f = BorderFactory.createEmptyBorder(0, 60, 0, 60);
		final JMenuBar tableMenuBar = populateJMenuBar();
		this.setJMenuBar(tableMenuBar);
		info1 = new PlayerInfo(p1,game,m);
		info2 = new PlayerInfo(p2,game,m);
		south = new SouthPanel(game);
		info2.setBorder(f);
		info1.setBorder(f);
		this.add(info1,BorderLayout.WEST);
		this.add(gameBoard,BorderLayout.CENTER);
		this.add(info2,BorderLayout.EAST);
		this.add(south,BorderLayout.SOUTH);
		this.validate();
		setVisible(true);
	}

	private JMenuBar populateJMenuBar() {
		final JMenuBar tableMenuBar = new JMenuBar();
		tableMenuBar.add(createFileMenu());
		return tableMenuBar;
	}

	private JMenu createFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		fileMenu.add(exit);
		return fileMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	
	public static void main(String[]args) {
		Player p1 = new Player("Farah");
		Player p2 = new Player("Laithy");
		p1.getDeadCharacters().add(new Super(p1,new Game(p1,p2),"SwampDude"));
		p2.getDeadCharacters().add(new Super(p2,new Game(p1,p2),"King"));
		p1.setPayloadPos(3);
		GameWindow w = new GameWindow(p1,p2);
		
	}
	public void updateData(){
		south.updatePlayer();
		info1.drawDed();
		info2.drawDed();
		info1.drawPayload();
		info2.drawPayload();
	}

	public PlayerInfo getInfo1() {
		return info1;
	}

	public PlayerInfo getInfo2() {
		return info2;
	}

}
