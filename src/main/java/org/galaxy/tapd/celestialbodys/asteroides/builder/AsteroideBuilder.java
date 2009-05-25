package org.galaxy.tapd.celestialbodys.asteroides.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.builder.AbstractBuilder;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;

public class AsteroideBuilder extends AbstractBuilder{

	private static Float MIN_DIAMETRO = 0.1f;
	private static Float MAX_DIAMETRO = 1.3f;
	private static Integer MIN_DISTACIA_TIERRA = 1;
	private static Integer MAX_DISTACIA_TIERRA = 100;
	private static Float MIN_PORCENTAJE_METALES_UTILES = 24.1f;
	private static Float MAX_PORCENTAJE_METALES_UTILES = 67.4f;
	private static Float MIN_PORCENTAJE_ELEMENTOS_RADIACTIVOS = 11.7f;
	private static Float MAX_PORCENTAJE_ELEMENTOS_RADIACTIVOS= 30.4f;
	private static Integer MIN_ORBITA_ESTRELLA_CERCANA = 300;
	private static Integer MAX_ORBITA_ESTRELLA_CERCANA = 1000;
	private static Float MIN_PORCENTAJE_DEUTERIO = 39.4f;
	private static Float MAX_PORCENTAJE_DEUTERIO = 50.7f;
	private static Float MIN_AGUA_SOLIDA_POLO = 20.5f;
	private static Float MAX_AGUA_SOLIDA_POLO = 62.4f;
	
	public Asteroide build(Componente parent) {
		Asteroide asteroide = new Asteroide(parent);
		asteroide.setDiametro(getRandomFloatInRange(MIN_DIAMETRO,MAX_DIAMETRO));
		asteroide.setDistanciaTierra(getRandomIntegerInRange(MIN_DISTACIA_TIERRA,MAX_DISTACIA_TIERRA));
		asteroide.setPorcentajeAguaSolida(getRandomFloatInRange(MIN_AGUA_SOLIDA_POLO, MAX_AGUA_SOLIDA_POLO));
		asteroide.setPorcentajeMetalesUtiles(getRandomFloatInRange(MIN_PORCENTAJE_METALES_UTILES, MAX_PORCENTAJE_METALES_UTILES));
		asteroide.setPorcentajeDeuterio(getRandomFloatInRange(MIN_PORCENTAJE_DEUTERIO, MAX_PORCENTAJE_DEUTERIO));
		asteroide.setPeriodoOrbital(getRandomIntegerInRange(MIN_ORBITA_ESTRELLA_CERCANA, MAX_ORBITA_ESTRELLA_CERCANA));
		asteroide.setPorcentajeElementosRadiactivos(getRandomFloatInRange(MIN_PORCENTAJE_ELEMENTOS_RADIACTIVOS, MAX_PORCENTAJE_ELEMENTOS_RADIACTIVOS));
		return asteroide;
	}

}
