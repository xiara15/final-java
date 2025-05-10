package archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import clases.Producto;

	public class ArchivoProducto {

	    private String rutaArchivo;

	    public ArchivoProducto(String rutaArchivo) {
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
	                    System.out.println("Archivo de productos creado.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo: " + e.getMessage());
	        }
	    }

	    public static void crearArchivoProducto(String rutaArchivo) {
	        new ArchivoProducto(rutaArchivo);
	    }

	    public static void eliminarArchivoProducto(String rutaArchivo) {
	        File archivo = new File(rutaArchivo);
	        if (archivo.exists()) {
	            if (archivo.delete()) {
	                System.out.println("Archivo de productos eliminado correctamente.");
	            } else {
	                System.out.println("No se pudo eliminar el archivo.");
	            }
	        } else {
	            System.out.println("El archivo no existe.");
	        }
	    }

	    // Guardar un producto al archivo (agregando a la lista)
	    public void guardarProducto(Producto producto) {
	        List<Producto> productos = cargarProductos(); // Cargar existentes
	        productos.add(producto); // Agregar nuevo
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
	            oos.writeObject(productos);
	            System.out.println("Producto guardado con éxito.");
	        } catch (IOException e) {
	            System.out.println("Error al guardar el producto: " + e.getMessage());
	        }
	    }

	    // Cargar todos los productos del archivo
	    public List<Producto> cargarProductos() {
	        File archivo = new File(rutaArchivo);
	        if (!archivo.exists() || archivo.length() == 0) {
	            return new ArrayList<>(); // Retorna lista vacía si el archivo está vacío
	        }

	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
	            return extraer(ois);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al cargar los productos: " + e.getMessage());
	            return new ArrayList<>();
	        }
	    }

	    private List<Producto> extraer(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	        return (List<Producto>) ois.readObject();
	    }
	}


