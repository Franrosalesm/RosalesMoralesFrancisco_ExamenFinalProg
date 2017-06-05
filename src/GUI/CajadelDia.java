package GUI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

public class CajadelDia {

	
	protected Window frame3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajadelDia window = new CajadelDia();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CajadelDia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 450, 300);
		((JFrame) frame3).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
