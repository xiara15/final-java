package archivos;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import clases.Persona;
public class ArchivoPersona {

	    private static final String RUTA_ARCHIVO = "Carpeta General" + File.separator + "persona.dat";

	    // CREAR ARCHIVO
	    public static void crearArchivoPersona() {
	        File archivo = new File(RUTA_ARCHIVO);
	        if (!archivo.exists()) {
	            try {
	                if (archivo.createNewFile()) {
	                    System.out.println("El archivo 'persona.dat' se creó con éxito.");
	                }
	            } catch (IOException e) {
	                System.out.println("ERROR al crear el archivo: " + e.getMessage());
	            }
	        } else {
	            System.out.println("El archivo 'persona.dat' ya existe.");
	        }
	    }

	    // ELIMINAR ARCHIVO
	    public static void eliminarArchivoPersona() {
	        File archivo = new File(RUTA_ARCHIVO);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("El archivo 'persona.dat' fue eliminado correctamente.");
	            } else {
	                System.out.println("No se pudo eliminar el archivo.");
	            }
	        } else {
	            System.out.println("El archivo no existe. No se eliminó nada.");
	        }
	    }

	    // SERIALIZAR - GUARDAR LISTA
	    public static void guardarPersonas() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
	            oos.writeObject(Persona.listaPersonas);
	            System.out.println("Archivo 'persona.dat' guardado correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar el archivo: " + e.getMessage());
	        }
	    }

	    // DESERIALIZAR - CARGAR LISTA
	    public static void cargarPersonas() {
	        File archivo = new File(RUTA_ARCHIVO);
	        if (!archivo.exists()) {
	            System.out.println("No se encontró el archivo 'persona.dat' para cargar.");
	            return;
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	            Persona.listaPersonas = (ArrayList<Persona>) ois.readObject();
	            System.out.println("Archivo 'persona.dat' cargado correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al cargar el archivo: " + e.getMessage());
	        } catch (ClassNotFoundException e) {
	            System.out.println("Clase no encontrada al cargar: " + e.getMessage());
	        }
	    }
	}