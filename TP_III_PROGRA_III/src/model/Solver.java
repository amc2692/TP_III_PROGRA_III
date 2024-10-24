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
	

	//CONTROLAR ESTE METODO
	public static Set<ArrayList<String>> crearSoluciones(HashMap<String, Reserva> listaDeReservas){
		Set<ArrayList<String>> listaDeSoluciones = new HashSet<ArrayList<String>>();	
		Random rand = new Random();
		//
		while(listaDeSoluciones.size() < listaDeReservas.size()) {
			ArrayList<String> solucionPosible = Solver.setearHorario();
			ArrayList<String> arrayBandasRegistradas = mapToArray(listaDeReservas);
			
			while(0 < arrayBandasRegistradas.size ()) {
				String banda = arrayBandasRegistradas.get(rand.nextInt(arrayBandasRegistradas.size()));
				marcarHorarios(solucionPosible, listaDeReservas.get(banda));
				arrayBandasRegistradas.remove(banda);
			}
			listaDeSoluciones.add(solucionPosible);
		}
		return listaDeSoluciones;
	}

	public static ArrayList<String> buscarSolucionConMayorMonto(HashMap<String, Reserva> listaDeReservas) {
		ArrayList<String> mejorSolucion = new ArrayList<String>();
		double mejorMonto = 0;
		Set<ArrayList<String>> solucionesPosibles = crearSoluciones(listaDeReservas);
		for(ArrayList<String> soluciones : solucionesPosibles) {
			if(mejorMonto < calcularMontoTotal(soluciones, listaDeReservas)) {
				mejorSolucion.removeAll(mejorSolucion);
				mejorSolucion.addAll(soluciones);
			}
		}
		return mejorSolucion;
	}
	
	public static double calcularMontoTotal(ArrayList<String> solucionPosible, HashMap<String, Reserva> listaDeReservas) {
		double monto = 0;
		Set<String> set = arrayToSet(solucionPosible);
		for(String s: set) {
			monto += listaDeReservas.get(s).getMonto();
		}
		return monto;
	}
	
	
	private static ArrayList<String> mapToArray(HashMap<String, Reserva> listaReservas) {
		ArrayList<String> mapToArray = new ArrayList<String>();
		for(String s : listaReservas.keySet()) {
			mapToArray.add(s);
		}
		return mapToArray;
	}
	
	private static Set<String> arrayToSet(ArrayList<String> lista) {
		Set<String> set = new HashSet<String>(); 
		for(String s: lista) {
			if(s != "-") {
				set.add(s);
			}
		}
		return set;
	}


}
