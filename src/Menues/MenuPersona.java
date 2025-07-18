package Menues;

import java.util.ArrayList;

import clases.Persona;
import FinalprogramacionII.MetodosGeneral;
public class MenuPersona {
	
	//MENUS PERSONA
		public static void menuDatosPersona(ArrayList <Persona> lista) {
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
					Persona elemento = menuSelectPersona(lista);
					elemento.datosPersona(elemento);
					break;
								
				case 2:
					Persona.listarPersonas();
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
				
		public static void menuIngresoPersona(ArrayList <Persona> lista) {
			System.out.println("Bienvenido al menú de ingreso de datos de persona/s:");
			System.out.println("1 - Ingresar una persona.");
			System.out.println("2 - Dar de baja a una persona.");
			System.out.println("3 - Buscar una persona por su DNI.");
			System.out.println("4 - Modificar algunos de los datos de una persona.");
			System.out.println("5 - Salir.");
		
			Persona elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 5);
						
			switch(num) {
			case 1:
				Persona.altaPersona();
				break;
							
			case 2:
				if(lista != null) {
					elemento = menuSelectPersona(lista);
					elemento.bajaPersona(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 3:
				if(lista != null) {
					elemento = Persona.buscarPersonaDni();
					MenuPersona.menuPesona(elemento, lista);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 4:
				if(lista != null) {
					elemento = menuSelectPersona(lista);
					elemento.modificarPersona(elemento);
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
		
		public static void menuPesona(Persona persona, ArrayList <Persona> lista) {
			if(persona != null && lista != null) {
				System.out.println("Bienvenido al menú general de persona/s:");
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
					persona.datosPersona(persona);
					break;
					
				case 2:
					persona.modificarPersona(persona);
					break;
					
				case 3:
					persona.bajaPersona(persona);
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
			MenuPersona.menuIngresoPersona(lista);
		}
		
		public static Persona menuSelectPersona(ArrayList <Persona> lista) {
			if(lista != null) {
				int cont = 1, limit = lista.size();
				for(Persona elemento : lista) {
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
