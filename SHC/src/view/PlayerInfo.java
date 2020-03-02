package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controller.MoveController;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Hero;
import model.pieces.heroes.Super;

@SuppressWarnings("serial")
public class PlayerInfo extends JPanel{
	private Player player;
	private JLabel playerName;
	private JLabel payload = new JLabel();
	private GridBagConstraints c = new GridBagConstraints();
	private JPanel Back = new JPanel();
	private JPanel deds = new JPanel();
	private MoveController m; 
	
	public PlayerInfo(Player player,Game game,MoveController m) {
		this.m = m;
		this.player = player;
		setLayout(new BorderLayout());
		this.add(Back, BorderLayout.PAGE_START);
		Back.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		try {
			Fonts.installFonts();
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		playerName = new JLabel(player.getName());
		playerName.setFont(new Font("Basset RR Four", Font.BOLD, 30));
		Back.add(playerName,c);
		c.gridy += 50;
		Back.add(payload,c);
		c.gridy += 50;
		drawPayload();
		c.gridy +=50;
		deds.setLayout(new GridBagLayout());
		drawDed();
		Back.add(deds, c);
	}

	public void drawPayload() {
		payload.setIcon(new ImageIcon("art/score"+ player.getPayloadPos() + ".png"));
		//payload.setText("score : " + player.getPayloadPos());	
		}
	
	public void drawDed() {
		deds.removeAll();
		deds.revalidate();
		deds.repaint();
		ArrayList<Piece> deadCharacters = player.getDeadCharacters();
		for (int i = 0; i < deadCharacters.size();i++) {
				//String imageName = "art/"+ deadCharacters.get(i).getName() +".png";
			    DedIcon dedButton = new DedIcon(deadCharacters.get(i),m);
			    deds.add(dedButton,c);
			    c.gridy += 50;
		}
		add(deds);
		
	}


}
