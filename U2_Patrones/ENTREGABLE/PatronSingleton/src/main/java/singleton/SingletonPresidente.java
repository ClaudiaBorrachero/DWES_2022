package singleton;

public class SingletonPresidente {

	private String nombre, apellidos;
	private int anioEleccion;

	private SingletonPresidente(String nombre, String apellidos, int anioEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anioEleccion = anioEleccion;
	}	
	
	public static SingletonPresidente Presidente = null;
	
	public static SingletonPresidente getPresidente(String nombre, String apellidos, int anioEleccion) {
		
		if(Presidente == null) {
			Presidente = new SingletonPresidente(nombre,apellidos,anioEleccion);
		}
		return Presidente;
	}

	@Override
	public String toString() {
		return "SingletonPresidente [nombre=" + nombre + ", apellidos=" + apellidos + ", anioEleccion=" + anioEleccion
				+ "]";
	}
		
}
