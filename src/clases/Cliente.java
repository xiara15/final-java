package clases;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.time.LocalDate;
import FinalprogramacionII.MetodosGeneral;

public class Cliente extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static ArrayList <Cliente> listaClientes = null;

	// Atributos
	private CuentaCorriente ctacte;
	
	// Constructor
	public Cliente (int dni, boolean activo, String nombres, String apellidos, String telefono, String direccion,
            Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
		super(dni, activo, nombres, apellidos, telefono, direccion, provincia, localidad, fechaNacimiento, sexo);
		this.ctacte = ctacte;
	}
	
	
	//Setters y Getters
	public CuentaCorriente getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorriente ctacte) {
		this.ctacte = ctacte;
	}

	// Metodos
	public static void altaCliente (CuentaCorriente ctacte) {
		if(ctacte != null) {
			try (Scanner teclado = new Scanner(System.in)) {
				String nombres, apellidos, telefono, direccion, localidad, dnistring = null;
				System.out.println("Ingrese el nombre: ");
				nombres = teclado.nextLine();
				
				System.out.println("Ingrese el apellido: ");
				apellidos = teclado.nextLine();
				
				int dni = MetodosGeneral.castearEntero ("Ingrese su DNI:", dnistring);
				
				Sexo genero = Sexo.elegirSexo();
				
				System.out.println("Ingrese el telefono: ");
				telefono = teclado.nextLine();
				
				System.out.println("Ingrese el direccion: ");
				direccion = teclado.nextLine();
				
				LocalDate fechaNacimiento = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");
				
				Provincia provincia = Provincia.obtenerProvincia();
				
				System.out.println("Ingrese la localidad: ");
				localidad = teclado.nextLine();
				
				boolean activo = true;
				
				Cliente nuevoCliente = new Cliente (dni, activo, nombres, apellidos, telefono, direccion, provincia, localidad, fechaNacimiento, genero, ctacte);
				
				if(listaClientes == null && listaPersonas == null) {
					Cliente.listaClientes = new ArrayList <Cliente> ();
				}
				if(listaPersonas == null){
					Persona.listaPersonas = new ArrayList <Persona> ();
				}
				if(listaClientes == null){
					Cliente.listaClientes = new ArrayList <Cliente> ();
				}
				
				listaClientes.add(nuevoCliente);
				Persona.listaPersonas.add(nuevoCliente);
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	public void modificarCliente(Cliente cliente) {
		if(cliente != null) {
			super.modificarPersona(cliente);
			
			System.out.println("1 - Modificar cuenta corriente.");
			System.out.println("2 - Salir.");
			
			String numAux=null; int num=0;
			do {
				num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
			}while(num < 1 || num > 2);
			
			switch(num) {
			case 1:
				cliente.getCtacte().modificarCtaCte(this.ctacte);
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
	}
	
	public void datosCliente(Cliente cliente) {
		if(cliente != null) {
			super.datosPersona(cliente);
			cliente.verCtaCte(cliente.getCtacte());
			System.out.println("------------------------------");
		}else {
			System.out.println("No se han encontrado datos.");
		}
	}
	
	public static void listarClientes() {
		if(Cliente.listaClientes != null) {
			for(Cliente elemento : listaClientes) {
				elemento.datosCliente(elemento);
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public static Cliente buscarCliente() {
		int num; String numAux=null;
		num = MetodosGeneral.castearEntero("Ingrese el DNI del cliente a buscar: ", numAux);
		for(Cliente elemento : listaClientes) {
			if(num == elemento.getDni()) {
				System.out.println("El cliente SI fue encontrada.");
				return elemento;
			}
		}
		System.out.println("El cliente NO fue encontrado.");
		return null;
	}
	
	public void verCtaCte(CuentaCorriente ctacte) {
	    if (ctacte != null) {
	        ctacte.datosCtaCte(null);
	    } else {
	        System.out.println("No se encontraron los datos.");
	    }
	}
	
	public Cliente enviarCLiente (Cliente cliente) {
		if(cliente != null) {
			return cliente;
		}else {
			System.out.println("No se encontraron los datos.");
		}
		return null;
	}
}