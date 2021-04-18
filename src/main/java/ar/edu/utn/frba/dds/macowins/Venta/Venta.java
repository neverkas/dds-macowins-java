package ar.edu.utn.frba.dds.macowins.Venta;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

public class Venta {
	List<VentaItem> prendasVendidas;
	private TipoVenta tipo;
	
	public Venta(TipoVenta tipo) {
		super();
		this.tipo = tipo;
		this.prendasVendidas = new ArrayList<>();
	}
	
	public Venta(TipoVenta tipo, List<VentaItem> prendas) {
		this(tipo);
		//this.tipo = tipo;
		this.prendasVendidas = prendas;
	}

	public int cantidadPrendas() {
		return prendasVendidas
				.stream()
				.mapToInt(ventaItem -> ventaItem.getCantidad())
				.sum();
	}
	
	public double precioVentaTotal() {
		return prendasVendidas
				.stream()
				.mapToDouble(ventaItem -> tipo.precioVenta(ventaItem.precio()))
				.sum();
	}
	
	public void agregarPrendasVendida(Prenda prenda, int cantidad) {
		VentaItem item = new VentaItem(prenda, cantidad);
		this.prendasVendidas.add(item);
	}
	
	public void agregarVariasPrendasVendidas(List<VentaItem> prendas) {
		this.prendasVendidas.addAll(prendas);
	}
}