package org.galaxy.tapd.celestialbodys.planetas.builder;

import java.util.Random;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.planetas.Planeta;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso.TipoSuelo;

public class PlanetaRocosoBuilder extends PlanetaBuilder {
	private static final Float MIN_DIAMETRO = 0.5f;
	private static final Float MAX_DIAMETRO = 1.6f;
	private static final Float MIN_DISTANCIA_ESTRELLA_CERCANA = 0.1f;
	private static final Float MAX_DISTANCIA_ESTRELLA_CERCANA = 6.4f;
	private static final Integer MIN_TEMPERATURA = 0;
	private static final Integer MAX_TEMPERATURA = 1000;
	private static final Integer MIN_PROMEDIO_OXIGENO = 50;
	private static final Integer MAX_PROMEDIO_OXIGENO = 95;
	private static final Integer MIN_PERIODO_ORBITAL = 15;
	private static final Integer MAX_PERIODO_ORBITAL = 500;
	private static final Float MIN_PORCENTA_METALES_UTILES= 0.3f;
	private static final Float MAX_PORCENTA_METALES_UTILES = 48.4f;
	private static final Float MIN_ELEMENTOS_RADIACTIVOS = 0.3f;
	private static final Float MAX_ELEMENTOS_RADIACTIVOS= 70.8f;
	private static final Float MIN_PORCENTAJE_AGUA = 0.3f;
	private static final Float MAX_PORCENTAJE_AGUA= 90.5f;	
	
	@Override
	public Planeta build(Componente padre) {
		PlanetaRocoso planeta = new PlanetaRocoso(padre);
		commonBuild(planeta);
		planeta.setPorcentajeMetalesUtiles(getRandomFloatInRange(MIN_PORCENTA_METALES_UTILES,MAX_PORCENTA_METALES_UTILES));
		planeta.setPorcentajeElementosRadiactivos(getRandomFloatInRange(MIN_ELEMENTOS_RADIACTIVOS,MAX_ELEMENTOS_RADIACTIVOS));
		planeta.setPorcentajeAgua(getRandomFloatInRange(MIN_PORCENTAJE_AGUA,MAX_PORCENTAJE_AGUA));
		planeta.setTipoSuelo(getRandomTipoSuelo());
		return planeta;
	}
	
	private TipoSuelo getRandomTipoSuelo() {
		TipoSuelo resultado = null;
		Random generador = new Random();
		int result = generador.nextInt(3);
		switch (result) {
		case 0:
			resultado = TipoSuelo.DESIERTO;
			break;
		case 1:
			resultado = TipoSuelo.ESCARPADO;
			break;
		case 2 :
			resultado = TipoSuelo.VALLE;
			break;
		}
		return resultado;
	}

	@Override
	protected Float getMaxDiametro() {
		return MAX_DIAMETRO;
	}

	@Override
	protected Float getMaxDistanciaEstrellaCercana() {
		return MAX_DISTANCIA_ESTRELLA_CERCANA;
	}

	@Override
	protected Integer getMaxPeriodoOrbitalEstrellaCercana() {
		return MAX_PERIODO_ORBITAL;
	}

	@Override
	protected Integer getMaxPromedioOxigeno() {
		return MAX_PROMEDIO_OXIGENO;
	}

	@Override
	protected Integer getMaxTemperatura() {
		return MAX_TEMPERATURA;
	}

	@Override
	protected Float getMinDiametro() {
		return MIN_DIAMETRO;
	}

	@Override
	protected Float getMinDistanciaEstrellaCercana() {
		return MIN_DISTANCIA_ESTRELLA_CERCANA;
	}

	@Override
	protected Integer getMinPeriodoOrbitalEstrellaCercana() {
		return MIN_PERIODO_ORBITAL;
	}

	@Override
	protected Integer getMinPromedioOxigeno() {
		return MIN_PROMEDIO_OXIGENO;
	}

	@Override
	protected Integer getMinTemperatura() {
		return MIN_TEMPERATURA;
	}

}
