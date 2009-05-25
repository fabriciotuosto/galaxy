package org.galaxy.tapd.visitors;

import org.galaxy.tapd.celestialbodys.asteroides.Asteroide;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnana;
import org.galaxy.tapd.celestialbodys.estrellas.EstrellaEnanaBlanca;
import org.galaxy.tapd.celestialbodys.estrellas.Supernova;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaGaseoso;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso;

public interface CuerpoCelesteVisitor {

	void visitAsteroide(Asteroide asteroide);
	void vistPlanetaRocoso(PlanetaRocoso planetaRocoso);
	void visitPlanetaGaseoso(PlanetaGaseoso planetaGaseoso);
	void visitEstrellaEnanaBlanca(EstrellaEnanaBlanca estrella);
	void visitEstrellaEnana(EstrellaEnana estrella);
	void visitSupernova(Supernova estrella);
}
