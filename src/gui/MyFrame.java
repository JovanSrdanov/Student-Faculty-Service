package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4070509246110827584L;
	
	public static MyFrame instance = null;

	private MyFrame() 
	{
		this.initialise();
		this.createMenuBar();
		this.createToolbar();
	}
	
	//Singleton
	public static MyFrame getInstance()
	{
		if(instance == null)
			instance = new MyFrame();
		
		return instance;
	}
	
	private void createToolbar()
	{
		//Toolbar
		Toolbar toolbar = new Toolbar();
		this.add(toolbar, BorderLayout.NORTH);
	}
	
	private void createMenuBar()
	{
		//Menu bar
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
	}
	
	private void initialise()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidith = screenSize.width;
		setSize((screenWidith / 4) * 3, (screenHeight / 4) * 3);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 95, 105));		
	    this.add(panel);
	}
}
