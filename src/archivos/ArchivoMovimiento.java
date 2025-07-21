package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import clases.Movimiento;

public class ArchivoMovimiento {

	  
	    private static Object listaMovimiento;

		// Crear archivo
	    public static void crearArchivoMovimiento() {
	        String ruta = "Carpeta General" + File.separator + "movimiento.dat";
	        File archivo = new File(ruta);
	        if (!archivo.exists()) {
	            try {
	                if (archivo.createNewFile()) {
	                    System.out.println("El archivo se creó con éxito.");
	                }
	            } catch (IOException e) {
	                System.out.println("ERROR: " + e.getMessage());
	            }
	        } else {
	            System.out.println("El archivo que intenta crear ya existe.");
	        }
	    }

	    // Eliminar archivo
	    public static void eliminarArchivoMovimiento() {
	        String ruta = "Carpeta General" + File.separator + "movimiento.dat";
	        File archivo = new File(ruta);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Se ha eliminado correctamente el archivo.");
	            } else {
	                System.out.println("No se ha podido eliminar el archivo.");
	            }
	        } else {
	            System.out.println("No se eliminó nada porque el archivo no existe.");
	        }
	    }

	    // Guardar lista serializada
	    public static void guardarMovimientos() {
	        String ruta = "Carpeta General" + File.separator + "movimiento.dat";
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
	            oos.writeObject(listaMovimiento);
	            System.out.println("Archivo de movimientos guardado correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar: " + e.getMessage());
	        }
	    }

	    // Cargar lista desde archivo serializado
	    public static void cargarMovimientos() {
	        String ruta = "Carpeta General" + File.separator + "movimiento.dat";
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
	            listaMovimiento = (ArrayList<Movimiento>) ois.readObject();
	            System.out.println("Archivo de movimientos cargado correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al cargar: " + e.getMessage());
	        } catch (ClassNotFoundException e) {
	            System.out.println("Clase no encontrada: " + e.getMessage());
	        }
	    }
	 } 
	