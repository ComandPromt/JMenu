package com.jmenu.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class SimpleMenu extends JPanel {

	private Color colorCabecera;

	private Color itemMenu;

	private Cabecera cabecera;

	private JPanel categorias;

	private boolean menuAbierto;

	private JPanel menu;

	private List<String> categories;

	private boolean test;

	private ArrayList<ItemMenu> items;

	private Color seleccion;

	private Color fondoMenu;

	private JPanel btnNewButton;

	private JPanel panel;

	private int indice;

	private List<JPanel> paneles;

	private int ancho;

	@Override
	public void setFont(Font font) {

		try {

			cabecera.setFont(font);

		}

		catch (Exception e) {

		}

	}

	@Override
	public void setForeground(Color fg) {

		try {

			cabecera.setForeground(fg);

		}

		catch (Exception e) {

		}

	}

	public void setHeaderIcon(Icon icon) {

		try {

			cabecera.setIcon(icon);

		}

		catch (Exception e) {

		}

	}

	public void setText(String text) {

		try {

			cabecera.setText(text);

		}

		catch (Exception e) {

		}

	}

	public int getAncho() {

		return ancho;

	}

	public void setAncho(int ancho) {

		this.ancho = ancho;

	}

	public JPanel getCategorias() {

		return categorias;

	}

	public void setCategorias(JPanel categorias) {

		this.categorias = categorias;

	}

	public Color getItemMenu() {

		return itemMenu;

	}

	public void setItemMenu(Color itemMenu) {

		this.itemMenu = itemMenu;

	}

	public Color getColorCabecera() {

		return colorCabecera;

	}

	public void setColorCabecera(Color colorCabecera) {

		try {

			this.colorCabecera = colorCabecera;

			cabecera.setBackground(colorCabecera);

		}

		catch (Exception e) {

		}

	}

	public Color getSeleccionMenu() {

		return seleccion;

	}

	public void setSeleccionMenu(Color seleccionMenu) {

		this.seleccion = seleccionMenu;

	}

	public Color getFondoMenu() {

		return fondoMenu;

	}

	public void setFondoMenu(Color fondoMenu) {

		this.fondoMenu = fondoMenu;

	}

	private void clickMenu() {

		try {

			abrirMenu(!menuAbierto);

		}

		catch (Exception e1) {

		}

	}

	public SimpleMenu(List<String> categories, List<JPanel> panels) {

		indice = -1;

		ancho = 145;

		try {

			this.panel = panels.get(0);

		}

		catch (Exception e) {

		}

		paneles = panels;

		seleccion = Color.LIGHT_GRAY;

		fondoMenu = Color.WHITE;

		items = new ArrayList<>();

		addComponentListener(new ComponentAdapter() {

			@Override

			public void componentResized(ComponentEvent e) {

				cabecera.setBounds(0, 0, getWidth(), 50);

				menu.setBounds(0, 50, getWidth(), getHeight() - 50);

				clickMenu();

			}

		});

		this.categories = categories;

		categorias = new JPanel();

		setLayout(null);

		cabecera = new Cabecera();

		colorCabecera = Color.WHITE;

		cabecera.setBackground(colorCabecera);

		cabecera.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				clickMenu();

			}

		});

		add(cabecera);

		cabecera.setLayout(null);

		menu = new JPanel();

		menu.setBackground(Color.GREEN);

		add(menu);

		menu.setLayout(new GridLayout());

		try {

			abrirMenu(false);

		}

		catch (Exception e) {

		}

	}

	void abrirMenu(boolean abrir) {

		try {

			if (abrir) {

				menu.removeAll();

				categorias.setBounds(0, 0, ancho, menu.getHeight());

				categorias.setLayout(new GridLayout(categories.size(), 1));

				menu.add(categorias);

				ItemMenu item;

				categorias.removeAll();

				items.clear();

				JLabel label;

				for (int i = 0; i < categories.size(); i++) {

					if (categories.get(i).startsWith("#")) {

						label = new JLabel(categories.get(i).substring(1));

						label.setBackground(Color.WHITE);

						label.setForeground(itemMenu);

						categorias.add(label);

					}

					else {

						item = new ItemMenu(categories.get(i), seleccion, fondoMenu);

						if (itemMenu != null) {

							item.setForeground(itemMenu);

							if (i < paneles.size()) {

								item.setPanel(i, this);

							}

						}

						items.add(item);

						categorias.add(item);

					}

				}

				categorias.setVisible(true);

				categorias.repaint();

				repaint();

				if (!test) {

					test = true;

					abrirMenu(false);

					abrirMenu(true);

				}

				if (indice > -1) {

					try {

						panel = paneles.get(indice);

					}

					catch (Exception e) {

					}

				}

				panel.setBounds(categorias.getWidth(), 0, menu.getWidth() - categorias.getWidth(), menu.getHeight());

				btnNewButton = panel;

				menu.add(btnNewButton);

			}

			else {

				categorias.removeAll();

				categorias.setVisible(false);

				panel.setBounds(0, 0, menu.getWidth(), menu.getHeight());

				panel = new Prueba();

				btnNewButton = panel;

				menu.setLayout(null);

				menu.add(panel);

			}

			menuAbierto = !menuAbierto;

		}

		catch (Exception e) {

		}

	}

	public void setPanel(int indice) {

		try {

			this.indice = indice;

			this.panel = paneles.get(indice);

			menu.removeAll();

			categorias.setBounds(0, 0, 146, menu.getHeight());

			categorias.setLayout(new GridLayout(categories.size(), 1));

			menu.add(categorias);

			ItemMenu item;

			categorias.removeAll();

			items.clear();

			for (int i = 0; i < categories.size(); i++) {

				item = new ItemMenu(categories.get(i), seleccion, fondoMenu);

				if (itemMenu != null) {

					item.setForeground(itemMenu);

				}

				items.add(item);

				categorias.add(item);

			}

			categorias.setVisible(true);

			panel.setBounds(categorias.getWidth(), 0, menu.getWidth() - categorias.getWidth(), menu.getHeight());

			btnNewButton = panel;

			menu.add(btnNewButton);

			abrirMenu(false);

		}

		catch (Exception e) {

		}

	}

}
