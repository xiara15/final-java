package archivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import clases.Cliente;

public class ArchivoCliente {

    private String rutaArchivo;

    public ArchivoCliente(String rutaArchivo) {
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
                    System.out.println("Archivo de clientes creado.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void crearArchivoCliente(String rutaArchivo) {
        new ArchivoCliente(rutaArchivo);
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

    // Guardar un cliente al archivo (agregando a la lista)
    public void guardarCliente(Cliente cliente) {
        List<Cliente> clientes = cargarClientes(); // Cargar existentes
        clientes.add(cliente); // Agregar nuevo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(clientes);
            System.out.println("Cliente guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }

    // Cargar todos los clientes del archivo
    public List<Cliente> cargarClientes() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>(); // Retorna lista vacía si el archivo está vacío
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return extracted(ois);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los clientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

	private List<Cliente> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		return (List<Cliente>) ois.readObject();
	}
}