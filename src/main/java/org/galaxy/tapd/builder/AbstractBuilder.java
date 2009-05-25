package org.galaxy.tapd.builder;

import java.util.Random;

import org.galaxy.tapd.Componente;

public abstract class AbstractBuilder {
	
	public abstract Object build (Componente parent);

	public Double getRandomDoubleInRange(Double desde, Double hasta)
	{
		Random generador = new Random();
		return generador.nextDouble()*(hasta-desde)+desde;
	}
	
	public Long getRandomLongInRange(Long desde, Long hasta)
	{
		Random generador = new Random();
		return generador.nextLong()*(hasta-desde)+desde;
	}
	
	public Integer getRandomIntegerInRange(Integer desde, Integer hasta)
	{
		Random generador = new Random();
		return generador.nextInt(hasta-desde)+desde;
	}
	
	public Float getRandomFloatInRange(Float desde, Float hasta)
	{
		Random generador = new Random();
		return generador.nextFloat()*(hasta-desde)+desde;
	}
}
