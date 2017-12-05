package TPO.vista;

import TPO.controlador.Mercado;
import modelo.Usuario;
import vista.MainAdminView;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ModificarUsuarioView extends JFrame {

	private JPanel contentPane;
	private Mercado sistema;
	private JTextField txtIngreseUsuarioA;
	private JTextField tNom;
	private JTextField tMail;
	private JTextField tDom;
	private JTextField tUsr;
	private JTextField tPwd;

	/**
	 * Create the frame.
	 */
	public ModificarUsuarioView(Mercado a){
		sistema = a;
		initGUI();
		
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Modificar usuario");
		setType(Type.UTILITY);
		setBounds(100, 100, 440, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtIngreseUsuarioA = new JTextField();
		txtIngreseUsuarioA.setSize(291, 20);
		txtIngreseUsuarioA.setLocation(107, 11);
		txtIngreseUsuarioA.setText("Ingrese usuario a modificar");
		contentPane.add(txtIngreseUsuarioA);
		txtIngreseUsuarioA.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u ;
				u = sistema.buscarUsuario(txtIngreseUsuarioA.getText());
				if(u == null)
					JOptionPane.showMessageDialog(null, "El usuario que ingreso no existe");
				else{
					tNom.setText(u.getNombre());
					tMail.setText(u.getMail());
					tDom.setText(u.getDomicilio());
					tUsr.setText(u.getUsr());
					tPwd.setText(u.getPwd());
				}
			}
		});
		btnBuscar.setBounds(10, 10, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 67, 56, 20);
		contentPane.add(lblNombre);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(10, 107, 56, 20);
		contentPane.add(lblMail);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(10, 153, 56, 20);
		contentPane.add(lblDomicilio);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(216, 67, 56, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(216, 110, 56, 20);
		contentPane.add(lblPassword);
		
		tNom = new JTextField();
		tNom.setBounds(65, 67, 121, 20);
		contentPane.add(tNom);
		tNom.setColumns(10);
		
		tMail = new JTextField();
		tMail.setColumns(10);
		tMail.setBounds(65, 107, 121, 20);
		contentPane.add(tMail);
		
		tDom = new JTextField();
		tDom.setColumns(10);
		tDom.setBounds(65, 153, 121, 20);
		contentPane.add(tDom);
		
		tUsr = new JTextField();
		tUsr.setColumns(10);
		tUsr.setBounds(282, 67, 116, 20);
		contentPane.add(tUsr);
		
		tPwd = new JTextField();
		tPwd.setColumns(10);
		tPwd.setBounds(282, 107, 116, 20);
		contentPane.add(tPwd);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = new Usuario(tNom.getText(),tMail.getText(),tDom.getText(),tUsr.getText(),tPwd.getText());
				if(sistema.buscarUsuario(u.getNombre()) == null)
					sistema.modifUsuario(u.getNombre(), u.getDomicilio(), u.getMail(), u.getUsr(), u.getPwd());
				else
					JOptionPane.showMessageDialog(null, "Los datos que ingreso ya existen");
			}
		});
		btnAceptar.setBounds(210, 152, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainAdminView n = new MainAdminView(sistema);
				n.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(309, 152, 89, 23);
		contentPane.add(btnVolver);
		
		
	}
}
