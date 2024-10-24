package model;

import java.time.LocalDate;
import java.util.HashMap;

public class NegocioSala {
	private HashMap<String, Reserva> conjuntoDeReservas;
	
	public NegocioSala() {
		conjuntoDeReservas = new HashMap<String, Reserva>();
	}
	
	public void registrarReserva(LocalDate dia, String nombreBanda, int horaDesde, int horaHasta, int monto, LocalDate fechaReserva){
		if(conjuntoDeReservas.containsKey(nombreBanda)) {
			throw new RuntimeException("la banda ya se encuentra en la lista de reservas");
		}
		else {
			Reserva nuevaReserva = new Reserva(nombreBanda, horaDesde, horaHasta, monto, fechaReserva);
			conjuntoDeReservas.put(nombreBanda, nuevaReserva);
		}
	}
	
	public void printReservas() {
		for(String s: conjuntoDeReservas.keySet()) {
			System.out.println(conjuntoDeReservas.get(s));
		}
	}

	public HashMap<String, Reserva> getConjuntoDeReservas() {
		return conjuntoDeReservas;
	}
	
	public Reserva getReserva(String nombreBanda) {
		return conjuntoDeReservas.get(nombreBanda);
	}
	
	
	public void setearReservasDePrueba() {
		
		registrarReserva(null, "Tesseract", 7, 10, 16000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Periphery", 8, 12, 20000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Vola", 10, 17, 13000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Tool", 11, 17, 21000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Bring Me The Horizon", 0, 7, 15000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Fit For An autopsy", 13, 17, 17000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Jinjer", 17, 19, 16000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Mudvayne", 15, 22, 13000, LocalDate.of(2024, 10, 23));
		registrarReserva(null, "Thy Art Is Murder", 20, 23, 11100, LocalDate.of(2024, 10, 23));
	}

	
}
