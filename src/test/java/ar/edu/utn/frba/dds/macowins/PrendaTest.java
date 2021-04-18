package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.dds.macowins.Prenda.EstadoLiquidacion;
import ar.edu.utn.frba.dds.macowins.Prenda.EstadoNueva;
import ar.edu.utn.frba.dds.macowins.Prenda.EstadoPromocion;
import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class PrendaTest {

	private int precio;
	
	@BeforeEach
	public void initialize() {
		precio = 100;
	}
	@Test
	public void unaPrendaNuevaMantieneSuPrecio() {
		Prenda prenda = new Prenda("saco", precio, new EstadoNueva());

		assertEquals(precio, prenda.getPrecio());
	}

	@Test
	public void unaPrendaConPromocionEsMasBarata() {
		Prenda prenda = new Prenda("saco", precio, new EstadoPromocion(100));

		assertEquals(precio - 100, prenda.getPrecio());
	}

	@Test
	public void unaPrendaEnLiquidacionCuestaLaMitad() {
		Prenda prenda = new Prenda("saco", precio, new EstadoLiquidacion());

		assertEquals(precio / 2, prenda.getPrecio());
	}
}