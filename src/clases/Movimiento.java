package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class Movimiento implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static int codigo;
	    private static String detalle;
	    private double montoDebe;
	    private static double montoHaber;
	    private static double saldo;

	    public Movimiento(int codigo, String detalle, double montoDebe, double montoHaber, double saldo) {
	        Movimiento.codigo = codigo;
	        Movimiento.detalle = detalle;
	        this.montoDebe = montoDebe;
	        Movimiento.montoHaber = montoHaber;
	        Movimiento.saldo = saldo;
	    }
	    
	
	    public static ArrayList<Movimiento>listaMovimiento = new ArrayList<>();
	
		private static Scanner teclado;

		public static int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			Movimiento.codigo = codigo;
		}

		public static String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			Movimiento.detalle = detalle;
		}

		public double getMontoDebe() {
			return montoDebe;
		}

		public void setMontoDebe(double montoDebe) {
			this.montoDebe = montoDebe;
		}

		public static double getMontoHaber() {
			return montoHaber;
		}

		public void setMontoHaber(double montoHaber) {
			Movimiento.montoHaber = montoHaber;
		}

		public static double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			Movimiento.saldo = saldo;
		}

		public static ArrayList<Movimiento> getListaMovimiento() {
			return listaMovimiento;
		}

		public static void setListaMovimiento(ArrayList<Movimiento> listaMovimiento) {
			Movimiento.listaMovimiento = listaMovimiento;
		}

		
//metodos personales de movimiento
		
	    public static Movimiento altaMovimiento(){
	        try (Scanner entrada = new Scanner(System.in)) {
				int codigo = Excepciones.castearEntero("ingrese el codigo de movimiento: ");

				System.out.println("Ingrese detalle del movimiento:");
				teclado = null;
				detalle = teclado.nextLine();

				System.out.println("detalles del movimineto");
				String detalle = entrada.nextLine();
				double montoDebe = Excepciones.castearDecimal("ingrese el monto que debe: ");
				double montoHaber = Excepciones.castearDecimal("ingrese el monto de haber: ");
				double saldo = Excepciones.castearDecimal("ingrese el saldo: ");

				Movimiento nuevoMovimiento = new Movimiento(codigo,detalle,montoDebe,montoHaber,saldo);
				listaMovimiento.add(nuevoMovimiento);
				System.out.println("movimiento creado con exito");

				return nuevoMovimiento;
			}
			
	    }
	    
	    public Movimiento datosMovimiento(Movimiento mov) {
	        if (mov != null) {
	            System.out.println("Datos del movimiento:");
	            System.out.println("Código: " + Movimiento.getCodigo());
	            System.out.println("Detalle: " + Movimiento.getDetalle());
	            System.out.println("Saldo: " + Movimiento.getSaldo());
	            System.out.println("Precio: " + Movimiento.getMontoHaber());
	            System.out.println("Marca: " + Movimiento.getMontoHaber()); 
	            System.out.println("------------------------------");
	        } else {
	            System.out.println("No se encontraron los datos.");
	        }
	        return mov;
	    }

		public void modificarMovimiento(Movimiento elemento){
	        try (Scanner entrada = new Scanner(System.in)) {
				int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento: ");
				Movimiento movimientoExistente = null;
				for (Movimiento movimiento : listaMovimiento) {
				    if (Movimiento.getCodigo() == codigo) {
				        movimientoExistente = movimiento;
				        break;
				    }
				}
				if (movimientoExistente == null) {
				    System.out.println("no se encontro el movimiento con el codigo ingresado ");
				    return;
				} System.out.print("ingrese el nuevo detalle del movimiento: ");
				String detalle = entrada.nextLine();
				double montoDebe = Excepciones.castearDecimal("ingrese el nuevo monto debe: ");
				double montoHaber = Excepciones.castearDecimal("ingrese el nuevo monto haber: ");
				double saldo = Excepciones.castearDecimal("ingrese el nuevo saldo: ");
				movimientoExistente.setDetalle(detalle);
				movimientoExistente.setMontoDebe(montoDebe);
				movimientoExistente.setMontoHaber(montoHaber);
				movimientoExistente.setSaldo(saldo);
			}
				System.out.println("movimiento modificado con exito");
	    }
	    
	    public void bajaMovimiento(Movimiento elemento){
	        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento a eliminar: ");
	        Movimiento movimientoExistente = null;
	        for (Movimiento movimiento : listaMovimiento){
	            if (Movimiento.getCodigo() == codigo){
	                movimientoExistente = movimiento;
	                break;
	            }
	        }
	        if (movimientoExistente == null) {
	            System.out.println("no se encontro el movimiento con el codigo ingresado.");
	            return;
	        }
	        listaMovimiento.remove(movimientoExistente);
	        System.out.println("movimiento eliminado");
	    }



	    public static void listarMovimientos() {
	        if (listaMovimiento != null && !listaMovimiento.isEmpty()) {
	            for (Movimiento elemento : listaMovimiento) {
	                System.out.println(elemento); // o imprimir campos específicos
	            }
	        } else {
	            System.out.println("No se encontraron los datos.");
	        }
	    }
		
	    public static Movimiento buscarMovimiento() {
	        int codigo;
	        String codigoAux = null;
	        codigo = MetodosGeneral.castearEntero("Ingrese el código del producto a buscar: ", codigoAux);

	        for (Movimiento elemento : listaMovimiento) {
	            if (codigo == Movimiento.getCodigo()) {
	                System.out.println("El movimiento SÍ fue encontrado.");
	                return elemento;
	            }
	        }

	        System.out.println("El movimiento NO fue encontrado.");
	        return null;
	    }
		
		public static ArrayList <Movimiento> crearMovimientos (Movimiento...movimientos){
			if(movimientos != null) {
				ArrayList <Movimiento> listarMovimientos = new ArrayList <Movimiento> ();
				for (Movimiento elemento : movimientos) {
					listarMovimientos.add(elemento);
				}
				return listarMovimientos;
			}else {
				System.out.println("No se encontraron los datos.");
			}
			return null;
		}
		
		public boolean validarMovimiento (Movimiento movimiento) {
			return this.montoDebe <= Movimiento.saldo;
		}
		
		public double calcularSaldo(Movimiento movimiento) {
			return Movimiento.saldo += Movimiento.montoHaber - movimiento.montoDebe;
		}
					
		public double calcularNeto(Movimiento movimiento) {
			return Movimiento.montoHaber - movimiento.montoDebe;
		}
		

}

	

