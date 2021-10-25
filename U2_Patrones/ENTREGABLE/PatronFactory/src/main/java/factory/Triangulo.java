package factory;

public class Triangulo extends Figura{

	public Triangulo(String color) {
		super(color);
	}

	@Override
	public String dibujarFigura() {
		return "Soy un triángulo " + getColor();
	}	
	
}
