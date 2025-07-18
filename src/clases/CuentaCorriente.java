package clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class CuentaCorriente implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ArrayList<CuentaCorriente> listaCtactes; 

    // atributos
    private String detalle;
    private int codigo;
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    // constructor
    public CuentaCorriente(ArrayList<Movimiento> movimientos, String detalle, int codigo) {
        this.movimientos = movimientos;
        this.setDetalle(detalle);
        this.setCodigo(codigo);
    }
   
    //set y get
    
	public ArrayList <Movimiento> getMovimiento (){
		return movimientos;
	}
	public void setMovimientos (ArrayList <Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
    
   
    
    //metodos personales de ctacte
	

	public static void altaCtaCte(ArrayList<Movimiento> movimientos) {
        try (Scanner teclado = new Scanner(System.in)) {
			System.out.print("Ingrese el detalle de la cuenta: ");
			String detalle = teclado.nextLine();

			int codigo = MetodosGeneral.castearEntero("Ingrese el código de la cuenta: ", null);

			CuentaCorriente nuevaCtaCte = new CuentaCorriente(movimientos, detalle, codigo);

			if (CuentaCorriente.listaCtactes == null) {
			    CuentaCorriente.listaCtactes = new ArrayList<>();
			}

			CuentaCorriente.listaCtactes.add(nuevaCtaCte);
		}
    }
	
	

	public void agregarMovimiento (ArrayList <Movimiento> movimientos, Movimiento movimiento) {
		if(movimiento != null && movimientos != null) {
			movimientos.add(movimiento);
			this.setMovimientos(movimientos);
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	


	public void actualizarSaldo (Movimiento movimiento) {
		if(movimiento != null) {
			double nuevoSaldo; String nuevoSaldoAux=null;
			System.out.println("Detalle del movimiento: " + Movimiento.getDetalle());
			System.out.println("Su saldo actual es: " + Movimiento.getSaldo());
			
			if(MetodosGeneral.escogerBooleano("¿Desea actualizar su saldo?:")) {
				nuevoSaldo = MetodosGeneral.castearDecimal("Ingrese el nuevo saldo:", nuevoSaldoAux);
				movimiento.setSaldo(nuevoSaldo);
				movimiento.setSaldo(movimiento.calcularSaldo(movimiento));
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void datosCtaCte (ArrayList <Movimiento> movimientos) {
		if(movimientos != null) {
			System.out.println("Detalles de la cuenta: " + this.detalle);
			for (Movimiento elemento : movimientos) {
				elemento.datosMovimiento(elemento);
			}
			System.out.println("------------------------------");
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public void modificarCtaCte(CuentaCorriente ctacte) {
		if(ctacte != null) {
			try (Scanner teclado = new Scanner(System.in)) {
				System.out.println("1 - Modificar codigo.");
				System.out.println("2 - Modificar detalle.");
				System.out.println("3 - Salir.");
				
				String numAux=null; int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
				}while(num < 1 || num > 3);
				
				switch(num) {
				case 1:
					String codigoAux = null;
					int codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", codigoAux);
					ctacte.setCodigo(codigo);
					break;
					
				case 2:
					System.out.println("Ingrese detalle de la cuenta:");
					String detalle = teclado.nextLine();
					ctacte.setDetalle(detalle);
					break;
					
				case 3:
					System.out.println("Saliendo...");
					break;
					
				default:
					break;
				}
			}
		}else {
			System.out.println("No se han encontrado los datos.");
		}
	}
	
	public static void listarCtaCtes() {
		if(CuentaCorriente.listaCtactes != null) {
			for(CuentaCorriente elemento : listaCtactes) {
				elemento.datosCtaCte(elemento.getMovimiento());
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	public static CuentaCorriente buscarCtaCteCodigo () {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(CuentaCorriente elemento : listaCtactes) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("La venta SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("La venta NO fue encontrado.");
		return null;
	}

}

   




