package model;

import java.time.LocalDate;

public class Reserva {
	
	private String nombreReserva;
	private int horarioDesde;
	private int horarioHasta;
	private int monto;
	private LocalDate fecha;
	
	public Reserva(String nombreReserva, int horarioDesde, int horarioHasta,int monto, LocalDate fecha) {
		this.horarioDesde = horarioDesde;
		this.horarioHasta = horarioHasta;
		this.nombreReserva = nombreReserva;
		this.monto = monto;
		this.fecha = fecha;
	}
	
	
	
	
}
