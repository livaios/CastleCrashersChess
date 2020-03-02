package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Game;

public class SouthPanel extends JPanel{
	private JLabel c;
	Game game;
	public SouthPanel(Game game) {
		this.game = game;
		try {
			Fonts.installFonts();
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String player = game.getCurrentPlayer().getName();
		c = new JLabel("It's " + player + "'s Turn");
		c.setFont(new Font("Basset RR Four", Font.BOLD, 30));
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.CENTER;
		this.add(c,g);
	}
	public void updatePlayer() {
		String player = game.getCurrentPlayer().getName();
		c.setText("It's " + player + "'s Turn");
	}

}
