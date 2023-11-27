package com.jmenu;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import com.jmenu.simple.SimpleMenu;

@SuppressWarnings("serial")

public class MaterialMenu extends JPanel {
	
	public MaterialMenu(int type,List<String>categories) {
		
		setLayout(new GridLayout(1, 0, 0, 0));
	
		switch(type) {
		
		case 2:
			
			break;
			
			default:
			
				add(new SimpleMenu(categories));
				
			break;
		
		}
		
	}

}
