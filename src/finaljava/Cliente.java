package finaljava;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona {
	 
	private static ArrayList<Cliente> listaCliente = new ArrayList<>();
    private CuentaCorriente ctacte;
 
public Cliente(int dni, boolean activo, String nombres, String apellidos,
            String telefono, String direccion, Provincia provincia, String localidad,
            LocalDate fechaNacimiento, Sexo sexo, CuentaCorriente ctacte,
            int numeroCliente)
{
            super(dni, activo, nombres, apellidos, telefono, direccion,
         provincia, localidad, fechaNacimiento, sexo);
 this.ctacte = ctacte;

}

public Cliente() {
	//costructor vacio.
}

public CuentaCorriente getCtacte() {
	return ctacte;
}

public void setCtacte(CuentaCorriente ctacte) {
	this.ctacte = ctacte;
}

//metodos personales de cliente

public void verCuentaCorriente() {
    if (ctacte == null) {
        System.out.println("el cliente no tiene una cuenta corriente: ");
        return;
    }
    System.out.println("movimientos de la cuenta corriente: ");
    for (Movimiento movimiento : ctacte.getMovimientos()) {
        System.out.println("codigo: " + movimiento.getCodigo());
        System.out.println("detalle: " + movimiento.getDetalle());
        System.out.println("monto debe: " + movimiento.getMontoDebe());
        System.out.println("monto haber: " + movimiento.getMontoHaber());
        System.out.println("saldo: " + movimiento.getSaldo());
    }
    double saldoActual = ctacte.obtenerSaldo();
    System.out.println("saldo actual: " + saldoActual);
}

public void altaCliente() {
	 try (Scanner entrada = new Scanner(System.in)) {
	}

     int dni = Excepciones.castearEntero("ingrese el dni del cliente: ");

     Persona personaExistente = buscarPersona(dni);
     if (personaExistente != null) {
         System.out.println("el con el dni " + dni + "ya existe");

     } else {
         System.out.println("debe crear una persona: ");
         altaPersona();
         personaExistente = buscarPersona(dni);
     }

     int numeroCliente = Excepciones.castearEntero("ingrese el numero de cliente: ");

     Cliente nuevoClinete = new Cliente(
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
             ctacte,
             numeroCliente);
     listaCliente.add(nuevoClinete);
     System.out.println("cliente creado con exito");
 }

}

