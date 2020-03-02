package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.game.Game;
import model.game.Player;

public class Transient extends JPanel{
	JLabel[][] back;
	public Transient() {
		this.setLayout(new GridLayout(7,6));
		back = new JLabel[7][6];
		for (int i = 0 ; i <= 6 ; i++) {
			for(int j = 0 ; j <= 5 ; j++) {
				back[i][j] = new JLabel();
				back[i][j].setIcon(new ImageIcon("art/Board2.png"));
				this.add(back[i][j]);
			}
		}
	}
}
