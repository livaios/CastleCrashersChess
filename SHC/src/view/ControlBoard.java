package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlBoard extends JPanel{
	private JButton upleft;
	private JButton up;
	private JButton upright;
	private JButton left;
	private JButton usePower;
	private JButton right;
	private JButton downleft;
	private JButton down;
	private JButton downright;
	public ControlBoard() {
		this.setLayout(new GridLayout(3,3));
		upleft = new JButton();
		up = new JButton();
		upright = new JButton();
		left = new JButton();
		usePower = new JButton();
		right = new JButton();
		downleft = new JButton();
		down = new JButton();
		downright = new JButton();
		this.add(upleft);
		this.add(up);
		this.add(upright);
		this.add(left);
		this.add(usePower);
		this.add(right);
		this.add(downleft);
		this.add(down);
		this.add(downright);
	}

}
