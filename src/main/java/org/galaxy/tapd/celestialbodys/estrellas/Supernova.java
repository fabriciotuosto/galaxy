package org.galaxy.tapd.celestialbodys.estrellas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;

public class Supernova extends Estrella implements EstacionSolarInstalable{

	private Componente parent;

	public Supernova(Componente padre) {
		super(padre);
		if (padre == null)
		{
			throw new IllegalStateException("El Padre no puede ser null");
		}
		parent = padre;
	}

	public void accept(CuerpoCelesteVisitor visitor) {
		visitor.visitSupernova(this);
	}

	public Componente getParent() {
		return parent;
	}

	public void instalrEstacionSolar() {
		// TODO Auto-generated method stub		
	}
}
