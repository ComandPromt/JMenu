package com.jmenu.simple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("all")

public class Main extends javax.swing.JFrame {

	public Main() throws IOException {
		getContentPane().setBackground(Color.PINK);

		setTitle("");

		initComponents();

		setVisible(true);

	}

	public static void main(String[] args) {

		try {

			new Main().setVisible(true);

		}

		catch (Exception e) {

		}

	}

	public void initComponents() throws IOException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		LinkedList<String> lista = new LinkedList<>();

		lista.add("Text 1");

		lista.add("Text 2");

		LinkedList<JPanel> paneles = new LinkedList<>();

		paneles.add(new Prueba());

		paneles.add(new Prueba1());

		SimpleMenu panel = new SimpleMenu(lista, paneles, null);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE));

		getContentPane().setLayout(layout);

		setSize(new Dimension(532, 433));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}
}
