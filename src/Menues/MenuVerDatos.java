package Menues;

import java.util.ArrayList;

import FinalprogramacionII.MetodosGeneral;
import clases.Cliente;
import clases.CuentaCorriente;
import clases.Empleado;
import clases.Movimiento;
import clases.Persona;
import clases.Producto;
import clases.Proveedor;
import clases.Usuario;
import clases.Venta;

public class MenuVerDatos {

	public static Persona menuDatosPersona(ArrayList <Persona> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de persona/s:");
			System.out.println("1 - Datos de una persona.");
			System.out.println("2 - Datos de todas las personas.");
			System.out.println("3 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				Persona elemento = menuDatosPersona(lista);
			
				break;
							
			case 2:
				Persona.mostrarListaPersonas();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
		return null;
	}
	
	public static Usuario menuDatosUsuario(ArrayList <Usuario> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de cleinte/s:");
			System.out.println("1 - Datos de un cliente.");
			System.out.println("2 - Datos de todos los cleintes.");
			System.out.println("3 - Salir.");
			
			Usuario elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				usuario.datosCliente ;
				
				break;
							
			case 2:
				Usuario.listarUsuario (lista);
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
		return null;
	}
			
	
	public static Cliente menuDatosCliente(ArrayList <Cliente> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de cleinte/s:");
			System.out.println("1 - Datos de un cleinte.");
			System.out.println("2 - Datos de todos los cleintes.");
			System.out.println("3 - Salir.");
			
			Cliente elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuDatosCliente(lista);
				
				break;
							
			case 2:
				Cliente.altaCliente();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
		return null;
	}
			
	public static Empleado menuDatosEmpleado(ArrayList <Empleado> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de empleado/s:");
			System.out.println("1 - Datos de un empleado.");
			System.out.println("2 - Datos de todos los empleados.");
			System.out.println("3 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				Empleado elemento = menuDatosEmpleado(lista);
			
				break;
							
			case 2:
				Empleado.ListarEmpleado();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
		return null;
	}
	public static CuentaCorriente menuDatosCtaCte(ArrayList <CuentaCorriente> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de cuenta/s:");
			System.out.println("1 - Datos de una cuenta.");
			System.out.println("2 - Salir");
			
			
			CuentaCorriente elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuDatosCtaCte(lista);
			
				break;
								
			case 2:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
		return null;
	}
	public static Movimiento menuDatosMovimiento(ArrayList <Movimiento> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de movimiento/s:");
			System.out.println("1 - Datos de un movimiento.");
			System.out.println("2 - Datos de todos los movimiento.");
			System.out.println("3 - Salir.");
			
			Movimiento elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuDatosMovimiento(lista);
				
				break;
							
			case 2:
				Movimiento.listarMovimientos();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusVerDatos();
	}
	public static void menuDatosProducto(ArrayList <Producto> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de producto/s:");
			System.out.println("1 - Datos de un producto.");
			System.out.println("2 - Datos de todos los producto.");
			System.out.println("3 - Salir.");
			
			Producto elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuSelectProducto(lista);
				
				break;
							
			case 2:
				Producto.listarProductos();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusDatos();
	}
	public static void menuDatosProveedor(ArrayList <Proveedor> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de cleinte/s:");
			System.out.println("1 - Datos de un cleinte.");
			System.out.println("2 - Datos de todos los cleintes.");
			System.out.println("3 - Salir.");
			
			Proveedor elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuSelectProveedor(lista);
				
				break;
							
			case 2:
				Proveedor.listarProveedor();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusDatos();
	}
	public static void menuDatosVenta(ArrayList <Venta> lista) {
		if(lista != null) {
			System.out.println("Bienvenido al menú de datos de venta/s:");
			System.out.println("1 - Datos de un venta.");
			System.out.println("2 - Datos de todos los ventas.");
			System.out.println("3 - Salir.");
			
			Venta elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				elemento = menuSelectVenta(lista);
			
				break;
							
			case 2:
				Venta.listarVentas();
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
		Menu.menusDatos();
	}
	
	
	
}
