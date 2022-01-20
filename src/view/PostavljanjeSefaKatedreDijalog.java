package view;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaProfesora;
import model.Katedra;
import model.Profesor;

public class PostavljanjeSefaKatedreDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6157322927938848633L;

	public PostavljanjeSefaKatedreDijalog(Frame owner, String title, boolean modal, Katedra k) {
		super(owner, title, modal);
		setSize(400, 400);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		JPanel btnPan = new JPanel(new FlowLayout(FlowLayout.LEFT));

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

		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {

			listaMogucihProfesora.add(p);

		}

		for (Profesor p : listaMogucihProfesora) {

			imePrezimeProfesora.add(p.getPrezime() + " " + p.getIme());

		}

		String[] dodaj = new String[imePrezimeProfesora.size()];

		for (int i = 0; i < imePrezimeProfesora.size(); i++) {
			dodaj[i] = imePrezimeProfesora.get(i);
		}

		JList<String> listBox = new JList<String>(dodaj);
		
		listBox.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {

				if (!arg0.getValueIsAdjusting()) {
					postaviSefaKatedreBtn.setEnabled(true);
				}

			}
		});
		
		centerPanel.add(listBox);
		centerPanel.add(btnPan);
		this.add(centerPanel);

	}

}
