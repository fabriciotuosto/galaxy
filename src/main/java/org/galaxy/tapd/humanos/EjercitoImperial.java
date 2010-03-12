package org.galaxy.tapd.humanos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;
import org.galaxy.tapd.celestialbodys.estrellas.Supernova;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;
import org.galaxy.tapd.validation.BeanValidation;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;

public class EjercitoImperial extends Humanos {

    public EjercitoImperial() {
    }

    @Override
    public CuerpoCelesteVisitorFinder getBuscadorDestinosEnGalaxia() {
        return new BuscadorDestinosEjercitoImperial();
    }

    private static class BuscadorDestinosEjercitoImperial implements CuerpoCelesteVisitorFinder {

        public boolean existeEstrella = false;
        private List<CuerpoCeleste> resultado = null;

        public BuscadorDestinosEjercitoImperial() {
            existeEstrella = false;
            resultado = new ArrayList<CuerpoCeleste>();
        }

        @Override
        public void visitEstrellaEnana(EstrellaEnana estrella) {
        }

        @Override
        public void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella) {
        }

        @Override
        public void visitSupernova(Supernova estrella) {
            boolean isValid = BeanValidation.newBeanValidation(estrella).
                    validateMenor("promedioTormentasSolares", 30).validateMenor("distanciaAlCentroDeGalaxia", 40).
                    build().isValidBean();
            if (isValid) {
                existeEstrella = true;
            }
        }

        @Override
        public void visitAsteroide(Asteroide asteroide) {
            boolean isValid = BeanValidation.newBeanValidation(asteroide).
                    validateMenor("porcentajeElementosRadiactivos", 20f).build().
                    isValidBean();
            if (isValid) {
                resultado.add(asteroide);
            }
        }

        @Override
        public void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso) {
            boolean isValid = BeanValidation.newBeanValidation(planetaGaseoso).
                    validateMenor("deuterioEnAtmosfera", 30f).validateMenor("promedioHuracanasAlAno", 10).
                    build().isValidBean();

            if (isValid) {
                resultado.add(planetaGaseoso);
            }
        }

        @Override
        public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
            boolean isValid = BeanValidation.newBeanValidation(planetaRocoso).
                    validateMenor("temperatura", 800).validateMenor("porcentajeElementosRadiactivos", 20).
                    build().isValidBean();
            if (isValid) {
                resultado.add(planetaRocoso);
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
