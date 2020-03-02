package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class SidePanel extends JPanel{
	public SidePanel(PlayerInfo c) {
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.CENTER;
		g.fill = GridBagConstraints.VERTICAL;
		this.add(c,g);
	}

}
