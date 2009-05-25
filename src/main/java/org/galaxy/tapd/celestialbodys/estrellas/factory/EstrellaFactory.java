package org.galaxy.tapd.celestialbodys.estrellas.factory;

import java.util.Random;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.estrellas.Estrella;
import org.galaxy.tapd.celestialbodys.estrellas.builder.EnanaBlancaBuilder;
import org.galaxy.tapd.celestialbodys.estrellas.builder.EnanaBuilder;
import org.galaxy.tapd.celestialbodys.estrellas.builder.EstrellaBuilder;
import org.galaxy.tapd.celestialbodys.estrellas.builder.SupernovaBuilder;
import org.galaxy.tapd.factory.AbstractFactory;

public class EstrellaFactory extends AbstractFactory{

	private static final Integer PROBABILIDAD_ENANA_BLANCA = 27;
	private static final Integer PROBABILIDAD_ENANA = 32;
	@SuppressWarnings("unused")
	private static final Integer PROBABILIDAD_SUPERNOVA = 41;
	
	//Builders
	private EstrellaBuilder supernovaBuilder = new SupernovaBuilder();
	private EstrellaBuilder enanaBlancaBuilder = new EnanaBlancaBuilder();
	private EstrellaBuilder enanaBuilder = new EnanaBuilder();
	private static EstrellaFactory instance = new EstrellaFactory();
	
	private EstrellaFactory() {
		
	}
	
	public static EstrellaFactory getInstance()
	{
		return instance;
	}
	
	public Estrella getProduct(Componente parent)
	{
		EstrellaBuilder builder = null;
		Random generator = new Random();
		int porcentaje = generator.nextInt(100);
		if (porcentaje < PROBABILIDAD_ENANA_BLANCA)
		{
		  builder = enanaBlancaBuilder;	
		}else if (porcentaje >= PROBABILIDAD_ENANA_BLANCA && porcentaje < PROBABILIDAD_ENANA_BLANCA+PROBABILIDAD_ENANA)
		{
			builder = enanaBuilder ;	
		}else
		{
			builder = supernovaBuilder;	
		}
		return builder.build(parent);
	}

}
