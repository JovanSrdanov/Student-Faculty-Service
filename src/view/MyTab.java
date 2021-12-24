package view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTabbedPane;



public class MyTab extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTab() {
		super();
		
	}
	
	public void addTab(String title, Icon icon, Component component, String tip) {
		super.addTab(title, icon, component, tip);
		
		
	}



	
}
