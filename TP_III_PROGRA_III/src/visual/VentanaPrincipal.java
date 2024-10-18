package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {
	private JFrame frame;
	private JButton buttonSalir;
	private JComboBox<Integer> boxDia;
	private JComboBox<String> boxMes;
	private JComboBox<Integer> boxHoraDesde;
	private JComboBox<Integer> boxHoraHasta;
	private JTextField textNombre;
	private JTextField textMontoReserva;
	private JButton buttonCrearReserva;
	private JButton buttonVerReservas;
	
	
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema de Reservas: Sala The Bunker");
		frame.setBounds(100, 100, 450, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttonSalir = new JButton("SALIR");
		buttonSalir.setBounds(167, 417, 89, 23);
		frame.getContentPane().add(buttonSalir);
		
		JLabel lblNewLabel = new JLabel("Nombre ");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 70, 120, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setBounds(87, 70, 149, 20);
		textNombre.setColumns(10);
		frame.getContentPane().add(textNombre);
		
		JLabel lblMontoDeReserva = new JLabel("Monto");
		lblMontoDeReserva.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblMontoDeReserva.setBounds(10, 104, 77, 28);
		frame.getContentPane().add(lblMontoDeReserva);
		
		textMontoReserva = new JTextField();
		textMontoReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMontoReserva.setColumns(10);
		textMontoReserva.setBounds(87, 104, 105, 20);
		frame.getContentPane().add(textMontoReserva);
		
		JLabel lblFecha = new JLabel("Fecha de Reserva");
		lblFecha.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblFecha.setBounds(10, 143, 194, 28);
		frame.getContentPane().add(lblFecha);
		
		boxDia = new JComboBox<Integer>();
		boxDia.setBounds(56, 172, 45, 22);
		frame.getContentPane().add(boxDia);
		
		boxMes = new JComboBox<String>();
		boxMes.setBounds(167, 172, 89, 22);
		frame.getContentPane().add(boxMes);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblDia.setBounds(20, 168, 37, 28);
		frame.getContentPane().add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblMes.setBounds(128, 168, 37, 28);
		frame.getContentPane().add(lblMes);
		
		JLabel lblHorasAReservar = new JLabel("Horas a Reservar");
		lblHorasAReservar.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblHorasAReservar.setBounds(10, 211, 194, 28);
		frame.getContentPane().add(lblHorasAReservar);
		
		boxHoraDesde = new JComboBox<Integer>();
		boxHoraDesde.setBounds(85, 244, 45, 22);
		frame.getContentPane().add(boxHoraDesde);
		
		boxHoraHasta = new JComboBox<Integer>();
		boxHoraHasta.setBounds(87, 277, 45, 22);
		frame.getContentPane().add(boxHoraHasta);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblDesde.setBounds(10, 240, 65, 28);
		frame.getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblHasta.setBounds(10, 273, 55, 28);
		frame.getContentPane().add(lblHasta);
		
		buttonCrearReserva = new JButton("CREAR RESERVA");
		buttonCrearReserva.setBounds(10, 310, 226, 23);
		frame.getContentPane().add(buttonCrearReserva);
		
		buttonVerReservas = new JButton("VER RESERVAS");
		buttonVerReservas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonVerReservas.setBounds(128, 385, 157, 23);
		frame.getContentPane().add(buttonVerReservas);
		frame.setVisible(true);
	}

	
	
	public JFrame getFrame() {
		return frame;
	}

	public JButton getButtonSalir() {
		return buttonSalir;
	}

	public JComboBox<Integer> getBoxDia() {
		return boxDia;
	}

	public JComboBox<String> getBoxMes() {
		return boxMes;
	}

	public JComboBox<Integer> getBoxHoraDesde() {
		return boxHoraDesde;
	}

	public JComboBox<Integer> getBoxHoraHasta() {
		return boxHoraHasta;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextMontoReserva() {
		return textMontoReserva;
	}

	public JButton getButtonCrearReserva() {
		return buttonCrearReserva;
	}

	public JTextField getMontoReserva() {
		return textMontoReserva;
	}

	public JButton getButtonVerReservas() {
		return buttonVerReservas;
	}
}
