package ar.edu.utn.frba.dds.macowins.Venta;

public class TipoVentaTarjeta implements TipoVenta{
	private int cantidadCuotas;
	private int coeficiente;
	
	@Override
	public double precioVenta(double precio) {
		return this.precioConRecargo(precio);
	}
	
	private double precioConRecargo(double precio) {
		return cantidadCuotas*coeficiente + 0.01*precio;
	}
}
