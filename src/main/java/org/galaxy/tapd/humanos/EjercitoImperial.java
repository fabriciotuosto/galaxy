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
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;

public class EjercitoImperial extends Humanos {

	
	public EjercitoImperial() {
	}
	
	@Override
	public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
		return new BuscadorDestinosEjercitoImperial();
	}
	
	private static class BuscadorDestinosEjercitoImperial implements CuerpoCelesteVisitorFinder
	{
		public boolean existeEstrella = false;
		private List<CuerpoCeleste> resultado = null;
		
		public BuscadorDestinosEjercitoImperial() {
			existeEstrella = false;
			resultado = new ArrayList<CuerpoCeleste>();
		}
		
		public void visitEstrellaEnana(EstrellaEnana estrella) {}
		public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {}
		public void visitSupernova(Supernova estrella) {
			try
			{
				validarPromedioTormetnasSolares(estrella.getPromedioTormentasSolares());
				validarDistanciaCentroGalaxia(estrella.getDistanciaAlCentroDeGalaxia());
				existeEstrella = true;
			}catch(Exception e)
			{
			}
		}

		public void visitAsteroide(Asteroide asteroide) {
			try
			{
				validarPorcentajeElementosRadiactivos(asteroide.getPorcentajeElementosRadiactivos());
				resultado.add(asteroide);
			}catch(Exception e)
			{
			}
		}
		
		public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {
			try
			{
				validarPorcentajeDeuterio(planetaGaseoso.getDeuterioEnAtmosfera());
				validarPromedioHuracanes(planetaGaseoso.getPromedioHuracanesAlAno());
				resultado.add(planetaGaseoso);
			}catch(Exception e)
			{		
			}
		}
		
		private void validarPromedioHuracanes(Integer promedioHuracanesAlAno) throws Exception {
			if (10 > promedioHuracanesAlAno)
			{
				throw new Exception("Demasiada Cantidad de Huracanes al a�os");
			}
		}
		
		private void validarPorcentajeDeuterio(Float porcentajeDeuterio) throws Exception {
			if (30 > porcentajeDeuterio)
			{
				throw new Exception("No hay suficiente porcenaje de deuterio");
			}
		}
		
		public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
			try
			{
				validarPorcentajeElementosRadiactivos(planetaRocoso.getPorcentajeElementosRadiactivos());
				validarTemperatura(planetaRocoso.getTemperatura(), 800);
				resultado.add(planetaRocoso);
			}catch(Exception e)
			{
			}
		}
		
		private void validarTemperatura(Integer temperatura, int i) throws Exception {
			if (i < temperatura)
			{
				throw new Exception("Temperatura inadecuada");
			}
		}
		private void validarPorcentajeElementosRadiactivos(Float porcentajeElementosRadiactivos) throws Exception {
			if (20 < porcentajeElementosRadiactivos)
			{
				throw new Exception("Elementos radiactivos demasiados o insuficientes");
			}
		}
		
		private void validarDistanciaCentroGalaxia(Integer distanciaAlCentroDeGalaxia) throws Exception {
			if (40 < distanciaAlCentroDeGalaxia)
			{
				throw new Exception("La distancia al centro de la galaxia no es la adecuada");
			}
		}

		private void validarPromedioTormetnasSolares(Integer promedioTormentasSolares) throws Exception {
			if (30 < promedioTormentasSolares)
			{
				throw new Exception("La cantidad de tormentas solares en 10 a�os no es la correcta");
			}
		}
		
		public List<CuerpoCeleste> obtenerResultado() {
			List<CuerpoCeleste> returnList = null;
			if (existeEstrella)
			{
				returnList = resultado;
				
			}
			else
			{
				returnList = new ArrayList<CuerpoCeleste>();
			}
			return returnList;
		}
	
	}
}
