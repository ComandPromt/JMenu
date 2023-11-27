package com.jmenu.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class Cabecera extends JPanel {

	private IconoCabecera icono;

	private JLabel texto;

	@Override
	public void setBackground(Color bg) {

		super.setBackground(bg);

		try {

			icono.setBackground(bg);

		}

		catch (Exception e) {

		}

	}

	public Cabecera() {

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {

				int ancho = 45;

				icono.setBounds(0, 0, ancho, getHeight());

				texto.setBounds(ancho, 0, getWidth() - ancho, getHeight());

			}

		});

		setLayout(null);

		icono = new IconoCabecera();

		icono.setBounds(0, 0, 204, 300);

		add(icono);

		texto = new JLabel("New label");

		texto.setFont(new Font("Dialog", Font.PLAIN, 20));

		texto.setHorizontalAlignment(SwingConstants.CENTER);

		texto.setBounds(203, 0, 247, 300);

		add(texto);

	}

}
