
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

import com.jmenu.simple.Cabecera;
import com.jmenu.simple.SimpleMenu;

@SuppressWarnings("all")

public class Main extends javax.swing.JFrame {

	public Main() throws IOException {
		getContentPane().setBackground(Color.PINK);

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

		lista.add("FF");

		LinkedList<JPanel> paneles = new LinkedList();

		paneles.add(new prueba.Prueba());

		paneles.add(new prueba.Prueba1());

		LinkedList<ImageIcon> iconos = new LinkedList();

		iconos.add(new ImageIcon("C:\\Users\\7\\Documents\\2023-12-07_18-05-01.png"));

		iconos.add(null);

		iconos.add(new ImageIcon("C:\\Users\\7\\Documents\\2023-12-07_18-05-01.png"));

		SimpleMenu panel = new SimpleMenu(lista, paneles);
		panel.setText("AAA");

		// panel.setAlturaPanel(400);

		// panel.setIcon(new
		// ImageIcon("C:\\Users\\7\\Documents\\2023-12-07_18-05-01.png"));

		// panel.setAnchoIcono(ABORT);

//		panel.setAncho(40);

		panel.setFont(new Font("Algerian", Font.PLAIN, 20));

		panel.setForeground(Color.WHITE);

		Cabecera lblNewLabel = new Cabecera();
		lblNewLabel.setBackground(Color.WHITE);

//		panel.setItemMenu(Color.BLUE);

		// panel.setSeleccionMenu(Color.MAGENTA);

		// panel.setFondoMenu(Color.LIGHT_GRAY);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(27).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(242, Short.MAX_VALUE)));

		getContentPane().setLayout(layout);

		setSize(new Dimension(532, 552));

		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public void stateChanged(ChangeEvent e) {

	}

}
