package Menues;

import java.util.ArrayList;

import FinalprogramacionII.MetodosGeneral;
import clases.Empleado;

public class MenuEmpleado {

	
	//MENUS EMPLEADO
		public static void menuDatosEmpleado(ArrayList <Empleado> lista) {
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
					Empleado elemento = menuSelectEmpleado(lista);
					elemento.datosEmpleado(elemento);
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
			Menu.menusDatos();
		}
				
		public static void menuIngresoEmpleado(ArrayList <Empleado> lista) {
			System.out.println("Bienvenido al menú de ingreso de datos de empleado/s:");
			System.out.println("1 - Ingresar un empleado.");
			System.out.println("2 - Dar de baja a un empleado.");
			System.out.println("3 - Modificar algunos de los datos de un empelado.");
			System.out.println("4 - Salir.");
		
			Empleado elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 5);
						
			switch(num) {
			case 1:
				Empleado.altaEmpleado();
				break;
							
			case 2:
				if(lista != null) {
					elemento = menuSelectEmpleado(lista);
					elemento.bajaPersona(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
	
							
			case 3:
				if(lista != null) {
					elemento = menuSelectEmpleado(lista);
					elemento.modificarEmpleado(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
				
			case 4:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
			Menu.menusIngresar();
		}
		
		public static void menuEmpleado(Empleado empleado, ArrayList <Empleado> lista) {
			if(empleado != null && lista != null) {
				System.out.println("Bienvenido al menú general de empleado/s:");
				System.out.println("1 - Ver datos.");
				System.out.println("2 - Modificar algún dato.");
				System.out.println("3 - Dar de baja");
				System.out.println("4 - Salir.");
			
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > 4);
							
				switch(num) {
				case 1:
					empleado.datosEmpleado(empleado);
					break;
					
				case 2:
					empleado.modificarEmpleado(empleado);
					break;
					
				case 3:
					empleado.bajaPersona(empleado);
					break;
					
				case 4:
					System.out.println("Saliendo...");
					break;
					
				default:
					break;
				}
				MenuEmpleado.menuIngresoEmpleado(lista);
			}else {
				System.out.println("No se encontraron los datos.");
			}
		}
		
		public static Empleado menuSelectEmpleado(ArrayList <Empleado> lista) {
			if(lista != null) {
				int cont = 1, limit = lista.size();
				for(Empleado elemento : lista) {
					System.out.println(cont + " - " + elemento.getNombre());
					cont++;
				}
				
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > limit+1);
				
				return lista.get(num-1);
			}else {
				System.out.println("No se encontraron datos.");
			}
			return null;
		}
}
