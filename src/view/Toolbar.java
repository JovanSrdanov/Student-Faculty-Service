package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;

import controller.PredmetiController;
import controller.ProfesorController;
import controller.StudentiController;

public class Toolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;
	
	private static String staraPretraga;

	public static String getStaraPretraga() {
		return staraPretraga;
	}

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

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
					StudentiController.getInstance().dodajStudenta();
				} else if (selectedTab == 1) {
					// Profesor
					ProfesorController.getInstance().dodajProfesora();
				} else if (selectedTab == 2) {
					// Predmet
					PredmetiController.getInstance().dodajPredmet();
				}
			}
		});

		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
					if (MyFrame.getTabelaStduenti().getSelectedRow() >= 0)
						StudentiController.getInstance().izmeniStudenta();
					else
						JOptionPane.showMessageDialog(null, "Izaberi studenta za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 1) {
					MyFrame.getInstance();
					// Profesor
					if (MyFrame.getTabelaProfesora().getSelectedRow() >= 0)
						ProfesorController.getInstance().izmeniProfesora();
					else
						JOptionPane.showMessageDialog(null, "Izaberi profesora za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 2) {
					if (MyFrame.getTabelaPredmeta().getSelectedRow() >= 0)
						PredmetiController.getInstance().izmeniPredmet();
					else
						JOptionPane.showMessageDialog(null, "Izaberi predmet za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					StudentiController.getInstance().izbrisiStudenta(MyFrame.getTabelaStduenti().getSelectedRow());
					if(MyFrame.getInstance().isPretraga()) {
						StudentiController.getInstance().pretraziStudente(staraPretraga);
					}
				} else if (selectedTab == 1) {
					ProfesorController.getInstance().izbrisiProfesora(MyFrame.getTabelaProfesora().getSelectedRow());
					if(MyFrame.getInstance().isPretraga()) {
						ProfesorController.getInstance().pretraziProfesore(staraPretraga);
					}
				} else if (selectedTab == 2) {
					PredmetiController.getInstance().izbrisiPredmet(MyFrame.getTabelaPredmeta().getSelectedRow());
					if(MyFrame.getInstance().isPretraga())
						PredmetiController.getInstance().pretraziPredmete(staraPretraga);
				}
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
		searchBar.setPreferredSize(new Dimension(350, 30));
		searchBar.setMaximumSize(new Dimension(350, 30));
		toolBarPanel.add(searchBar);

		toolBarPanel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton searchBtn = new JButton();
		initBtn(searchBtn, "Pretraži", new ImageIcon("icons/search.png"), 30);
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
					if(searchBar.getText().isBlank())
					{
						MyFrame.getInstance().setPretraga(false);
						MyFrame.getInstance().azurirajPrikazStudenata();
					}
					else
					{
						MyFrame.getInstance().setPretraga(true);
						staraPretraga = searchBar.getText();
						StudentiController.getInstance().pretraziStudente(staraPretraga);
					}
					
					
					
					
				} else if (selectedTab == 1) {
					// Profesor
					if(searchBar.getText().isBlank())
					{
						MyFrame.getInstance().setPretraga(false);
						MyFrame.getInstance().azurirajPrikazProfesora();
					}
					else
					{
						MyFrame.getInstance().setPretraga(true);
						staraPretraga = searchBar.getText();
						ProfesorController.getInstance().pretraziProfesore(staraPretraga);
					}
					
				} else if (selectedTab == 2) {
					// Predmet	
					if(searchBar.getText().isBlank())
					{
						MyFrame.getInstance().setPretraga(false);
						MyFrame.getInstance().azurirajPrikazPredmeta();
					}
					else
					{
						MyFrame.getInstance().setPretraga(true);
						staraPretraga = searchBar.getText();
						//ProfesorController.getInstance().pretraziProfesore(staraPretraga);
						PredmetiController.getInstance().pretraziPredmete(staraPretraga);
					}
				}
			}
		});
		
		toolBarPanel.add(searchBtn);
	}

	private void initBtn(JButton btn, String toolTip, ImageIcon icon, int dim) {
		btn.setToolTipText(toolTip);
		btn.setMaximumSize(new Dimension(dim, dim));
		btn.setPreferredSize(new Dimension(dim, dim));
		btn.setBackground(Color.white);
		btn.setIcon(icon);

	}

}
