package TPO.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TPO.impl.Admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class frmAltaUser extends JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton alta;
	private JTextField mail;
	private JTextField domicilio;
	private JTextField nombre;
	private JTextField usr;
	private JTextField pwd;
	private JLabel jLabel3;
	
	private JPanel contentPane;
	private Admin sistema;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public frmAltaUser(Admin a){
		super();
		sistema = a;
		
		initGUI();
	}
	
	private void initGUI() {

		setTitle("Alta usuario");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 446, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
			getContentPane().setLayout(null);
			
				jLabel1 = new JLabel();
				jLabel1.setSize(57, 37);
				jLabel1.setLocation(10, 37);
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre:");
				contentPane.add(jLabel1);
			
				jLabel2 = new JLabel();
				jLabel2.setSize(62, 43);
				jLabel2.setLocation(10, 82);
				getContentPane().add(jLabel2);
				jLabel2.setText("Domicilio:");
				contentPane.add(jLabel2);
				
				jLabel3 = new JLabel();
				jLabel3.setLocation(10, 136);
				jLabel3.setSize(50, 30);
				getContentPane().add(jLabel3);
				jLabel3.setText("Mail:");
				contentPane.add(jLabel3);
			
				JLabel jLabelUsr = new JLabel();
				jLabelUsr.setSize(57, 37);
				jLabelUsr.setLocation(229, 65);
				getContentPane().add(jLabelUsr);
				jLabelUsr.setText("Usuario:");
				contentPane.add(jLabelUsr);
			
				JLabel jLabelPwd = new JLabel();
				jLabelPwd.setSize(50, 37);
				jLabelPwd.setLocation(229, 113);
				jLabelPwd.setText("Password:");
				getContentPane().add(jLabelPwd);
				contentPane.add(jLabelPwd);
			
				nombre = new JTextField();
				nombre.setSize(115, 25);
				nombre.setLocation(80, 43);
				nombre.setColumns(10);
				getContentPane().add(nombre);
				contentPane.add(nombre);
			
				domicilio = new JTextField();
				domicilio.setSize(115, 25);
				domicilio.setLocation(80, 139);
				getContentPane().add(domicilio);
				contentPane.add(domicilio);
			
				mail = new JTextField();
				mail.setSize(115, 25);
				mail.setLocation(80, 91);
				getContentPane().add(mail);
				contentPane.add(mail);
			
				usr = new JTextField();
				usr.setSize(115, 25);
				usr.setLocation(289, 71);
				getContentPane().add(usr);
				contentPane.add(usr);
			
				pwd = new JTextField();
				pwd.setSize(115, 25);
				pwd.setLocation(289, 120);
				getContentPane().add(pwd);
				contentPane.add(pwd);
			
				alta = new JButton();
				alta.setBounds(315, 206, 89, 23);
				alta.setText("Crear");
				getContentPane().add(alta);
				contentPane.add(alta);
				
				alta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						sistema.altaUsuario(nombre.getText(), 
								domicilio.getText(), 
								mail.getText(), 
								usr.getText(), 
								pwd.getText());
						
						nombre.setText("");
						domicilio.setText("");
						mail.setText("");
						usr.setText("");
						pwd.setText("");
						
					}
				});
			
				btnNewButton = new JButton("Volver");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frmMainAdmin n = new frmMainAdmin(sistema);
						n.setVisible(true);
						dispose();
					}
				});
				btnNewButton.setBounds(213, 206, 89, 23);
				getContentPane().add(btnNewButton);
				contentPane.add(btnNewButton);
			}
			
	}

