
package com.jmenu.horizontal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HorizontalMenu extends JPanel {

	@SuppressWarnings("unused")
	private int indice;

	public void setIndice(int indice) {

		this.indice = indice;

	}

	public HorizontalMenu(int align, List<String> list, List<String> iconos, Color foreground, Color background,
			Font font) {

		if (background != null) {

			setBackground(background);

		}

		try {

			if (list != null && !list.isEmpty()) {

				setLayout(new GridLayout(1, list.size()));

			}

			String icon = "";

			for (int i = 0; i < list.size(); i++) {

				if (iconos != null && i < iconos.size()) {

					icon = iconos.get(i);

					if (!new File(icon).exists()) {

						icon = "";

					}

				}

				else {

					icon = "";

				}

				add(new SimpleLabel(list.get(i), foreground, background, icon, font, align, this, i));

			}

		}

		catch (Exception e) {

		}

	}

}
