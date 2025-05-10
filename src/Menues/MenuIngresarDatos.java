package Menues;

import FinalprogramacionII.MetodosGeneral;

public class MenuIngresarDatos {

	public static void menusIngresar() {
		System.out.println("Bienvenido al menú secundario para ingresar datos:");
		System.out.println("1 - Menú de personas.");
		System.out.println("2 - Menú de empleados.");
		System.out.println("3 - Menú de usuarios.");
		System.out.println("4 - Menú de productos,.");
		System.out.println("5 - Menú de ventas.");
		System.out.println("6 - Menú de movimientos.");
		System.out.println("7 - Menú de cuentas corrientes.");
		System.out.println("8 - Menú de clientes.");
		System.out.println("9 - Menú de proveedores.");
		System.out.println("10 - Salir.");
			
		String numAux=null; int num=0;
		do {
			num = MetodosGeneral.castearEntero("Seleccione: ", numAux);
		}while(num < 1 || num > 10);
			
		switch(num) {
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
			MenuProducto.menuIngresoProducto(Producto.listaProductos);
			break;
				
		case 5:
			MenuVenta.menuIngresoVenta(Venta.listaVentas);
			break;
				
		case 6:
			MenuMovimiento.menuIngresoMovimiento(Movimiento.listaMovimientos);
			break;
				
		case 7:
			MenuCtaCte.menuIngresoCtaCte(CuentaCorriente.listaCtaCtes);
			break;
				
		case 8:
			MenuCliente.menuIngresoCliente(Cliente.listaClientes);
			break;
				
		case 9:
			MenuProveedor.menuIngresoProveedor(Proveedor.listaProveedores);
			break;
				
		case 10:
			System.out.println("Saliendo...");
			break;
				
		default:
			break;
		}
		Menus.menuPrincipal();
	}
}
