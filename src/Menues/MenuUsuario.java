package Menues;

import java.util.ArrayList;
import clases.Persona;
import clases.Usuario;
import FinalprogramacionII.MetodosGeneral;

public class MenuUsuario {
	 
	    // MENÚ DE CONSULTA DE DATOS DE USUARIOS
	    public static void menuDatosUsuario(ArrayList<Usuario> lista) {
	        if (lista != null) {
	            System.out.println("Bienvenido al menú de datos de cliente/s:");
	            System.out.println("1 - Datos de un cliente.");
	            System.out.println("2 - Datos de todos los clientes.");
	            System.out.println("3 - Salir.");

	            Usuario elemento = null;
	            String numAux = null;
	            int num = 0;
	            do {
	                num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
	            } while (num < 1 || num > 3);

	            switch (num) {
	                case 1:
	                    elemento = menuSelectUsuario(lista);
	                    elemento.datosUsuario(elemento);
	                    break;

	                case 2:
	                    Usuario.listarUsuario(Usuario.listaDeusuarios);
	                    break;

	                case 3:
	                    System.out.println("Saliendo...");
	                    break;
	            }
	        } else {
	            System.out.println("No se han encontrado los datos.");
	        }

	        Menu.menusDatos();
	    }

	    // MENÚ DE ALTA, BAJA Y MODIFICACIÓN DE USUARIOS
	    public static void menuIngresoUsuario(ArrayList<Usuario> lista) {
	        System.out.println("Bienvenido al menú de ingreso de datos de cliente/s:");
	        System.out.println("1 - Ingresar un cliente.");
	        System.out.println("2 - Dar de baja a un cliente.");
	        System.out.println("3 - Buscar un cliente por su DNI.");
	        System.out.println("4 - Modificar algunos de los datos de un cliente.");
	        System.out.println("5 - Salir.");

	    
	        String numAux = null;
	        int num = 0;
	        do {
	            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
	        } while (num < 1 || num > 5);

	        Usuario elemento;
			switch (num) {
	            case 1:
	                Usuario.altaUsuario(MenuPersona.menuSelectPersona(Persona.listaPersonas));
	                break;

	            case 2:
	                if (lista != null) {
	                    elemento = menuSelectUsuario(lista);
	                    elemento.bajaUsuario(elemento);
	                } else {
	                    System.out.println("No se han encontrado los datos.");
	                }
	                break;

	            case 3:
	                if (lista != null) {
	                    elemento = Usuario.buscarUsuario(num);
	                    MenuUsuario.menuUsuario(elemento, lista);
	                } else {
	                    System.out.println("No se han encontrado los datos.");
	                }
	                break;

	            case 4:
	                if (lista != null) {
	                    elemento = menuSelectUsuario(lista);
	                    elemento.modificarUsuario(elemento);
	                } else {
	                    System.out.println("No se han encontrado los datos.");
	                }
	                break;

	            case 5:
	                System.out.println("Saliendo...");
	                break;
	        }

	        Menu.menusIngresar();
	    }

	    // MENÚ INDIVIDUAL DE USUARIO
	    public static void menuUsuario(Usuario usuario, ArrayList<Usuario> lista) {
	        if (usuario != null && lista != null) {
	            System.out.println("Bienvenido al menú general de cliente/s:");
	            System.out.println("1 - Ver datos.");
	            System.out.println("2 - Modificar algún dato.");
	            System.out.println("3 - Dar de baja.");
	            System.out.println("4 - Salir.");

	            String numAux = null;
	            int num = 0;
	            do {
	                num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
	            } while (num < 1 || num > 4);

	            switch (num) {
	                case 1:
	                    usuario.datosUsuario(usuario);
	                    break;

	                case 2:
	                    usuario.modificarUsuario(usuario);
	                    break;

	                case 3:
	                    usuario.bajaUsuario(usuario);
	                    break;

	                case 4:
	                    System.out.println("Saliendo...");
	                    break;
	            }
	        } else {
	            System.out.println("No se han encontrado los datos.");
	        }

	        MenuUsuario.menuIngresoUsuario(lista);
	    }

	    // SELECCIÓN DE USUARIO DE UNA LISTA
	    public static Usuario menuSelectUsuario(ArrayList<Usuario> lista) {
	        if (lista != null && !lista.isEmpty()) {
	            int cont = 1;
	            int limit = lista.size();
	            for (Usuario elemento : lista) {
	                System.out.println(cont + " - " + elemento.getUsuario());
	                cont++;
	            }

	            String numAux = null;
	            int num = 0;
	            do {
	                num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
	            } while (num < 1 || num > limit);

	            return lista.get(num - 1);
	        } else {
	            System.out.println("No se encontraron datos.");
	        }

	        return null;
	    }
	}



