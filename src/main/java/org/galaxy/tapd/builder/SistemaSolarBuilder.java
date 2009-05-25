package org.galaxy.tapd.builder;

import java.util.Random;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.SistemaSolar;
import org.galaxy.tapd.celestialbodys.asteroides.factory.AsteroidesFactory;
import org.galaxy.tapd.celestialbodys.estrellas.factory.EstrellaFactory;
import org.galaxy.tapd.celestialbodys.planetas.factory.PlanetaFactory;
import org.galaxy.tapd.factory.AbstractFactory;

public class SistemaSolarBuilder extends AbstractBuilder{
	
	private static EstrellaFactory estrellasFactory = EstrellaFactory.getInstance();
	private static PlanetaFactory planetasFactory = PlanetaFactory.getInstance();
	private static AsteroidesFactory asteroidesFactory = AsteroidesFactory.getInstance();
	
	
	
	private int getCantidadEstrellas()
	{
		int porcentaje = obtenerPorcentaje();
		int resultado = 0;
		if (porcentaje < 25)
		{
			resultado = 3;
		}
		else if (porcentaje <=25 && porcentaje >25+32){
			resultado = 2;
		}
		else {
			resultado = 1;
		}
		return resultado;
	}
	
	private int obtenerPorcentaje() {
		Random generator = new Random();
		return generator.nextInt(100);
	}

	private int getCantidadPlanetas()
	{
		int porcentaje = obtenerPorcentaje();
		int resultado = 0;
		if (porcentaje < 9)
		{
			resultado = 13;
		}
		else if (porcentaje <=9 && porcentaje >9+33){
			resultado = 4;
		}
		else {
			resultado = 8;
		}
		return resultado;
	}
	
	private int getCantidadAsteroides()
	{
		int porcentaje = obtenerPorcentaje();
		int resultado = 0;
		if (porcentaje < 17)
		{
			resultado = 13;
		}
		else if (porcentaje <=17 && porcentaje >17+21){
			resultado = 31;
		}
		else {
			resultado = 20;
		}
		return resultado;
	}

	@Override
	public SistemaSolar build(Componente parent) {
		SistemaSolar sistemaSolar = new SistemaSolar(parent);
		agregarCuerposCelestes(sistemaSolar,getCantidadAsteroides(),asteroidesFactory);
		agregarCuerposCelestes(sistemaSolar,getCantidadEstrellas(),estrellasFactory);
		agregarCuerposCelestes(sistemaSolar,getCantidadPlanetas(),planetasFactory);
		return sistemaSolar;
	}

	private void agregarCuerposCelestes(SistemaSolar sistemaSolar, int cantidad, AbstractFactory factory) {
		for (int i=0;i<=cantidad;i++)
		{
			sistemaSolar.addCelestialBody(factory.getProduct(sistemaSolar));
		}
	}
	
}
