package TPO.vista;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;
import TPO.modelo.VentaInmediata;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CrearVentaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CrearVentaFrame(Mercado sistema, JFrame ventana) {
		setTitle("Crear venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel publicacionPanel = new PublicacionPanel(new VentaInmediata(sistema.getUsuarioActivo(), "", "", "", "", false, "", "", "", 0), true);
		publicacionPanel.setSize(490, 308);
		publicacionPanel.setLocation(6, 6);
		contentPane.add(publicacionPanel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(111, 343, 117, 29);
		contentPane.add(btnVolver);
		
		JButton btnCrearVenta = new JButton("Crear venta");
		btnCrearVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sistema.crearPublicacionVentaInmediata(
					sistema.getUsuarioActivo(), 
					((PublicacionPanel) publicacionPanel).getTitulo(),
					(((PublicacionPanel) publicacionPanel).getDescripcion()),
					(((PublicacionPanel) publicacionPanel).getFormaPago()),
					(((PublicacionPanel) publicacionPanel).getGarantia()),
					true,
					(((PublicacionPanel) publicacionPanel).getTipoContrato()), 
					(((PublicacionPanel) publicacionPanel).getCertificados()),
					"TEST", 
					(((PublicacionPanel) publicacionPanel).getPrecio())
				);
			}
		});
		btnCrearVenta.setBounds(235, 343, 117, 29);
		contentPane.add(btnCrearVenta);
	}
}
