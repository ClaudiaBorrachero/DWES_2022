package factoria;

public class Factory {

public static Pizza getPizza(String nombre) {
		
		if(nombre.equals("tropical")) {
			return new Tropical("tropical");
			
		} else if(nombre.equals("bacon")){
			return new Bacon("bacon");
			
		} else {
			return new Carbonara("carbonara");
		}

	}
	
}
