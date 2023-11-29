
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

import com.jmenu.simple.Prueba;
import com.jmenu.simple.Prueba1;
import com.jmenu.simple.SimpleMenu;

@SuppressWarnings("all")

public class Main extends javax.swing.JFrame {

	public Main() throws IOException {

		setTitle("");

		initComponents();

		setVisible(true);

	}

	public static void main(String[] args) {

		try {

			new Main().setVisible(true);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initComponents() throws IOException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		LinkedList<String> lista = new LinkedList();

		lista.add("AAA");

		lista.add("BBB");

		lista.add("#CCC");

		lista.add("DDD");

		lista.add("EEE");

		LinkedList<JPanel> paneles = new LinkedList();

		paneles.add(new Prueba());

		paneles.add(new Prueba1());

		SimpleMenu panel = new SimpleMenu(lista, paneles);
		panel.setBackground(Color.PINK);

		panel.setAncho(40);

		panel.setHeaderIcon(new ImageIcon("C:\\Users\\7\\Downloads\\descarga (3).png"));

		panel.setFont(new Font("Algerian", Font.PLAIN, 20));

		panel.setText("Menu");

		panel.setForeground(Color.WHITE);

		panel.setItemMenu(Color.BLUE);

		panel.setSeleccionMenu(Color.MAGENTA);

		panel.setFondoMenu(Color.LIGHT_GRAY);

		panel.setColorCabecera(Color.ORANGE);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE));

		getContentPane().setLayout(layout);

		setSize(new Dimension(532, 433));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}

}
