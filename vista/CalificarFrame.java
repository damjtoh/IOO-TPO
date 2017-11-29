package TPO.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;

import java.awt.Font;

public class CalificarFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CalificarFrame() {
		setTitle("Calificar usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUstedEstCalificando = new JLabel("Usted está calificando al usuario ~usuario~ por la compra de ~articulo~");
		lblUstedEstCalificando.setHorizontalAlignment(SwingConstants.CENTER);
		lblUstedEstCalificando.setBounds(5, 5, 440, 35);
		contentPane.add(lblUstedEstCalificando);
		
		JLabel lblCalificacion = new JLabel("8");
		lblCalificacion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCalificacion.setBounds(218, 98, 11, 29);
		contentPane.add(lblCalificacion);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent event) {
                int currentCalificacion = ((JSlider)event.getSource()).getValue();
                System.out.println("Changed: "+String.valueOf(currentCalificacion));
                lblCalificacion.setText(String.valueOf(currentCalificacion));
            }
        });
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(5);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(10);
		slider.setBounds(15, 56, 415, 44);
		contentPane.add(slider);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(327, 132, 117, 29);
		contentPane.add(btnCalificar);
	}
}
