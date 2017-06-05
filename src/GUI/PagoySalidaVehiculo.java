package GUI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import models.Coche;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class PagoySalidaVehiculo {
	protected JFrame frame2;
	private JTextField txtMatricula;
	private JTextField txtHoraEntrada;
	private JTextField txtHoraSalida;
	private JTextField txtImporteEntregado;
	private List<Coche> lista = new ArrayList<Coche>(); //Implementamos un ArrayList para la clase Coche, 
	                                                    //para así poder añadirle los datos que se introducen en la ventana
	
	private String error; //Inicializamos un mensaje de error 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoySalidaVehiculo window = new PagoySalidaVehiculo();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PagoySalidaVehiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JButton button = new JButton("Entrada Veh\u00EDculo");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Cuando hagamos click aquí, nos lleva hacia otra ventana
				frame2.dispose();
				VistaParking p = new VistaParking();
				 ((Window) p.getFrame()).setVisible(true);
			}
		});
		button.setBounds(10, 22, 134, 74);
		frame2.getContentPane().add(button);
		
		JButton button_1 = new JButton("Pago y salida veh\u00EDculos");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(145, 22, 171, 74);
		frame2.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Caja del d\u00EDa");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { //Cuando hagamos click aquí, nos lleva hacia otra ventana
				
				getFrame2().dispose();
				CajadelDia p = new CajadelDia();
				 ((Window) p.frame3).setVisible(true);
			}
		});
		button_2.setBounds(319, 22, 105, 74);
		frame2.getContentPane().add(button_2);
		
		JButton btnPagarYSalir = new JButton("Pagar y salir del parking");
		btnPagarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int cont = 0;
				String matricula = null;
				float HoraInicio= 0;
				float HoraFinal= 0;
				float importeEntregado = 0;
				
			
				
				cont += validarString(txtMatricula.getText());
				cont += validarString(txtHoraEntrada.getText());
				cont += validarString(txtHoraSalida.getText());
				cont += validarString(txtImporteEntregado.getText());

				error = "Campo/s vacíos";
				if (cont == 4) { //Si los 4 datos cumplen lo validado, entrará aquí
					
					matricula = txtMatricula.getText();
					HoraInicio= txtHoraEntrada.getAlignmentY(); //Fecha de Entrada al parking
					HoraFinal= txtHoraSalida.getAlignmentY(); //Fecha de salida del parking
					importeEntregado= txtImporteEntregado.getAlignmentY(); //Dinero dado
					
					Coche p = new Coche(matricula, HoraInicio, HoraFinal, importeEntregado);
					lista.add(p); //Se añaden los datos introducidos del coche y el parking
					
					int diferencia=(int) (HoraFinal-HoraInicio);
					
					clean(); //Para salir de la ventana
				}
				
				else {
					JOptionPane.showMessageDialog(frame2, error,  matricula, JOptionPane.ERROR_MESSAGE); //Si no se cumple, mostrará el mensaje de error
				}
			}
		});
		
		btnPagarYSalir.setBounds(72, 211, 177, 39);
		frame2.getContentPane().add(btnPagarYSalir);
		
		txtMatricula = new JTextField();
		txtMatricula.setForeground(Color.GRAY);
		txtMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtMatricula.setText(""); //Al hacer click, se borrara el texto predeterminado
			}
		});
		txtMatricula.setText("Matricula");
		txtMatricula.setBounds(72, 118, 107, 20);
		frame2.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtHoraEntrada = new JTextField();
		txtHoraEntrada.setForeground(Color.GRAY);
		txtHoraEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHoraEntrada.setText(""); //Al hacer click, se borrara el texto predeterminado
			}
		});
		txtHoraEntrada.setText("Hora Entrada");
		txtHoraEntrada.setBounds(72, 149, 107, 20);
		frame2.getContentPane().add(txtHoraEntrada);
		txtHoraEntrada.setColumns(10);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setForeground(Color.GRAY);
		txtHoraSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHoraSalida.setText(""); //Al hacer click, se borrara el texto predeterminado
				
			}
		});
		txtHoraSalida.setText("Hora Salida");
		txtHoraSalida.setBounds(72, 180, 107, 20);
		frame2.getContentPane().add(txtHoraSalida);
		txtHoraSalida.setColumns(10);
		
		txtImporteEntregado = new JTextField();
		txtImporteEntregado.setForeground(Color.GRAY);
		txtImporteEntregado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtImporteEntregado.setText("");
			}
		});
		txtImporteEntregado.setText("Importe entregado");
		txtImporteEntregado.setBounds(271, 180, 105, 20);
		frame2.getContentPane().add(txtImporteEntregado);
		txtImporteEntregado.setColumns(10);
	}
	
	protected void clean() { //Función para salir de la ventana
		
		frame2.setVisible(false);
	}

	protected Window getFrame2() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte validarString(String cadena) {

		if (cadena.isEmpty() || cadena.equals(null)) {
			return 0;
		} else {
			return 1;
		}
	}
	public byte validarFloat(Float numero) {

		if (numero.equals(null)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public JFrame getFrame() {
		return frame2;
	}

	public void setFrame(JFrame frame) {
		this.frame2 = frame;
	}

}
