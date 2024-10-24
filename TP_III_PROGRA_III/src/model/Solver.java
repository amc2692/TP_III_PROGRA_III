package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solver {
	
	
	
	
	public static void marcarHorarios(ArrayList<String> horarios, Reserva reserva) {
		if(horarioEstaLibre(horarios, reserva) && !horarios.contains(reserva.getNombreBanda())) {
			for(int i = reserva.getHoraDesde(); i< reserva.getHoraHasta(); i++) {
				horarios.remove(i);
				horarios.add(i, reserva.getNombreBanda());
			}
		}
		else {
			throw new RuntimeException("no esta libre el horario para reservar");
		}
	}
	
	public static boolean horarioEstaLibre(ArrayList<String> horarios, Reserva reserva) {
		boolean flag = true;
		for(int i = reserva.getHoraDesde(); i< reserva.getHoraHasta()-1; i++){
			flag &= horarios.get(i) == "-";
		}
		return flag;
	}
	
	public static ArrayList<String> setearHorario() {
		ArrayList<String> horario = new ArrayList<String>();
		for(int i = 0; i < 24; i++ ) {
			horario.add("-");
		}
		return horario;
	}
	


	public static void crearSolucion(HashMap<String, Reserva> listaReservas){
		Set<String> bandaRegistradasEnSolucion = new HashSet<String>();	
		String[] horarios = new String[24];
		Random rand = new Random();
		
	
	
	}
	
	


}
