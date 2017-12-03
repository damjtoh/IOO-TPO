package TPO.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TPO.modelo.Publicacion;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VerPublicacionFrame extends JFrame {

	private JPanel contentPane;
	
	
	public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container)component, enable);
            }
        }
    }

	/**
	 * Create the frame.
	 */
	public VerPublicacionFrame(Publicacion publicacion, ListadoPublicacionesFrame listadoPublicacionesFrame) {
		setTitle("Ver publicacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel publicacionPanel = new PublicacionPanel(publicacion);
		publicacionPanel.setSize(490, 308);
		publicacionPanel.setLocation(6, 6);
		contentPane.add(publicacionPanel);
		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(118, 336, 83, 29);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listadoPublicacionesFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnVolver);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(260, 336, 98, 29);
		contentPane.add(btnComprar);
		
		this.enableComponents(publicacionPanel, false);
	}
}
