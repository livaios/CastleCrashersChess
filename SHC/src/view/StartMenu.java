package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.game.Player;

public class StartMenu extends JFrame implements ActionListener{
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public static int ScreenWidth = (int)(0.75*dim.getWidth());
	public static int ScreenHeight = (int)(0.75*dim.getHeight());
	public static int ScreenWidth2 = (int)(0.5*dim.getWidth());
	public static int ScreenHeight2 = (int)(0.5*dim.getHeight());
	private Start panel = new Start(this);
	

	public StartMenu() {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds((int)(0.25*ScreenWidth2),(int) (0.25*ScreenHeight2),ScreenWidth, ScreenHeight);
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("art/Start.png"));
    	    add(background);
        panel.setOpaque(false);
        background.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
		background.add(panel,c);
		soundtrack();
		setVisible(true);
		
	}
	private static void soundtrack() {
		try {
		File f = new File ("BB.wav");
		Clip c = AudioSystem.getClip();
		c.open(AudioSystem.getAudioInputStream(f));
		c.loop(Clip.LOOP_CONTINUOUSLY);
		c.start();
		return;
		}
		catch (Exception e) {
		System.err.println(e.getMessage());}
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Press to Start")) {
			Player p1 = new Player(panel.getNameP1());
			Player p2 = new Player(panel.getNameP2());
			new GameWindow(p1,p2);
			this.dispose();
		}	
	}		
		public static void main(String[]args) {
		new StartMenu();
	}
}
