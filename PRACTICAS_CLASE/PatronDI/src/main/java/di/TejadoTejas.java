package di;

public class TejadoTejas extends Tejado{

	public TejadoTejas() {
		super();
	}

	@Override
	public void darSoporte() {
		System.out.println("Soy una teja");
	}

	@Override
	public String toString() {
		return "TejadoTejas []";
	}
	
}
