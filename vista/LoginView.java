package TPO.vista;
import TPO.controlador.Mercado;
import TPO.vista.MainView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usrField;
	private JTextField passField;
	
	private Mercado sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Ingresar");
		initGUI();
		sistema = new Mercado();
	}
	
	private void initGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 187, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		contentPane.add(lblUsuario);
		lblUsuario.setBounds(10, 6, 59, 50);
		
		JLabel lblPassword = new JLabel("Password:");
		contentPane.add(lblPassword);
		lblPassword.setBounds(10, 45, 69, 50);
		
		usrField = new JTextField();
		contentPane.add(usrField);
		usrField.setColumns(10);
		usrField.setBounds(70, 21, 140, 20);
		usrField.setSize(100, 20);
		
		
		passField = new JTextField();
		contentPane.add(passField);
		passField.setColumns(10);
		passField.setBounds(70, 60, 140, 20);
		passField.setSize(100, 20);
		
		JButton btnLoguear = new JButton("Loguear");
		btnLoguear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(sistema.login(usrField.getText(),passField.getText()))
				{
					if(sistema.sosAdmin(sistema.getUsuarioActivo())){
							MainAdminView n = new MainAdminView(sistema);
							n.setVisible(true);
					}else{
						System.out.println("No es admin");
						MainView n = new MainView(sistema);
						n.setVisible(true);
					}
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos o no existen");					
				}
			}
		});
		btnLoguear.setBounds(49, 107, 89, 23);
		contentPane.add(btnLoguear);
	}
}
