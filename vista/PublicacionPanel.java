package TPO.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import TPO.modelo.Publicacion;

public class PublicacionPanel extends JPanel {
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtPrecio;
	private JTextField txtFormaPago;
	private JTextField txtGarantia;
	private JTextField txtTipoContrato;
	private JTextField txtCertificados;
	
	public PublicacionPanel(Publicacion publicacion, boolean isEmpty) {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 490, 400);
		setLayout(null);
		
		String titulo = "";
		String precio = "";
		String descripcion = "";
		String formasDePago = "";
		String garantia = "";
		String tipoContrato = "";
		String certificados = "";
		
		if (!isEmpty) {
			titulo = publicacion.getTitulo();
			precio = "$"+String.valueOf(publicacion.getPrecio());
			descripcion = publicacion.getDescripcion();
			formasDePago = (publicacion.getFormaspago() != null) ? publicacion.getFormaspago().toString() : "";
			garantia = publicacion.getGarantia();
			tipoContrato = publicacion.getTipoContrato();
			certificados = publicacion.getCertificados();
		}
		
		JLabel lblTtulo = new JLabel("Título: ");
		lblTtulo.setBounds(6, 6, 61, 16);
		add(lblTtulo);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(6, 30, 61, 16);
		add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(6, 52, 75, 16);
		add(lblDescripcin);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago:");
		lblFormaDePago.setBounds(235, 30, 97, 16);
		add(lblFormaDePago);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setBounds(6, 186, 61, 16);
		add(lblGarantia);
		
		JLabel lblTipoContrato = new JLabel("Tipo contrato");
		lblTipoContrato.setBounds(6, 238, 91, 16);
		add(lblTipoContrato);
		
		JLabel lblCertificados = new JLabel("Certificados");
		lblCertificados.setBounds(6, 268, 97, 16);
		add(lblCertificados);
		
		JLabel lblTipoDePubliacin = new JLabel("Tipo de publiación:");
		lblTipoDePubliacin.setBounds(6, 159, 121, 16);
		add(lblTipoDePubliacin);
		
		txtTitulo = new JTextField();
		txtTitulo.setText(titulo);
		txtTitulo.setBounds(57, 1, 423, 26);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setText(precio);
		txtPrecio.setBounds(57, 25, 97, 26);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setText(descripcion);
		txtrDescripcion.setBounds(6, 73, 474, 74);
		add(txtrDescripcion);
		
		txtFormaPago = new JTextField();
		txtFormaPago.setText(formasDePago);
		txtFormaPago.setBounds(337, 25, 143, 26);
		add(txtFormaPago);
		txtFormaPago.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 155, 52, 27);
		add(comboBox);
		
		txtGarantia = new JTextField();
		txtGarantia.setText(garantia);
		txtGarantia.setBounds(70, 181, 166, 26);
		add(txtGarantia);
		txtGarantia.setColumns(10);
		
		txtTipoContrato = new JTextField();
		txtTipoContrato.setText(publicacion.getTipoContrato());
		txtTipoContrato.setBounds(93, 233, 143, 26);
		add(txtTipoContrato);
		txtTipoContrato.setColumns(10);
		
		txtCertificados = new JTextField();
		txtCertificados.setText(publicacion.getCertificados());
		txtCertificados.setBounds(85, 263, 143, 26);
		add(txtCertificados);
		txtCertificados.setColumns(10);
		
		JCheckBox chckbxGarantiaExtendida = new JCheckBox("Garantia extendida");
		chckbxGarantiaExtendida.setBounds(6, 214, 179, 23);
		add(chckbxGarantiaExtendida);
	}

}
