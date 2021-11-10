package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4070509246110827584L;

	public MyFrame() {
		//Inicijalizacija
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidith = screenSize.width;
		setSize((screenWidith / 4) * 3, (screenHeight / 4) * 3);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.cyan);		
	    this.add(panel);
		
		//Menu bar
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Toolbar toolbar = new Toolbar();
		this.add(toolbar, BorderLayout.NORTH);

	}
}
