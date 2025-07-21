package Menues;

import java.io.File;
import java.util.Scanner;
import archivos.*;
import FinalprogramacionII.MetodosGeneral;
public class MenuArchivo {
	

	// MENU ARCHIVO GENERAL
	public static void menuArchivo() {
		System.out.println("Bienvenido al menú general de archivo/s:");
		System.out.println("1 - Crear la carpeta general.");
		System.out.println("2 - Eliminar la carpeta general.");
		System.out.println("3 - Eliminar un archivo.");
		System.out.println("4 - Eliminar todos los archivos.");
		System.out.println("5 - Salir.");
		
		try (Scanner teclado = new Scanner(System.in)) {
			String numAux=null, ruta=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 8);
			
			switch(num) {
			case 1:
				archivo.crearCarpeta("Carpeta General");
				break;
				
			case 2:
				archivo.eliminarCarpeta("Carpeta General");
				break;
				
			case 3:
				System.out.println("Ingrese el nombre del archivo a eliminar: ");
				ruta = teclado.nextLine() + ".dat";
				archivo.eliminarArchivo("Carpeta General" + File.separator + ruta);
				break;
				
			case 4:
				archivo.eliminarArchivo("Carpeta General");
				break;
				
			case 5:
				System.out.println("Saliendo...");
				break;
				
			default:
				break;
			}
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO PERSONA
	public static void menuArchivoPersona() {
		System.out.println("Bienvenido al menú general de archivo/s:");
		System.out.println("1 - Crear archivo persona.");
		System.out.println("2 - Guardar persona.");
		System.out.println("3 - Cargar persona.");
		System.out.println("4 - Eliminar archivo persona.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoPersona.crearArchivoPersona();
			break;
			
		case 2:
			ArchivoPersona.guardarPersonas();
			break;
			
		case 3:
			ArchivoPersona.cargarPersonas();
			break;
			
		case 4:
			ArchivoPersona.eliminarArchivoPersona();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO EMPLEADO
	public static void menuArchivoEmpleado() {
		System.out.println("Bienvenido al menú general de archivo/s empleado:");
		System.out.println("1 - Crear archivo empleado.");
		System.out.println("2 - Guardar empleado.");
		System.out.println("3 - Cargar empleado.");
		System.out.println("4 - Eliminar archivo empleado.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoEmpleado.crearArchivoEmpleado();
			break;
			
		case 2:
			ArchivoEmpleado.guardarEmpleados();
			break;
			
		case 3:
			ArchivoEmpleado.cargarEmpleados();
			break;
			
		case 4:
			ArchivoEmpleado.eliminarArchivoEmpleado();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO PRODUCTO
	public static void menuArchivoProducto() {
		System.out.println("Bienvenido al menú general de archivo/s producto:");
		System.out.println("1 - Crear archivo producto.");
		System.out.println("2 - Guardar producto.");
		System.out.println("3 - Cargar producto.");
		System.out.println("4 - Eliminar archivo producto.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoProducto.crearArchivoProducto();
			break;
			
		case 2:
			ArchivoProducto.guardarProductos();
			break;
			
		case 3:
			ArchivoProducto.cargarProductos();
			break;
			
		case 4:
			ArchivoProducto.eliminarArchivoProducto();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO MOVIMIENTO
	public static void menuArchivoMovimiento() {
		System.out.println("Bienvenido al menú general de archivo/s movimiento:");
		System.out.println("1 - Crear archivo movimiento.");
		System.out.println("2 - Guardar movimiento.");
		System.out.println("3 - Cargar movimiento.");
		System.out.println("4 - Eliminar archivo movimiento.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoMovimiento.crearArchivoMovimiento();
			break;
			
		case 2:
			ArchivoMovimiento.guardarMovimientos();
			break;
			
		case 3:
			ArchivoMovimiento.cargarMovimientos();
			break;
			
		case 4:
			ArchivoMovimiento.eliminarArchivoMovimiento();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO VENTA
	public static void menuArchivoVenta() {
		System.out.println("Bienvenido al menú general de archivo/s venta:");
		System.out.println("1 - Crear archivo venta.");
		System.out.println("2 - Guardar venta.");
		System.out.println("3 - Cargar venta.");
		System.out.println("4 - Eliminar archivo venta.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoVenta.crearArchivoVenta();
			break;
			
		case 2:
			ArchivoVenta.guardarVentas();
			break;
			
		case 3:
			ArchivoVenta.cargarVentas();
			break;
			
		case 4:
			ArchivoVenta.eliminarArchivoVenta();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO CLIENTE
	public static void menuArchivoCliente() {
		System.out.println("Bienvenido al menú general de archivo/s cliente:");
		System.out.println("1 - Crear archivo cliente.");
		System.out.println("2 - Guardar cliente.");
		System.out.println("3 - Cargar cliente.");
		System.out.println("4 - Eliminar archivo cliente.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoMovimiento.crearArchivoMovimiento();
			break;
			
		case 2:
			ArchivoMovimiento.guardarMovimientos();
			break;
			
		case 3:
			ArchivoMovimiento.cargarMovimientos();
			break;
			
		case 4:
			ArchivoMovimiento.eliminarArchivoMovimiento();
			break;
			
		case 5:
			System.out.println("Saliendo...");
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO CTACTE
	public static void menuArchivoCtaCte() {
		System.out.println("Bienvenido al menú general de archivo/s cuenta corriente:");
		System.out.println("1 - Crear archivo cuenta corriente.");
		System.out.println("2 - Guardar cuenta corriente.");
		System.out.println("3 - Cargar cuenta corriente.");
		System.out.println("4 - Eliminar archivo cuenta corriente.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoCuentaCorriente.crearArchivoCtaCte();
			break;
			
		case 2:
			ArchivoCuentaCorriente.guardarCtaCtes();
			break;
			
		case 3:
			ArchivoCuentaCorriente.cargarCtaCtes();
			break;
			
		case 4:
			ArchivoCuentaCorriente.eliminarArchivoCtaCte();
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO PROVEEDOR
	public static void menuArchivoProveedor() {
		System.out.println("Bienvenido al menú general de archivo/s proveedor:");
		System.out.println("1 - Crear archivo proveedor.");
		System.out.println("2 - Guardar proveedor.");
		System.out.println("3 - Cargar proveedor.");
		System.out.println("4 - Eliminar archivo proveedor.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoProveedor.crearArchivoProveedor();
			break;
			
		case 2:
			ArchivoProveedor.guardarProveedores();
			break;
			
		case 3:
			ArchivoProveedor.cargarProveedores();
			break;
			
		case 4:
			ArchivoProveedor.crearArchivoProveedor();
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
	
	// MENU ARCHIVO USUARIO
	public static void menuArchivoUsuario() {
		System.out.println("Bienvenido al menú general de archivo/s persona:");
		System.out.println("1 - Crear archivo usuario.");
		System.out.println("2 - Guardar usuario.");
		System.out.println("3 - Cargar usuario.");
		System.out.println("4 - Eliminar archivo usuario.");
		System.out.println("5 - Salir.");
		
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 5);
		
		switch(num) {
		case 1:
			ArchivoUsuario.crearArchivoUsuario();
			break;
			
		case 2:
			ArchivoUsuario.guardarUsuarios();
			break;
			
		case 3:
			ArchivoUsuario.cargarUsuarios();
			break;
			
		case 4:
			ArchivoUsuario.crearArchivoUsuario();
			break;
			
		default:
			break;
		}
		Menu.menusArchivos();
	}
}