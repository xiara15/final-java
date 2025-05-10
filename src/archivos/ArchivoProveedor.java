package archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import clases.Proveedor;

public class ArchivoProveedor {

    private String rutaArchivo;

    public ArchivoProveedor(String rutaArchivo) {
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
                    System.out.println("Archivo de proveedores creado.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void crearArchivoProveedor(String rutaArchivo) {
        new ArchivoProveedor(rutaArchivo);
    }

    public static void eliminarArchivoProveedor(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo de proveedores eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    // Guardar un proveedor al archivo (agregando a la lista)
    public void guardarProveedor(Proveedor proveedor) {
        List<Proveedor> proveedores = cargarProveedores(); // Cargar existentes
        proveedores.add(proveedor); // Agregar nuevo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(proveedores);
            System.out.println("Proveedor guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el proveedor: " + e.getMessage());
        }
    }

    // Cargar todos los proveedores del archivo
    public List<Proveedor> cargarProveedores() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>(); // Retorna lista vacía si el archivo está vacío
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return extraer(ois);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los proveedores: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Proveedor> extraer(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        return (List<Proveedor>) ois.readObject();
    }
}