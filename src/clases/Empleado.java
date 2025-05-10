package clases;
import java.time.LocalDate;
import java.util.Scanner;
	
public class Empleado extends Persona{

	    private static int length;
		private LocalDate fechaIngreso;
	    private LocalDate fechaEgreso;
	    private  int legajo;
	    private double salario;
		private static Empleado[] listaEmpleados;
	

	 
public Empleado(int dni, boolean activo, String nombre, String apellido, String telefono, String direccion, Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, LocalDate fechaIngreso, LocalDate fechaEgreso, int legajo, double salario) {
	        //indica que estás llamando al constructor de la clase padre para inicializar los atributos heredados de esa clase.
	    	super(dni, activo, nombre, apellido, telefono, direccion, provincia, localidad, fechaNacimiento, sexo);
	        
	        this.fechaIngreso = fechaIngreso;
	        this.fechaEgreso = fechaEgreso;
	        this.legajo = legajo;
	        this.salario = salario;
	    }

public Empleado(){
//consturctor vacio
}

public LocalDate getFechaIngreso() {
	return fechaIngreso;
}

public void setFechaIngreso(LocalDate fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}

public LocalDate getFechaEgreso() {
	return fechaEgreso;
}

public void setFechaEgreso(LocalDate fechaEgreso) {
	this.fechaEgreso = fechaEgreso;
}

public int getLegajo() {
	return legajo;
}

public void setLegajo(int legajo) {
	this.legajo = legajo;
}

public double getSalario() {
	return salario;
}

public void setSalario(double salario) {
	this.salario = salario;
}

//metodos personalizados para empleado

public void altaEmpleado(){
    int dni = Excepciones.castearEntero("ingrese el dni: ");

    Persona personaExistente = buscarPersona(dni);
    if (personaExistente != null) {
        System.out.println("la persona con DNI " + dni + " ya existe:");
        System.out.println("nombre: " + personaExistente.getNombres());
        System.out.println("apellido: " + personaExistente.getApellidos());
    }else {
        System.out.println("debe crear una persona");
        altaPersona();
        personaExistente = buscarPersona(dni);
    }

    int legajo = Excepciones.castearEntero("ingrese el legajo del empleado: ");

    double salario = Excepciones.castearDecimal("ingrese el sueldo del empleado: ");

    System.out.println("fecha de ingreso " + LocalDate.now());
    LocalDate fechaIngreso = LocalDate.now();

    Empleado nuevoEmpleado = new Empleado(
            personaExistente.getDni(),
            personaExistente.isActivo(),
            personaExistente.getNombres(),
            personaExistente.getApellidos(),
            personaExistente.getTelefono(),
            personaExistente.getDireccion(),
            personaExistente.getProvincia(),
            personaExistente.getLocalidad(),
            personaExistente.getFechaNacimiento(),
            personaExistente.getSexo(),
            fechaIngreso,
            null,
            legajo,
            salario);
    extracted(nuevoEmpleado).setActivo(true);
    System.out.println("empleado creado con exito");

}

public void bajaEmpleado() {
    Scanner entrada = new Scanner(System.in);
	
    int dniBuscado = Excepciones.castearEntero("ingrese el dni: ");

    Empleado empleadoEncontrado = null;
    for (Empleado empleado : listaEmpleados) {
        if (extracted(empleado).getDni() == dniBuscado) {
            empleadoEncontrado = extracted(empleado);
            break;
        }
    }

    if (extracted(empleadoEncontrado) == null) {
        System.out.println("no se encontro el dni ingresado.");
        return;
    }

    if (!extracted(empleadoEncontrado).isActivo()) {
        System.out.println("el empleado ya esta dado de baja.");
        return;
    }

    LocalDate fechaEgreso = Excepciones.crearFecha("ingrese la fecha de egreso del empleado:");

    extracted(empleadoEncontrado).setActivo(false);
    extracted(empleadoEncontrado).setFechaEgreso(fechaEgreso);
    System.out.println("empleado ha sido dado de baja exitosamente.");
}

public void modificarEmpleado(int legajo) {
    Scanner scanner = new Scanner(System.in);
		// Mostrar menú de opciones para modificar
		    System.out.println("¿Qué deseas modificar?");
		    System.out.println("1. Nombre");
		    System.out.println("2. Apellido");
		    System.out.println("3. Teléfono");
		    System.out.println("4. Dirección");
		    System.out.println("5. Salario");
		    System.out.println("6. Fecha de ingreso");
		    System.out.println("0. Salir");

		    int opcion1 = scanner.nextInt();
		    scanner.nextLine(); // Limpiar el buffer

		    Empleado empleado = null;
			switch (opcion1) {
		        case 1:
		            System.out.print("Ingrese el nuevo nombre: ");
		            String nuevoNombre = scanner.nextLine();
		            extracted(empleado).setNombre(nuevoNombre);
		            break;
		        case 2:
		            System.out.print("Ingrese el nuevo apellido: ");
		            String nuevoApellido = scanner.nextLine();
		            extracted(empleado).setApellidos(nuevoApellido);
		            break;
		        case 3:
		            System.out.print("Ingrese el nuevo teléfono: ");
		            String nuevoTelefono = scanner.nextLine();
		            extracted(empleado).setTelefono(nuevoTelefono);
		            break;
		        case 4:
		            System.out.print("Ingrese la nueva dirección: ");
		            String nuevaDireccion = scanner.nextLine();
		            extracted(empleado).setDireccion(nuevaDireccion);
		            break;
		        case 5:
		            System.out.print("Ingrese el nuevo salario: ");
		            double nuevoSalario = scanner.nextDouble();
		            extracted(empleado).setSalario(nuevoSalario);
		            break;
		        case 6:
		            System.out.print("Ingrese la nueva fecha de ingreso (yyyy-MM-dd): ");
		            String nuevaFechaIngreso = scanner.nextLine();
		            extracted(empleado).setFechaIngreso(java.time.LocalDate.parse(nuevaFechaIngreso));
		            break;
		        case 0:
		            System.out.println("Modificación cancelada.");
		            break;
		        default:
		            System.out.println("Opción no válida.");
		            break;
		    }
	
    }

private Empleado extracted(Empleado empleado) {
	return empleado;
} 


public void buscarEmpleado(){
    try (Scanner entrada = new Scanner(System.in)) {
	}

    int buscarDni = Excepciones.castearEntero("ingrese el dni: ");

    Empleado empleadoEncontrado = null;
    for (Empleado empleado : listaEmpleados) {
        if (empleado.getDni() == buscarDni) {
            empleadoEncontrado = empleado;
            break;
        }
    }

    if (empleadoEncontrado != null) {
        System.out.println("empleado encontrado: ");
        System.out.println("nombre: " + empleadoEncontrado.getNombres());
        System.out.println("apellido: " + empleadoEncontrado.getApellidos());
        System.out.println("legajo: " + empleadoEncontrado.getLegajo());
        System.out.println("fecha de ingreso: " + empleadoEncontrado.getFechaIngreso());
        System.out.println("activo: " + (empleadoEncontrado.isActivo() ? "si" : "no"));
    } else {
        System.out.println("no se encontro el empleado");
    }}

    public static void ListarEmpleado() {
        if (Empleado.length == 0) {
            System.out.println("no hay personas registradas.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                System.out.println("DNI: " + empleado.getDni());
                System.out.println("nombre: " + empleado.getNombres());
                System.out.println("apellido: " + empleado.getApellidos());
                System.out.println("legajo: " + empleado.getLegajo());
                System.out.println("telefono: " + empleado.getTelefono());
                System.out.println("direccion: " + empleado.getDireccion());
                System.out.println("provincia: " + empleado.getProvincia().obtenerProvincia());
                System.out.println("localidad: " + empleado.getLocalidad());
                System.out.println("fecha de nacimiento: " + empleado.getFechaNacimiento());
                System.out.println("sexo: " + empleado.getSexo().ObtenerSexo());
                System.out.println("fecha de ingreso: " + empleado.getFechaIngreso());
                System.out.println("sueldo del empleado: " + empleado.getSalario());
                System.out.println("activo: " + (empleado.isActivo() ? "si" : "no"));
                if (!empleado.isActivo()) {
                    System.out.println("Fecha de egreso: " + empleado.getFechaEgreso());}
                    System.out.println("--------------------------");
                }
            }
        }


}
