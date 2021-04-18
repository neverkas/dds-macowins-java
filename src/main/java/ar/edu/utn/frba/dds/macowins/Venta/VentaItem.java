package ar.edu.utn.frba.dds.macowins.Venta;

import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

public class VentaItem {
	private Prenda prenda;
	private int cantidad;
	
	public VentaItem(Prenda prenda, int cantidad) {
		this.prenda = prenda;
		this.cantidad = cantidad;
	}
	
	public double precio() {
		return this.prenda.getPrecio() * this.cantidad;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
}
