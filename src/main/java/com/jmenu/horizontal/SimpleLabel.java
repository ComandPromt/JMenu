package com.jmenu.horizontal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SimpleLabel extends JLabel {

	public SimpleLabel(String text, Color foreground, Color background, String icon, Font font, int align,
			HorizontalMenu menu, int indice) {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				menu.setIndice(indice);

			}

		});

		setText(text);

		setForeground(foreground);

		setBackground(background);

		setHorizontalAlignment(align);

		setFont(font);

		if (!icon.equals("")) {

			setIcon(new ImageIcon(icon));

		}

	}

}
