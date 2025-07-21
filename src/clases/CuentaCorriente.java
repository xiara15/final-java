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
    
   
    
 //METODOS
	

	//ALTA CLIENTE
	public static void altaCtaCte(ArrayList<Movimiento> movimientos) {
        try (Scanner teclado = new Scanner(System.in)) {
			System.out.print("Ingrese el detalle de la cuenta: ");
			String detalle = teclado.nextLine();

			int codigo = MetodosGeneral.castearEntero("Ingrese el código de la cuenta: ", detalle);

			CuentaCorriente nuevaCtaCte = new CuentaCorriente(movimientos, detalle, codigo);

			if (CuentaCorriente.listaCtactes == null) {
			    CuentaCorriente.listaCtactes = new ArrayList<>();
			}

			CuentaCorriente.listaCtactes.add(nuevaCtaCte);
		}
    }
	
	
    //AGREGAR MOVIMIENTO
	public void agregarMovimiento (ArrayList <Movimiento> movimientos, Movimiento movimiento) {
		if(movimiento != null && movimientos != null) {
			movimientos.add(movimiento);
			this.setMovimientos(movimientos);
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	

    //ACTUALIZAR SALDO
	public void actualizarSaldo (Movimiento movimiento) {
		if(movimiento != null) {
			double nuevoSaldo; 
			System.out.println("Detalle del movimiento: " + Movimiento.getDetalle());
			System.out.println("Su saldo actual es: " + Movimiento.getSaldo());
			
			if(MetodosGeneral.escogerBooleano("¿Desea actualizar su saldo?:")) {
				nuevoSaldo = MetodosGeneral.castearDecimal("Ingrese el nuevo saldo:", detalle);
				movimiento.setSaldo(nuevoSaldo);
				movimiento.setSaldo(movimiento.calcularSaldo(movimiento));
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	//DATOS CUENTA CORRIENTE
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
	
	//MODIFICAR CUENTA CORRIENTE
	public void modificarCtaCte(CuentaCorriente ctacte) {
		if(ctacte != null) {
			try (Scanner teclado = new Scanner(System.in)) {
				System.out.println("1 - Modificar codigo.");
				System.out.println("2 - Modificar detalle.");
				System.out.println("3 - Salir.");
				
				int num=0;
				do {
					num = MetodosGeneral.castearEntero("Seleccione: ", detalle);
				}while(num < 1 || num > 3);
				
				switch(num) {
				case 1:
					int codigo = MetodosGeneral.castearEntero("Ingrese el codigo del movimiento:", detalle);
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
	
	
	//LISTAR CUENTA CORRIENTE
	public static void listarCtaCtes() {
		if(CuentaCorriente.listaCtactes != null) {
			for(CuentaCorriente elemento : listaCtactes) {
				elemento.datosCtaCte(elemento.getMovimiento());
			}
		}else {
			System.out.println("Los datos no se han encontrado.");
		}
	}
	
	
	//BUSCAR CUENTA CORRIENTE
	public static CuentaCorriente buscarCtaCteCodigo () {
		int codigo; String codigoAux=null;
		codigo = MetodosGeneral.castearEntero("Ingrese el codigo del producto a buscar: ", codigoAux);
		for(CuentaCorriente elemento : listaCtactes) {
			if(codigo == elemento.getCodigo()) {
				System.out.println("La venta SI fue encontrado.");
				return elemento;
			}
		}
		System.out.println("La venta no fue encontrado.");
		return null;
	}

}

   




