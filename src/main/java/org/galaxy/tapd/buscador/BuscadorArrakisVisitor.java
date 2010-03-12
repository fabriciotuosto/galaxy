package org.galaxy.tapd.buscador;

import java.util.ArrayList;
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

public class BuscadorArrakisVisitor implements CuerpoCelesteVisitorFinder {

    private List<CuerpoCeleste> resultado = null;

    public BuscadorArrakisVisitor() {
        resultado = new ArrayList<CuerpoCeleste>();
    }

    @Override
    public void visitAsteroide(Asteroide asteroide) {
    }

    @Override
    public void visitEstrellaEnana(EstrellaEnana estrella) {
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
    public void vistPlanetaRocoso(PlanetaRocoso planetaRocoso) {
        boolean isValid = BeanValidation.newBeanValidation(planetaRocoso)
                .validateEnum("tipoSuelo", EnumSet.of(TipoSuelo.DESIERTO))
                .validateMayor("porcentajeAgua", 3f)
                .validateRange("temperatura", new NumberRange(313, 333))
                .build().isValidBean();
        if (isValid) {
            resultado.add(planetaRocoso);
        }
    }

    @Override
    public List<CuerpoCeleste> obtenerResultado() {
        return resultado;
    }
}
