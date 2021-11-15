package gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
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
		
		JPanel toolBarPanel = new JPanel();
		toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.X_AXIS));
		add(toolBarPanel);
		
		JButton addBtn = new JButton();
		addBtn.setToolTipText("Dodaj");
		addBtn.setMaximumSize(new Dimension(50,50));
		addBtn.setPreferredSize(new Dimension(50,50));
		addBtn.setBackground(Color.white);
		addBtn.setIcon(new ImageIcon("icons/new.png"));
		toolBarPanel.add(addBtn);
		
		JButton editBtn = new JButton();
		editBtn.setToolTipText("Izmeni");
		editBtn.setMaximumSize(new Dimension(50,50));
		editBtn.setPreferredSize(new Dimension(50,50));
		editBtn.setBackground(Color.white);
		editBtn.setIcon(new ImageIcon("icons/editPom.png"));
		toolBarPanel.add(editBtn);
		
		JButton deleteBtn = new JButton();
		deleteBtn.setToolTipText("Obriši");
		deleteBtn.setMaximumSize(new Dimension(50,50));
		deleteBtn.setPreferredSize(new Dimension(50,50));
		deleteBtn.setBackground(Color.white);
		deleteBtn.setIcon(new ImageIcon("icons/delete.png"));
		toolBarPanel.add(deleteBtn);
		
		toolBarPanel.add(Box.createHorizontalGlue());
		
		JTextField searchBar = new JTextField();
		searchBar.setToolTipText("Unesi reč za pretragu");
		searchBar.setMaximumSize(new Dimension(9000,30));
		toolBarPanel.add(searchBar);
		
		toolBarPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JButton searchBtn = new JButton();
		searchBtn.setToolTipText("Pretraži");
		searchBtn.setMaximumSize(new Dimension(30,30));
		searchBtn.setPreferredSize(new Dimension(30,30));
		searchBtn.setBackground(Color.white);
		searchBtn.setIcon(new ImageIcon("icons/search.png"));
		toolBarPanel.add(searchBtn);
		
		
	}
	
	

}
