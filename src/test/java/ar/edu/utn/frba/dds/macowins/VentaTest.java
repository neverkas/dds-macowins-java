
package ar.edu.utn.frba.dds.macowins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.dds.macowins.Prenda.EstadoNueva;
import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;
import ar.edu.utn.frba.dds.macowins.Venta.TipoVentaEfectivo;
import ar.edu.utn.frba.dds.macowins.Venta.Venta;

class VentaTest {

	private double precio;

	@BeforeEach
	public void initialize() {
		precio = 100;
	}
	
	@Test
	public void elPrecioDeVentaDePrendasNuevasEnEfectivoSeMantiene() {
		Prenda prenda = new Prenda("saco", precio, new EstadoNueva());
		Venta venta = new Venta(new TipoVentaEfectivo());
		venta.agregarPrendaVendida(prenda);
		venta.agregarPrendaVendida(prenda);
		venta.agregarPrendaVendida(prenda);
		
		assertEquals(precio*venta.cantidadPrendas(), venta.precioVentaTotal());
	}

}