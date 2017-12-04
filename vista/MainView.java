package TPO.vista;




import TPO.controlador.Mercado;
import TPO.vista.ListadoPublicacionesFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Mercado sistema;

	/**
	 * Launch the application.
	 */
		
	public MainView(Mercado a) {
		super();
		sistema = a;
		initGUI();
		System.out.println("Sistema: "+a.toString());
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 332);
		setResizable(false);
		setTitle("Mercado");

		// Instanciamos el frame de listado de publicaciones y lo ocultamos
		JFrame listadoPublicacionesFrame = new ListadoPublicacionesFrame(this.sistema, this);
		listadoPublicacionesFrame.setVisible(false);
		listadoPublicacionesFrame.addComponentListener(new ComponentAdapter() {
//			public void componentHidden(ComponentEvent e) 
//			{
//			    /* code run when component hidden*/
//			}
			public void componentShown(ComponentEvent e) {
			    /* code run when component shown */
			}
			});
		
		//Instanciamos el frame de crear venta y lo ocultamos
		JFrame crearVentaFrame = new CrearVentaFrame(this.sistema, this);
		crearVentaFrame.setVisible(false);
		
		
		//Instanciamos el frame de reputacion
		JDialog reputacionDialog = new ReputacionDialog();
		reputacionDialog.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPublicaciones = new JMenu("Publicaciones");
		menuBar.add(mnPublicaciones);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnPublicaciones.add(mntmListado);
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				System.out.println(evt.getActionCommand());
				System.out.println("Clickié el listado!");
				listadoPublicacionesFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem mntmCrearPublicacion = new JMenuItem("Crear publicación");
		mnPublicaciones.add(mntmCrearPublicacion);
		mntmCrearPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				crearVentaFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem mntmCrearSubasta = new JMenuItem("Crear subasta");
		mnPublicaciones.add(mntmCrearSubasta);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmMiReputacin = new JMenuItem("Mi reputación");
		mnPerfil.add(mntmMiReputacin);
		mntmMiReputacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				reputacionDialog.setVisible(true);
//				setVisible(false);
			}
		});
		
		JMenuItem mntmMisTransacciones = new JMenuItem("Mis transacciones");
		mnPerfil.add(mntmMisTransacciones);
		mntmMisTransacciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				//Instanciamos el frame de listado de transaccinoes
				JFrame transaccionesFrame = new TransaccionesFrame(sistema);
				transaccionesFrame.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		getContentPane().setLayout(new CardLayout(0, 0));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblBienvenidoAlMercado = new JLabel("Bienvenido al mercado!");
		lblBienvenidoAlMercado.setBounds(133, 119, 150, 16);
		contentPane.add(lblBienvenidoAlMercado);
	}
}