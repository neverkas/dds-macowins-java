package ar.edu.utn.frba.dds.macowins.Prenda;

public class EstadoPromocion  implements EstadoPrenda{
	private int valor;
	
	public EstadoPromocion(int valor) {
		this.valor = valor;
	}
	
	@Override
	public double precio(double precioBase) {
		return precioBase - valor;
	}
}
