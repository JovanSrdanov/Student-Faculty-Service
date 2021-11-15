package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;

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
		addBtn.setIcon(new ImageIcon("icons/new.png"));
		add(addBtn);
		
		JButton editBtn = new JButton();
		editBtn.setToolTipText("Izmeni");
		editBtn.setIcon(new ImageIcon("icons/editPom.png"));
		add(editBtn);
		
		JButton deleteBtn = new JButton();
		deleteBtn.setToolTipText("Obriši");
		deleteBtn.setIcon(new ImageIcon("icons/delete.png"));
		add(deleteBtn);
		
		add(Box.createHorizontalGlue());
		
		JTextField searchBar = new JTextField();
		searchBar.setToolTipText("Unesi reč za pretragu");
		searchBar.setMaximumSize(new Dimension(9000,30));
		add(searchBar);
		
		add(Box.createRigidArea(new Dimension(20, 0)));
		
		JButton searchBtn = new JButton();
		searchBtn.setToolTipText("Pretraži");
		searchBtn.setIcon(new ImageIcon("icons/search.png"));
		add(searchBtn);
		
		
	}
	
	

}
