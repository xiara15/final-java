package Menues;

import FinalprogramacionII.MetodosGeneral;
import Menues.MenuVerDatos;
import archivos.archivo;
import clases.Cliente;
import clases.CuentaCorriente;
import clases.Empleado;
import clases.Movimiento;
import clases.Persona;
import clases.Producto;
import clases.Proveedor;
import clases.Usuario;
import clases.Venta;



public class Menu {
	
	private static boolean ejecutar = false;

	//MENU PRINCIPAL
		public static void menuPrincipal() {
			if(!ejecutar) {
				archivo.cargarDatos();
				ejecutar = true;
			}
			
			System.out.println("\n====== Bienvenido al menú principal  ========");
			System.out.println("\n||     1. Ver datos del Menú               ||");
			System.out.println("\n||     2. Ingresar a los datos del Menú    ||");
			System.out.println("\n||     3. Ingresar al Manú de archivos     ||");
			System.out.println("\n||     4. Salir                            ||");
			System.out.println("\n||     5.Volver al menu principal          ||");
			System.out.println("\n=============================================");
			System.out.println("\nIngrese su opcion: ");
	
	
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 4);
				
			switch(num) {
			case 1:
				MenuVerDatos ();
		
				break;
					
			case 2:
				menusDatos();
				break;
					
			case 3:
				menusArchivos();
				break;
					
			case 4:
				archivo.cargarDatos();
				
				System.out.println("Saliendo...");
				System.exit(0);
				break;
					
			default:
				break;
			}
		}
			
		private static void MenuVerDatos() {
	
		
	}

		//MENUS SECUNDARIOS
		public static void menusVerDatos() {
			System.out.println("Bienvenido al menú secundario para ver datos:");
			System.out.println("1 - Menú de personas.");
			System.out.println("2 - Menú de empleados.");
			System.out.println("3 - Menú de usuarios.");
			System.out.println("4 - Menú de productos.");
			System.out.println("5 - Menú de ventas.");
			System.out.println("6 - Menú de movimientos.");
			System.out.println("7 - Menú de cuentas corrientes.");
			System.out.println("8 - Menú de clientes.");
			System.out.println("9 - Menú de proveedores.");
			System.out.println("10 - Salir.");
				
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 10);
				
			switch(num) {
			case 1:
				Persona.menuDatosPersona(Persona.lista);
				break;
					
			case 2:
				MenuEmpleado.menuDatosEmpleado(Empleado.listaEmpleados);
				break;
					
			case 3:
				MenuUsuario.menuDatosUsuario(Usuario.listaUsuarios);
				break;
					
			case 4:
				MenuProducto.menuDatosProducto(Producto.listaProductos);
				break;
					
			case 5:
				MenuVenta.menuDatosVenta(Venta.listaVentas);
				break;
					
			case 6:
				MenuMovimiento.menuDatosMovimiento(Movimiento.listaMovimientos);
				break;
					
			case 7:
				MenuCtaCte.menuDatosCtaCte(CuentaCorriente.listaCtaCtes);
				break;
					
			case 8:
				MenuCliente.menuDatosCliente(Cliente.listaClientes);
				break;
					
			case 9:
				MenuProveedor.menuDatosProveedor(Proveedor.listaProveedores);
				break;
					
			case 10:
				System.out.println("Saliendo...");
				break;
					
			default:
				break;
			}
			Menus.menuPrincipal();
		}
			
		public static void menusIngresar() {
			System.out.println("Bienvenido al menú secundario para ingresar datos:");
			System.out.println("1 - Menú de personas.");
			System.out.println("2 - Menú de empleados.");
			System.out.println("3 - Menú de usuarios.");
			System.out.println("4 - Menú de productos,.");
			System.out.println("5 - Menú de ventas.");
			System.out.println("6 - Menú de movimientos.");
			System.out.println("7 - Menú de cuentas corrientes.");
			System.out.println("8 - Menú de clientes.");
			System.out.println("9 - Menú de proveedores.");
			System.out.println("10 - Salir.");
				
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 10);
				
			switch(num) {
			case 1:
				MenuPersona.menuIngresoPersona(Persona.listaPersonas);
				break;
					
			case 2:
				MenuEmpleado.menuIngresoEmpleado(Empleado.listaEmpleados);
				break;
					
			case 3:
				MenuUsuario.menuIngresoUsuario(Usuario.listaUsuarios);
				break;
					
			case 4:
				MenuProducto.menuIngresoProducto(Producto.listaProductos);
				break;
					
			case 5:
				MenuVenta.menuIngresoVenta(Venta.listaVentas);
				break;
					
			case 6:
				MenuMovimiento.menuIngresoMovimiento(Movimiento.listaMovimientos);
				break;
					
			case 7:
				MenuCtaCte.menuIngresoCtaCte(CuentaCorriente.listaCtaCtes);
				break;
					
			case 8:
				MenuCliente.menuIngresoCliente(Cliente.listaClientes);
				break;
					
			case 9:
				MenuProveedor.menuIngresoProveedor(Proveedor.listaProveedores);
				break;
					
			case 10:
				System.out.println("Saliendo...");
				break;
					
			default:
				break;
			}
			Menus.menuPrincipal();
		}
			
		public static void menusArchivos() {
			System.out.println("Bienvenido al menú secundario para gestionar archivos:");
			System.out.println("1 - Menú general de archivos.");
			System.out.println("2 - Menú archivos de personas.");
			System.out.println("3 - Menú archivos de empleados.");
			System.out.println("4 - Menú archivos de usuarios.");
			System.out.println("5 - Menú archivos de productos,.");
			System.out.println("6 - Menú archivos de ventas.");
			System.out.println("7 - Menú archivos de movimientos.");
			System.out.println("8 - Menú archivos de cuentas corrientes.");
			System.out.println("9 - Menú archivos de clientes.");
			System.out.println("10 - Menú archivos de proveedores.");
			System.out.println("11 - Salir.");
				
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 11);
				
			switch(num) {
			case 1:
				MenuArchivo.menuArchivo();
				break;
					
			case 2:
				MenuArchivo.menuArchivoPersona();
				break;
					
			case 3:
				MenuArchivo.menuArchivoEmpleado();
				break;
					
			case 4:
				MenuArchivo.menuArchivoUsuario();
				break;
					
			case 5:
				MenuArchivo.menuArchivoProducto();
				break;
					
			case 6:
				MenuArchivo.menuArchivoVenta();
				break;
					
			case 7:
				MenuArchivo.menuArchivoMovimiento();
				break;
					
			case 8:
				MenuArchivo.menuArchivoCtaCte();
				break;
					
			case 9:
				MenuArchivo.menuArchivoCliente();
				break;
					
			case 10:
				MenuArchivo.menuArchivoProveedor();
				break;
				
			case 11:
				System.out.println("Saliendo...");
				break;
					
			default:
				break;
			}
			Menus.menuPrincipal();
		}
	}

}
