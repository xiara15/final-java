package archivos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class Empleado {
	
	public class ArchivoEmpleado {

	    private String rutaArchivo;

	    public ArchivoEmpleado(String rutaArchivo) {
	        this.rutaArchivo = rutaArchivo;
	        crearArchivoSiNoExiste();
	    }

	    private void crearArchivoSiNoExiste() {
	        File archivo = new File(rutaArchivo);
	        try {
	            File carpeta = archivo.getParentFile();
	            if (carpeta != null && !carpeta.exists()) {
	                carpeta.mkdirs(); // Crea la carpeta si no existe
	            }

	            if (!archivo.exists()) {
	                if (archivo.createNewFile()) {
	                    System.out.println("Archivo de empleados creado.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo: " + e.getMessage());
	        }
	    }


	    public static void eliminarArchivoEmpleado(String rutaArchivo) {
	        File archivo = new File(rutaArchivo);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Archivo de empleados eliminado correctamente.");
	            } else {
	                System.out.println("No se pudo eliminar el archivo.");
	            }
	        } else {
	            System.out.println("El archivo no existe.");
	        }
	    }

	    // Guardar un empleado al archivo
	    public void guardarEmpleado(Empleado empleado) {
	        List<Empleado> empleados = cargarEmpleados();
	        empleados.add(empleado);
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
	            oos.writeObject(empleados);
	            System.out.println("Empleado guardado con éxito.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar el empleado: " + e.getMessage());
	        }
	    }

	    // Cargar todos los empleados del archivo
	    public List<Empleado> cargarEmpleados() {
	        File archivo = new File(rutaArchivo);
	        if (!archivo.exists() || archivo.length() == 0) {
	            return new ArrayList<>();
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
	            return (List<Empleado>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al cargar los empleados: " + e.getMessage());
	            return new ArrayList<>();
	        }
	    }
	}

}
