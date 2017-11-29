package TPO.vista;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ListadoPublicacionesFrame extends JFrame {

	private JPanel contentPane;
	private Mercado sistema;
	private ListadoPublicacionesFrame that = this;

	/**
	 * Create the frame.
	 */
	public ListadoPublicacionesFrame(Mercado a, MainView mainView) {
		
		this.sistema = a;
		
		setTitle("Listado de publicaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultListModel<Publicacion> model = this.getPublicaciones();
		JList<Publicacion> listadoPublicaciones = new JList<Publicacion>(model);
		listadoPublicaciones.setBounds(6, 6, 438, 230);
		contentPane.add(listadoPublicaciones);
		
		addComponentListener ( new ComponentAdapter ()
	    {
	        public void componentShown ( ComponentEvent e )
	        {
	        	listadoPublicaciones.setModel(that.getPublicaciones());
	        }

	        public void componentHidden ( ComponentEvent e )
	        {
	            System.out.println ( "Component hidden" );
	        }
	    } );
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainView.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(85, 243, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnVerPublicacion = new JButton("Ver publicación");
		btnVerPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Publicacion currentPublicacion = listadoPublicaciones.getSelectedValue();
				if (currentPublicacion == null) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una publicación");
				} else {					
					JFrame verPublicacionFrame = new VerPublicacionFrame(currentPublicacion, that);
					verPublicacionFrame.setVisible(true);
					that.setVisible(false);
					System.out.println("Selected publicacion: "+currentPublicacion.toString());
				}
			}
		});
		btnVerPublicacion.setBounds(214, 243, 128, 29);
		contentPane.add(btnVerPublicacion);
	}
	
	private DefaultListModel<Publicacion> getPublicaciones() {
		ArrayList<Publicacion> publicacionesArrayList  = sistema.getPublicaciones();
		DefaultListModel<Publicacion> model = new DefaultListModel<>();
		for (Publicacion publicacion : publicacionesArrayList) {
			model.addElement(publicacion);
		}
		return model;
	}
}
