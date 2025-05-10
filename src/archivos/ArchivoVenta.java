package archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import clases.Venta;

public class ArchivoVenta {

    private String rutaArchivo;

    public ArchivoVenta(String rutaArchivo) {
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
                    System.out.println("Archivo de ventas creado.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void crearArchivoVenta(String rutaArchivo) {
        new ArchivoVenta(rutaArchivo);
    }

    public static void eliminarArchivoVenta(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo de ventas eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    // Guardar una venta al archivo (agregando a la lista)
    public void guardarVenta(Venta venta) {
        List<Venta> ventas = cargarVentas(); // Cargar existentes
        ventas.add(venta); // Agregar nueva venta
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(ventas);
            System.out.println("Venta guardada con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }
    }

    // Cargar todas las ventas del archivo
    public List<Venta> cargarVentas() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>(); // Retorna lista vacía si el archivo está vacío
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return extraer(ois);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las ventas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Venta> extraer(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        return (List<Venta>) ois.readObject();
    }
}