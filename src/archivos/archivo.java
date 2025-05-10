package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

		//TRADICIONAL
		public static void escribirArchivo(String ruta, String contenido) {
			File miArchivo = new File (ruta);
			if (miArchivo.exists()) {
				PrintWriter escritura = null;
				try{
					escritura = new PrintWriter(new FileWriter(miArchivo, true));
					escritura.println(contenido);
				} catch (IOException error) {
					System.out.println("Error al escribir el archivo: " + error.getMessage());
				} finally {
					if (escritura != null) {
		                escritura.close();
		            }
				}
			} else {
				System.out.println("El archivo especificado no existe.");
			}
		}
			
		public static void leerArchivo (String ruta) {
			File miArchivo = new File (ruta);
			if (miArchivo.exists()) {
				BufferedReader lectura = null;
				try {
					lectura = new BufferedReader(new FileReader(miArchivo));
					String contenido = lectura.readLine();
					while (contenido != null) {
						System.out.println(contenido);
						contenido = lectura.readLine();
					}
				} catch (FileNotFoundException error) {
					System.out.println(error.getMessage());
				} catch ( IOException error) {
					System.out.println(error.getMessage());
				} finally {
					if (lectura != null) {
						try {
							lectura.close();
						} catch (IOException error) {
							System.out.println(error.getMessage());
						}
					}
				}
			} else {
				System.out.println("El archivo especificado no existe.");
			}
		}

		public static void cargarDatos() {
			// TODO Auto-generated method stub
			
		}
		
	}
		
		
		
		