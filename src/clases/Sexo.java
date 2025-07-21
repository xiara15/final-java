package clases;
import FinalprogramacionII.MetodosGeneral;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    OTRO("Otro");

    private final String SaberSexo;

    Sexo(String SaberSexo){
        this.SaberSexo = SaberSexo;
    }

    public String ObtenerSexo(){
        return this.SaberSexo;
    }


    public static Sexo elegirSexo (){
int seleccion = 0; String seleccionAux = null;
		
		do {
			System.out.println("Generos disponibles:");
			for(Sexo genero: Sexo.values()) {
				System.out.println(genero.ordinal() + 1 + "." + genero.ObtenerSexo());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione algún genero: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 3);
		
		return Sexo.values()[seleccion - 1];
	}
}