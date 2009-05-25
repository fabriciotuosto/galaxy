package org.galaxy.tapd.celestialbodys.planetas.factory;

import java.util.Random;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.planetas.Planeta;
import org.galaxy.tapd.celestialbodys.planetas.builder.PlanetaBuilder;
import org.galaxy.tapd.celestialbodys.planetas.builder.PlanetaGaseosoBuilder;
import org.galaxy.tapd.celestialbodys.planetas.builder.PlanetaRocosoBuilder;
import org.galaxy.tapd.factory.AbstractFactory;

public class PlanetaFactory extends AbstractFactory{
	private static final Integer PROBABILIDAD_ROCOSO = 38;
	@SuppressWarnings("unused")
	private static final Integer PROBABILIDAD_GASEOSO = 62;
	private static PlanetaFactory instance = new PlanetaFactory();
	private PlanetaBuilder gaseosoBuilder = new PlanetaGaseosoBuilder();
	private PlanetaBuilder rocosoBuilder = new PlanetaRocosoBuilder();
	private PlanetaFactory() {
		
	}
	
	public static PlanetaFactory getInstance()
	{
		return instance;
	}
	
	public Planeta getProduct(Componente parent)
	{
		PlanetaBuilder builder = null;
		
		Random generator = new Random();
		int porcentaje = generator.nextInt(100);
		if (porcentaje < PROBABILIDAD_ROCOSO)
		{
			builder = rocosoBuilder;
		}else
		{
			builder = gaseosoBuilder;	
		}
		return builder.build(parent);
	}
}
