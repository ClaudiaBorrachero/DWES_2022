package factoria;

public class Main {

public static void main(String[] args) {
        
        Pizza p = Factory.getPizza("tropical");
        Pizza p2 = Factory.getPizza("bacon");
        Pizza p3 = Factory.getPizza("carbonara");
        
        System.out.println(p.sabor());
        System.out.println(p2.sabor());
        System.out.println(p3.sabor());
        
    }
	
}
