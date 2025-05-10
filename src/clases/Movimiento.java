package clases;

import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class Movimiento {

	    private static int codigo;
	    private static String detalle;
	    private double montoDebe;
	    private static double montoHaber;
	    private static double saldo;

	    public Movimiento(int codigo, String detalle, double montoDebe, double montoHaber, double saldo) {
	        this.codigo = codigo;
	        this.detalle = detalle;
	        this.montoDebe = montoDebe;
	        this.montoHaber = montoHaber;
	        this.saldo = saldo;
	    }
	    
	    public Movimiento(){
	    	//constructor vacio
	    }
	    
	    private static ArrayList<Movimiento>listaMovimiento = new ArrayList<>();

		public static int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public static String getDetalle() {
			return detalle;
		}

		public void setDetalle(String detalle) {
			this.detalle = detalle;
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
			this.montoHaber = montoHaber;
		}

		public static double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public static ArrayList<Movimiento> getListaMovimiento() {
			return listaMovimiento;
		}

		public static void setListaMovimiento(ArrayList<Movimiento> listaMovimiento) {
			Movimiento.listaMovimiento = listaMovimiento;
		}

		
//metodos personales de movimiento
		
	    public Movimiento altaMovimiento(){
	        Scanner entrada = new Scanner(System.in);
				int codigo = Excepciones.castearEntero("ingrese el codigo de movimiento: ");

				Movimiento movimientoExistente = datosMovimiento(codigo);
				if (movimientoExistente != null){
				    System.out.println("el movimineto " + codigo + "ya existe: ");
				    System.out.println("desea crear un nuevo movimiento?? (si / no): ");
				    String respuesta = entrada.nextLine();
				    if (respuesta.equalsIgnoreCase("no")){
				        System.out.println("movimiento no creado: ");
				        return null;
				    }
				}

				System.out.println("detalles del movimineto");
				String detalle = entrada.nextLine();
				double montoDebe = Excepciones.castearDecimal("ingrese el monto del debe: ");
				double montoHaber = Excepciones.castearDecimal("ingrese el monto del haber: ");
				double saldo = Excepciones.castearDecimal("ingrese el saldo: ");

				Movimiento nuevoMovimiento = new Movimiento(codigo,detalle,montoDebe,montoHaber,saldo);
				listaMovimiento.add(nuevoMovimiento);
				System.out.println("movimiento creado con exito");

				return nuevoMovimiento;
			
	    }
	    
	    public void datosMovimiento (Movimiento mov) {
			if(mov != null) {
				System.out.println("Datos del movimiento:");
				System.out.println("Codigo: " + Movimiento.getCodigo());
				System.out.println("Detalle: " + Movimiento.getDetalle());
				System.out.println("Saldo: " + Movimiento.getSaldo());
				System.out.println("Precio: " + Movimiento.getMontoHaber());
				System.out.println("Marca: " + Movimiento.getMontoHaber());
				System.out.println("------------------------------");
			}else {
				System.out.println("No se encontraron los datos.");
			}
		}

		public void modificarMovimiento(){
	        Scanner entrada = new Scanner(System.in);
				int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento: ");
				Movimiento movimientoExistente = null;
				for (Movimiento movimiento : listaMovimiento) {
				    if (movimiento.getCodigo() == codigo) {
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
			
	        System.out.println("movimiento modificado con exito");
	    }
	    
	    public void bajaMovimiento(){
	        Scanner entrada = new Scanner(System.in);
			
	        int codigo = Excepciones.castearEntero("ingrese el codigo del movimiento a eliminar: ");
	        Movimiento movimientoExistente = null;
	        for (Movimiento movimiento : listaMovimiento){
	            if (movimiento.getCodigo() == codigo){
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

	    public void menuMovimiento(){
	        try (Scanner entrada = new Scanner(System.in)) {
				int opcion;
				boolean salir = false;

				do {
				    System.out.println("1- crear un movimiento: ");
				    System.out.println("2- modificar un movimiento: ");
				    System.out.println("3- dar de baja un movimiento: ");
				    System.out.println("4- salir");
				    opcion = entrada.nextInt();
				    entrada.nextLine();

				    switch (opcion){
				        case 1:
				            altaMovimiento();
				            break;
				        case 2:
				            modificarMovimiento();
				            break;
				        case 3:
				            bajaMovimiento();
				            break;
				        case 4:
				            salir = true;
				            System.out.println("saliendo del sistema");
				            break;
				        default:
				            System.out.println("opcion incorrecta");
				            return;
				    }

				}while(! salir);
			}

	    }

		public static void listarMovimientos() {
			if(Movimiento.listaMovimiento != null) {
				for (Movimiento elemento : listaMovimiento) {
				
				}
			}else {
				System.out.println("No se encontraron los datos.");
			}
		}
		}

	

