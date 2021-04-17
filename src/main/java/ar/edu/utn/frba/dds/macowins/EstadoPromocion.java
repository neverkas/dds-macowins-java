package ar.edu.utn.frba.dds.macowins;

public class EstadoPromocion  implements EstadoPrenda{
	private int valor;
	
	@Override
	public int precio(int precioBase) {
		return precioBase - valor;
	}
}
