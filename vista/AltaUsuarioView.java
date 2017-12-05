package TPO.vista;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TPO.controlador.Mercado;
import vista.MainAdminView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class AltaUsuarioView extends JFrame {
	private JLabel nombreLabel;
	private JLabel domicilioLabel;
	private JButton crearButton;
	private JTextField mailField;
	private JTextField domicilioField;
	private JTextField nombreField;
	private JTextField userField;
	private JTextField passwordField;
	private JLabel mailLabel;
	
	private JPanel contentPane;
	private Mercado sistema;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public AltaUsuarioView(Mercado a){
		super();
		sistema = a;
		
		initGUI();
	}
	
	private boolean validarPass(String pass){
		byte cont_charNum = 0;
		byte cont_charMayus = 0;
		byte cont_char = 0;
		char clave;
		
		for(byte i = 0; i<pass.length(); i++){
			cont_char++; //cantidad de caracteres, min 8 max 20
			clave = pass.charAt(i);
			String passValue = String.valueOf(clave);
			if(passValue.matches("[0-9]"))
				cont_charNum++; // cantidad d nums, minimo 1
			else if (passValue.matches("[A-Z]"))
				cont_charMayus++;// cantidad de mayus, minimo 1		
		}
		
		if(cont_charNum>=1 && cont_charMayus>=1 && 8<=cont_char && cont_char<=20)
			return true;
		else
			return false;
	}

	
	private void initGUI() {

		setTitle("Alta usuario");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 446, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
			getContentPane().setLayout(null);
			
				nombreLabel = new JLabel();
				nombreLabel.setSize(57, 37);
				nombreLabel.setLocation(10, 37);
				getContentPane().add(nombreLabel);
				nombreLabel.setText("Nombre:");
				contentPane.add(nombreLabel);
			
				domicilioLabel = new JLabel();
				domicilioLabel.setSize(65, 43);
				domicilioLabel.setLocation(207, 34);
				getContentPane().add(domicilioLabel);
				domicilioLabel.setText("Domicilio:");
				contentPane.add(domicilioLabel);
				
				mailLabel = new JLabel();
				mailLabel.setLocation(10, 86);
				mailLabel.setSize(50, 30);
				getContentPane().add(mailLabel);
				mailLabel.setText("Mail:");
				contentPane.add(mailLabel);
			
				JLabel userLabel = new JLabel();
				userLabel.setSize(57, 37);
				userLabel.setLocation(10, 141);
				getContentPane().add(userLabel);
				userLabel.setText("Usuario:");
				contentPane.add(userLabel);
			
				JLabel passwordLabel = new JLabel();
				passwordLabel.setSize(65, 37);
				passwordLabel.setLocation(207, 141);
				passwordLabel.setText("Password:");
				getContentPane().add(passwordLabel);
				contentPane.add(passwordLabel);
			
				nombreField = new JTextField();
				nombreField.setSize(115, 25);
				nombreField.setLocation(72, 42);
				nombreField.setColumns(10);
				getContentPane().add(nombreField);
				contentPane.add(nombreField);
			
				domicilioField = new JTextField();
				domicilioField.setSize(115, 25);
				domicilioField.setLocation(72, 88);
				getContentPane().add(domicilioField);
				contentPane.add(domicilioField);
			
				mailField = new JTextField();
				mailField.setSize(115, 25);
				mailField.setLocation(274, 42);
				getContentPane().add(mailField);
				contentPane.add(mailField);
			
				userField = new JTextField();
				userField.setSize(115, 25);
				userField.setLocation(80, 146);
				getContentPane().add(userField);
				contentPane.add(userField);
			
				passwordField = new JTextField();
				passwordField.setSize(115, 25);
				passwordField.setLocation(274, 146);
				getContentPane().add(passwordField);
				contentPane.add(passwordField);
			
				crearButton = new JButton();
				crearButton.setBounds(223, 217, 89, 23);
				crearButton.setText("Crear");
				getContentPane().add(crearButton);
				contentPane.add(crearButton);
				
				crearButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						if(validarPass(passwordField.getText())){
						sistema.altaUsuario(nombreField.getText(), 
								domicilioField.getText(), 
								mailField.getText(), 
								userField.getText(), 
								passwordField.getText());
						
						nombreField.setText("");
						domicilioField.setText("");
						mailField.setText("");
						userField.setText("");
						passwordField.setText("");
						}
						else
							JOptionPane.showMessageDialog(null, "La contraseña no cumple las restricciones, minimo 1 num, 1 mayus, entre 8 y 20 caracteres");
					}
				});
			
				btnNewButton = new JButton("Volver");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MainAdminView n = new MainAdminView(sistema);
						n.setVisible(true);
						dispose();
					}
				});
				btnNewButton.setBounds(134, 217, 89, 23);
				getContentPane().add(btnNewButton);
				contentPane.add(btnNewButton);
			}
			
	}

