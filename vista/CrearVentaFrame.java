package TPO.vista;

import TPO.controlador.Mercado;

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
	private JTextField txtTitulo;
	private JTextField txtPrecio;
	private JTextField txtFormaPago;
	private JTextField txtGarantia;
	private JTextField txtTipoContrato;
	private JTextField txtCertificados;

	/**
	 * Create the frame.
	 */
	public CrearVentaFrame(Mercado sistema, JFrame ventana) {
		setTitle("Crear venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("Título: ");
		lblTtulo.setBounds(6, 6, 61, 16);
		contentPane.add(lblTtulo);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(6, 30, 61, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(6, 52, 75, 16);
		contentPane.add(lblDescripcin);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago:");
		lblFormaDePago.setBounds(235, 30, 97, 16);
		contentPane.add(lblFormaDePago);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setBounds(6, 186, 61, 16);
		contentPane.add(lblGarantia);
		
		JLabel lblTipoContrato = new JLabel("Tipo contrato");
		lblTipoContrato.setBounds(6, 238, 91, 16);
		contentPane.add(lblTipoContrato);
		
		JLabel lblCertificados = new JLabel("Certificados");
		lblCertificados.setBounds(6, 268, 97, 16);
		contentPane.add(lblCertificados);
		
		JLabel lblTipoDePubliacin = new JLabel("Tipo de publiación:");
		lblTipoDePubliacin.setBounds(6, 159, 121, 16);
		contentPane.add(lblTipoDePubliacin);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(57, 1, 423, 26);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(57, 25, 97, 26);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setBounds(6, 73, 474, 74);
		contentPane.add(txtrDescripcion);
		
		txtFormaPago = new JTextField();
		txtFormaPago.setBounds(337, 25, 143, 26);
		contentPane.add(txtFormaPago);
		txtFormaPago.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 155, 52, 27);
		contentPane.add(comboBox);
		
		txtGarantia = new JTextField();
		txtGarantia.setBounds(70, 181, 166, 26);
		contentPane.add(txtGarantia);
		txtGarantia.setColumns(10);
		
		txtTipoContrato = new JTextField();
		txtTipoContrato.setBounds(93, 233, 143, 26);
		contentPane.add(txtTipoContrato);
		txtTipoContrato.setColumns(10);
		
		txtCertificados = new JTextField();
		txtCertificados.setBounds(85, 263, 143, 26);
		contentPane.add(txtCertificados);
		txtCertificados.setColumns(10);
		
		JCheckBox chckbxGarantiaExtendida = new JCheckBox("Garantia extendida");
		chckbxGarantiaExtendida.setBounds(6, 214, 179, 23);
		contentPane.add(chckbxGarantiaExtendida);
		
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
