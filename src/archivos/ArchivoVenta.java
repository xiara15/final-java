package archivos;

import java.io.*;
import java.util.ArrayList;

import clases.Venta;

public class ArchivoVenta {

	// CREAR ARCHIVO
		public static void crearArchivoVenta() {
			String ruta = "Carpeta General" + File.separator + "venta.dat";
			File archivo = new File(ruta);
			if (archivo.exists()==false){
				try {
					if (archivo.createNewFile()) {
						System.out.println("El archivo se creó con exito");
					}
				} catch (IOException error) {
					System.out.println("ERROR: " + error.getMessage());
				}
			} else {
				System.out.println("El archivo que intenta crear ya existe.");
			}
		}
		
		// ELIMINAR ARCHIVO
		public static void eliminarArchivoVenta() {
			String ruta = "Carpeta General" + File.separator + "venta.dat";
			File miArchivo = new File (ruta);
			if (miArchivo.exists()){
				if (miArchivo.delete()) {
					System.out.println("Se ha eliminado correctamente el archivo.");
				} else {
					System.out.println("No se ha podido eliminar el archivo.");
				}
			} else {
				System.out.println("No se elimino nada porque no existe.");
			}
		}
		
		// SERIALIZAR
		public static void guardarVentas() {
		    try (ObjectOutputStream oos = new ObjectOutputStream(
		            new FileOutputStream("Carpeta General" + File.separator + "venta.dat"))) {
		        
		        oos.writeObject(Venta.listaDeVentas);
		        System.out.println("Archivo venta guardado correctamente.");
		        
		    } catch (IOException error) {
		        System.out.println("Error al guardar: " + error.getMessage());
		    }
		}

		// DESERIALIZAR
		public static void cargarVentas() {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "venta.dat"))) {
				Venta.listaDeVentas = (ArrayList <Venta>) ois.readObject();
				System.out.println("Archivo venta cargado correctamente.");
			} catch (IOException error) {
				System.out.println("Error al cargar: " + error.getMessage());
			} catch (ClassNotFoundException error) {
				System.out.println("Clase no encontrada: " + error.getMessage());
			}
		}
}