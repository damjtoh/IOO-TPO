package TPO.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;
import TPO.modelo.Transaccion;

public class TransaccionesFrame extends JFrame {

	private JPanel contentPane;
	private Mercado sistema;
	private JFrame that = this;

	/**
	 * Create the frame.
	 */
	public TransaccionesFrame(Mercado sistema) {
		setTitle("Mis transacciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Transaccion> list = new JList<Transaccion>(this.getTransaccionesModel());
		list.setBounds(6, 6, 438, 235);
		contentPane.add(list);
		
		
		addComponentListener ( new ComponentAdapter ()
	    {
	        public void componentShown ( ComponentEvent e )
	        {
	        	System.out.println("Listado de publicaciones is now showed");
	        	list.setModel(that.getTransaccionesModel());
	        }

	        public void componentHidden ( ComponentEvent e )
	        {
	            System.out.println ( "Component hidden" );
	        }
	    } );
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(327, 243, 117, 29);
		contentPane.add(btnCalificar);
	}
	
	private DefaultListModel<Transaccion> getTransaccionesModel() {
		ArrayList<Transaccion> transaccionesArrayList  = sistema.getTransacciones();
		DefaultListModel<Transaccion> model = new DefaultListModel<>();
		for (Transaccion transaccion : transaccionesArrayList) {
			model.addElement(transaccion);
		}
		return model;
	}
}
