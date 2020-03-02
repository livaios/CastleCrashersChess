package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.game.Game;
import model.game.Player;

public class Winner extends JFrame implements ActionListener {
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public static int ScreenWidth = (int) (0.75 * dim.getWidth());
	public static int ScreenHeight = (int) (0.75 * dim.getHeight());
	public static int ScreenWidth2 = (int) (0.5 * dim.getWidth());
	public static int ScreenHeight2 = (int) (0.5 * dim.getHeight());
	private JLabel theWinner;
	private JButton exit = new JButton("EXIT");
	private JButton playAgain = new JButton("PLAY AGAIN");
	

	public Winner(Player p) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		Border f = BorderFactory.createEmptyBorder(0, 0, 10, 0);
		c.anchor = GridBagConstraints.CENTER;
		try {
			Fonts.installFonts();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds((int) (0.25 * ScreenWidth2), (int) (0.25 * ScreenHeight2), ScreenWidth, ScreenHeight);
		setTitle("Winner");
		setLayout(new GridBagLayout());
		theWinner = new JLabel(p.getName() + " WINS!");
		theWinner.setForeground(Color.WHITE);
		theWinner.setBackground(Color.BLACK);
		theWinner.setFont(new Font("Basset RR Four", Font.BOLD, 40));
		playAgain.setForeground(Color.WHITE);
		playAgain.setBorder(null);
		playAgain.setBorderPainted(false);
		playAgain.setContentAreaFilled(false);
		playAgain.setOpaque(false);
		playAgain.setFont(new Font("Basset RR Four", Font.BOLD, 40));
		playAgain.addActionListener(this);
		playAgain.setVisible(true);
		exit.setForeground(Color.WHITE);
		exit.setBorder(null);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setOpaque(false);
		exit.setFont(new Font("Basset RR Four", Font.BOLD, 40));
		exit.addActionListener(this);
		exit.setVisible(true);
		JLabel gif = new JLabel(new ImageIcon("art/gif.gif"));
		this.add(gif, c);
		gif.setLayout(new GridBagLayout());
		gif.add(theWinner, c);
		c.gridy += 50;
		gif.add(playAgain, c);
		c.gridy += 50;
		gif.add(exit, c);
		c.gridy += 50;
		setVisible(true);

	}

	public static void main(String[] args) {
		Winner e = new Winner(new Player("Laithy"));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("EXIT"))
			this.dispose();
		if (e.getActionCommand().equals("PLAY AGAIN")) {
			new StartMenu();
			this.dispose();
		}
	}

}
