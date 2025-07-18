package FinalprogramacionII;

	import java.time.LocalDate;
	import java.util.Scanner;

	public class MetodosGeneral {

	    private static final Scanner entradaTeclado = new Scanner(System.in);

	    public static LocalDate crearFecha(String mensaje) {
	        System.out.println(mensaje);
	        String dia = null, mes = null, anio = null;
	        int diaAux, mesAux, anioAux;

	        diaAux = castearEntero("Ingrese el día: ", dia);
	        mesAux = castearEntero("Ingrese el mes: ", mes);
	        anioAux = castearEntero("Ingrese el año: ", anio);

	        return LocalDate.of(anioAux, mesAux, diaAux);
	    }

	    public static int castearEntero(String mensaje, String dato) {
	        int num = 0;
	        boolean valido = false;

	        do {
	            System.out.print(mensaje);
	            dato = entradaTeclado.nextLine();
	            if (Excepciones.verificarEntero(dato)) {
	                try {
	                    num = Integer.parseInt(dato);
	                    valido = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Número inválido. Intente nuevamente.");
	                }
	            } else {
	                System.out.println("Entrada inválida. Intente nuevamente.");
	            }
	        } while (!valido);

	        return num;
	    }

	    public static double castearDecimal(String mensaje, String dato) {
	        double num = 0;
	        boolean valido = false;

	        do {
	            System.out.print(mensaje);
	            dato = entradaTeclado.nextLine();
	            if (Excepciones.verificarDecimal(dato)) {  // Asumo que existe este método
	                try {
	                    num = Double.parseDouble(dato);
	                    valido = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Número decimal inválido. Intente nuevamente.");
	                }
	            } else {
	                System.out.println("Entrada inválida. Intente nuevamente.");
	            }
	        } while (!valido);

	        return num;
	    }

	    public static boolean escogerBooleano(String mensaje) {
	        String aux = null;
	        int num;

	        do {
	            System.out.println(mensaje);
	            System.out.println("1. Sí");
	            System.out.println("2. No");

	            num = castearEntero("Ingrese una opción: ", aux);
	        } while (num != 1 && num != 2);

	        return num == 1;
	    }

	    public static String verificarBooleano(boolean activo) {
	        return activo ? "Sí" : "No";
	    }
	}