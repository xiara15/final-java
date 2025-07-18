package archivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import clases.Cliente;

public class ArchivoCliente {

	public static void crearArchivoCliente() {
		String ruta = "Carpeta General" + File.separator + "cliente.dat";
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

    public static void eliminarArchivoCliente(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo de clientes eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public static void guardarClientes() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Carpeta General" + File.separator + "cliente.dat"))) {
			oos.writeObject(Cliente.listaClientes);
			System.out.println("Archivo cliente guardado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al guardar: " + error.getMessage());
		}
	}

	// DESERIALIZAR
	public static void cargarClientes() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "cliente.dat"))) {
			Cliente.listaClientes = extracte(ois);
			System.out.println("Archivo cliente cargado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}

	private static ArrayList<Cliente> extracte(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ArrayList <Cliente> object = extracte(ois);
		return object;
	}
}