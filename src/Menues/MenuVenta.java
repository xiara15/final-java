package Menues;

import java.util.ArrayList;

import FinalprogramacionII.MetodosGeneral;
import clases.Cliente;
import clases.Producto;
import clases.Venta;

public class MenuVenta {

    private static Venta elemento;
	private static Venta elemento2;

	// Menú principal de datos de ventas
    public static void menuDatosVenta(ArrayList<Venta> lista) {
        if (lista != null) {
            System.out.println("Bienvenido al menú de datos de venta/s:");
            System.out.println("1 - Datos de una venta.");
            System.out.println("2 - Datos de todas las ventas.");
            System.out.println("3 - Salir.");

            elemento = null;
            String numAux = null;
            int num = 0;

            do {
                num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
            } while (num < 1 || num > 3);

            switch (num) {
                case 1:
               
                    elemento.verDetalleDeVenta(elemento);
                    break;

                case 2:
                    Venta.listarVentas();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;
            }
        } else {
            System.out.println("No se han encontrado los datos.");
        }

        Menu.menusDatos();
    }

    // Menú para ingresar, modificar o eliminar ventas
    public static void menuIngresoVenta(ArrayList<Venta> lista) {
        System.out.println("Bienvenido al menú de ingreso de datos de venta/s:");
        System.out.println("1 - Ingresar una venta.");
        System.out.println("2 - Dar de baja a una venta.");
        System.out.println("3 - Buscar una venta por su código.");
        System.out.println("4 - Modificar datos de una venta.");
        System.out.println("5 - Salir.");

        elemento2 = null;
        String numAux = null;
        int num = 0;

        do {
            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
        } while (num < 1 || num > 5);

        switch (num) {
            case 1:
                elemento2.altaVenta(MenuCliente.menuSelectCliente(Cliente.listaClientes), MenuProducto.menuVectorProductos(Producto.listaProducto));
                break;

            case 2:
                if (lista != null) {
                   
                    elemento2.bajaDeVenta(elemento2);
                } else {
                    System.out.println("No se han encontrado los datos.");
                }
                break;

            case 3:
                if (lista != null) {
                    elemento2 = Venta.buscarVentaCodigo();
                    MenuVenta.menuVenta(elemento2, lista);
                } else {
                    System.out.println("No se han encontrado los datos.");
                }
                break;

            case 4:
                if (lista != null) {
                    
                    elemento2.modificarVenta(elemento2);
                } else {
                    System.out.println("No se han encontrado los datos.");
                }
                break;

            case 5:
                System.out.println("Saliendo...");
                break;
        }

        Menu.menusIngresar();
    }

    // Menú general para una venta específica
    public static void menuVenta(Venta venta, ArrayList<Venta> lista) {
        if (venta != null && lista != null) {
            System.out.println("Bienvenido al menú general de venta/s:");
            System.out.println("1 - Ver datos.");
            System.out.println("2 - Modificar algún dato.");
            System.out.println("3 - Dar de baja.");
            System.out.println("4 - Salir.");

            String numAux = null;
            int num = 0;

            do {
                num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
            } while (num < 1 || num > 4);

            switch (num) {
                case 1:
                    venta.verDetalleDeVenta(venta);
                    break;

                case 2:
                    venta.modificarVenta(venta);
                    break;

                case 3:
                    venta.bajaDeVenta(venta);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
        } else {
            System.out.println("No se han encontrado los datos.");
        }

        MenuVenta.menuIngresoVenta(lista);
    }

 
}