package Menues;

import clases.*;
import FinalprogramacionII.MetodosGeneral;
import archivos.archivo;

public class Menu {

    private static boolean ejecutar = false;

    // MENU PRINCIPAL
    public static void menuPrincipal() {
        if (!ejecutar) {
            archivo.guardarDatos();
            ejecutar = true;
        }

        System.out.println("\n====== Bienvenido al MENÚ PRINCIPAL ======");
        System.out.println("1 - Ver datos del sistema");
        System.out.println("2 - Ingresar nuevos datos");
        System.out.println("3 - Gestión de archivos");
        System.out.println("4 - Salir");
        System.out.println("==========================================");

        String numAux = null;
        int num = 0;
        do {
            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
        } while (num < 1 || num > 4);

        switch (num) {
            case 1:
                menusDatos();
                break;
            case 2:
                menusIngresar();
                break;
            case 3:
                menusArchivos();
                break;
            case 4:
                archivo.guardarDatos();
                
                System.out.println("Saliendo...");
                System.exit(0);
                break;
        }
    }

    // MENÚ SECUNDARIO - VER DATOS
    public static void menusDatos() {
        System.out.println("\n--- MENÚ PARA VER DATOS ---");
        System.out.println("1 - Personas");
        System.out.println("2 - Empleados");
        System.out.println("3 - Usuarios");
        System.out.println("4 - Productos");
        System.out.println("5 - Ventas");
        System.out.println("6 - Movimientos");
        System.out.println("7 - Cuentas Corrientes");
        System.out.println("8 - Clientes");
        System.out.println("9 - Proveedores");
        System.out.println("10 - Volver al menú principal");

        String numAux = null;
        int num = 0;
        do {
            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
        } while (num < 1 || num > 10);

        switch (num) {
            case 1:
                MenuPersona.menuDatosPersona(Persona.listaPersonas);
                break;
            case 2:
                MenuEmpleado.menuDatosEmpleado(Empleado.listaEmpleados);
                break;
            case 3:
                MenuUsuario.menuDatosUsuario(Usuario.listaUsuarios);
                break;
            case 4:
                MenuProducto.menuDatosProducto(Producto.listaProducto);
                break;
            case 5:
                MenuVenta.menuDatosVenta(Venta.listaDeVentas);
                break;
            case 6:
                MenuMovimiento.menuDatosMovimiento(Movimiento.listaMovimiento);
                break;
            case 7:
                MenuCuentaCorriente.menuDatosCtaCte(CuentaCorriente.listaCtactes);
                break;
            case 8:
                MenuCliente.menuDatosCliente(Cliente.listaClientes);
                break;
            case 9:
                MenuProveedor.menuDatosProveedor(Proveedor.listaProveedores);
                break;
            case 10:
                break;
        }

        menuPrincipal();
    }

    // MENÚ SECUNDARIO - INGRESAR DATOS
    public static void menusIngresar() {
        System.out.println("\n--- MENÚ PARA INGRESAR DATOS ---");
        System.out.println("1 - Personas");
        System.out.println("2 - Empleados");
        System.out.println("3 - Usuarios");
        System.out.println("4 - Productos");
        System.out.println("5 - Ventas");
        System.out.println("6 - Movimientos");
        System.out.println("7 - Cuentas Corrientes");
        System.out.println("8 - Clientes");
        System.out.println("9 - Proveedores");
        System.out.println("10 - Volver al menú principal");

        String numAux = null;
        int num = 0;
        do {
            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
        } while (num < 1 || num > 10);

        switch (num) {
            case 1:
                MenuPersona.menuIngresoPersona(Persona.listaPersonas);
                break;
            case 2:
                MenuEmpleado.menuIngresoEmpleado(Empleado.listaEmpleados);
                break;
            case 3:
                MenuUsuario.menuIngresoUsuario(Usuario.listaUsuarios);
                break;
            case 4:
                MenuProducto.menuIngresoProducto(Producto.listaProducto);
                break;
            case 5:
                MenuVenta.menuIngresoVenta(Venta.listaDeVentas);
                break;
            case 6:
                MenuMovimiento.menuIngresoMovimiento(Movimiento.listaMovimiento);
                break;
            case 7:
                MenuCuentaCorriente.menuIngresoCtaCte(CuentaCorriente.listaCtactes);
                break;
            case 8:
                MenuCliente.menuIngresoCliente(Cliente.listaClientes);
                break;
            case 9:
                MenuProveedor.menuIngresoProveedor(Proveedor.listaProveedores);
                break;
            case 10:
                break;
        }

        menuPrincipal();
    }

    // MENÚ SECUNDARIO - ARCHIVOS
    public static void menusArchivos() {
        System.out.println("\n--- MENÚ PARA GESTIÓN DE ARCHIVOS ---");
        System.out.println("1 - General");
        System.out.println("2 - Personas");
        System.out.println("3 - Empleados");
        System.out.println("4 - Usuarios");
        System.out.println("5 - Productos");
        System.out.println("6 - Ventas");
        System.out.println("7 - Movimientos");
        System.out.println("8 - Cuentas Corrientes");
        System.out.println("9 - Clientes");
        System.out.println("10 - Proveedores");
        System.out.println("11 - Volver al menú principal");

        String numAux = null;
        int num = 0;
        do {
            num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
        } while (num < 1 || num > 11);

        switch (num) {
            case 1:
                MenuArchivo.menuArchivo();
                break;
            case 2:
                MenuArchivo.menuArchivoPersona();
                break;
            case 3:
                MenuArchivo.menuArchivoEmpleado();
                break;
            case 4:
                MenuArchivo.menuArchivoUsuario();
                break;
            case 5:
                MenuArchivo.menuArchivoProducto();
                break;
            case 6:
                MenuArchivo.menuArchivoVenta();
                break;
            case 7:
                MenuArchivo.menuArchivoMovimiento();
                break;
            case 8:
                MenuArchivo.menuArchivoCtaCte();
                break;
            case 9:
                MenuArchivo.menuArchivoCliente();
                break;
            case 10:
                MenuArchivo.menuArchivoProveedor();
                break;
            case 11:
                break;
        }
		Menu.menuPrincipal();
    }
}
