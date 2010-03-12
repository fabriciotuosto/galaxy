package org.galaxy.tapd.humanos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import org.apache.commons.lang.math.NumberRange;

import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;
import org.galaxy.tapd.celestialbodys.estrellas.Supernova;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso.TipoSuelo;
import org.galaxy.tapd.validation.BeanValidation;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;

public class Colonizadores extends Humanos {

    public Colonizadores() {
    }

    @Override
    public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
        return new BuscadorDestinosColonizadores();
    }

    private static class BuscadorDestinosColonizadores implements CuerpoCelesteVisitorFinder {

        private List<CuerpoCeleste> resultado = null;
        private boolean hayEstrellaNecesariaParaVida;

        public BuscadorDestinosColonizadores() {
            resultado = new ArrayList<CuerpoCeleste>();
            hayEstrellaNecesariaParaVida = false;
        }

        @Override
        public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {
        }

        @Override
        public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {
        }

        @Override
        public void visitSupernova(Supernova estrella) {
        }

        @Override
        public List<CuerpoCeleste> obtenerResultado() {
            List<CuerpoCeleste> returnList = Collections.emptyList();
            if (hayEstrellaNecesariaParaVida) {
                returnList = resultado;
            }
            return returnList;
        }

        @Override
        public void visitEstrellaEnana(EstrellaEnana estrella) {
            boolean isValid = BeanValidation.newBeanValidation(estrella).
                    validateRange("temperatura", new NumberRange(5f, 7.5f)).
                    validateMenor("promedioTormentasSolares", 10).build().
                    isValidBean();
            if (isValid) {
                hayEstrellaNecesariaParaVida = true;
            }
        }

        @Override
        public void visitAsteroide(Asteroide asteroide) {
            boolean isValid = BeanValidation.newBeanValidation(asteroide)
                    .validateRange("periodoOrbital", new NumberRange(100, 300))
                    .validateMenor("distanciaTierra", 30)
                    .validateMayor("diametro", 0.9f)
                    .validateMenor("porcentajeElementosRadiactivos", 30f)
                    .validateMayor("porcentajeAguaSolida", 28f)
                    .validateMayor("porcentajeDeuterio", 40f).
                    build().isValidBean();
            if (isValid) {
                resultado.add(asteroide);
            }
        }

        @Override
        public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
            boolean isValid = BeanValidation.newBeanValidation(planetaRocoso)
                    .validateRange("orbita", new NumberRange(100, 300))
                    .validateMenor("distanciaALaTierra", 30)
                    .validateMayor("diametro", 0.9f)
                    .validateMenor("porcentajeElementosRadiactivos", 30f)
                    .validateMayor("porcentajeAgua", 28f)
                    .validateRange("temperatura", new NumberRange(200, 600))
                    .validateMayor("porcentajeOxigeno", 35)
                    .validateEnum("tipoSuelo", EnumSet.of(TipoSuelo.VALLE,TipoSuelo.ESCARPADO))
                    .build().isValidBean();
            if (isValid) {
                resultado.add(planetaRocoso);
            }
      
        }

    } //End Inner Class
}
