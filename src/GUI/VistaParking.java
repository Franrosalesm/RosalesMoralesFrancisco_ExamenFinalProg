package GUI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import GUI.VistaParking;
import models.Coche;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class VistaParking {

	private JFrame frame;
	private JTextField txtMatricula;
	private List<Coche> lista = new ArrayList<Coche>();  //Implementamos un ArrayList para la clase Coche, 
    //para así poder añadirle los datos que se introducen en la ventana

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaParking window = new VistaParking();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaParking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnEntradaVehculo = new JButton("Entrada Veh\u00EDculo");
		btnEntradaVehculo.setBounds(10, 24, 134, 74);
		getFrame().getContentPane().add(btnEntradaVehculo);
		
		JButton btnPagoYSalida = new JButton("Pago y salida veh\u00EDculos");
		btnPagoYSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Cuando hagamos click aquí, nos lleva hacia otra ventana
				getFrame().dispose();
				PagoySalidaVehiculo p = new PagoySalidaVehiculo();
				 ((Window) p.frame2).setVisible(true);
			}
		});
		btnPagoYSalida.setBounds(146, 24, 167, 74);
		getFrame().getContentPane().add(btnPagoYSalida);
		
		JButton btnCajaDelDa = new JButton("Caja del d\u00EDa");
		btnCajaDelDa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Cuando hagamos click aquí, nos lleva hacia otra ventana
				getFrame().dispose();
				CajadelDia p = new CajadelDia();
				 ((Window) p.frame3).setVisible(true);
				
			}
		});
		btnCajaDelDa.setBounds(316, 24, 101, 74);
		getFrame().getContentPane().add(btnCajaDelDa);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int cont = 0;
				String matricula = null;
				
				cont += validarString(txtMatricula.getText());
				
				String error = "Debes incluir la matricula del coche";
				
				if (cont == 1) { //Si el dato cumple con lo validado, entrará aquí
					
					matricula = txtMatricula.getText();
					Coche p = new Coche(matricula, cont, cont, cont);
					lista.add(p);
					//Se añade el dato introducido en la ventana y se muestra un mensaje de confirmación
					JOptionPane.showMessageDialog( btnRegistrar, "Matricula añadida con éxito", "Mensaje", cont, null);
				}
				
				else {
					JOptionPane.showMessageDialog(frame, error, "ERROR MATRICULA", JOptionPane.ERROR_MESSAGE); //Si no se cumple, mostrará el mensaje de error
				}
			}
		});
		btnRegistrar.setBounds(132, 193, 119, 45);
		getFrame().getContentPane().add(btnRegistrar);
		
		txtMatricula = new JTextField();
		txtMatricula.setForeground(Color.GRAY);
		txtMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtMatricula.setText(""); //Al hacer click, se borrara el texto predeterminado
			}
		});
		txtMatricula.setText("Matricula");
		txtMatricula.setBounds(93, 138, 101, 20);
		getFrame().getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public byte validarString(String cadena) {

		if (cadena.isEmpty() || cadena.equals(null)) {
			return 0;
			
		
		} else {
			return 1;
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
