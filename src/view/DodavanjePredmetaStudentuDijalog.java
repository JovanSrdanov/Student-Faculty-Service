package view;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaPredmeta;
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
		setLocationRelativeTo(owner);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel btnPnl = new JPanel();
		dodajBtn = new JButton("Dodaj");
		dodajBtn.setEnabled(false);
		odustaniBTN = new JButton("Odustani");
		btnPnl.add(dodajBtn);
		btnPnl.add(odustaniBTN);

		ArrayList<Predmet> listaMogucihPredmeta = new ArrayList<Predmet>();

		ArrayList<String> sifraImePredmeta = new ArrayList<String>();

		for (Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if (p.getGodinaStudijaUKojojSePredmetIzvodi() <= StudentDijalog.getSelectedStudent()
					.getTrenutnaGodinaStudija())
				listaMogucihPredmeta.add(p);
		}

		for (Predmet p : listaMogucihPredmeta) {
			sifraImePredmeta.add(p.getSifrPredmeta() + " - " + p.getNazivPredmeta());
		}

		String[] dodaj = new String[sifraImePredmeta.size()];

		for (int i = 0; i < sifraImePredmeta.size(); i++) {
			dodaj[i] = sifraImePredmeta.get(i);
		}

		JList<String> listBox = new JList<String>(dodaj);
		
		
		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					// samo nas interesuje trenutak otpustanja misa

					System.out.println(String.format("Selektovan je dan: %s, sa indeksom: %d",
							listBox.getSelectedValue(), listBox.getSelectedIndex()));
				}

			}
		});
			
		
		

		centerPanel.add(listBox);
		centerPanel.add(btnPnl);
		this.add(centerPanel);

	}

}
