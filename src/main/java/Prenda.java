package main.java;

public class Prenda {
	private String tipo;
	private int precioBase;
	private EstadoPrenda estado;
	
	public int precio() {
		return estado.precio(precioBase) + this.precioBase;
	}
	
	public int getPrecioBase() {
		return this.precioBase;
	}
}
