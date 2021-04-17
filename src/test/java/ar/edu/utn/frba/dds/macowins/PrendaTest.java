package ar.edu.utn.frba.dds.macowins;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrendaTest {

	@Test
	public void unaPrendaNuevaMantieneSuPrecio() {
		Prenda prenda = new Prenda("saco", 300, new EstadoNueva());
		
		assertEquals(300, prenda.precio());
	}

	@Test
	public void unaPrendaConPromocionEsMasBarata() {
		Prenda prenda = new Prenda("saco", 300, new EstadoPromocion(100));
		
		assertEquals(300-100, prenda.precio());
	}

	@Test
	public void unaPrendaEnLiquidacionCuestaLaMitad() {
		Prenda prenda = new Prenda("saco", 300, new EstadoLiquidacion());
		
		assertEquals(300/2, prenda.precio());
	}
}
