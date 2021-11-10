package gui;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		
		setBackground(Color.white);
		setFloatable(false);
		
		JButton addBtn = new JButton();
		addBtn.setToolTipText("Dodaj");
		//TODO dodaj dobru ikonicu za btn
		addBtn.setIcon(new ImageIcon("icons/editPom.png"));
		add(addBtn);
		
		JButton editBtn = new JButton();
		editBtn.setToolTipText("Izmeni");
		//TODO dodaj dobru ikonicu za btn
		editBtn.setIcon(new ImageIcon("icons/editPom.png"));
		add(editBtn);
		
		JButton deleteBtn = new JButton();
		deleteBtn.setToolTipText("Obrisi");
		//TODO dodaj dobru ikonicu za btn
		deleteBtn.setIcon(new ImageIcon("icons/editPom.png"));
		add(deleteBtn);
		
	}
	
	

}
