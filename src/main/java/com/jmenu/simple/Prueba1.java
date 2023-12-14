package com.jmenu.simple;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Prueba1 extends JPanel {

	public Prueba1() {

		setLayout(null);

		JButton btnNewButton = new JButton("Prueba 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton.setBounds(0, 0, 186, 91);

		add(btnNewButton);

	}

}
