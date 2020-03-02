package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Start extends JPanel{
	
	private JLabel welcome = new JLabel("Castle Crashers II");
	private JButton startButton = new JButton("Press to Start");
	private JLabel player1 = new JLabel("Enter Player 1's name:");
	private JTextField enterP1 = new JTextField(20);
	private JLabel player2 = new JLabel("Enter Player 2's name:");
	private JTextField enterP2 = new JTextField(20);
	private String nameP1;
	private String nameP2;
	
	public Start(StartMenu startMenu) {
		super();
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		try {
			Fonts.installFonts();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Fonts2.installFonts();
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Border f = BorderFactory.createEmptyBorder(0, 0, 10, 0);
		welcome.setBorder(f);
		welcome.setBackground(null);
		welcome.setFont(new Font("Basset RR Four", Font.BOLD, 40));
		welcome.setForeground(Color.WHITE);
		player1.setFont(new Font("moinho", Font.BOLD, 20));
		player1.setForeground(Color.WHITE);
		player2.setFont(new Font("moinho", Font.BOLD, 20));
		player2.setForeground(Color.WHITE);
		enterP1.setBorder(f);
		enterP2.setBorder(f);
		startButton.setFont(new Font("moinho", Font.BOLD, 20));
		startButton.setSize(20, 50);
		c.anchor=GridBagConstraints.CENTER;
		c2.anchor=GridBagConstraints.CENTER;
		this.add(welcome, c2);
		c.gridy+=50;
		this.add(player1,c);
		c.gridy+=50;
		this.add(enterP1,c);
		c.gridy+=50;
		this.add(player2,c);
		c.gridy+=50;
		this.add(enterP2,c);
		c.gridy+=50;
		this.add(startButton,c);
		startButton.addActionListener(startMenu);
	}


	public String getNameP1() {
		return enterP1.getText();
	}
	
	public String getNameP2() {
		return enterP2.getText();
	}
}
