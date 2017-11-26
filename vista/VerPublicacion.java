package TPO.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TPO.modelo.Publicacion;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VerPublicacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VerPublicacion(Publicacion publicacion, MainView mainView) {
		setTitle("Ver publicacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo de la publicación");
		lblTitulo.setBounds(6, 6, 247, 16);
		contentPane.add(lblTitulo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(6, 29, 61, 16);
		contentPane.add(lblPrecio);
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setText("Descripcion");
		txtrDescripcion.setBounds(6, 50, 438, 102);
		contentPane.add(txtrDescripcion);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(80, 243, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(228, 243, 117, 29);
		contentPane.add(btnComprar);
	}
}
