package Menues;

import clases.Cliente;
import java.util.ArrayList;
import clases.CuentaCorriente;
import FinalprogramacionII.MetodosGeneral;

public class MenuCliente {

	//MENUS CLIENTE
		public static void menuDatosCliente(ArrayList <Cliente> lista) {
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
					elemento = menuSelectCliente(lista);
					elemento.datosCliente(elemento);
					break;
								
				case 2:
					Cliente.listarClientes();
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
				
		public static void menuIngresoCliente(ArrayList <Cliente> lista) {
			System.out.println("Bienvenido al menú de ingreso de datos de cliente/s:");
			System.out.println("1 - Ingresar un cliente.");
			System.out.println("2 - Dar de baja a un cliente.");
			System.out.println("3 - Buscar un cliente por su DNI.");
			System.out.println("4 - Modificar algunos de los datos de un cliente.");
			System.out.println("5 - Salir.");
		
			Cliente elemento = null;
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 5);
						
			switch(num) {
			case 1:
				Cliente.altaCliente(MenuCuentaCorriente.menuSelectCtaCte(CuentaCorriente.listaCtactes));
				break;
							
			case 2:
				if(lista != null) {
					elemento = menuSelectCliente(lista);
					elemento.bajaPersona(elemento);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 3:
				if(lista != null) {
					elemento = Cliente.buscarCliente();
					MenuCliente.menuCliente(elemento, lista);
				}else {
					System.out.println("No se han encontrado los datos.");
				}
				break;
							
			case 4:
				if(lista != null) {
					elemento = menuSelectCliente(lista);
					elemento.modificarCliente(elemento);
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
		
		public static void menuCliente(Cliente cliente, ArrayList <Cliente> lista) {
			if(lista != null) {
				System.out.println("Bienvenido al menú general de cliente/s:");
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
					cliente.datosCliente(cliente);
					break;
					
				case 2:
					cliente.modificarCliente(cliente);
					break;
					
				case 3:
					cliente.bajaPersona(cliente);
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
			MenuCliente.menuIngresoCliente(lista);
		}
		
		public static Cliente menuSelectCliente(ArrayList <Cliente> lista) {
			if(lista != null) {
				int cont = 1, limit = lista.size();
				for(Cliente elemento : lista) {
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
