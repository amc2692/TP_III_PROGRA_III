package controller;


import model.SalaEnsayos;
import model.Solver;

public class Main {

	public static void main(String[] args) {
		//new Controller();
		SalaEnsayos sala = new SalaEnsayos();
		sala.setearReservasDePrueba();
		
		
		System.out.println(Solver.buscarSolucionConMayorMonto(sala.getConjuntoDeReservas()));
	
		
		
	}

}
