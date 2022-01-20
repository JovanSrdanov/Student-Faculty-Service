package view;

import java.awt.Frame;

import javax.swing.JDialog;

public class KatedraDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5756133743805054823L;

	public KatedraDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(500, 500);

	}
}
