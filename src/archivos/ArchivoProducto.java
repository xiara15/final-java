package archivos;

import java.io.*;

import java.util.ArrayList;


import clases.Producto;

	public class ArchivoProducto {

		// CREAR ARCHIVO
		public static void crearArchivoProducto() {
			String ruta = "Carpeta General" + File.separator + "producto.dat";
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
		
		// ELIMINAR ARCHIVO
		public static void eliminarArchivoProducto() {
			String ruta = "Carpeta General" + File.separator + "producto.dat";
			File miArchivo = new File (ruta);
			if (miArchivo.exists()){
				if (miArchivo.delete()) {
					System.out.println("Se ha eliminado correctamente el archivo.");
				} else {
					System.out.println("No se ha podido eliminar el archivo.");
				}
			} else {
				System.out.println("No se elimino nada porque no existe.");
			}
		}

		// SERIALIZAR
		public static void guardarProductos() {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Carpeta General" + File.separator + "producto.dat"))) {
				oos.writeObject(Producto.listaProducto);
				System.out.println("Archivo producto guardado correctamente.");
			} catch (IOException error) {
				System.out.println("Error al guardar: " + error.getMessage());
			}
		}

		// DESERIALIZAR
		public static void cargarProductos() {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "producto.dat"))) {
				Producto.listaProducto = (ArrayList <Producto>) ois.readObject();
				System.out.println("Archivo producto cargado correctamente.");
			} catch (IOException error) {
				System.out.println("Error al cargar: " + error.getMessage());
			} catch (ClassNotFoundException error) {
				System.out.println("Clase no encontrada: " + error.getMessage());
			}
		}
	}


