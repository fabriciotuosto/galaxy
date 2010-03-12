package org.galaxy.tapd.humanos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.math.NumberRange;

import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;
import org.galaxy.tapd.celestialbodys.estrellas.Supernova;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;
import org.galaxy.tapd.validation.BeanValidation;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;

public class Industriales extends Humanos {

    public Industriales() {
    }

    @Override
    public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
        return new BuscadorDestinosIndustriales();
    }

    private static class BuscadorDestinosIndustriales implements CuerpoCelesteVisitorFinder {

        public boolean existeEstrella = false;
        private List<CuerpoCeleste> resultado = null;

        public BuscadorDestinosIndustriales() {
            existeEstrella = false;
            resultado = new ArrayList<CuerpoCeleste>();
        }

        @Override
        public void visitEstrellaEnana(EstrellaEnana estrella) {
            boolean isValid = BeanValidation.newBeanValidation(estrella).
                    validateMenor("distanciaAlCentroDeGalaxia", 50).build().
                    isValidBean();
            if (isValid) {
                existeEstrella = true;
            }
        }

        @Override
        public void visitSupernova(Supernova estrella) {
            boolean isValid = BeanValidation.newBeanValidation(estrella).
                    validateMenor("distanciaAlCentroDeGalaxia", 50).build().
                    isValidBean();
            if (isValid) {
                existeEstrella = true;
            }
        }

        @Override
        public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {
            boolean isValid = BeanValidation.newBeanValidation(estrella).
                    validateMenor("distanciaAlCentroDeGalaxia", 50).build().
                    isValidBean();
            if (isValid) {
                existeEstrella = true;
            }
        }

        @Override
        public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
            boolean isValid = BeanValidation.newBeanValidation(planetaRocoso).
                    validateMenor("temperatura", 1200).validateRange("porcentajeElementosRadiactivos", new NumberRange(20f, 60f)).
                    validateMayor("porcentajeMetalesUtiles", 20f).build().
                    isValidBean();
            if (isValid) {
                resultado.add(planetaRocoso);
            }
        }

        @Override
        public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {
            boolean isValid = BeanValidation.newBeanValidation(planetaGaseoso).
                    validateMenor("temperatura", 1300).validateMenor("porcentajeDeuterioEnAtmosfera", 35f).
                    validateMayor("densidadGases", 15f).validateMenor("promedioHuracanesAlAno", 100).
                    build().isValidBean();
            if (isValid) {
                resultado.add(planetaGaseoso);
            }
        }

        @Override
        public void visitAsteroide(Asteroide asteroide) {
            boolean isValid = BeanValidation.newBeanValidation(asteroide).
                    validateMenor("porcentajeDeuterio", 35f).validateRange("porcentajeElementosRadiactivos", new NumberRange(20f, 60f)).
                    validateMayor("porcentajeMetalesUtiles", 20f).build().
                    isValidBean();
            if (isValid) {
                resultado.add(asteroide);
            }
        }

        @Override
        public List<CuerpoCeleste> obtenerResultado() {
            List<CuerpoCeleste> returnList = Collections.emptyList();
            if (existeEstrella) {
                returnList = resultado;
            }
            return returnList;
        }
    }
}
