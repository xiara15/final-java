package archivos;

import java.io.*;

import java.util.ArrayList;

import clases.Proveedor;

public class ArchivoProveedor {
	
	public static void crearArchivoProveedor() {
		String ruta = "Carpeta General" + File.separator + "proveedor.dat";
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


 	public static void guardarProveedores() {
 		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Carpeta General" + File.separator + "proveedor.dat"))) {
 			oos.writeObject(Proveedor.listaProveedores);
 			System.out.println("Archivo proveedor guardado correctamente.");
 		} catch (IOException error) {
 			System.out.println("Error al guardar: " + error.getMessage());
 		}
 	}

 	
 	public static void cargarProveedores() {
 		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "proveedor.dat"))) {
 			Proveedor.listaProveedores = (ArrayList <Proveedor>) ois.readObject();
 			System.out.println("Archivo proveedor cargado correctamente.");
 		} catch (IOException error) {
 			System.out.println("Error al cargar: " + error.getMessage());
 		} catch (ClassNotFoundException error) {
 			System.out.println("Clase no encontrada: " + error.getMessage());
 		}
 	}
}