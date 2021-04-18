package ar.edu.utn.frba.dds.macowins.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

public class Venta {
	List<VentaItem> prendasVendidas;
	private TipoVenta tipo;
	private LocalDate fechaDeVenta;
	
	public Venta(TipoVenta tipo, LocalDate fechaDeVenta) {
		this.tipo = tipo;
		this.fechaDeVenta = fechaDeVenta;
		this.prendasVendidas = new ArrayList<>();
	}

	public boolean esRealizadaEnEstaFecha(LocalDate fecha) {
		return this.fechaDeVenta.equals(fecha);
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