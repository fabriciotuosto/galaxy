package org.galaxy.tapd.celestialbodys.estrellas.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.estrellas.Estrella;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;

public class EnanaBlancaBuilder extends EstrellaBuilder {

	private static Float MIN_DIAMTREO = 1.3f;
	private static Float MAX_DIAMTREO = 3.6f;
	private static Float MIN_TEMPERATURA = 2.4f;
	private static Float MAX_TEMPERATURA = 5.3f;
	private static Integer MIN_TORMENTAS = 2;
	private static Integer MAX_TORMENTAS = 9;

	
	@Override
	public Estrella build(Componente parent) {
		EstrellaEnanaBlanca estrella = new EstrellaEnanaBlanca(parent);
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
