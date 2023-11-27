package com.jmenu.simple;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class SimpleMenu extends JPanel {

	private Cabecera cabecera;

	private JPanel categorias;

	private boolean menuAbierto;

	private JPanel menu;

	private List<String> categories;

	private boolean test;

	private SimpleMenu esto;

	private ArrayList<ItemMenu> items;

	private Color seleccion;

	private Color fondoMenu;

	public JPanel getCategorias() {

		return categorias;

	}

	public void setCategorias(JPanel categorias) {

		this.categorias = categorias;

	}

	public Color getSeleccion() {

		return seleccion;

	}

	public void setSeleccion(Color seleccion) {

		this.seleccion = seleccion;

	}

	public Color getFondoMenu() {

		return fondoMenu;

	}

	public void setFondoMenu(Color fondoMenu) {

		this.fondoMenu = fondoMenu;

	}

	public SimpleMenu(List<String> categories) {

		seleccion = Color.LIGHT_GRAY;

		fondoMenu = Color.WHITE;

		items = new ArrayList();

		addComponentListener(new ComponentAdapter() {

			@Override

			public void componentResized(ComponentEvent e) {

				cabecera.setBounds(0, 0, getWidth(), 50);

				menu.setBounds(0, 50, getWidth(), getHeight() - 50);

			}

		});

		this.categories = categories;

		categorias = new JPanel();

		setLayout(null);

		cabecera = new Cabecera();

		cabecera.setBackground(Color.ORANGE);

		cabecera.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				try {

					abrirMenu(!menuAbierto);

				}

				catch (Exception e1) {

					e1.printStackTrace();

				}

			}

		});

		cabecera.setBounds(0, 0, 450, 50);

		add(cabecera);

		cabecera.setLayout(null);

		menu = new JPanel();

		menu.setBackground(Color.PINK);

		menu.setBounds(0, 50, 450, 251);

		add(menu);

		menu.setLayout(null);

		esto = this;

	}

	private void abrirMenu(boolean abrir) {

		if (abrir) {

			categorias.setBounds(0, 0, 146, menu.getHeight());

			categorias.setLayout(new GridLayout(categories.size(), 1));

			menu.add(categorias);

			ItemMenu item;

			categorias.removeAll();

			items.clear();

			for (String nombre : categories) {

				item = new ItemMenu(nombre, Color.LIGHT_GRAY, Color.WHITE);

				items.add(item);

				categorias.add(item);

			}

			categorias.setVisible(true);

			categorias.repaint();

			repaint();

			if (!test) {

				test = true;

				abrirMenu(false);

				abrirMenu(true);

			}

		}

		else {

			categorias.removeAll();

			categorias.setVisible(false);

		}

		menuAbierto = !menuAbierto;

	}

}
