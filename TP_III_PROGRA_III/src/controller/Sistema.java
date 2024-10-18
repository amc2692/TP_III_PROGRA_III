package controller;

import model.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {

	ArrayList<String> listaReservas;
	HashMap<String, Reserva> listaDeReservas;
	
	public Sistema() {
		this.listaReservas = new ArrayList<String>();
		this.listaDeReservas = new HashMap<String, Reserva>();
	}
	
	public void crearReserva(String nombreReserva, int horarioDesde, int horarioHasta, int monto, LocalDate fecha) {
		if(!listaDeReservas.containsKey(nombreReserva)) {
			listaDeReservas.put(nombreReserva, new Reserva(nombreReserva, horarioDesde, horarioHasta, monto, fecha));
		}
		else {
			throw new RuntimeException();
		}
	}
}
