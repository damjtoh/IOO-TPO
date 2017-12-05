package TPO.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import TPO.modelo.Usuario;
import TPO.modelo.Calificacion;

public class ReputacionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ReputacionDialog(Usuario usuario) {
		setTitle("Mi reputación");
		setBounds(100, 100, 450, 106);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblTuReputacionEs = new JLabel("<html>La reputación del usuario: <b>"+usuario.getNombre()+"</b>");
			contentPanel.add(lblTuReputacionEs);
		}
		float reputacion = usuario.getReputacionVenta();
		String reputacionMessage = String.valueOf(usuario.getReputacionVenta());
		if (reputacion == 0)
			reputacionMessage = "No tiene suficientes calificaciones.";
		{
			JLabel lblReputacion = new JLabel(reputacionMessage);
			contentPanel.add(lblReputacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
