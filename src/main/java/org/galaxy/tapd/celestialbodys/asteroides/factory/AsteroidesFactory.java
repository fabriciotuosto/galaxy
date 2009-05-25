package org.galaxy.tapd.celestialbodys.asteroides.factory;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.asteroides.builder.AsteroideBuilder;
import org.galaxy.tapd.factory.AbstractFactory;

public class AsteroidesFactory extends AbstractFactory{
	private static AsteroidesFactory instance = new AsteroidesFactory();
	private AsteroideBuilder builder = new AsteroideBuilder();
	private AsteroidesFactory() {
		
	}
	
	public static AsteroidesFactory getInstance()
	{
		return instance;
	}
	
	public Asteroide getProduct(Componente parent)
	{	
		return builder.build(parent);		
	}
}
