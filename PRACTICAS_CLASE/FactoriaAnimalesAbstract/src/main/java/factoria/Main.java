package factoria;

public class Main {

	public static void main(String[] args) {
		Animal a = Factory.getAnimal("perro", "Hillary");
		
		System.out.println(a.saludar());
	}

}
