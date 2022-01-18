package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaProfesora;
import model.Profesor;

public class DodavnjaProfesoraPredmetu extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4322116241138504021L;
	private JButton potvrdiBtn;
	private JButton odustaniBtn;
	public DodavnjaProfesoraPredmetu(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(300, 300);
		setLocationRelativeTo(owner);
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel btnPnl = new JPanel();
		potvrdiBtn = new JButton("Potvrdi");
		potvrdiBtn.setEnabled(false);
		odustaniBtn = new JButton("Odustani");
		btnPnl.add(potvrdiBtn);
		btnPnl.add(odustaniBtn);	
		
		String[] listaProfa;
		listaProfa = new String[BazaProfesora.getInstance().getProfesori().size()];
		
		//Popuniti listu profa
		int i = 0;
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			listaProfa[i] = p.getIme() + " " + p.getPrezime();
			++i;
		}
		
		JList<String> listBox = new JList<String>(listaProfa);
		listBox.setPreferredSize(new Dimension(100, 200));

		listBox.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					potvrdiBtn.setEnabled(true);
				}
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listBox.getSelectedIndex();
				PredmetDialog.getSelectedPredmet().setPredmetniProfesor(BazaProfesora.getInstance().getProfesori().get(selectedIndex));
				BazaProfesora.getInstance().getProfesori().get(selectedIndex).getSpisakPredmetaNaKojimaJeProfesor().add(PredmetDialog.getSelectedPredmet());
				PredmetDialog.azurirajProf();
				dispose();
			}
			
		});
		
		odustaniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});
		
		centerPanel.add(listBox);
		centerPanel.add(btnPnl);
		this.add(centerPanel);
	}
}
