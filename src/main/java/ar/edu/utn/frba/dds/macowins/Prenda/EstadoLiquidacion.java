package ar.edu.utn.frba.dds.macowins.Prenda;

public class EstadoLiquidacion implements EstadoPrenda{
	@Override
	public double precio(double precioBase) {
		return this.precioConDescuento(precioBase);
	}
	
	public double precioConDescuento(double precio) {
		return precio / 2;
	}
}
