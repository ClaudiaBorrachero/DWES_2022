package factoria;

public class Carbonara extends Pizza{

	public Carbonara(String nombre) {
		super(nombre);
	}
	
	@Override
	public String sabor() {
		return "Tengo champis";
	}

}
