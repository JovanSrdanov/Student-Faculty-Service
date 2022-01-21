package view;

import java.awt.Dimension;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.MyApp;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696597433259221588L;
	private static LocalDateTime now;
	private JLabel datumVremeLab;
	private JLabel imeAplikacijeLab;
	private String imeApp;

	public StatusBar() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension((int) this.getSize().getWidth(), 25));
		imeApp = MyApp.resourceBundle.getString("naslovAplikacije");
		imeAplikacijeLab = new JLabel(imeApp +" - "+ MyApp.resourceBundle.getString("studenti"));
		imeAplikacijeLab.setHorizontalAlignment(SwingConstants.LEFT);
		add(imeAplikacijeLab);

		add(Box.createHorizontalGlue());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		now = LocalDateTime.now();
		datumVremeLab = new JLabel(dtf.format(now));
	

		DateFormat df = DateFormat.getDateInstance();
	
		
		datumVremeLab = new JLabel();
		
		add(datumVremeLab);
		
		// https://www.codegrepper.com/code-examples/java/java+repeat+function+every+minute
		 
		 
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// what you want to do
				String datum = df.format(new Date());
				now = LocalDateTime.now();
				datumVremeLab.setText(dtf.format(now) + " " + datum );
			}
		}, 0, 1000);
		//
		
	}

	public void setAktivniTab(int indexTaba) {
		String imeTaba = MyApp.resourceBundle.getString("studenti");
		if (indexTaba == 0) {
			imeTaba = MyApp.resourceBundle.getString("studenti");
		} else if (indexTaba == 1) {
			imeTaba = MyApp.resourceBundle.getString("profesori");
		} else if (indexTaba == 2) {
			imeTaba = MyApp.resourceBundle.getString("predmeti");
		}
		imeAplikacijeLab.setText(imeApp + " - " + imeTaba);
	}

}
