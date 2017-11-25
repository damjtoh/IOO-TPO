package TPO.vista;

import TPO.controlador.Mercado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ModificarUsuarioView extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Mercado sistema;

	/**
	 * Create the frame.
	 */
	public ModificarUsuarioView(Mercado a){
		sistema = a;
		initGUI();
		
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

}
