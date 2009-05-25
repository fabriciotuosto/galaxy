package org.galaxy.tapd.celestialbodys.estrellas.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.estrellas.Estrella;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;

public class EnanaBuilder extends EstrellaBuilder {

	private static Float MIN_DIAMTREO = 4.7f;
	private static Float MAX_DIAMTREO = 7.5f;
	private static Float MIN_TEMPERATURA = 4.7f;
	private static Float MAX_TEMPERATURA = 8.1f;
	private static Integer MIN_TORMENTAS = 7;
	private static Integer MAX_TORMENTAS = 11;
	
	@Override
	public Estrella build(Componente parent) {
		EstrellaEnana estrella = new EstrellaEnana(parent);
		estrella.setDiametro(getRandomFloatInRange(getMinDiametro(),getMaxDiametro()));
		estrella.setDistanciaAlCentroDeGalaxia(getRandomIntegerInRange(getMinDistanciaCentroUniverso(),getMaxnDistanciaCentroUniverso()));
		estrella.setPromedioTormentasSolares(getRandomIntegerInRange(getMinTormentasSolares(), getMaxTormentasSolares()));
		estrella.setTemperatura(getRandomFloatInRange(getMinTemperatura(),getMaxTemperatura()));
		return estrella;
	}

	@Override
	protected Float getMaxDiametro() {
		return MAX_DIAMTREO;
	}

	@Override
	protected Float getMaxTemperatura() {
		return MAX_TEMPERATURA;
	}

	@Override
	protected Integer getMaxTormentasSolares() {
		return MAX_TORMENTAS;
	}

	@Override
	protected Integer getMaxnDistanciaCentroUniverso() {
		return MAX_DISTANCIA_CENTRO;
	}

	@Override
	protected Float getMinDiametro() {
		return MIN_DIAMTREO;
	}

	@Override
	protected Integer getMinDistanciaCentroUniverso() {
		return MIN_DISTANCIA_CENTRO;
	}

	@Override
	protected Float getMinTemperatura() {
		return MIN_TEMPERATURA;
	}

	@Override
	protected Integer getMinTormentasSolares(){ 
		return MIN_TORMENTAS;
	}

}
