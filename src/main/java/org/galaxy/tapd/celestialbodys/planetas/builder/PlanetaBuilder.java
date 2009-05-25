package org.galaxy.tapd.celestialbodys.planetas.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.builder.AbstractBuilder;
import org.galaxy.tapd.celestialbodys.planetas.Planeta;

public abstract class PlanetaBuilder extends AbstractBuilder{
	
	protected final static Integer MIN_DISTACIA_TIERRA = 1;
	protected final static Integer MAX_DISTACIA_TIERRA = 100;
	
	protected abstract Integer getMinTemperatura();
	protected abstract Integer getMaxTemperatura();
	protected abstract Float getMinDiametro();
	protected abstract Float getMaxDiametro();
	protected abstract Float getMinDistanciaEstrellaCercana();
	protected abstract Float getMaxDistanciaEstrellaCercana();
	protected abstract Integer getMinPromedioOxigeno();
	protected abstract Integer getMaxPromedioOxigeno();
	protected abstract Integer getMinPeriodoOrbitalEstrellaCercana();
	protected abstract Integer getMaxPeriodoOrbitalEstrellaCercana();
	
	public abstract Planeta build(Componente padre); 

	
	protected void commonBuild(Planeta planeta)
	{
		planeta.setDiametro(getRandomFloatInRange(getMinDiametro(),getMaxDiametro()));
		planeta.setDistanciaALaTierra(getRandomIntegerInRange(MIN_DISTACIA_TIERRA,MAX_DISTACIA_TIERRA));
		planeta.setDistanciaEstrellaMasCercana(getRandomFloatInRange(getMinDistanciaEstrellaCercana(),getMaxDistanciaEstrellaCercana()));
		planeta.setTemperatura(getRandomIntegerInRange(getMinTemperatura(),getMaxTemperatura()));
		planeta.setPorcentajeOxigeno(getRandomIntegerInRange(getMinPromedioOxigeno(),getMaxPromedioOxigeno()));
		planeta.setOrbita(getRandomIntegerInRange(getMinPeriodoOrbitalEstrellaCercana(),getMaxPeriodoOrbitalEstrellaCercana()));
	}
}
