package clases;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

	
public class Usuario extends Persona implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String usuario;
	    private String clave;
	    private Persona propietario;

public Usuario(int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, String usuario, Persona propietario, String clave) {
	        super(dni, activo, nombres, apellidos, telefono, direccion, provincia, localidad, fechaNacimiento, sexo);
	        this.usuario = usuario;
	        this.propietario = propietario;
	        this.clave = clave;
	    }
	


public static ArrayList<Usuario>listaDeusuarios = new ArrayList<>();
private static Scanner entrada;

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

public Persona getPropietario() {
	return propietario;
}

public void setPropietario(Persona propietario) {
	this.propietario = propietario;
}

public static ArrayList<Usuario> getListaDeusuarios() {
	return listaDeusuarios;
}

public static void setListaDeusuarios(ArrayList<Usuario> listaDeusuarios) {
	Usuario.listaDeusuarios = listaDeusuarios;
}

//metodos personales ususario

public static Usuario altaUsuario(Persona persona){

    entrada = new Scanner(System.in);
		int dni = Excepciones.castearEntero("ingrese el dni: ");
		Persona propietario = buscarUsuario(dni);
		if (propietario == null){
		    System.out.println("no se encontro el dni, debes crear una persona primero: ");
		    return null;
		}

		String nombreUsuario;
		boolean flag = false;
		do {
		    System.out.println("ingrese el nombre de ususario: ");
		    nombreUsuario = entrada.nextLine();
		    if (Excepciones.verificarUsuario(nombreUsuario)){
		        flag = true;
		    }
		}while (!flag);

		String clave;
		flag = false;
		do {
		    System.out.println("ingrese la contraseña: ");
		    clave = entrada.nextLine();
		    if (Excepciones.verificarClave(clave)){
		        flag = true;
		    }
		}while (!flag);

		Usuario nuevoUsuario = new Usuario(propietario.getDni(),
		        propietario.isActivo(),
		        propietario.getNombre(),
		        propietario.getApellido(),
		        propietario.getTelefono(),
		        propietario.getDireccion(),
		        propietario.getProvincia(),
		        propietario.getLocalidad(),
		        propietario.getFechaNacimiento(),
		        propietario.getSexo(),
		        nombreUsuario,
		        propietario,
		        clave);
		listaDeusuarios.add(nuevoUsuario);
		System.out.println("usuario creado con exito: ");
		return nuevoUsuario;
	
}

public void bajaUsuario(Usuario elemento){

    int dni = Excepciones.castearEntero("ingrese el dni: ");
    Usuario usuarioExistente = buscarUsuario(dni);
    if (usuarioExistente == null){
        System.out.println("no se encontro el ususrio: ");
        return;
    }
    listaDeusuarios.remove(usuarioExistente);
    System.out.println("usuario eliminado: ");
}

public void modificarUsuario(Usuario usuario){
    entrada = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		int dni = Excepciones.castearEntero("ingrese el dni: ");
		Usuario usuarioExistente = buscarUsuario(dni);
		if (usuarioExistente == null){
		    System.out.println("no se encontro el usuario: ");
		    return;
		}
		do {
		    System.out.println("usuario encontrado: ");
		    System.out.println("1- usuario: ");
		    System.out.println("2- clave: ");
		    System.out.println("3- salir");
		    opcion = entrada.nextInt();
		    entrada.nextLine();

		    switch (opcion){
		        case 1:
		            String usuarioNuevo;
		            boolean flag = false;
		            do {
		                System.out.println("ingrese el nombre de ususario nuevo: ");
		                usuarioNuevo = entrada.nextLine();
		                if (Excepciones.verificarUsuario(usuarioNuevo)){
		                    flag = true;
		                }
		            }while (! flag);

		            break;

		        case 2:
		            String claveNueva;
		            flag = false;
		            do {
		                System.out.println("ingrese la contraseña: ");
		                claveNueva = entrada.nextLine();
		                if (Excepciones.verificarClave(claveNueva)){
		                    flag = true;
		                }
		            }while (! flag);

		            break;

		        case 3:
		            salir = true;
		            System.out.println("saliendo del sistema");
		            break;

		        default:
		            System.out.println("opcion incorrecta: ");
		            return;
		    }
		}while (! salir);
	
}

public static Usuario buscarUsuario(int dni){
    for (Usuario usuario : listaDeusuarios){
        if (usuario.getDni() == dni){
            return usuario;
        }
    }
    System.out.println("usuario no encontrado");
    return null;
}

public static void listarUsuario(ArrayList<Usuario> listaDeusuarios){
    if (listaDeusuarios.isEmpty()){
        System.out.println("no hay usuario para mostrar: ");
    } else {
        for (Usuario usuario : listaDeusuarios){
            System.out.println("nombre: " + usuario.getNombre());
            System.out.println("apellido: " + usuario.getApellido());
            System.out.println("nombre de usuario: " + usuario.getUsuario());
        }
    }
}

public void datosUsuario(Usuario usuario) {
	if(usuario != null) {
		System.out.println("Datos del usuario:");
		System.out.println("Usuario: " + usuario.getUsuario());
		System.out.println("Clave: " + usuario.getClave());
		System.out.println("Propietario: " + usuario.getPropietario());
		System.out.println("Activo: " + MetodosGeneral.verificarBooleano(usuario.isActivo()));
		System.out.println("------------------------------");
	}else {
		System.out.println("No se encontraron los datos.");
	}
}

}
