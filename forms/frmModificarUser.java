package TPO.forms;

import TPO.impl.Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class frmModificarUser extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Admin sistema;

	/**
	 * Create the frame.
	 */
	public frmModificarUser(Admin a){
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
