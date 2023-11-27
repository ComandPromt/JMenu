package com.jmenu.simple;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class SimpleMenu2 extends JPanel {

	private JPanel categorias;

	private boolean menuAbierto;

	private JPanel menu;

	private List<String> categories;

	private boolean test;

	private SimpleMenu2 esto;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	public JPanel getCategorias() {

		return categorias;

	}

	public void setCategorias(JPanel categorias) {

		this.categorias = categorias;

	}

	public SimpleMenu2(List<String> categories) {

		addComponentListener(new ComponentAdapter() {

			@Override

			public void componentResized(ComponentEvent e) {

				menu.setBounds(0, 50, getWidth(), getHeight() - 50);

			}

		});

		this.categories = categories;

		categorias = new JPanel();

		setLayout(null);

		menu = new JPanel();

		menu.setBackground(Color.PINK);

		menu.setBounds(0, 0, 450, 301);

		add(menu);

		menu.setLayout(null);

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(4, 1));
		panel.setBounds(0, 0, 300, 301);
		menu.add(panel);
		panel.setBackground(Color.YELLOW); // Establece un color de fondo para el panel

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setBounds(0, 0, 168, 75); // Ajusta la posición y el tamaño según sea necesario

		lblNewLabel_1.repaint();
		panel.add(lblNewLabel_1);
		repaint();
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		esto = this;

	}
}
