package archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import clases.Usuario;

public class ArchivoUsuario {

    private String rutaArchivo;

    public ArchivoUsuario(String rutaArchivo) {
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
                    System.out.println("Archivo de usuarios creado.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public static void crearArchivoUsuario(String rutaArchivo) {
        new ArchivoUsuario(rutaArchivo);
    }

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

    // Guardar un usuario al archivo (agregando a la lista)
    public void guardarUsuario(Usuario usuario) {
        List<Usuario> usuarios = cargarUsuarios(); // Cargar existentes
        usuarios.add(usuario); // Agregar nuevo
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(usuarios);
            System.out.println("Usuario guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

    // Cargar todos los usuarios del archivo
    public List<Usuario> cargarUsuarios() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>(); // Retorna lista vacía si el archivo está vacío
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return extraer(ois);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Usuario> extraer(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        return (List<Usuario>) ois.readObject();
    }
}