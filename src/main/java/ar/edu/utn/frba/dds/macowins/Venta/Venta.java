package ar.edu.utn.frba.dds.macowins.Venta;

import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

public class Venta {
	List<Prenda> prendas;
	private TipoVenta tipo;
	
	public Venta(TipoVenta tipo) {
		this.tipo = tipo;
		this.prendas = new ArrayList<>();
	}
	
	public int cantidadPrendas() {
		return prendas.size();
	}
	
	public double precioVentaTotal() {
		return prendas
				.stream()
				.mapToDouble(prenda -> tipo.precioVenta(prenda.getPrecio()))
				.sum();
	}
	
	public void agregarPrendaVendida(Prenda prenda) {
		prendas.add(prenda);
	}
}
