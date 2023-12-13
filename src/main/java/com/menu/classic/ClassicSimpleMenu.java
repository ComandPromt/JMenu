package com.menu.classic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.jmenu.simple.Cabecera;
import com.jmenu.simple.IconoCabecera;
import com.jmenu.simple.ItemMenu;

@SuppressWarnings("serial")
public class ClassicSimpleMenu extends JPanel {

	private int anchoIcono;

	private int alto;

	private int ancho;

	private int alturaPanel;

	private boolean abrir;

	private JPanel panel;

	private IconoCabecera cabecera;

	public JPanel getPanel() {

		return panel;

	}

	public int getAncho() {

		return ancho;

	}

	public void setAncho(int ancho) {

		this.ancho = ancho;

		repaint();

	}

	public void setIcon(Icon icon) {

		try {

			cabecera.setIcon(icon);

		}

		catch (Exception e) {

		}

	}

	public int getAlto() {

		return alto;

	}

	public void setAlto(int alto) {

		this.alto = alto;

		revalidate();

		repaint();

	}

	public int getAlturaPanel() {

		return alturaPanel;

	}

	public void setAlturaPanel(int alturaPanel) {

		this.alturaPanel = alturaPanel;

		revalidate();

		repaint();

	}

	private void click() {

		revalidate();

		repaint();

	}

	private void hacerClick() {

		abrir = !abrir;

		click();

	}

	public ClassicSimpleMenu(Color seleccion, Color fondo, List<String> lista, List<ImageIcon> iconos) {

		addMouseListener(new MouseAdapter() {

			@Override

			public void mousePressed(MouseEvent e) {

				hacerClick();

			}

		});

		if (seleccion == null) {

			seleccion = Color.LIGHT_GRAY;

		}

		if (fondo == null) {

			fondo = Color.WHITE;

		}

		anchoIcono = 100;

		alto = 800;

		ancho = 180;

		alturaPanel = 100;

		setLayout(null);

		cabecera = new IconoCabecera(anchoIcono, anchoIcono);

		cabecera.setBackground(Color.WHITE);

		cabecera.setBounds(0, 0, anchoIcono, anchoIcono);

		add(cabecera);

		panel = new JPanel();

		panel.setBounds(0, anchoIcono, ancho, alturaPanel);

		if (lista != null) {

			panel.setLayout(new GridLayout(lista.size(), 1));

			ItemMenu item;

			Cabecera cabecera;

			for (int i = 0; i < lista.size(); i++) {

				item = new ItemMenu(lista.get(i), seleccion, fondo);

				if (i < iconos.size()) {

					cabecera = new Cabecera();

					cabecera.setIcon(iconos.get(i));

					panel.add(cabecera);

				}

				else {

					panel.add(item);

				}

			}

		}

		add(panel);

		panel.setVisible(false);

	}

	public int getAnchoIcono() {

		return anchoIcono;

	}

	public void setAnchoIcono(int anchoIcono) {

		this.anchoIcono = anchoIcono;

		revalidate();

		repaint();

	}

	@Override
	protected void paintComponent(Graphics g) {

		if (abrir) {

			setSize(ancho, anchoIcono + alturaPanel); // Usa la variable alturaPanel

			panel.setBounds(0, anchoIcono, ancho, alturaPanel);

			panel.setVisible(true); // Muestra el panel

		}

		else {

			setSize(anchoIcono, anchoIcono);

			panel.setBounds(0, anchoIcono, ancho, alturaPanel);

			panel.setVisible(false); // Oculta el panel

			super.paintComponent(g);

		}

	}

}
