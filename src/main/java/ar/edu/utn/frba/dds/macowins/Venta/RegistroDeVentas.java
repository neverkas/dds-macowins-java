package ar.edu.utn.frba.dds.macowins.Venta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroDeVentas {
	List<Venta> ventas;
	
	public RegistroDeVentas() {
		this.ventas = new ArrayList<>();
	}

	public List<Venta> ventasSegunFecha(LocalDate fecha) {
		return this.ventas
				.stream()
				.filter(venta -> venta.esRealizadaEnEstaFecha(fecha))
				.collect(Collectors.toList());
	}
	
	public double gananciasObtenidasSegunFecha(LocalDate fecha) {
		return this.ventasSegunFecha(fecha)
				.stream()
				.mapToDouble(venta -> venta.precioVentaTotal())
				.sum();
	}
	
	public void agregarVentas(Venta venta) {
		this.ventas.add(venta);
	}
}
