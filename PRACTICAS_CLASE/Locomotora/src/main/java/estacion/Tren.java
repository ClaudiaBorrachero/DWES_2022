package estacion;

public class Tren {

	public String modelo;
	private Locomotora locomotora;
	private Maquinista maquinista;

	public Tren(String modelo, Locomotora locomotora, Maquinista maquinista) {
		this.modelo = modelo;
		this.locomotora = locomotora;
		this.maquinista = maquinista;
	}

	@Override
	public String toString() {
		return "Tren [modelo=" + modelo + ", locomotora=" + locomotora + ", maquinista=" + maquinista + "]";
	}

}
