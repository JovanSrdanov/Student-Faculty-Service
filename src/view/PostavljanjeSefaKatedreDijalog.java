package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaKatedri;
import model.Katedra;

import model.Profesor;
import model.Zvanje;

public class PostavljanjeSefaKatedreDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6157322927938848633L;

	public PostavljanjeSefaKatedreDijalog(Frame owner, String title, boolean modal, Katedra k) {
		super(owner, title, modal);
		setSize(300, 300);
		setResizable(false);
		// setLocationRelativeTo(owner);
		Dimension dimListe = new Dimension(300, 250);
		Dimension dimScroll = new Dimension(200, 200);
		Dimension dimBtn = new Dimension(300, 50);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		JPanel btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPan.setPreferredSize(dimBtn);

		JButton postaviSefaKatedreBtn = new JButton("Postavi");
		JButton odustaniBtn = new JButton("Odustani");
		postaviSefaKatedreBtn.setEnabled(false);

		btnPan.add(postaviSefaKatedreBtn);
		btnPan.add(odustaniBtn);

		odustaniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		ArrayList<Profesor> listaMogucihProfesora = new ArrayList<Profesor>();

		ArrayList<String> imePrezimeProfesora = new ArrayList<String>();

		for (Profesor p : k.getSpisakProfesoraKojiSuNaKatedri()) {

			boolean nalazi = false;

			if (p.getZvanje() != Zvanje.DOCENT && p.getGodineStaza() >= 5)
				for (Katedra pom : BazaKatedri.getInstance().getKatedre()) {
					if (pom.getSefKatedre() == p)
						nalazi = true;

				}

			if (nalazi == false)
				listaMogucihProfesora.add(p);

		}

		for (Profesor p : listaMogucihProfesora) {

			imePrezimeProfesora.add(p.getIme() + " " + p.getPrezime());

		}

		String[] dodaj = new String[imePrezimeProfesora.size()];

		for (int i = 0; i < imePrezimeProfesora.size(); i++) {
			dodaj[i] = imePrezimeProfesora.get(i);
		}

		JList<String> listBox = new JList<String>(dodaj);
		JPanel listPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JScrollPane sctrollList = new JScrollPane(listBox);
		sctrollList.setPreferredSize(dimScroll);

		listPnl.add(sctrollList);
		listPnl.setPreferredSize(dimListe);

		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					postaviSefaKatedreBtn.setEnabled(true);
				}

			}
		});

		postaviSefaKatedreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor p = new Profesor();
				p = listaMogucihProfesora.get(listBox.getSelectedIndex());
				k.setSefKatedre(p);
				KatedraDijalog.azurirajPrikazKatedre();
				dispose();
			}

		});

		centerPanel.add(listPnl);
		centerPanel.add(btnPan);
		this.add(centerPanel);

	}

}
