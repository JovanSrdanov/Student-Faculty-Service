package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MyApp;
import model.BazaProfesora;
import model.Profesor;

public class DodajProfesoraPredmetuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4322116241138504021L;
	private JButton potvrdiBtn;
	private JButton odustaniBtn;

	public DodajProfesoraPredmetuDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(300, 300);
		setResizable(false);
		//setLocationRelativeTo(owner);
		Dimension dimListe = new Dimension(300, 250);
		Dimension dimScroll = new Dimension(220, 200);
		Dimension dimBtn = new Dimension(300, 50);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPnl.setPreferredSize(dimBtn);
		
		potvrdiBtn = new JButton(MyApp.resourceBundle.getString("apply"));
		potvrdiBtn.setEnabled(false);
		odustaniBtn = new JButton(MyApp.resourceBundle.getString("odustani"));
		btnPnl.add(potvrdiBtn);
		btnPnl.add(odustaniBtn);

		String[] listaProfa;
		listaProfa = new String[BazaProfesora.getInstance().getProfesori().size()];

		// Popuniti listu profa
		int i = 0;
		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
			listaProfa[i] = p.getIme() + " " + p.getPrezime();
			++i;
		}

		JList<String> listBox = new JList<String>(listaProfa);
		JPanel listPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JScrollPane sctrollList = new JScrollPane(listBox);
		sctrollList.setPreferredSize(dimScroll);
		
		listPnl.add(sctrollList);
		listPnl.setPreferredSize(dimListe);

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
				PredmetDialog.getSelectedPredmet()
						.setPredmetniProfesor(BazaProfesora.getInstance().getProfesori().get(selectedIndex));
				BazaProfesora.getInstance().getProfesori().get(selectedIndex).getSpisakPredmetaNaKojimaJeProfesor()
						.add(PredmetDialog.getSelectedPredmet());
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

		centerPanel.add(listPnl);
		centerPanel.add(btnPnl);
		this.add(centerPanel);
	}
}
