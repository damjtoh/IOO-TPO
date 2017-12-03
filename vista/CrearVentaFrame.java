package TPO.vista;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CrearVentaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CrearVentaFrame(Mercado sistema, JFrame ventana) {
		setTitle("Crear venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 400);
		
		JPanel publicacionPanel = new PublicacionPanel();
		publicacionPanel.setSize(490, 308);
		publicacionPanel.setLocation(6, 6);
		contentPane.add(publicacionPanel);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(111, 343, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnCrearVenta = new JButton("Crear venta");
		btnCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sistema.crearPublicacionVentaInmediata(
					sistema.getUsuarioActivo(), 
					txtTitulo.getText(), 
					txtrDescripcion.getText(), 
					txtFormaPago.getText(), 
					txtGarantia.getText(), 
					chckbxGarantiaExtendida.isSelected(), 
					txtTipoContrato.getText(), 
					txtCertificados.getText(), 
					"TEST", 
					Float.valueOf(txtPrecio.getText())
				);
			}
		});
		btnCrearVenta.setBounds(235, 343, 117, 29);
		contentPane.add(btnCrearVenta);
	}
}
