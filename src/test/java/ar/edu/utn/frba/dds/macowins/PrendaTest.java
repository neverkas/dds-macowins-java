package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import ar.edu.utn.frba.dds.macowins.Prenda.EstadoLiquidacion;
import ar.edu.utn.frba.dds.macowins.Prenda.EstadoNueva;
import ar.edu.utn.frba.dds.macowins.Prenda.EstadoPromocion;
import ar.edu.utn.frba.dds.macowins.Prenda.Prenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class PrendaTest {

	private int precio, precioPromocion;
	EstadoNueva nueva;
	EstadoPromocion promocion;
	EstadoLiquidacion liquidacion;

	@BeforeEach
	public void initialize() {
		precio = 200;
		precioPromocion = 100;
		nueva = new EstadoNueva();
		promocion = new EstadoPromocion(100);
		liquidacion = new EstadoLiquidacion();
	}
	
	@Test
	public void unaPrendaNuevaMantieneSuPrecio() {
		Prenda prenda = new Prenda("saco", precio, nueva);

		assertEquals(precio, prenda.getPrecio());
	}

	@Test
	public void unaPrendaConPromocionEsMasBarata() {
		Prenda prenda = new Prenda("saco", precio, promocion);

		assertEquals(precio - precioPromocion, prenda.getPrecio());
	}

	@Test
	public void unaPrendaEnLiquidacionCuestaLaMitad() {
		Prenda prenda = new Prenda("saco", precio, liquidacion);

		assertEquals(precio / 2, prenda.getPrecio());
	}
}