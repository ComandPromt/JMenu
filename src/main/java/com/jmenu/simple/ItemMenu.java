package com.jmenu.simple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class ItemMenu extends JLabel {

	private Color fondo;

	private Color seleccion;

	private Color backgroundColor;

	public Color getSelected() {

		return seleccion;

	}

	public void setSelected(Color selected) {

		this.seleccion = selected;

	}

	public Color getBackgroundColor() {

		return backgroundColor;

	}

	public void setBackgroundColor(Color backgroundColor) {

		this.backgroundColor = backgroundColor;

	}

	public ItemMenu(String text, Color selected, Color background) {

		super(text);

		setHorizontalAlignment(SwingConstants.CENTER);

		if (selected == null) {

			selected = Color.LIGHT_GRAY;

		}

		if (background == null) {

			background = Color.WHITE;

		}

		seleccion = selected;

		backgroundColor = background;

		fondo = backgroundColor;

		addMouseListener(new MouseAdapter() {

			@Override

			public void mouseEntered(MouseEvent e) {

				fondo = seleccion;

				repaint();
			}

			@Override

			public void mouseExited(MouseEvent e) {

				fondo = backgroundColor;

				repaint();

			}

		});

	}

	@Override
	protected void paintComponent(Graphics g) {

		g.setColor(fondo);

		g.fillRect(0, 0, getWidth(), getHeight());

		super.paintComponent(g);

	}

}
