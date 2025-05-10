package archivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Persona {
	
	
	
	public class ArchivoPersona {

	    private String rutaArchivo;

	    public ArchivoPersona(String rutaArchivo) {
	        this.rutaArchivo = rutaArchivo;
	        crearArchivoSiNoExiste();
	    }

	    private void crearArchivoSiNoExiste() {
	        File archivo = new File(rutaArchivo);
	        try {
	            File carpeta = archivo.getParentFile();
	            if (carpeta != null && !carpeta.exists()) {
	                carpeta.mkdirs(); // Crear carpeta si no existe
	            }

	            if (!archivo.exists()) {
	                if (archivo.createNewFile()) {
	                    System.out.println("Archivo de personas creado.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo: " + e.getMessage());
	        }
	    }


	    public static void eliminarArchivoPersona(String rutaArchivo) {
	        File archivo = new File(rutaArchivo);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Archivo de personas eliminado correctamente.");
	            } else {
	                System.out.println("No se pudo eliminar el archivo.");
	            }
	        } else {
	            System.out.println("El archivo no existe.");
	        }
	    }

	    public void guardarPersona(Persona persona) {
	        List<Persona> personas = cargarPersonas();
	        personas.add(persona);
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
	            oos.writeObject(personas);
	            System.out.println("Persona guardada con éxito.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar la persona: " + e.getMessage());
	        }
	    }

	    public List<Persona> cargarPersonas() {
	        File archivo = new File(rutaArchivo);
	        if (!archivo.exists() || archivo.length() == 0) {
	            return new ArrayList<>();
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
	            return (List<Persona>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al cargar las personas: " + e.getMessage());
	            return new ArrayList<>();
	        }
	    }
	}
	
}
