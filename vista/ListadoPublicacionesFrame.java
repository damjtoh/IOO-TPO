package TPO.vista;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		DefaultListModel<String> model = new DefaultListModel<String>();
//		ArrayList<Publicacion> publicaciones = sistema.getPublicaciones();
//		if (!publicaciones.isEmpty()) {			
//			for (Publicacion publicacion : publicaciones) {
//				model.addElement(publicacion.getTitulo() + " \t\t\t $" + publicacion.getPrecio());
//			}
//		}
		ArrayList<Publicacion> publicacionesArrayList  = sistema.getPublicaciones();
		Publicacion[] publicaciones = new Publicacion[publicacionesArrayList.size()];
		publicacionesArrayList.toArray(publicaciones);
		JList<Publicacion> listadoPublicaciones = new JList<Publicacion>(publicaciones);
		listadoPublicaciones.setBounds(6, 6, 438, 230);
		contentPane.add(listadoPublicaciones);
		
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
	
	private void getPublicaciones() {
		
	}
}
