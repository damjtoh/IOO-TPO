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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;

import TPO.controlador.Mercado;
import TPO.modelo.Publicacion;
import TPO.modelo.Transaccion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalificarFrame extends JFrame {

	private JPanel contentPane;
	private int calificaion;
	private CalificarFrame that = this;

	/**
	 * Create the frame.
	 */
	public CalificarFrame(Mercado sistema, Transaccion transaccion, TransaccionesFrame transaccionesFrame) {
		setTitle("Calificar usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUstedEstCalificando = new JLabel("<html>Usted está calificando al usuario <b>"+transaccion.getVendedor().getNombre() +"</b> por la compra de <b>"+ transaccion.getPublicacion().getTitulo()+"</b></html>");
		lblUstedEstCalificando.setHorizontalAlignment(SwingConstants.CENTER);
		lblUstedEstCalificando.setBounds(5, 5, 440, 52);
		contentPane.add(lblUstedEstCalificando);
		
		JLabel lblCalificacion = new JLabel("8");
		lblCalificacion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCalificacion.setBounds(218, 98, 11, 29);
		contentPane.add(lblCalificacion);
		
		JSlider slider = new JSlider();
		slider.setMinimum(1);
		slider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent event) {
                that.calificaion = ((JSlider)event.getSource()).getValue();
                System.out.println("Changed: "+String.valueOf(calificaion));
                lblCalificacion.setText(String.valueOf(calificaion));
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
		btnCalificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				transaccion.getVendedor().calificar(sistema.getUsuarioActivo(), transaccion, that.calificaion);
				JOptionPane.showMessageDialog(null, "Transacción calificada con éxito");
				transaccion.setCalificada();
				transaccionesFrame.setVisible(true);
				dispose();
			}
		});
		btnCalificar.setBounds(327, 132, 117, 29);
		contentPane.add(btnCalificar);
	}
}
