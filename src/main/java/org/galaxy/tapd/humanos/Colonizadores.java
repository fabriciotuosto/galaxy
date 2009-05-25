package org.galaxy.tapd.humanos;

import java.util.ArrayList;
import java.util.List;

import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;
import org.galaxy.tapd.celestialbodys.estrellas.Supernova;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso.TipoSuelo;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;

public class Colonizadores extends Humanos {
	
	public Colonizadores() {
	}
	
	@Override
	public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
		return new BuscadorDestinosColonizadores();
	}
	
	private static class BuscadorDestinosColonizadores implements CuerpoCelesteVisitorFinder
	{
		private List<CuerpoCeleste> resultado = null;
		private boolean hayEstrellaNecesariaParaVida;
		
		public BuscadorDestinosColonizadores() {
			resultado = new ArrayList<CuerpoCeleste>();
			hayEstrellaNecesariaParaVida = false;
		}
		
		public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {}
		public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {}
		public void visitSupernova(Supernova estrella) {}
	
		public List<CuerpoCeleste> obtenerResultado() {
			List<CuerpoCeleste> returnList = null;
			if (hayEstrellaNecesariaParaVida)
			{
				returnList = resultado;
			}
			else
			{
				returnList = new ArrayList<CuerpoCeleste>();
			}
			return returnList;
		}
		
		public void visitEstrellaEnana(EstrellaEnana estrella) {
			try
			{
				validarPromediotormentasAnuales(estrella.getPromedioTormentasSolares());
				validarTemperaturaEstrella(estrella.getTemperatura());
				hayEstrellaNecesariaParaVida = true;
			}catch(Exception e)
			{
			}
		}
		public void visitAsteroide(Asteroide asteroide) {
			try
			{
				validarDiametro(asteroide.getDiametro());
				validarDistanciaALaTierra(asteroide.getDistanciaTierra());
				validarPeriodoOribtal(asteroide.getPeriodoOrbital());
				validarPorcentajeElementosRadiactivos(asteroide.getPorcentajeElementosRadiactivos());
				validarAguaEnCasquetesPolares(asteroide.getPorcentajeAguaSolida());
				validarPorcentajeDeuterio(asteroide.getPorcentajeDeuterio());
				resultado.add(asteroide);
			}catch(Exception e)
			{
			}
		}

		public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
			try
			{
				validarDiametro(planetaRocoso.getDiametro());
				validarDistanciaALaTierra(planetaRocoso.getDistanciaALaTierra());
				validarPromedioOxigeno(planetaRocoso.getPorcentajeOxigeno());
				validarPeriodoOribtal(planetaRocoso.getOrbita());
				validarPorcentajeElementosRadiactivos(planetaRocoso.getPorcentajeElementosRadiactivos());
				validarPorcentajeDeAgua(planetaRocoso.getPorcentajeAgua());
				validarTipoSuelo(planetaRocoso.getTipoSuelo());
				validarTemperatura(planetaRocoso.getTemperatura());
				resultado.add(planetaRocoso);
			}catch(Exception e)
			{
			}
		}

		private void validarPorcentajeDeuterio(Float porcentajeDeuterio) throws Exception {
			if (40f > porcentajeDeuterio)
			{
				throw new Exception("No hay suficiente deuterio");
			}
		}

		private void validarAguaEnCasquetesPolares(Float porcentajeAguaSolida) throws Exception {
			if (28f > porcentajeAguaSolida)
			{
				throw new Exception("No hay suficiente agua");
			}
		}

		private void validarTemperatura(Integer temperatura) throws Exception {
			if (200> temperatura || temperatura > 600)
			{
				throw new Exception("La temperatura no es la adecuada");
			}
		}

		private void validarTipoSuelo(TipoSuelo tipoSuelo) throws Exception {
			if (!TipoSuelo.VALLE.equals(tipoSuelo) && !TipoSuelo.ESCARPADO.equals(tipoSuelo))
			{
				throw new Exception("El tipo de suelo no es el adecuado");
			}
		}

		private void validarPorcentajeDeAgua(Float porcentajeAgua) throws Exception {
			if (28f > porcentajeAgua)
			{
				throw new Exception("No hay suficiente agua");
			}
		}

		private void validarPorcentajeElementosRadiactivos(Float porcentajeElementosRadiactivos) throws Exception {
			if (30f < porcentajeElementosRadiactivos)
			{
				throw new Exception("Demasiados elementos radiactivos para la supervivencia");
			}
		}

		private void validarPeriodoOribtal(Integer orbita) throws Exception {
			if (100 > orbita  || orbita >300)
			{
				throw new Exception("La orbita no se adecua a los parametros establecidos");
			}			
		}

		private void validarPromedioOxigeno(Integer porcentajeOxigeno) throws Exception{
			if (35 > porcentajeOxigeno)
			{
				throw new Exception("No hay suficiente oxigeno");
			}		
		}

		private void validarDistanciaALaTierra(Integer distanciaALaTierra) throws Exception{
			if (30 > distanciaALaTierra)
			{
				throw new Exception("Hay demasiada distancia a la tierra");
			}	
		}

		private void validarDiametro(Float diametro) throws Exception {
			if (0.9f>diametro)
			{
				throw new Exception("El diametro no es adecuado");
			}		
		}

		private void validarTemperaturaEstrella(Float temperatura) throws Exception {
			if (5f>temperatura || temperatura>7.5f)
			{
				throw new Exception("La temperatura de la estrella no es la adecuada");
			}
		}


		private void validarPromediotormentasAnuales(Integer promedioTormentasSolares) throws Exception {
			if (10 < promedioTormentasSolares)
			{
				throw new Exception("Demasiada cantidad de tormentas solares");
			}
		}

	} //End Inner Class
	
	

}
