package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.SalaEnsayos;
import model.Solver;
import serializable.Escritura;
import serializable.Lectura;
import visual.VentanaPrincipal;

public class Controller {
	
	private VentanaPrincipal interfazUsuario;
	private SalaEnsayos salaDeEnsayo;

	public Controller() {
		this.interfazUsuario = new VentanaPrincipal();
		this.salaDeEnsayo = Lectura.cargarDatosSalaEnsayos();

		inicializarInterfazUsuario();

	}

	private void inicializarInterfazUsuario() {

		interfazUsuario.getButtonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazUsuario.getFrame().dispose();
			}
		});

		interfazUsuario.getButtonCrearReserva().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldsSonVacios()) {
					JOptionPane.showMessageDialog(null, "Ingrese nombre de la banda / Monto");
				}
				else {
					try {
						crearReserva();
						Escritura.guardarDatosSalaEnsayos(salaDeEnsayo);
					}catch (Exception f) {
						JOptionPane.showMessageDialog(null,"El horario de inicio debe ser diferente al horario en que termina el ensayo");
					}
				}
				
			reinicializarFieldsAndBoxes();
			}


		});
		interfazUsuario.getBoxMes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarBoxDias();
			}
		});

		interfazUsuario.getBoxHoraDesde().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarBoxHasta();
			}
		});

		interfazUsuario.getButtonPrintReservas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salaDeEnsayo.printReservas();
			}
		});
		
		interfazUsuario.getButtonBuscarMejorSolucion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazUsuario.getTextArea().setText(null);
				ArrayList<String> solucion = Solver.buscarSolucionConMayorMonto(salaDeEnsayo.geListaDeReservas());
				interfazUsuario.getTextArea().append(solucion.toString() + " \n" 
				+ Solver.calcularMontoTotal(solucion, salaDeEnsayo.geListaDeReservas()));
				
			}
		});
		

		cargarBoxes();
	}

	private void actualizarBoxHasta() {
		interfazUsuario.getBoxHoraHasta().removeAllItems();
		for (int i = (int) interfazUsuario.getBoxHoraDesde().getSelectedItem(); i < 24; i++) {
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}
	}

	private void actualizarBoxDias() {
		interfazUsuario.getBoxDia().removeAllItems();
		for (int i = 1; i < getDiasSegunMes(interfazUsuario.getBoxMes()) + 1; i++) {
			interfazUsuario.getBoxDia().addItem(i);
		}
	}

	private void cargarBoxMes() {
		interfazUsuario.getBoxMes().addItem("ENERO");
		interfazUsuario.getBoxMes().addItem("FEBRERO");
		interfazUsuario.getBoxMes().addItem("MARZO");
		interfazUsuario.getBoxMes().addItem("ABRIL");
		interfazUsuario.getBoxMes().addItem("MAYO");
		interfazUsuario.getBoxMes().addItem("JUNIO");
		interfazUsuario.getBoxMes().addItem("JULIO");
		interfazUsuario.getBoxMes().addItem("AGOSTO");
		interfazUsuario.getBoxMes().addItem("SEPTIEMBRE");
		interfazUsuario.getBoxMes().addItem("OCTUBRE");
		interfazUsuario.getBoxMes().addItem("NOVIEMBRE");
		interfazUsuario.getBoxMes().addItem("DICIEMBRE");
	}

	private int getDiasSegunMes(JComboBox<String> boxMes) {
		switch (boxMes.getSelectedItem().toString()) {
		case "ENERO":
			return 31;
		case "FEBRERO":
			return 29;
		case "MARZO":
			return 31;
		case "ABRIL":
			return 30;
		case "MAYO":
			return 31;
		case "JUNIO":
			return 30;
		case "JULIO":
			return 31;
		case "AGOSTO":
			return 31;
		case "SEPTIEMBRE":
			return 30;
		case "OCTUBRE":
			return 31;
		case "NOVIEMBRE":
			return 30;
		case "DICIEMBRE":
			return 31;
		default:
			return 0;
		}
	}

	private void cargarBoxDesdeHasta() {
		for (int i = 00; i < 24; i++) {
			interfazUsuario.getBoxHoraDesde().addItem(i);
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}

	}

	private void cargarBoxes() {
		cargarBoxMes();
		cargarBoxDesdeHasta();
	}

	private void crearReserva() {
		String nombreBanda = interfazUsuario.getTextNombre().getText();
		int horaDesde = (int) interfazUsuario.getBoxHoraDesde().getSelectedItem();
		int horaHasta = (int) interfazUsuario.getBoxHoraHasta().getSelectedItem();
		double monto = Double.valueOf(interfazUsuario.getTextMontoReserva().getText());
		LocalDate fecha = LocalDate.of(2024, interfazUsuario.getBoxMes().getSelectedIndex() + 1,
				interfazUsuario.getBoxDia().getSelectedIndex() + 1);
		if(horaDesde == horaHasta) {
			throw new RuntimeException();
		}
		else {
			salaDeEnsayo.registrarReserva(nombreBanda, horaDesde, horaHasta, monto, fecha);
		}
	}
	
	private boolean fieldsSonVacios() {
		return interfazUsuario.getTextNombre().getText().isEmpty() ||
				interfazUsuario.getTextMontoReserva().getText().isEmpty();
	}

	private void reinicializarFieldsAndBoxes() {
		interfazUsuario.getTextMontoReserva().setText(null);
		interfazUsuario.getTextNombre().setText(null);
		interfazUsuario.getBoxHoraDesde().setSelectedIndex(0);
		interfazUsuario.getBoxHoraHasta().setSelectedIndex(0);
		
		
	}
}