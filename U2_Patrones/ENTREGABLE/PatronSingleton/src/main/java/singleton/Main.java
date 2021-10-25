package singleton;

public class Main {

	public static void main(String[] args) {
		
		SingletonPresidente p = SingletonPresidente.getPresidente("Barack", "Obama", 2009);
		SingletonPresidente p2 = SingletonPresidente.getPresidente("Joe", "Biden", 2021);
		
		System.out.println(p);
		System.out.println(p2);
		
	}

}
