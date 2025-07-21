package clases;

import FinalprogramacionII.MetodosGeneral;

public enum FormaDePago {

	EFECTIVO("Efectivo"),
    TARJETA_DEBITO("Tarjeta De Debito"),
    TARJETA_CREDITO("Tarjeta De Credito"),
    TRANSFERENCIA("Transferencia"),
    CUENTA_CORRIENTE("Cuenta Corriente");

    private final String descripcion;

    FormaDePago(String descripcion){
        this.descripcion = descripcion;
}

public String  obtenerFormaDePago(){
    return descripcion;
}

public static FormaDePago escogerFomaPago () {
	int seleccion; String seleccionAux = null;
	
	do {
		System.out.println("Formas de pago disponibles:");
		for(FormaDePago forma: FormaDePago.values()) {
			System.out.println(forma.ordinal() + 1 + "." + forma.obtenerFormaDePago());
		}
		seleccion = MetodosGeneral.castearEntero("Seleccione alguna forma de pago: ", seleccionAux);
	}while(seleccion < 1 || seleccion > 5);
	
	return FormaDePago.values()[seleccion - 1];
}
}