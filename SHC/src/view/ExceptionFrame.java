package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.game.Player;

public class ExceptionFrame extends JFrame implements ActionListener {
	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public static int ScreenWidth = (int) (0.75 * dim.getWidth());
	public static int ScreenHeight = (int) (0.75 * dim.getHeight());
	public static int ScreenWidth2 = (int) (0.5 * dim.getWidth());
	public static int ScreenHeight2 = (int) (0.5 * dim.getHeight());
	private JLabel msg = new JLabel();
	private JButton ok = new JButton("Ok");

	public ExceptionFrame(String message) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds((int) (0.8*ScreenWidth2), (int) (0.75*ScreenHeight2), 400, 100);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		ok.addActionListener(this);
		msg.setText(message);
		this.add(msg,c);
		c.gridy+=50;
		this.add(ok,c);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ok")) {
			this.dispose();
		}
	}

}