package clases;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

	
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	public static ArrayList <Usuario> listaUsuarios = null;
	
	
	

	// Atributos
	private String usuario;
	private String clave;
	private Persona propetario;
	private boolean activo;
	
	// Constructores
	public Usuario (String usuario, String clave, Persona propetario, boolean activo) {
		this.usuario = usuario;
		this.clave = clave;
		this.propetario = propetario;
		this.activo = activo;
	}
	
	// Setter y Getters
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public Persona getPropetario() {
		return propetario;
	}
	public void setPropetario(Persona propetario) {
		this.propetario = propetario;
	}
	
	public boolean getActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
// Metodos
	
	//ALTA USUARIO
  public static void altaUsuario (Persona propietario) {
		if(propietario != null) {
			Scanner teclado = new Scanner (System.in);
			String usuario, clave;
			
			System.out.println("Ingrese su usuario:");
			usuario = teclado.nextLine();
			
			System.out.println("Ingrese su clave:");
			clave = teclado.nextLine();
			
			boolean activo = true;
			
			Usuario nuevoUsuario = new Usuario (usuario, clave, propietario, activo);
			
			if(Usuario.listaUsuarios == null) {
				listaUsuarios = new ArrayList <Usuario> ();
			}
			
			listaUsuarios.add(nuevoUsuario);
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}

  
  //BAJA USUARIO
	public void bajaUsuario (Usuario usuario) {
		if(usuario != null) {
			usuario.setActivo(false);
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	//MODIFICAR USUARIO
	public void modificarUsuario (Usuario usuario) {
		if(usuario != null) {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("1 - Modificar nombre de usuario.");
			System.out.println("Modificar su clave de usuario.");
			System.out.println("3 - Salir.");
			
			int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", clave);
			}while(num < 1 || num > 3);
			
			switch(num) {
			case 1:
				System.out.println("Ingrese su usuario:");
				String usuarioAux = teclado.nextLine();
				usuario.setUsuario(usuarioAux);
				break;
				
			case 2:
				System.out.println("Ingrese su clave:");
				String claveAux = teclado.nextLine();
				usuario.setUsuario(claveAux);
				break;
				
			case 3:
				System.out.println("Saliendo...");
				break;
				
			default:
				break;
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	
	// BUSCAR USUARIO
	public static Usuario buscarUsuario (int num) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de usuario a buscar:");
		String usser = teclado.nextLine();
		
		for(Usuario elemento : listaUsuarios) {
			if(usser.equals(elemento.getUsuario())) {
				System.out.println("El usuario SI se ha encontrado.");
				return elemento;
			}
		}
		
		System.out.println("El usuario NO se ha encontrado.");
		return null;
	}
	
	
	//DATOS USUARIO
	public void datosUsuario(Usuario usuario) {
		if(usuario != null) {
			System.out.println("Datos del usuario:");
			System.out.println("Usuario: " + usuario.getUsuario());
			System.out.println("Clave: " + usuario.getClave());
			System.out.println("Propietario: " + usuario.getPropetario());
			System.out.println("Activo: " + MetodosGeneral.verificarBooleano(usuario.getActivo()));
			System.out.println("------------------------------");
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
	
	//LISTAR USUARIO
	public static void listarUsuario (ArrayList <Usuario> listaUsuarios){
		if(listaUsuarios != null) {
			for(Usuario elemento : listaUsuarios) {
				elemento.datosUsuario(elemento);
			}
		}else {
			System.out.println("No se encontraron los datos.");
		}
	}
}
