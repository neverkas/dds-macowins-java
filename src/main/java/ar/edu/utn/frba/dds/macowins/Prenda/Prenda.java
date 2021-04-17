package ar.edu.utn.frba.dds.macowins;
//import ar.edu.utn.frba.dds.macowins.EstadoPrenda;

public class Prenda{
	private String tipo;
	private int precioBase;
	private EstadoPrenda estado;

	public Prenda(String tipo, int precioBase, EstadoPrenda estado) {
		this.tipo = tipo;
		this.precioBase = precioBase;
		this.estado = estado;
	}
	
	public int precio() {
		return estado.precio(precioBase);
	}
	
	public int getPrecioBase() {
		return this.precioBase;
	}
}
