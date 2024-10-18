package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.w3c.dom.events.EventException;

import visual.VentanaPrincipal;

public class Controller {
	private VentanaPrincipal interfazUsuario;
	private Sistema sistemaReservas;
	
	
	public Controller() {
		interfazUsuario = new VentanaPrincipal();
		sistemaReservas = new Sistema();
		inicializarFuncionalidadInterfaz();
		
	}


	private void inicializarFuncionalidadInterfaz() {
		
		interfazUsuario.getButtonSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazUsuario.getFrame().dispose();
			}
		});
		
		interfazUsuario.getButtonVerReservas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(sistemaReservas.listaDeReservas);
			}
		});
		
		interfazUsuario.getButtonCrearReserva().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!interfazUsuario.getTextNombre().getText().isEmpty() 
						&& !interfazUsuario.getTextMontoReserva().getText().isEmpty()) {
					
						try {
							crearReserva();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Ya se encuentra registrada la banda");
						}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al cargar la reserva");
				}
				
				setearDeafultBoxTextos();
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
		
		cargarBoxes();
	}

	
	private void actualizarBoxHasta() {
		interfazUsuario.getBoxHoraHasta().removeAllItems();
		for(int i = (int) interfazUsuario.getBoxHoraDesde().getSelectedItem(); i < 24; i++ ) {
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}
	}
	
	private void actualizarBoxDias() {
		interfazUsuario.getBoxDia().removeAllItems();
		for (int i = 1; i < getDiasSegunMes(interfazUsuario.getBoxMes())+1; i++) {
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
		switch(boxMes.getSelectedItem().toString()) {
		case "ENERO": return 31;
		case "FEBRERO": return 29;
		case "MARZO": return 31;
		case "ABRIL": return 30;
		case "MAYO": return 31;
		case "JUNIO": return 30;
		case "JULIO": return 31;
		case "AGOSTO": return 31;
		case "SEPTIEMBRE": return 30;
		case "OCTUBRE": return 31;
		case "NOVIEMBRE": return 30;
		case "DICIEMBRE": return 31;
		default: return 0;
		}
	}
	
	private void cargarBoxDesdeHasta() {
		for(int i = 00; i < 24; i++) {
			interfazUsuario.getBoxHoraDesde().addItem(i);
			interfazUsuario.getBoxHoraHasta().addItem(i);
		}
		
	}
	private void cargarBoxes() {
		cargarBoxMes();
		cargarBoxDesdeHasta();
	}
	
	private void setearDeafultBoxTextos() {
		interfazUsuario.getTextNombre().setText(null);
		interfazUsuario.getTextMontoReserva().setText(null);
		interfazUsuario.getBoxDia().setSelectedIndex(0);
		interfazUsuario.getBoxMes().setSelectedIndex(0);
		interfazUsuario.getBoxHoraDesde().setSelectedIndex(0);
		interfazUsuario.getBoxHoraHasta().setSelectedIndex(0);
	}
	
	private void crearReserva() {
		String nombreReserva = interfazUsuario.getTextNombre().getText();
		int monto = Integer.parseInt( interfazUsuario.getMontoReserva().getText());
		int horarioDesde = (int) interfazUsuario.getBoxHoraDesde().getSelectedItem();
		int horarioHasta = (int) interfazUsuario.getBoxHoraHasta().getSelectedItem();
		int mes = interfazUsuario.getBoxMes().getSelectedIndex();
		int dia = (int) interfazUsuario.getBoxDia().getSelectedItem();
		LocalDate fechaReserva = LocalDate.of(2024, mes, dia);
		sistemaReservas.crearReserva(nombreReserva, horarioDesde, horarioHasta, monto, fechaReserva);
	
	}
	
}