package clases;
import FinalprogramacionII.MetodosGeneral;


public enum Provincia {
	 BUENOS_AIRES ("Buenos Aires"),
	 CATAMARCA("Catamarca"),
	 CHACO("Chaco"),
	 CHUBUT("Chubut"),
	 CORDOBA("Cordoba"),
	 CORRIENTES("Corriente"),
	 ENTRE_RIOS("Entre Rios"),
	 FORMOSA("Formosa"),
	 JUJUY("Jujuy"),
	 LA_PAMPA("La Pampa"),
	 LA_RIOJA("La Rioja"),
	 MENDOZA("Mendoza"),
	 NEUQUEN("Neuquen"),
	 RIO_NEGRO("Rio Negro"),
	 SALTA("Salta"),
	 SAN_JUAN("San Juan"),
	 SAN_LUIS("San Luis"),
	 SANTA_FE("Santa Fe"),
	 SANTIAGO_DEL_ESTERO("Santiago Del Estero"),
	 TIERRA_DEL_FUEGO("Tierra Del Fego"),
	 TUCUMAN("Tucuman");

 private String descripcionProvincia;

     Provincia(String descripcionProvincia){
        this.descripcionProvincia = descripcionProvincia;
     }
     
 public String elegirProvincia(){
         return descripcionProvincia;
        }

 public static Provincia escogerProvincia () {
		int seleccion; String seleccionAux = null;
		
		do {
			System.out.println("Provincias disponibles:");
			for(Provincia prov: Provincia.values()) {
				System.out.println(prov.ordinal() + 1 + "." + prov.elegirProvincia());
			}
			seleccion = MetodosGeneral.castearEntero("Seleccione alguna provincia: ", seleccionAux);
		}while(seleccion < 1 || seleccion > 23);
		
		return Provincia.values()[seleccion - 1];
	}
       
 }