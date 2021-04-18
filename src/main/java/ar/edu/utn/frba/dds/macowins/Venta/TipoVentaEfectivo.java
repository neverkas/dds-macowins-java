package ar.edu.utn.frba.dds.macowins.Venta;

public class TipoVentaEfectivo implements TipoVenta{
	@Override
	public double precioVenta(double precio) {
		return precio;
	}
}
