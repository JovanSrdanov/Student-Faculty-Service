package view;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;
	private static LocalDateTime now;
	private JLabel datumVremeLab;
	private JLabel imeAplikacijeLab;
	private final String imeApp = "Studentska služba";

	public StatusBar() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension((int)this.getSize().getWidth(), 25));
		imeAplikacijeLab = new JLabel(imeApp);
		imeAplikacijeLab.setHorizontalAlignment(SwingConstants.LEFT);
		add(imeAplikacijeLab);

		add(Box.createHorizontalGlue());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		now = LocalDateTime.now();
		datumVremeLab = new JLabel(dtf.format(now));
		add(datumVremeLab);

		// https://www.codegrepper.com/code-examples/java/java+repeat+function+every+minute
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// what you want to do
				now = LocalDateTime.now();
				datumVremeLab.setText(dtf.format(now));
			}
		}, 0, 1000);
		//
	}

	public void setAktivniTab(int indexTaba) {
		String imeTaba = "";
		if (indexTaba == 0) {
			imeTaba = "Studenti";
		} else if (indexTaba == 1) {
			imeTaba = "Profesori";
		} else if (indexTaba == 2) {
			imeTaba = "Predmeti";
		}
		imeAplikacijeLab.setText(imeApp + " - " + imeTaba);
	}

}
