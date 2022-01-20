package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ocena;

public class PolaganjeDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3632848417475164935L;

	private JTextField sifraTxt;
	private JTextField nazivTxt;
	private JComboBox<String> ocenaCb;
	private JTextField datumTxt;
	private JButton okBtn;

	public PolaganjeDialog(Frame owner, String title, boolean modal, Ocena ocena) {
		super(owner, title, modal);
		setSize(300, 300);
		setLocationRelativeTo(owner);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		Dimension dimLabela = new Dimension(150, 20);
		Dimension dimTextBox = new Dimension(100, 20);

		// Dodavanje jednog reda
		JPanel sifraPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel sifraLbl = new JLabel("Sifra:");
		sifraLbl.setPreferredSize(dimLabela);

		sifraTxt = new JTextField();
		sifraTxt.setPreferredSize(dimTextBox);
		sifraTxt.setEditable(false);
		sifraTxt.setText(ocena.getPredmet().getSifrPredmeta());

		sifraPnl.add(sifraLbl);
		sifraPnl.add(sifraTxt);

		// Naziv
		JPanel nazivPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nazivLbl = new JLabel("Naziv predmeta:");
		nazivLbl.setPreferredSize(dimLabela);

		nazivTxt = new JTextField();
		nazivTxt.setPreferredSize(dimTextBox);
		nazivTxt.setEditable(false);
		nazivTxt.setText(ocena.getPredmet().getNazivPredmeta());

		nazivPnl.add(nazivLbl);
		nazivPnl.add(nazivTxt);

		// Datum
		JPanel datPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datLbl = new JLabel("Datum polaganja:");
		datLbl.setPreferredSize(dimLabela);

		datumTxt = new JTextField();
		datumTxt.setPreferredSize(dimTextBox);

		datPnl.add(datLbl);
		datPnl.add(datumTxt);

		// ocena (treba bude comboBox)
		JPanel ocenaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ocenaLbl = new JLabel("Ocena:");
		ocenaLbl.setPreferredSize(dimLabela);

		String[] zvanja = { "6", "7", "8", "9", "10" };
		ocenaCb = new JComboBox<String>(zvanja);
		ocenaCb.setPreferredSize(dimTextBox);

		ocenaPnl.add(ocenaLbl);
		ocenaPnl.add(ocenaCb);

		// btn
		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		okBtn = new JButton("Potvrdi");
		okBtn.setEnabled(false);
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ocena.setBrojcanaVrednostOcene(ocenaCb.getSelectedIndex() + 6);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
				LocalDate datum = LocalDate.parse(datumTxt.getText(), formatter);
				ocena.setDatumPolaganjaIspita(datum);
				MyFrame.getInstance().azurirajPrikazStudenata();
				dispose();

			}
		});
		btnPnl.add(okBtn);

		JButton ripBtn = new JButton("Odustani");
		ripBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ocena.setBrojcanaVrednostOcene(5);
				dispose();
			}
		});
		btnPnl.add(ripBtn);

		dodajFocusListener(datumTxt);

		centerPanel.add(sifraPnl);
		centerPanel.add(nazivPnl);
		centerPanel.add(ocenaPnl);
		centerPanel.add(datPnl);
		centerPanel.add(btnPnl);
		add(centerPanel);
	}

	private void dodajFocusListener(JTextField txt) {
		txt.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				okBtn.setEnabled(proveraUpis());

			}

			@Override
			public void focusLost(FocusEvent e) {
				okBtn.setEnabled(proveraUpis());

			}

		});

		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				okBtn.setEnabled(proveraUpis());

			}

			@Override
			public void keyPressed(KeyEvent e) {
				okBtn.setEnabled(proveraUpis());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				okBtn.setEnabled(proveraUpis());

			}

		});
	}

	private boolean proveraUpis() {
		if (!datumTxt.getText().matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}")) {
			return false;
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
				LocalDate datum = LocalDate.parse(datumTxt.getText(), formatter);
				if (datum.isAfter(LocalDate.now())) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

}
