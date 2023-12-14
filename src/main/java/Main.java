
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

import com.jmenu.paneles.TextoConIcono;
import com.jmenu.simple.Prueba;
import com.jmenu.simple.Prueba1;
import com.jmenu.simple.Prueba2;
import com.jmenu.simple.Prueba3;
import com.jmenu.simple.Prueba4;
import com.jmenu.simple.Prueba5;
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

		lista.add("#");

		lista.add("#CCC");

		lista.add("#");

		lista.add("DDD");

		lista.add("EEE");

		LinkedList<JPanel> paneles = new LinkedList();

		paneles.add(new Prueba());

		paneles.add(new Prueba1());

		paneles.add(new Prueba2());

		paneles.add(new Prueba3());

		paneles.add(new Prueba4());

		paneles.add(new Prueba5());

		LinkedList<JComponent> components = new LinkedList<>();

		components
				.add(new TextoConIcono("aaa", new ImageIcon("C:\\Users\\7\\Downloads\\descarga.png"), 40, Color.WHITE));

		components.add(new JLabel("wwww"));

		SimpleMenu panel = null;

		try {

			panel = new SimpleMenu(lista, null, components);

			panel.setAnchoIcono(40);

			panel.setAnchoMenu(300);

			panel.setAlturaMenu(1000);

			panel.setHeaderIcon(new ImageIcon("C:\\Users\\7\\Downloads\\descarga.png"));

			panel.setFont(new Font("Algerian", Font.PLAIN, 20));

			panel.setText("Menu");

			panel.setForeground(Color.WHITE);

			panel.setItemMenu(Color.BLUE);

			panel.setSeleccionMenu(Color.MAGENTA);

			panel.setFondoMenu(Color.LIGHT_GRAY);

			panel.setColorCabecera(Color.ORANGE);
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE));

		getContentPane().setLayout(layout);

		setSize(new Dimension(866, 647));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}

}
