package finaljava;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    OTRO("Otro");

    private final String SaberSexo;

    Sexo(String SaberSexo){
        this.SaberSexo = SaberSexo;
    }

    public String ObtenerSexo(){
        return SaberSexo;
    }

    public static Sexo fromInt(int opcion) throws Excepciones {
        if (opcion < 1 || opcion > values().length) {
            throw new Excepciones("La opccion esta mal, elegi un numero entre 1 y " + values().length + ".");
        }
        return values()[opcion - 1];
    }
}