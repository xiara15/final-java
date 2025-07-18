package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ArrayList<Persona> listaPersonas = new ArrayList<>();

    private int dni;
    private boolean activo;
    protected String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Provincia provincia;
    private String localidad;
    private LocalDate fechaNacimiento;
    private Sexo sexo;

    public Persona(int dni, boolean activo, String nombre, String apellido, String telefono, String direccion,
                   Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo) {
        this.dni = dni;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Provincia getProvincia() { return provincia; }
    public void setProvincia(Provincia provincia) { this.provincia = provincia; }

    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Sexo getSexo() { return sexo; }
    public void setSexo(Sexo sexo) { this.sexo = sexo; }

    public static void altaPersona() {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre: ");
            String nombre = teclado.nextLine();

            System.out.println("Ingrese el apellido: ");
            String apellido = teclado.nextLine();

            System.out.println("Ingrese el telefono: ");
            String telefono = teclado.nextLine();

            System.out.println("Ingrese la direccion: ");
            String direccion = teclado.nextLine();

            System.out.println("Ingrese la localidad: ");
            String localidad = teclado.nextLine();

            int dni = MetodosGeneral.castearEntero("Ingrese su DNI: ", null);
            Sexo genero = Sexo.elegirSexo();
            Provincia prov = Provincia.obtenerProvincia();
            LocalDate fechaNac = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");

            Persona nuevaPersona = new Persona(dni, true, nombre, apellido, telefono, direccion, prov, localidad, fechaNac, genero);
            listaPersonas.add(nuevaPersona);
        }
    }

    public static Persona buscarPersonaDni() {
        int num = MetodosGeneral.castearEntero("Ingrese el DNI de la persona a buscar: ", null);
        for (Persona elemento : listaPersonas) {
            if (num == elemento.getDni()) {
                System.out.println("La persona SI fue encontrada.");
                return elemento;
            }
        }
        System.out.println("La persona NO fue encontrada.");
        return null;
    }

    public void datosPersona(Persona persona) {
        if (persona != null) {
            System.out.println("Datos personales:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("DNI: " + persona.getDni());
            System.out.println("Genero: " + Sexo.elegirSexo());
            System.out.println("Activo: " + MetodosGeneral.verificarBooleano(persona.isActivo()));
            System.out.println("Telefono: " + persona.getTelefono());
            System.out.println("Direccion: " + persona.getDireccion());
            System.out.println("Fecha de nacimiento: " + persona.getFechaNacimiento());
            System.out.println("Provincia: " + Provincia.obtenerProvincia());
            System.out.println("Localidad: " + persona.getLocalidad());
            System.out.println("------------------------------");
        } else {
            System.out.println("No se encontraron los datos.");
        }
    }

    public static void listarPersonas() {
        if (listaPersonas != null && !listaPersonas.isEmpty()) {
            for (Persona elemento : listaPersonas) {
                elemento.datosPersona(elemento);
            }
        } else {
            System.out.println("No se encontraron los datos.");
        }
    }

    public void modificarPersona(Persona persona) {
        if (persona != null) {
            try (Scanner teclado = new Scanner(System.in)) {
				System.out.println("1 - Modificar nombre.");
				System.out.println("2 - Modificar apellido.");
				System.out.println("3 - Modificar DNI.");
				System.out.println("4 - Modificar genero.");
				System.out.println("5 - Modificar telefono.");
				System.out.println("6 - Modificar direccion.");
				System.out.println("7 - Modificar fecha de nacimiento.");
				System.out.println("8 - Modificar provincia.");
				System.out.println("9 - Modificar localidad.");
				System.out.println("10 - Salir.");

				int num;
				do {
				    num = MetodosGeneral.castearEntero("Seleccione: ", null);
				} while (num < 1 || num > 10);

				switch (num) {
				    case 1:
				        System.out.println("Ingrese el nombre: ");
				        persona.setNombre(teclado.nextLine());
				        break;
				    case 2:
				        System.out.println("Ingrese el apellido: ");
				        persona.setApellido(teclado.nextLine());
				        break;
				    case 3:
				        persona.setDni(MetodosGeneral.castearEntero("Ingrese su DNI:", null));
				        break;
				    case 4:
				        persona.setSexo(Sexo.elegirSexo());
				        break;
				    case 5:
				        System.out.println("Ingrese el telefono: ");
				        persona.setTelefono(teclado.nextLine());
				        break;
				    case 6:
				        System.out.println("Ingrese la direccion: ");
				        persona.setDireccion(teclado.nextLine());
				        break;
				    case 7:
				        persona.setFechaNacimiento(MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:"));
				        break;
				    case 8:
				        persona.setProvincia(Provincia.obtenerProvincia());
				        break;
				    case 9:
				        System.out.println("Ingrese la localidad: ");
				        persona.setLocalidad(teclado.nextLine());
				        break;
				    case 10:
				        System.out.println("Saliendo...");
				        break;
				}
			}
        } else {
            System.out.println("No se encontraron los datos.");
        }
    }

    public void bajaPersona(Persona persona) {
        if (persona != null) {
            persona.setActivo(false);
        } else {
            System.out.println("No se encontraron los datos.");
        }
    }

	public static ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public static void setListaPersonas(ArrayList<Persona> listaPersonas) {
		Persona.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", activo=" + activo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", provincia=" + provincia + ", localidad="
				+ localidad + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", getDni()=" + getDni()
				+ ", isActivo()=" + isActivo() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
				+ ", getTelefono()=" + getTelefono() + ", getDireccion()=" + getDireccion() + ", getProvincia()="
				+ getProvincia() + ", getLocalidad()=" + getLocalidad() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getSexo()=" + getSexo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, apellido, direccion, dni, fechaNacimiento, localidad, nombre, provincia, sexo,
				telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return activo == other.activo && Objects.equals(apellido, other.apellido)
				&& Objects.equals(direccion, other.direccion) && dni == other.dni
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(nombre, other.nombre) && provincia == other.provincia && sexo == other.sexo
				&& Objects.equals(telefono, other.telefono);
	}
}
