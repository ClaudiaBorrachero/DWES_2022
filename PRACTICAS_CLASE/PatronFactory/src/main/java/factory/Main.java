package factory;

public class Main {

	public static void main(String[] args) {
		
		Figura f1 = Factory.getFigura("triangulo","azul");
		Figura f2 = Factory.getFigura("rectangulo","amarillo");
		Figura f3 = Factory.getFigura("circulo","rojo");
		Figura f4 = Factory.getFigura("cuadrado","verde");
		
		System.out.println(f1.dibujarFigura());
		System.out.println(f2.dibujarFigura());
		System.out.println(f3.dibujarFigura());
		System.out.println(f4.dibujarFigura());
		
	}

}
