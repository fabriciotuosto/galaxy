package org.galaxy.tapd.celestialbodys.planetas.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.planetas.Planeta;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;

public class PlanetaGaseosoBuilder extends PlanetaBuilder{

	private static final Float MIN_DIAMETRO = 2.2f;
	private static final Float MAX_DIAMETRO = 3.7f;
	private static final Float MIN_DISTANCIA_ESTRELLA_CERCANA = 3.1f;
	private static final Float MAX_DISTANCIA_ESTRELLA_CERCANA = 10f;
	private static final Integer MIN_TEMPERATURA = 0;
	private static final Integer MAX_TEMPERATURA = 2000;
	private static final Integer MIN_PROMEDIO_OXIGENO = 3;
	private static final Integer MAX_PROMEDIO_OXIGENO = 48;
	private static final Integer MIN_PERIODO_ORBITAL = 100;
	private static final Integer MAX_PERIODO_ORBITAL = 1000;
	private static final Float MIN_DENSIDAD_GASES = 0.4f;
	private static final Float MAX_DENSIDAD_GASES = 54.7f;
	private static final Integer MIN_PROMEDIO_HURACANES = 2;
	private static final Integer MAX_PROMEDIO_HURACANES = 700;
	private static final Float MIN_DEUTERIO_GASEOSO = 22.4f;
	private static final Float MAX_DEUTERIO_GASEOSO = 78.5f;
	
	@Override
	public Planeta build(Componente padre) {
		PlanetaGaseoso planeta = new PlanetaGaseoso(padre);
		commonBuild(planeta);
		planeta.setDensidadGases(getRandomFloatInRange(MIN_DENSIDAD_GASES,MAX_DENSIDAD_GASES));
		planeta.setPromedioHuracanesAlAno(getRandomIntegerInRange(MIN_PROMEDIO_HURACANES,MAX_PROMEDIO_HURACANES));
		planeta.setDeuterioEnAtmosfera(getRandomFloatInRange(MIN_DEUTERIO_GASEOSO, MAX_DEUTERIO_GASEOSO));
		return planeta;
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
