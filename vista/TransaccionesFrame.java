package TPO.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

public class TransaccionesFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TransaccionesFrame() {
		setTitle("Mis transacciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(6, 6, 438, 235);
		contentPane.add(list);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(327, 243, 117, 29);
		contentPane.add(btnCalificar);
	}
}
