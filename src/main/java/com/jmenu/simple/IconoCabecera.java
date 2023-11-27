package com.jmenu.simple;

import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IconoCabecera extends JLabel {

	@Override
	protected void paintComponent(Graphics g) {

		g.setColor(getBackground());
		
		g.fillRect(0, 0, getWidth(), getHeight());

		final int UNIDAD = Math.round(getHeight() * 0.2f);

		g.setColor(getForeground());

		g.fillRect(0, 0, getWidth() - 1, UNIDAD);

		g.fillRect(0, UNIDAD * 2, getWidth() - 1, UNIDAD);

		g.fillRect(0, UNIDAD * 4, getWidth() - 1, UNIDAD);

	}

}
