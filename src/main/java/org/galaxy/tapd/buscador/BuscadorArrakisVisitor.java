package org.galaxy.tapd.buscador;

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

	public class BuscadorArrakisVisitor implements CuerpoCelesteVisitorFinder
	{
		private List<CuerpoCeleste> resultado = null;
		
		public BuscadorArrakisVisitor() {
			resultado = new ArrayList<CuerpoCeleste>();
		}
		
		public void visitAsteroide(Asteroide asteroide) {}
		public void visitEstrellaEnana(EstrellaEnana estrella) {}
		public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {}
		public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {}
		public void visitSupernova(Supernova estrella) {}
		
		public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso)
		{
			try{
				validarTipoTerreno(planetaRocoso.getTipoSuelo());
				validarPorcentajeAguaEnAtmosfera(planetaRocoso.getPorcentajeAgua());
				validarTemperatura(planetaRocoso.getTemperatura());
				resultado.add(planetaRocoso);
			}catch (Exception e) {
			}
		}
		
		
		private void validarTemperatura(Integer temperatura) throws Exception{
			if (313 < temperatura || temperatura > 333)
			{
				throw new Exception("La temperatura no es la correspondienta a Arrakis");
			}
		}
		
		private void validarPorcentajeAguaEnAtmosfera(Float porcentajeAgua) throws Exception {
			if (3f>=porcentajeAgua)
			{
				throw new Exception("El porcentaje de agua no es el correspondienta a Arrakis");
			}
		}
		
		
		private void validarTipoTerreno(TipoSuelo tipoSuelo) throws Exception{
			if (!TipoSuelo.DESIERTO.equals(tipoSuelo))
			{
				throw new Exception("El tipo de suelo no es el correspondiente a Arrakis");
			}	
		}
		public List<CuerpoCeleste> obtenerResultado() {
			return resultado;
		}
	}