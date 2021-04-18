
package ar.edu.utn.frba.dds.macowins;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.dds.macowins.Prenda.*;
import ar.edu.utn.frba.dds.macowins.Venta.*;

class VentaTest {

	private double precio, precioPromocion;
	private EstadoNueva nueva;
	private EstadoPromocion promocion;
	private EstadoLiquidacion liquidacion;
	LocalDate fechaDeHoy, fechaDeNavidad, fechaDeSanValentin;

	@BeforeEach
	public void initialize() {
		precio = 200;
		precioPromocion = 100;
		nueva = new EstadoNueva();
		promocion = new EstadoPromocion(precioPromocion);
		liquidacion = new EstadoLiquidacion();
		fechaDeHoy = LocalDate.now();
		fechaDeNavidad = LocalDate.of(2021, 12, 25);
		fechaDeSanValentin = LocalDate.of(2021, 2, 14);
	}
	
	@Test
	public void elPrecioDeVentaDeSacosNuevosEnEfectivoSeMantiene() {
		int cantidadDeSacos=15;
		Prenda sacoNuevo = new Prenda(TipoPrenda.SACO, precio, nueva);
		Venta venta = new Venta(new TipoVentaEfectivo(), fechaDeHoy);

		venta.agregarPrendasVendida(sacoNuevo, cantidadDeSacos);
		
		assertEquals(precio*cantidadDeSacos, venta.precioVentaTotal());
	}
	
	@Test
	public void elPrecioDeVentaDeSacosEnPromocionEfectivoEsMasBarato() {
		int cantidadDeSacos=15;
		Prenda sacoEnPromocion = new Prenda(TipoPrenda.SACO, precio, promocion);
		Venta venta = new Venta(new TipoVentaEfectivo(), fechaDeHoy);
		venta.agregarPrendasVendida(sacoEnPromocion, cantidadDeSacos);
		
		assertEquals(precio*cantidadDeSacos-precioPromocion*cantidadDeSacos, venta.precioVentaTotal());
	}
	
	@Test
	public void elPrecioDeVentaDeSacosNuevosEnTarjetaTieneRecargo() {
		int cantidadDeSacos=15;
		int cantidadCuotas=12, coeficiente=2;
		Prenda sacoNuevo = new Prenda(TipoPrenda.SACO, precio, nueva);
		Venta venta = new Venta(new TipoVentaTarjeta(cantidadCuotas, coeficiente), fechaDeHoy);

		venta.agregarPrendasVendida(sacoNuevo, cantidadDeSacos);
		
		assertEquals(cantidadCuotas*coeficiente+0.01*precio*cantidadDeSacos, venta.precioVentaTotal());
	}


	@Test
	public void lasGananciasEnNavidadFueronNormales() {
		int cantidadDeSacos=15;
		Prenda sacoNuevo = new Prenda(TipoPrenda.SACO, precio, nueva);
		Venta venta = new Venta(new TipoVentaEfectivo(), fechaDeNavidad);

		venta.agregarPrendasVendida(sacoNuevo, cantidadDeSacos);
		
		RegistroDeVentas registro = new RegistroDeVentas();
		registro.agregarVentas(venta);
		
		assertEquals(precio*cantidadDeSacos, registro.gananciasObtenidasSegunFecha(fechaDeNavidad));
	}
	
	@Test
	public void lasGananciasEnSanValentinFueronAltas() {		
		int cantidadDeSacos=30;
		Prenda sacoEnPromocion = new Prenda(TipoPrenda.SACO, precio, promocion);
		Venta venta = new Venta(new TipoVentaEfectivo(), fechaDeSanValentin);

		venta.agregarPrendasVendida(sacoEnPromocion, cantidadDeSacos);
		
		RegistroDeVentas registro = new RegistroDeVentas();
		registro.agregarVentas(venta);
		
		assertEquals(precio*cantidadDeSacos-precioPromocion*cantidadDeSacos, registro.gananciasObtenidasSegunFecha(fechaDeSanValentin));
	}
	
	@Test
	public void hoyNoHuboGanancias() {		
		int cantidadDeSacos=30;
		Prenda sacoEnPromocion = new Prenda(TipoPrenda.SACO, precio, promocion);
		Venta venta = new Venta(new TipoVentaEfectivo(), fechaDeSanValentin);

		venta.agregarPrendasVendida(sacoEnPromocion, cantidadDeSacos);
		
		RegistroDeVentas registro = new RegistroDeVentas();
		registro.agregarVentas(venta);
		
		assertEquals(0, registro.gananciasObtenidasSegunFecha(fechaDeHoy));
	}

}