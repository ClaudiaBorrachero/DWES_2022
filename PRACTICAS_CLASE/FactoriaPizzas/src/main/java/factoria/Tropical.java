package factoria;

public class Tropical extends Pizza{

	public Tropical(String nombre) {
		super(nombre);
	}

	@Override
	public String sabor() {
		return "Tengo piña";
	}
	
}
