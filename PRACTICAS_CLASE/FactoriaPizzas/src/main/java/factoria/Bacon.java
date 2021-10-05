package factoria;

public class Bacon extends Pizza{

	public Bacon(String nombre) {
		super(nombre);
	}

	@Override
	public String sabor() {
		return "Tengo bacon";
	}
	
}
