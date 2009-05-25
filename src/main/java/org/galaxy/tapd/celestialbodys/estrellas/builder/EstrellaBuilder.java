package org.galaxy.tapd.celestialbodys.estrellas.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.builder.AbstractBuilder;
import org.galaxy.tapd.celestialbodys.estrellas.Estrella;

public abstract class EstrellaBuilder extends AbstractBuilder{
	protected static Integer MIN_DISTANCIA_CENTRO = 1;
	protected static Integer MAX_DISTANCIA_CENTRO = 100;
	public abstract Estrella build(Componente parent);
	
	protected abstract Float getMinDiametro();
	protected abstract Float getMaxDiametro();
	
	protected abstract Float getMinTemperatura();
	protected abstract Float getMaxTemperatura();
	
	protected abstract Integer getMinTormentasSolares();
	protected abstract Integer getMaxTormentasSolares();
	
	protected abstract Integer getMinDistanciaCentroUniverso();
	protected abstract Integer getMaxnDistanciaCentroUniverso();
	
}
