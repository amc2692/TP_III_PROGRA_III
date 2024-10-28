package serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.SalaEnsayos;

public class Escritura {
	
	
	
	public static void crearFicheroDatosSala(SalaEnsayos sala) {

		try (FileOutputStream fos = new FileOutputStream("datosSala.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(sala);

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");

		} catch (IOException e) {
			System.out.println("No se puede acceder al fichero");
		}
		System.out.println("Ok");
	}
	
	
	

}
