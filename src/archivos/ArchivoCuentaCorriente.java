package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import clases.CuentaCorriente;
public class ArchivoCuentaCorriente {


	    private static final String RUTA_ARCHIVO = "Carpeta General" + File.separator + "cuentacorriente.dat";

	    // CREAR ARCHIVO
	    public static void crearArchivoCtaCte() {
	        File archivo = new File(RUTA_ARCHIVO);
	        if (!archivo.exists()) {
	            try {
	                if (archivo.createNewFile()) {
	                    System.out.println("El archivo se creó con éxito.");
	                }
	            } catch (IOException error) {
	                System.out.println("ERROR al crear archivo: " + error.getMessage());
	            }
	        } else {
	            System.out.println("El archivo que intenta crear ya existe.");
	        }
	    }

	    // ELIMINAR ARCHIVO
	    public static void eliminarArchivoCtaCte() {
	        File archivo = new File(RUTA_ARCHIVO);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Se ha eliminado correctamente el archivo.");
	            } else {
	                System.out.println("No se ha podido eliminar el archivo.");
	            }
	        } else {
	            System.out.println("No se eliminó nada porque no existe.");
	        }
	    }

	    // SERIALIZAR (GUARDAR DATOS)
	    public static void guardarCtaCtes() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
	            oos.writeObject(CuentaCorriente.listaCtactes);
	            System.out.println("Archivo de cuentas guardado correctamente.");
	        } catch (IOException error) {
	            System.out.println("Error al guardar: " + error.getMessage());
	        }
	    }

	    // DESERIALIZAR (CARGAR DATOS)
	    public static void cargarCtaCtes() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
	            CuentaCorriente.listaCtactes = extraerLista(ois);
	            System.out.println("Archivo de cuentas cargado correctamente.");
	        } catch (IOException error) {
	            System.out.println("Error al cargar: " + error.getMessage());
	        } catch (ClassNotFoundException error) {
	            System.out.println("Clase no encontrada: " + error.getMessage());
	        }
	    }

	    // MÉTODO AUXILIAR PARA CASTEO
	    @SuppressWarnings("unchecked")
	    private static ArrayList<CuentaCorriente> extraerLista(ObjectInputStream ois)
	            throws IOException, ClassNotFoundException {
	        return (ArrayList<CuentaCorriente>) ois.readObject();
	    }
	}
	
	
	
	
	


