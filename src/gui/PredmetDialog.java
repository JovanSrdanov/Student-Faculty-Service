package gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import baza.BazaPredmeta;
import modelSistema.Predmet;
import modelSistema.Semestar;

public class PredmetDialog extends JDialog {
	
	private JComboBox godinaCb;
	private JComboBox semsetarCb;
	private JTextField sifraTxt;
	private JTextField nazivTxt;
	private JTextField espbTxt;

	public PredmetDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(350, 300);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(LEFT_ALIGNMENT);
		
		JButton okBtn = new JButton("OK");
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String greska = proveraUpis();
				if(greska.equals(""))
				{
					//uspesno
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, greska, "Greska", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JLabel sifraLbl = new JLabel("Unesi sifru predmeta:");
		JLabel nazivLbl = new JLabel("Unesi naziv predmeta:");
		JLabel espbLbl = new JLabel("Unesi broj ESPB bodova koji predmet nosi:");
		JLabel semsetarLbl = new JLabel("Izaberite semestar u kojom se predmet izvodi:");
		JLabel godinaLbl = new JLabel("Izaberite godinu u kojoj se predmet izvodi:");
		
		String[] godineOp = {"1", "2", "3", "4"};
		godinaCb = new JComboBox(godineOp);
		godinaCb.setMaximumSize(new Dimension(200,20));
		
		String[] semestarOp = {"ZIMSKI", "LETNJI"};
		semsetarCb = new JComboBox(semestarOp);
		semsetarCb.setMaximumSize(new Dimension(200,20));
		
		sifraTxt = new JTextField();
		sifraTxt.setMaximumSize(new Dimension(200,20));	
		
		nazivTxt = new JTextField();
		nazivTxt.setMaximumSize(new Dimension(200,20));
		
		espbTxt = new JTextField();
		espbTxt.setMaximumSize(new Dimension(200,20));
		
		panel.add(sifraLbl);
		panel.add(sifraTxt);
		panel.add(nazivLbl);
		panel.add(nazivTxt);
		panel.add(espbLbl);
		panel.add(espbTxt);
		panel.add(godinaLbl);
		panel.add(godinaCb);
		panel.add(semsetarLbl);
		panel.add(semsetarCb);
		panel.add(Box.createVerticalGlue());
		panel.add(okBtn);
		add(panel);
		
	}
	
	private String proveraUpis() {
		//JOptionPane.showMessageDialog(this, "Eggs are not supposed to be green.", "Ide gas", JOptionPane.WARNING_MESSAGE);
		String greska = "";
		if(sifraTxt.getText().isBlank())
		{
			greska = "Unesite sifru predmeta";
			return greska;
		}
		if(espbTxt.getText().isBlank())
		{
			greska = "Unesite broj ESPB bodova koji predmet nosi";
			return greska;
		}
		if(nazivTxt.getText().isBlank())
		{
			greska = "Unesite naziv predmeta";
			return greska;
		}
		if(!sifraTxt.getText().matches("[0-9]+"))
		{
			greska = "Sifra nije u dobrom formatu treba da bude broj";
			return greska;
		}
		if(existsBySifra(Integer.parseInt((sifraTxt.getText()))))
		{
			greska = "Predmet sa ovom sifrom vec postoji";
			return greska;
		}
		if(!espbTxt.getText().matches("[0-9]+"))
		{
			greska = "Espb nije u dobrom formatu treba da bude broj";
			return greska;
		}
		
		int sifra = Integer.parseInt(sifraTxt.getText());
		String naziv = nazivTxt.getText();
		int espb = Integer.parseInt(espbTxt.getText());
		Semestar semestar;
		
		if(semsetarCb.getSelectedIndex() == 0)
			semestar = Semestar.ZIMSKI;
		else
			semestar = Semestar.LETNJI;
		
		BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godinaCb.getSelectedIndex() + 1, null, espb);
		MyFrame.getInstance().azurirajPrikazPredmeta("dodat", 1);
		return greska;
	}
	
	private boolean existsBySifra(int sifra) {
		for(Predmet p: BazaPredmeta.getInstance().getPredmeti())
		{
			if(p.getSifrPredmeta() == sifra)
				return true;
		}
		return false;
	}

}
