package clases;

import FinalprogramacionII.MetodosGeneral;

public enum Categoria {
    INDUMENTARIA("indumentaria"),
    CALZADO("calzado"),
    ACCESORIO("accesorio");

    private final String descripcionCategoria;

    Categoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    public String obtenerCategoria() {
        return descripcionCategoria;
    }

    public static Categoria escogerCategoria () {
		int seleccion; String seleccionAux = null;
		
		do {
			System.out.println("Provincias disponibles:");
			for(Categoria cate: Categoria.values()) {
				System.out.println(cate.ordinal() + 1 + "." + cate.obtenerCategoria());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna categoria: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return Categoria.values()[seleccion - 1];
	}

    
}