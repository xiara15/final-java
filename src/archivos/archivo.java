package archivos;

import java.io.File;
import java.io.IOException;


public class archivo {
		
		public static void crearCarpeta (String ruta) {
			File miArchivo = new File (ruta);
				
				if (miArchivo.mkdir()) {
					System.out.println("La carpeta fue creada con exito.");
				} else {
					
					System.out.println("No se pudo crear la carpeta, revise path y/o permisos.");
				}
		}
		
		public static void crearArchivo(String ruta) {
			File miArchivo = new File (ruta);
			try {
				if(miArchivo.createNewFile()) {
				
					System.out.println("Archivo creado con exito.");
				} else {
					
					System.out.println("El archivo ya existe.");
				}
			} catch (IOException error) {
				
				System.out.println("ERROR: " + error.getMessage());
			}
		}
		
		public static void eliminarArchivo(String ruta)
		{
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


		public static void eliminarCarpeta(String ruta) {
		    File carpeta = new File(ruta);
		    if (carpeta.exists()) {
		        eliminarRecursivo(carpeta);
		        System.out.println("La carpeta ha sido eliminada correctamente.");
		    } else {
		        System.out.println("No se elimino nada porque la carpeta no existe.");
		    }
		}

		private static void eliminarRecursivo(File carpeta) {
		    if (carpeta.isDirectory()) {
		        File[] Arregloarchivos = carpeta.listFiles();
		        if (Arregloarchivos != null) {
		            for (File file : Arregloarchivos) {
		                eliminarRecursivo(file);
		            }
		        }
		    }
		    carpeta.delete();
		}

		
		
		public static void guardarDatos() {
			File carpeta = new File("Carpeta General");
		    if (carpeta.exists() == false) {
		    	archivo.crearCarpeta("Carpeta General");
		    	if(carpeta.length() == 0) {
			    	ArchivoPersona.crearArchivoPersona();
			    	ArchivoEmpleado.crearArchivoEmpleado();
					ArchivoCliente.crearArchivoCliente();
					ArchivoProveedor.crearArchivoProveedor();
					ArchivoUsuario.crearArchivoUsuario();
					ArchivoProducto.crearArchivoProducto();
					ArchivoMovimiento.crearArchivoMovimiento();
					ArchivoVenta.crearArchivoVenta();
					ArchivoCuentaCorriente.crearArchivoCtaCte();
					ArchivoUsuario.crearArchivoUsuario();
		    	}
		    }
		
		
	}
		
}
		
		
		
		