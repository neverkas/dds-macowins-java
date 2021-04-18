package ar.edu.utn.frba.dds.macowins.Prenda;

public class EstadoPromocion  implements EstadoPrenda{
	private double valor;
	
	public EstadoPromocion(double valor) {
		this.valor = valor;
	}
	
	@Override
	public double precio(double precioBase) {
		return precioBase - valor;
	}
}
