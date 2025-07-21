package Menues;

import java.util.ArrayList;
import java.util.Vector;

import FinalprogramacionII.MetodosGeneral;
import clases.Producto;

public class MenuProducto {

	   
    // Muestra los datos de UN solo producto
    private static void mostrarProducto(Producto p) {
        System.out.println("----- Detalle Producto -----");
        System.out.println("Código: " + p.getCodigo());
        System.out.println("Detalle: " + p.getDetalle());
        System.out.println("Precio: $" + p.getPrecio());
        System.out.println("Marca: " + p.getMarca());
        System.out.println("Material: " + p.getMaterial());
        System.out.println("Categoría: " + p.getCategoria().obtenerCategoria());
        System.out.println("Stock: " + p.getStock());
        System.out.println("----------------------------");
    }

    // Menú para ver datos
    public static void menuDatosProducto(ArrayList<Producto> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No se han encontrado los datos.");
            return;
        }

        System.out.println("\nBienvenido al menú de datos de producto/s:");
        System.out.println("1 - Datos de un producto.");
        System.out.println("2 - Datos de todos los productos.");
        System.out.println("3 - Volver.");

        int opcion;
        do {
            opcion = MetodosGeneral.castearEntero("Seleccione: ", null);
        } while (opcion < 1 || opcion > 3);

        switch (opcion) {
            case 1:
                Producto elegido = menuSelectProducto(lista);
                if (elegido != null) {
                    mostrarProducto(elegido);
                }
                break;
            case 2:
                Producto.verDetalleProducto();
                break;
            case 3:
                return;
        }

        // Vuelve a este menú tras la acción
        menuDatosProducto(lista);
    }

    // Menú para alta/baja/búsqueda/modificación
    public static void menuIngresoProducto(ArrayList<Producto> lista) {
        System.out.println("\nBienvenido al menú de ingreso de datos de producto/s:");
        System.out.println("1 - Ingresar un producto.");
        System.out.println("2 - Dar de baja a un producto.");
        System.out.println("3 - Buscar un producto por su código.");
        System.out.println("4 - Modificar un producto.");
        System.out.println("5 - Volver.");

        int opcion;
        do {
            opcion = MetodosGeneral.castearEntero("Seleccione: ", null);
        } while (opcion < 1 || opcion > 5);

        switch (opcion) {
            case 1:
                new Producto().altaProducto();
                break;
            case 2:
                new Producto().bajaProducto();
                break;
            case 3:
                int codBusq = MetodosGeneral.castearEntero("Ingrese código a buscar: ", null);
                Producto encontrado = Producto.buscarProductoCodigo(codBusq);
                if (encontrado != null) {
                    mostrarProducto(encontrado);
                    menuProducto(encontrado, lista);
                } else {
                    System.out.println("Producto NO encontrado.");
                }
                break;
            case 4:
                new Producto().modificarProducto();
                break;
            case 5:
                return;
        }

        // Vuelve a este menú tras la acción
        menuIngresoProducto(lista);
    }

    // Menú de acciones sobre un producto ya seleccionado
    public static void menuProducto(Producto producto, ArrayList<Producto> lista) {
        if (producto == null) {
            System.out.println("Producto inválido.");
            return;
        }

        System.out.println("\nBienvenido al menú general de producto:");
        System.out.println("1 - Ver datos.");
        System.out.println("2 - Modificar.");
        System.out.println("3 - Dar de baja.");
        System.out.println("4 - Volver.");

        int opcion;
        do {
            opcion = MetodosGeneral.castearEntero("Seleccione: ", null);
        } while (opcion < 1 || opcion > 4);

        switch (opcion) {
            case 1:
                mostrarProducto(producto);
                break;
            case 2:
                producto.modificarProducto();
                break;
            case 3:
                producto.bajaProducto();
                break;
            case 4:
                return;
        }

        // Tras la acción, vuelve al menú de este producto
        menuProducto(producto, lista);
    }

    // Permite seleccionar un producto de la lista por índice
    public static Producto menuSelectProducto(ArrayList<Producto> lista) {
        System.out.println("\nSeleccione un producto:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, lista.get(i).getDetalle());
        }

        int sel;
        do {
            sel = MetodosGeneral.castearEntero("Seleccione: ", null);
        } while (sel < 1 || sel > lista.size());

        return lista.get(sel - 1);
    }

    // Crea un Vector con productos seleccionados
    public static Vector<Producto> menuVectorProductos(ArrayList<Producto> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No se han encontrado los datos.");
            return null;
        }

        int max = 10;
        int cant;
        do {
            cant = MetodosGeneral.castearEntero(
                "Ingrese la cantidad de productos que desea ingresar (máx. " + max + "): ", null);
        } while (cant < 1 || cant > max);

        Vector<Producto> vector = new Vector<>(cant);
        for (int i = 0; i < cant; i++) {
            Producto p = menuSelectProducto(lista);
            vector.add(p);
        }

        return vector;
    }
}