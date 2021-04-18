package ar.edu.utn.frba.dds.macowins.Prenda;

public class Prenda{
	private TipoPrenda tipo;
	private double precioBase;
	private EstadoPrenda estado;

	public Prenda(TipoPrenda tipo, double precioBase, EstadoPrenda estado) {
		this.tipo = tipo;
		this.precioBase = precioBase;
		this.estado = estado;
	}
	
	public double getPrecio() {
		return estado.precio(precioBase);
	}
	
	public double getPrecioBase() {
		return this.precioBase;
	}
}
