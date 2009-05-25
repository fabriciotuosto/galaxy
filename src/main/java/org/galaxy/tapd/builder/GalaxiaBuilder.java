package org.galaxy.tapd.builder;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.Galaxia;
import org.galaxy.tapd.SistemaSolar;

public class GalaxiaBuilder extends AbstractBuilder {

	@Override
	public Galaxia build(Componente parent) {
		Galaxia galaxia = new Galaxia("Via Lactea");
		
		galaxia.addSistemaSolar(crearSistemaSolar("Alpha Centauri",galaxia));
		galaxia.addSistemaSolar(crearSistemaSolar("Cinturon de Orion",galaxia));
		galaxia.addSistemaSolar(crearSistemaSolar("Helion Prime",galaxia));
		return galaxia;
	}
	private SistemaSolar crearSistemaSolar(String string,Componente galaxia) {
		SistemaSolarBuilder builder = new SistemaSolarBuilder();
		SistemaSolar solar = builder.build(galaxia);
		solar.setNombre(string);
		return solar;
	}

}
