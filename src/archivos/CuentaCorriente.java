package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class CuentaCorriente {
	

	public class ArchivoCuentaCorriente {

	    private String rutaArchivo;

	    public ArchivoCuentaCorriente(String rutaArchivo) {
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
	                    System.out.println("Archivo de cuentas corrientes creado.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo: " + e.getMessage());
	        }
	    }

	    

	    public static void eliminarArchivoCuentaCorriente(String rutaArchivo) {
	        File archivo = new File(rutaArchivo);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Archivo de cuentas corrientes eliminado correctamente.");
	            } else {
	                System.out.println("No se pudo eliminar el archivo.");
	            }
	        } else {
	            System.out.println("El archivo no existe.");
	        }
	    }

	    // Guardar una cuenta corriente al archivo
	    public void guardarCuenta(CuentaCorriente cuenta) {
	        List<CuentaCorriente> cuentas = cargarCuentas(); // Cargar existentes
	        cuentas.add(cuenta); // Agregar nueva
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
	            oos.writeObject(cuentas);
	            System.out.println("Cuenta corriente guardada con éxito.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar la cuenta: " + e.getMessage());
	        }
	    }

	    // Cargar todas las cuentas del archivo
	    public List<CuentaCorriente> cargarCuentas() {
	        File archivo = new File(rutaArchivo);
	        if (!archivo.exists() || archivo.length() == 0) {
	            return new ArrayList<>(); // Lista vacía si archivo no existe o está vacío
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
	            return extracted(ois);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al cargar las cuentas: " + e.getMessage());
	            return new ArrayList<>();
	        }
	    }

		private List<CuentaCorriente> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
			return (List<CuentaCorriente>) ois.readObject();
		}
	}
	
	
	
	
	
	
	
	

}
