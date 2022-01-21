package view;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MyApp;
import model.BazaKatedri;

import model.Katedra;


public class KatedraDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5756133743805054823L;
	private static Tabela katedreTable;

	public Tabela getKatedreTable() {
		return katedreTable;
	}

	private KatedraDijalog prozor;

	public KatedraDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(800, 500);
		setResizable(false);
		prozor = this;

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		katedreTable = new Tabela(new AbstractTableModelKatedra());
		katedreTable.setAutoCreateRowSorter(true);
		JScrollPane scrollPaneKatedra = new JScrollPane(katedreTable);

		JPanel btnPan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton postaviSefaKatedreBtn = new JButton( MyApp.resourceBundle.getString("setSef"));
		JButton odustaniBtn = new JButton(MyApp.resourceBundle.getString("odustani"));

		odustaniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		postaviSefaKatedreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelectedIndex = katedreTable.getSelectedRow();
				if (rowSelectedIndex != -1) {
					int a = katedreTable.convertRowIndexToModel(rowSelectedIndex);
					Katedra k = BazaKatedri.getInstance().getRow(a);
					
					DodajSefaKatedriDialog dijag = new DodajSefaKatedriDialog(null,
							 MyApp.resourceBundle.getString("setSef"), true,k);
					dijag.setLocationRelativeTo(prozor);
					dijag.setVisible(true);
				}

			}
		});

		btnPan.add(postaviSefaKatedreBtn);
		btnPan.add(odustaniBtn);
		centerPanel.add(btnPan);
		centerPanel.add(scrollPaneKatedra);
		this.add(centerPanel);

	}
	public static void azurirajPrikazKatedre() {
		AbstractTableModelKatedra model = (AbstractTableModelKatedra) katedreTable.getModel();
		model.fireTableDataChanged();
		// validate();
	}
	
}
