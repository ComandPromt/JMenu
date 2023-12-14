package com.jmenu.simple;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Icono extends JLabel {
	public Icono() {
		setText("dsxxxxxxxxxxxxxxxx");
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("aaaaaaaaaaaaa");
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, getWidth(), getHeight());

//		final int UNIDAD = Math.round(getHeight() * 0.2f);
//
//		g.setColor(getForeground());
//
//		g.fillRect(0, 0, getWidth() - 1, UNIDAD);
//
//		g.fillRect(0, UNIDAD * 2, getWidth() - 1, UNIDAD);
//
//		g.fillRect(0, UNIDAD * 4, getWidth() - 1, UNIDAD);

	}

}
