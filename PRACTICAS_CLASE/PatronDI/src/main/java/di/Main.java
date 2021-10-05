package di;

public class Main {

	public static void main(String[] args) {
				
		Tejado t1 = new Tejado();
		TejadoTejas tt1 = new TejadoTejas();
		Pared p1 = new Pared(4);
		Pared p2 = new Pared(6);
		Pared p3 = new Pared(4);
		Pared p4 = new Pared(6);
		Casa c1 = new Casa(20, t1, p1, p2, p3, p4);
		Casa c2 = new Casa(50, t1, p4, p4, p4, p4);
		
		
		System.out.println("Soy la casa nº1: " + c1);
		System.out.println("Soy la casa nº2: " + c2);
		t1.darSoporte();
		tt1.darSoporte();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
	}
	
}
