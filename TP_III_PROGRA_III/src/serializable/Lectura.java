package serializable;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.SalaEnsayos;

public class Lectura {
	
	
	public static SalaEnsayos leerDataSalaEnsayos() {
		try (FileInputStream fis = new FileInputStream("datosSala.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {

				return (SalaEnsayos) ois.readObject();

			} catch (FileNotFoundException e) {
				System.out.println("Fichero no encontrado");

			} catch (IOException e) {
				System.out.println("No se puede acceder al fichero");
			
			} catch (ClassNotFoundException e) {
				System.out.println("No se encuentra la clase");
		
			}
			return null;
		}
		
	}
	

