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

public class Industriales extends Humanos {
	
	public Industriales() {

	}
	
	@Override
	public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
		return new BuscadorDestinosIndustriales();
	}
	
	private static class BuscadorDestinosIndustriales implements CuerpoCelesteVisitorFinder
	{
		public boolean existeEstrella = false;
		private List<CuerpoCeleste> resultado = null;

		public BuscadorDestinosIndustriales() {
			existeEstrella = false;
			resultado = new ArrayList<CuerpoCeleste>();
		}

		public void visitEstrellaEnana(EstrellaEnana estrella) {
			try
			{
				validarDistanciaCentroGalaxia(estrella.getDistanciaAlCentroDeGalaxia());
				existeEstrella = true;
			}catch(Exception e)
			{
			}
		}
		
		public void visitSupernova(Supernova estrella) {
			try
			{
				validarDistanciaCentroGalaxia(estrella.getDistanciaAlCentroDeGalaxia());
				existeEstrella = true;
			}catch(Exception e)
			{
			}
		}
		
		public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {
			try
			{
				validarDistanciaCentroGalaxia(estrella.getDistanciaAlCentroDeGalaxia());
				existeEstrella = true;
			}catch(Exception e)
			{
			}
		}


		public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
			try
			{
				validarTemperatura(planetaRocoso.getTemperatura(),1200);
				validarPorcentajeElementosRadiactivos(planetaRocoso.getPorcentajeElementosRadiactivos());
				validarPorcentajeMetalesUtiles(planetaRocoso.getPorcentajeMetalesUtiles());
				resultado.add(planetaRocoso);
			}catch(Exception e)
			{
			}
		}

		public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {
			try
			{
				validarTemperatura(planetaGaseoso.getTemperatura(),1300);
				validarPorcentajeDeuterio(planetaGaseoso.getDeuterioEnAtmosfera());
				validarPromedioGases(planetaGaseoso.getDensidadGases());
				validarPromedioHuracanes(planetaGaseoso.getPromedioHuracanesAlAno());
				resultado.add(planetaGaseoso);
			}catch(Exception e)
			{		
			}
		}
		

		public void visitAsteroide(Asteroide asteroide) {
			try
			{
				validarPorcentajeElementosRadiactivos(asteroide.getPorcentajeElementosRadiactivos());
				validarPorcentajeMetalesUtiles(asteroide.getPorcentajeMetalesUtiles());
				validarPorcentajeDeuterio(asteroide.getPorcentajeDeuterio());
				resultado.add(asteroide);
			}catch(Exception e)
			{			
			}
		}
		
		private void validarPromedioHuracanes(Integer promedioHuracanesAlAno) throws Exception {
			if (100 < promedioHuracanesAlAno)
			{
				throw new Exception("Demasiada Cantidad de Huracanes al a�os");
			}
		}

		private void validarPromedioGases(Float densidadGases) throws Exception {
			if (15f > densidadGases)
			{
				throw new Exception("No hay suficiente densidad de gases");
			}
		}

		private void validarPorcentajeDeuterio(Float porcentajeDeuterio) throws Exception {
			if (35 > porcentajeDeuterio)
			{
				throw new Exception("No hay suficiente porcenaje de deuterio");
			}
		}

		private void validarPorcentajeMetalesUtiles(Float porcentajeMetalesUtiles) throws Exception {
			if (20 > porcentajeMetalesUtiles)
			{
				throw new Exception("No hay suficiente metales utiles");
			}
		}
		
		private void validarPorcentajeElementosRadiactivos(Float porcentajeElementosRadiactivos) throws Exception {
			if (20f > porcentajeElementosRadiactivos || 60f < porcentajeElementosRadiactivos)
			{
				throw new Exception("Elementos radiactivos demasiados o insuficientes");
			}
		}

		private void validarTemperatura(Integer temperatura, int i) throws Exception {
			if (i < temperatura)
			{
				throw new Exception("Temperatura inadecuada");
			}
		}
		
		private void validarDistanciaCentroGalaxia(Integer distanciaAlCentroDeGalaxia) throws Exception {
			if (50 < distanciaAlCentroDeGalaxia)
			{
				throw new Exception("No se encuentra a una distancia adecuada");
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
