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

import model.BazaPredmeta;
import model.Ocena;
import model.Predmet;

public class DodavanjePredmetaStudentuDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton dodajBtn;
	private JButton odustaniBTN;

	public DodavanjePredmetaStudentuDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(300, 300);
		//setLocationRelativeTo(owner);
		Dimension dimListe = new Dimension(300, 250);
		Dimension dimScroll = new Dimension(200, 200);
		Dimension dimBtn = new Dimension(300, 50);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPnl.setPreferredSize(dimBtn);
		
		dodajBtn = new JButton("Dodaj");
		dodajBtn.setEnabled(false);
		odustaniBTN = new JButton("Odustani");
		btnPnl.add(dodajBtn);
		btnPnl.add(odustaniBTN);

		ArrayList<Predmet> listaMogucihPredmeta = new ArrayList<Predmet>();

		ArrayList<String> sifraImePredmeta = new ArrayList<String>();

		for (Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			boolean nalazi = false;

			for (Ocena o : StudentDijalog.getSelectedStudent().getSpisakNePolozenihIspita()) {
				if (o.getPredmet() == p) {
					nalazi = true;
				}

			}

			for (Ocena o : StudentDijalog.getSelectedStudent().getSpisakPolozenihIspita()) {
				if (o.getPredmet() == p) {
					nalazi = true;
				}

			}

			if (nalazi == false) {

				if (p.getGodinaStudijaUKojojSePredmetIzvodi() <= StudentDijalog.getSelectedStudent()
						.getTrenutnaGodinaStudija()) {

					listaMogucihPredmeta.add(p);
				}

			}

		}

		for (Predmet p : listaMogucihPredmeta) {
			sifraImePredmeta.add(p.getSifrPredmeta() + " - " + p.getNazivPredmeta());
		}

		String[] dodaj = new String[sifraImePredmeta.size()];

		for (int i = 0; i < sifraImePredmeta.size(); i++) {
			dodaj[i] = sifraImePredmeta.get(i);
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
					dodajBtn.setEnabled(true);
				}

			}
		});

		dodajBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet p = new Predmet();
				p = listaMogucihPredmeta.get(listBox.getSelectedIndex());
				Ocena ocena = new Ocena(StudentDijalog.getSelectedStudent(), p, 5, null);
				StudentDijalog.getSelectedStudent().getSpisakNePolozenihIspita().add(ocena);
				StudentDijalog.azurirajPrikazNepolozenih();
				dispose();
			}

		});

		odustaniBTN.addActionListener(new ActionListener() {
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
