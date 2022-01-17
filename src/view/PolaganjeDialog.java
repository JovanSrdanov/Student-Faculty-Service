package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ocena;

public class PolaganjeDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3632848417475164935L;
	
	private JTextField sifraTxt;
	private JTextField nazivTxt;
	private JTextField ocenaTxt;
	private JTextField datumTxt;
	
	public PolaganjeDialog(Frame owner, String title, boolean modal, Ocena ocena) {
		super(owner, title, modal);
		setSize(300, 300);
		setLocationRelativeTo(owner);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		Dimension dimLabela = new Dimension(80, 20);
		Dimension dimTextBox = new Dimension(100, 20);
		
		//Dodavanje jednog reda
		JPanel sifraPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel sifraLbl = new JLabel("Sifra:");
		sifraLbl.setPreferredSize(dimLabela);
		
		sifraTxt = new JTextField();
		sifraTxt.setPreferredSize(dimTextBox);
		sifraTxt.setEditable(false);
		sifraTxt.setText(ocena.getPredmet().getNazivPredmeta());
		
		sifraPnl.add(sifraLbl);
		sifraPnl.add(sifraTxt);
		
		//ocena (treba bude comboBox)
		JPanel ocenaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ocenaLbl = new JLabel("Ocena:");
		ocenaLbl.setPreferredSize(dimLabela);
		
		ocenaTxt = new JTextField();
		ocenaTxt.setPreferredSize(dimTextBox);
		//ocenaTxt.setText(ocena.getPredmet().getNazivPredmeta());
		
		ocenaPnl.add(ocenaLbl);
		ocenaPnl.add(ocenaTxt);
		
		//btn
		JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton okBtn = new JButton("Potvrdi");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ocena.setBrojcanaVrednostOcene(Integer.parseInt(ocenaTxt.getText()));
				ocena.setDatumPolaganjaIspita(LocalDate.now());
				dispose();
				
			}		
		});
		
		btnPnl.add(okBtn);
		
		
		centerPanel.add(sifraPnl);
		centerPanel.add(ocenaPnl);
		centerPanel.add(btnPnl);
		add(centerPanel);
	}

}
