package TPO.forms;

import TPO.impl.Admin;
import TPO.impl.Publicacion;
import TPO.impl.Usuario;








import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class frmMainAdmin extends JFrame {

	private JList<String> listUser;
	private JList<String> listPublis;
	private JPanel contentPane;
	private Admin sistema;

	/**
	 * Create the frame.
	 */
	public frmMainAdmin(Admin a) {
		super();
		sistema = a;
		
		initGUI();
	}

	private void initGUI() {
			// TODO Auto-generated method stub
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 446, 320);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			
			getContentPane().setLayout(null);
			
			DefaultListModel<String> dmlUsr = new DefaultListModel<String>();
			DefaultListModel<String> dmlPublis = new DefaultListModel<String>();
			
			ArrayList<Usuario> usuarios = sistema.getUsuarios();
			for(int i=0; i<usuarios.size(); i++){
				dmlUsr.addElement(usuarios.get(i).getUsr());
			}
			
			ArrayList<Publicacion> publicaciones = sistema.getPublicaciones();
			for(int i=0; i<publicaciones.size(); i++){
				dmlPublis.addElement(publicaciones.get(i).getTitulo());
			}
			
			listUser = new JList<String>(dmlUsr);
			listUser.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			listUser.setBackground(Color.WHITE);
			listUser.setBounds(30, 30, 170, 180);
			getContentPane().add(listUser);
			
			listPublis = new JList<String>(dmlPublis);
			listPublis.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Publicaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			listPublis.setBackground(Color.WHITE);
			listPublis.setBounds(240, 30, 167, 181);
			getContentPane().add(listPublis);
			
			JButton btnBorrarUsuario = new JButton("Borrar usuario");
			btnBorrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String usr = listUser.getSelectedValue();
					
					if(sistema.getUsuarioActivo().getUsr().equals(usr))
						JOptionPane.showMessageDialog(null, "No puedes borrarte a ti mismo");
					else{
						if(sistema.bajaUsuario(usr)){
							JOptionPane.showMessageDialog(null, "El usuario"+usr+" ha sido borrado exitosamente");
							dispose();
							frmMainAdmin n = new frmMainAdmin(sistema);
							n.setVisible(true);
						}else
							JOptionPane.showMessageDialog(null, "No se ha podido borrar el usuario "+usr);
						}
					}
				});
			btnBorrarUsuario.setBounds(30, 227, 108, 23);
			contentPane.add(btnBorrarUsuario);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnUsuarios = new JMenu("Usuarios");
			menuBar.add(mnUsuarios);
			
			JMenuItem mntmAltaUsuario = new JMenuItem("Alta usuario");
			mntmAltaUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmAltaUser n = new frmAltaUser(sistema);
					n.setVisible(true);
					dispose();
				}
			});
			mnUsuarios.add(mntmAltaUsuario);
			
			JMenuItem mntmModificarUsuario = new JMenuItem("Modificar usuario");
			mnUsuarios.add(mntmModificarUsuario);
			
	}
}
