package factoria;

public abstract class Pizza {
	
	private String nombre;

	public Pizza(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public abstract String sabor();
	
}
