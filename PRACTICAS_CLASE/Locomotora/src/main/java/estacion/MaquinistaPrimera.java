package estacion;

public class MaquinistaPrimera extends Maquinista{
	
	private int antiguedad;
	
	public MaquinistaPrimera(String nombre, String apellidos, String direccion, int antiguedad) {
		super(nombre, apellidos, direccion);
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "MaquinistaPrimera [antiguedad=" + antiguedad + "]";
	}

}
