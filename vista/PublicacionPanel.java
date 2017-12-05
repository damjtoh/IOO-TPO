package TPO.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
	private JTextArea txtrDescripcion;
	private JTextField txtGarantia;
	private JTextField txtCertificados;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_1;
	
	public PublicacionPanel(Publicacion publicacion, boolean isEmpty) {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 490, 358);
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
		
		JLabel lblTtulo = new JLabel("Titulo: ");
		lblTtulo.setBounds(6, 6, 61, 16);
		add(lblTtulo);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(6, 30, 61, 16);
		add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripcion");
		lblDescripcin.setBounds(6, 52, 75, 16);
		add(lblDescripcin);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago:");
		lblFormaDePago.setBounds(235, 30, 97, 16);
		add(lblFormaDePago);
		
		JLabel lblGarantia = new JLabel("Garantia:");
		lblGarantia.setBounds(6, 186, 61, 16);
		add(lblGarantia);
		
		JLabel lblTipoContrato = new JLabel("Tipo contrato");
		lblTipoContrato.setBounds(6, 198, 91, 16);
		add(lblTipoContrato);
		
		JLabel lblCertificados = new JLabel("Certificados");
		lblCertificados.setBounds(6, 230, 97, 16);
		add(lblCertificados);
		
		JLabel lblTipoDePubliacin = new JLabel("Tipo de publiacion:");
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
		
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setText(descripcion);
		txtrDescripcion.setBounds(6, 73, 474, 74);
		add(txtrDescripcion);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"ABONO", "UNICA VEZ"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(123, 193, 84, 27);
		add(comboBox_1);
		
		JCheckBox chckbxGarantiaExtendida = new JCheckBox("Garantia extendida");
		chckbxGarantiaExtendida.setBounds(6, 214, 179, 23);
		add(chckbxGarantiaExtendida);
		
		txtGarantia = new JTextField();
		txtGarantia.setText(garantia);
		txtGarantia.setBounds(70, 181, 166, 26);
		add(txtGarantia);
		txtGarantia.setColumns(10);
		
		txtCertificados = new JTextField();
		txtCertificados.setText(certificados);
		txtCertificados.setBounds(80, 225, 143, 26);
		add(txtCertificados);
		txtCertificados.setColumns(10);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"DEBITO", "CREDITO", "EFECTIVO"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(338, 28, 84, 27);
		add(comboBox_2);
		
		txtGarantia.setVisible(false);
		txtCertificados.setVisible(false);
		chckbxGarantiaExtendida.setVisible(false);
		comboBox_1.setVisible(false);
		lblGarantia.setVisible(false);
		lblTipoContrato.setVisible(false);
		lblCertificados.setVisible(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"SERVICIO", "PRODUCTO"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(123, 155, 84, 27);
		add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBox.getSelectedIndex() == 0)
				{
					lblTipoContrato.setVisible(true);
					txtCertificados.setVisible(true);
					lblCertificados.setVisible(true);
					comboBox_1.setVisible(true);
					txtGarantia.setVisible(false);
					chckbxGarantiaExtendida.setVisible(false);
					lblGarantia.setVisible(false);		
				}
				else
				{
					txtGarantia.setVisible(true);
					txtCertificados.setVisible(false);
					chckbxGarantiaExtendida.setVisible(true);
					comboBox_1.setVisible(false);
					lblGarantia.setVisible(true);
					lblTipoContrato.setVisible(false);
					lblCertificados.setVisible(false);
					
				}
				
			}
		});
		
	}
	
	public String getTitulo() {
		return txtTitulo.getText();
	}
	
	public String getDescripcion() {
		return txtrDescripcion.getText();
	}
	
	public String getGarantia() {
		return txtGarantia.getText();
	}	
	
	public String getCertificados() {
		return txtCertificados.getText();
	}
	
	public Float getPrecio() {
		return Float.valueOf(txtPrecio.getText());
	}
	
	public String getFormaPago(){
		return comboBox_2.getSelectedItem().toString();
		
	}
	
	public String getTipoContrato(){
		return comboBox_1.getSelectedItem().toString();
	
	}
}