package ar.edu.utn.frba.dds.macowins;

public class EstadoPromocion  implements EstadoPrenda{
	private int valor;
	
	public EstadoPromocion(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int precio(int precioBase) {
		return precioBase - valor;
	}
}
