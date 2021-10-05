package singleton;

public class Deposito {

	public static int cantidad;
	public static Deposito deposito = null;
	
	private Deposito() {
		System.out.println("Soy un depósito.");
	}
	
	public static Deposito getDeposito() {
		
		if (deposito == null){
			deposito = new Deposito();
        }
        
        return deposito;
		    
	}
	
	public static int llenar(int numLitros) {
		
		Deposito.cantidad += numLitros;
		System.out.println(Deposito.cantidad);
		return Deposito.cantidad;
	
	}
	
	public static int vaciar(int numLitros) {
		
		Deposito.cantidad -= numLitros;
		System.out.println(Deposito.cantidad);
		return Deposito.cantidad;
		
	}
	
	public static int getCantidad() {
		
		return Deposito.cantidad;
		
	}
	
}
