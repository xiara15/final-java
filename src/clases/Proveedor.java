package clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class Proveedor extends Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public static ArrayList<Proveedor> listaProveedores;

    // Atributos
    private CuentaCorriente ctacte;

    // Constructor
    public Proveedor(int dni, boolean activo, String nombre, String apellido, String telefono, String direccion,
                     Provincia provincia, String localidad, LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte) {
        super(dni, activo, nombre, apellido, telefono, direccion,
                provincia, localidad, fechaNacimiento, sexo);
        this.ctacte = ctacte;
    }

    // SET Y GET
    public CuentaCorriente getCtacte() {
        return ctacte;
    }

    public void setCtacte(CuentaCorriente ctacte) {
        this.ctacte = ctacte;
    }

// MÉTODOS
    
    
    // ALTA PROVEEDOR
    public static void altaProveedor(CuentaCorriente ctacte) {
        if (ctacte != null) {
            String nombre, apellido, telefono, direccion, localidad = null;
            int dni;
            LocalDate fechaNac;
            Provincia prov;
            Sexo genero;

            boolean activo = true;

            try (Scanner teclado = new Scanner(System.in)) {
                System.out.println("Ingrese el nombre: ");
                nombre = teclado.nextLine();

                System.out.println("Ingrese el apellido: ");
                apellido = teclado.nextLine();

                dni = MetodosGeneral.castearEntero("Ingrese su DNI:", localidad);

                genero = Sexo.elegirSexo();

                System.out.println("Ingrese el teléfono: ");
                telefono = teclado.nextLine();

                System.out.println("Ingrese la dirección: ");
                direccion = teclado.nextLine();

                fechaNac = MetodosGeneral.crearFecha("Ingrese fecha de nacimiento:");

                prov = Provincia.escogerProvincia();

                System.out.println("Ingrese la localidad: ");
                localidad = teclado.nextLine();
            }

            // Crear proveedor
            Proveedor nuevoProveedor = new Proveedor(dni, activo, nombre, apellido, telefono, direccion, prov, localidad, fechaNac, genero, ctacte);

            // Inicializar listas si es necesario
            if (listaProveedores == null) {
                listaProveedores = new ArrayList<>();
            }
            if (Persona.listaPersonas == null) {
                Persona.listaPersonas = new ArrayList<>();
            }

            listaProveedores.add(nuevoProveedor);
            Persona.listaPersonas.add(nuevoProveedor);

            System.out.println("Proveedor registrado con éxito.");
        } else {
            System.out.println("No se han encontrado los datos de cuenta corriente.");
        }
    }

    
    //DATOS PROVEEDOR
    public void datosProveedor(Proveedor proveedor) {
        if (proveedor != null) {
            super.datosPersona(proveedor);
            proveedor.verCtaCte(proveedor.getCtacte());
        } else {
            System.out.println("Los datos no se han encontrado.");
        }
    }

    //MODIFICAR PROVEEDOR
    public void modificarProveedor(Proveedor proveedor) {
        if (proveedor != null) {
            super.modificarPersona(proveedor);

            System.out.println("1 - Modificar cuenta corriente.");
            System.out.println("2 - Salir.");

            int num;

            do {
                num = MetodosGeneral.castearEntero("Seleccione: ", getDireccion());
            } while (num < 1 || num > 2);

            switch (num) {
                case 1:
                    proveedor.getCtacte().modificarCtaCte(this.ctacte);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("No se han encontrado los datos.");
        }
    }

    
    //LISTAR PROVEEDOR
    public static void listarProveedor() {
        if (listaProveedores != null && !listaProveedores.isEmpty()) {
            for (Proveedor elemento : listaProveedores) {
                elemento.datosProveedor(elemento);
            }
        } else {
            System.out.println("No hay proveedores registrados.");
        }
    }

    //BUSCAR PROVEEDOR
    public static Proveedor buscarProveedor() {
        int num;
        num = MetodosGeneral.castearEntero("Ingrese el DNI del proveedor a buscar: ", apellido);

        for (Proveedor elemento : listaProveedores) {
            if (num == elemento.getDni()) {
                System.out.println("El proveedor SÍ fue encontrado.");
                return elemento;
            }
        }
        System.out.println("El proveedor NO fue encontrado.");
        return null;
    }

    
    //VER CUENTA CORRIENTE
    public void verCtaCte(CuentaCorriente ctacte) {
        if (ctacte != null) {
            ctacte.datosCtaCte(ctacte.getMovimiento());
        } else {
            System.out.println("No se encontraron los datos de la cuenta corriente.");
        }
    }
}