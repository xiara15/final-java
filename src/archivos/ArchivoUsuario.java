package archivos;

import java.io.*;

import java.util.ArrayList;

import clases.Usuario;

public class ArchivoUsuario {

	// CREAR ARCHIVO
		public static void crearArchivoUsuario() {
			String ruta = "Carpeta General" + File.separator + "usuario.dat";
			File archivo = new File(ruta);
			if (archivo.exists()==false){
				try {
					if (archivo.createNewFile()) {
						System.out.println("El archivo se creó con exito");
					}
				} catch (IOException error) {
					System.out.println("Error al crear el archivo " + error.getMessage());
				}
			} else {
				System.out.println("El archivo que intenta crear ya existe.");
			}
		}
		
		//ELIMINAR ARCHIVO
    public static void eliminarArchivoUsuario(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo de usuarios eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    //SERIALIZAR 
    public static void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("Carpeta General" + File.separator + "usuario.dat"))) {
            
            oos.writeObject(Usuario.listaUsuarios);
            System.out.println("Archivo usuario guardado correctamente.");
            
        } catch (IOException error) {
            System.out.println("Error al guardar: " + error.getMessage());
        }
    }

	//DESERIALIZAR
	public static void cargarUsuarios() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Carpeta General" + File.separator + "usuario.dat"))) {
			Usuario.listaUsuarios = (ArrayList <Usuario>) ois.readObject();
			System.out.println("Archivo usuario cargado correctamente.");
		} catch (IOException error) {
			System.out.println("Error al cargar: " + error.getMessage());
		} catch (ClassNotFoundException error) {
			System.out.println("Clase no encontrada: " + error.getMessage());
		}
	}
}