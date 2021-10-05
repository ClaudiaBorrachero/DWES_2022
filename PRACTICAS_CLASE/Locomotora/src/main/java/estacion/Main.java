package estacion;

public class Main {

	public static void main(String[] args) {
		Maquinista m1 = new Maquinista("Pepe","Pérez","C/Sevilla,3");
		MaquinistaPrimera mp = new MaquinistaPrimera("Pepe","Pérez","C/Sevilla,3",6);
		Locomotora l1 = new Locomotora("Volkswagen",78,12);
		Tren t1 = new Tren("Citroen",l1,m1);
		
		System.out.println(m1);
		System.out.println(l1);
		System.out.println(t1);
		
	}

}
