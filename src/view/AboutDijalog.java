package view;


import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 706014951914755011L;

	public AboutDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(900, 350);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		String s = "";
		
		JLabel t = new JLabel(s,SwingConstants.LEFT);
		
		centerPanel.add(t);
		
		

		this.add(centerPanel);
		
		
	}
}
