package org.galaxy.tapd;

import java.util.List;

import org.galaxy.tapd.builder.GalaxiaBuilder;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.humanos.Colonizadores;
import org.galaxy.tapd.humanos.EjercitoImperial;
import org.galaxy.tapd.humanos.Industriales;

public class Main {

	private static final String SEPARADOR = "--------------------------------------------------";

	public static void main(String[] args) {
		GalaxiaBuilder builder = new GalaxiaBuilder();
		Galaxia galaxia = builder.build(null); 
		System.out.println(SEPARADOR);
		System.out.println(galaxia.toString());	
		
		
		System.out.println(SEPARADOR);
		List<CuerpoCeleste> resultado = galaxia.obtenerPosibleArrakist();
		
		System.out.println("Posibles Arrakis = "+resultado.size());
		System.out.println(SEPARADOR);
		for (CuerpoCeleste celeste : resultado) {
			System.out.println("Posible Arrakis ="+celeste.getNombre());
		}
		
		System.out.println(SEPARADOR);
		System.out.println("Busqueda Colonizadores");
		System.out.println(SEPARADOR);
		resultado = galaxia.obtenerPosiblesDestinos(new Colonizadores());
		for (CuerpoCeleste celeste : resultado) {
			System.out.println(celeste.getNombre());
		}

		
		System.out.println(SEPARADOR);
		System.out.println("Busqueda Industriales");
		System.out.println(SEPARADOR);
		resultado = galaxia.obtenerPosiblesDestinos(new Industriales());
		for (CuerpoCeleste celeste : resultado) {
			System.out.println(celeste.getNombre());
		}
		
		
		System.out.println(SEPARADOR);
		System.out.println("Busqueda Ejercito Imperial");
		System.out.println(SEPARADOR);
		resultado = galaxia.obtenerPosiblesDestinos(new EjercitoImperial());
		for (CuerpoCeleste celeste : resultado) {
			System.out.println(celeste.getNombre());
		}

	}
}
