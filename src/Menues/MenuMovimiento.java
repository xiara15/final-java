package Menues;

import java.util.ArrayList;

import FinalprogramacionII.MetodosGeneral;
import clases.Movimiento;

public class MenuMovimiento {
	
	//MENUS MOVIMIENTO
		public static void menuDatosMovimiento(ArrayList <Movimiento> lista) {
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
					elemento = menuSelectMovimiento(lista);
					elemento.datosMovimiento(elemento);
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
			Menu.menusDatos();
		}
				
		public static void menuIngresoMovimiento(ArrayList <Movimiento> lista) {
			System.out.println("Bienvenido al menú de ingreso de datos de movimiento/s:");
			System.out.println("1 - Ingresar un movimiento.");
			System.out.println("2 - Dar de baja a un movimiento.");
			System.out.println("3 - Buscar un producto por su codigo.");
			System.out.println("4 - Modificar algunos de los datos de un movimiento.");
			System.out.println("5 - Salir.");
		
			Movimiento elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 5);
						
			switch(num) {
			case 1:
				Movimiento.altaMovimiento();
				break;
							
			case 2:
				if(lista != null) {
					elemento = menuSelectMovimiento(lista);
					elemento.bajaMovimiento(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 3:
				if(lista != null) {
					elemento = Movimiento.buscarMovimiento();
					MenuMovimiento.menuMovimiento(elemento, lista);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 4:
				if(lista != null) {
					elemento = menuSelectMovimiento(lista);
					elemento.modificarMovimiento(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
				
			case 5:
				System.out.println("Saliendo...");
				break;
							
			default:
				break;
			}
			Menu.menusIngresar();
		}
		
		public static void menuMovimiento(Movimiento movimiento, ArrayList <Movimiento> lista) {
			if(movimiento != null && lista != null) {
				System.out.println("Bienvenido al menú general de movimiento/s:");
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
					movimiento.datosMovimiento(movimiento);
					break;
					
				case 2:
					movimiento.modificarMovimiento(movimiento);
					break;
					
				case 3:
					movimiento.bajaMovimiento(movimiento);
					break;
					
				case 4:
					System.out.println("Saliendo...");
					break;
					
				default:
					break;
				}
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			MenuMovimiento.menuIngresoMovimiento(lista);
		}
		
		public static Movimiento menuSelectMovimiento(ArrayList <Movimiento> lista) {
			if(lista != null) {
				int cont = 1, limit = lista.size();
				for(Movimiento elemento : lista) {
					System.out.println(cont + " - " + Movimiento.getDetalle());
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
		public static ArrayList <Movimiento> menuListaMovimientos(ArrayList <Movimiento> lista){
			if(lista != null) {
				ArrayList <Movimiento> movimientos = new ArrayList <Movimiento> (10);
				Movimiento elemento = null;
				
				int cant=0; String cantAux=null;
				cant = MetodosGeneral.castearEntero("Ingrese la cantidad de movimientos que desea enviar a la cuenta: ", cantAux);
				
				for(int i=0; i<cant; i++) {
					elemento = MenuMovimiento.menuSelectMovimiento(lista);
					movimientos.add(elemento);
				}
				
				return movimientos;
			}else {
				System.out.println("No se han encontrado los datos.");
			}
			return null;
		}

}
