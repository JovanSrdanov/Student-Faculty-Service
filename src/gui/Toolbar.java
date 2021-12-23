package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import baza.BazaPredmeta;
import controllers.PredmetiController;
import modelSistema.Semestar;


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
		JButton editBtn = new JButton();
		JButton deleteBtn = new JButton();
		
		addBtn.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent e){  
	            	PredmetiController.getInstance().dodajPredmet();
				}
			});
		
		editBtn.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent e){  
	            	//TODO
				}
			});
		
		deleteBtn.addActionListener(new ActionListener(){ 
			@Override
			public void actionPerformed(ActionEvent e){  
	            	MyFrame.getInstance();
					//TODO
					PredmetiController.getInstance().izbrisiPredmet(MyFrame.getTabelaPredmeta().getSelectedRow());
				}
			});
		
		
		initBtn(addBtn, "Dodaj", new ImageIcon("icons/new.png"), 50);
		initBtn(editBtn, "Izmeni", new ImageIcon("icons/editPom.png"), 50);
		initBtn(deleteBtn, "Obriši", new ImageIcon("icons/delete.png"), 50);
		
		toolBarPanel.add(addBtn);
		toolBarPanel.add(editBtn);
		toolBarPanel.add(deleteBtn);
		
		toolBarPanel.add(Box.createHorizontalGlue());
		
		JTextField searchBar = new JTextField();
		searchBar.setToolTipText("Unesi reč za pretragu");
		searchBar.setMaximumSize(new Dimension(9000,30));
		toolBarPanel.add(searchBar);
		
		toolBarPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JButton searchBtn = new JButton();		
		initBtn(searchBtn, "Pretraži", new ImageIcon("icons/search.png"), 30);
		toolBarPanel.add(searchBtn);	
	}
	
	private void initBtn(JButton btn, String toolTip, ImageIcon icon, int dim) {
		btn.setToolTipText(toolTip);
		btn.setMaximumSize(new Dimension(dim,dim));
		btn.setPreferredSize(new Dimension(dim,dim));
		btn.setBackground(Color.white);
		btn.setIcon(icon);
		
	}
	
	

}
