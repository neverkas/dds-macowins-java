package main.java;

public class EstadoLiquidacion implements EstadoPrenda{
	@Override
	public int precio(int precioBase) {
		return this.precioConDescuento(precioBase);
	}
	
	public int precioConDescuento(int precio) {
		return precio / 2;
	}
}