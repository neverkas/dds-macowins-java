
package ar.edu.utn.frba.dds.macowins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.dds.macowins.Prenda.*;
import ar.edu.utn.frba.dds.macowins.Venta.*;

class VentaTest {

	private double precio, precioPromocion;
	private EstadoNueva nueva;
	private EstadoPromocion promocion;
	private EstadoLiquidacion liquidacion;

	@BeforeEach
	public void initialize() {
		precio = 200;
		precioPromocion = 100;
		nueva = new EstadoNueva();
		promocion = new EstadoPromocion(precioPromocion);
		liquidacion = new EstadoLiquidacion();
	}
	
	@Test
	public void elPrecioDeVentaDeSacosNuevosEnEfectivoSeMantiene() {
		int cantidadDeSacos=15;
		Prenda sacoNuevo = new Prenda("saco", precio, nueva);
		Venta venta = new Venta(new TipoVentaEfectivo());

		venta.agregarPrendasVendida(sacoNuevo, cantidadDeSacos);
		
		assertEquals(precio*cantidadDeSacos, venta.precioVentaTotal());
	}
	
	@Test
	public void elPrecioDeVentaDeSacosEnPromocionEfectivoEsMasBarato() {
		int cantidadDeSacos=15;
		Prenda sacoEnPromocion = new Prenda("saco", precio, promocion);
		Venta venta = new Venta(new TipoVentaEfectivo());
		venta.agregarPrendasVendida(sacoEnPromocion, cantidadDeSacos);
		
		assertEquals(precio*cantidadDeSacos-precioPromocion*cantidadDeSacos, venta.precioVentaTotal());
	}
	
	@Test
	public void elPrecioDeVentaDeSacosNuevosEnTarjetaTieneRecargo() {
		int cantidadDeSacos=15;
		int cantidadCuotas=12, coeficiente=2;
		Prenda sacoNuevo = new Prenda("saco", precio, nueva);
		Venta venta = new Venta(new TipoVentaTarjeta(cantidadCuotas, coeficiente));

		venta.agregarPrendasVendida(sacoNuevo, cantidadDeSacos);
		
		assertEquals(cantidadCuotas*coeficiente+0.01*precio*cantidadDeSacos, venta.precioVentaTotal());
	}

}