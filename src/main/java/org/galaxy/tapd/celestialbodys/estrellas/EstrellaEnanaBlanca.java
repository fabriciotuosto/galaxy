package org.galaxy.tapd.celestialbodys.estrellas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;

public class EstrellaEnanaBlanca extends Estrella implements EstacionSolarInstalable{

	private Componente parent;

	public EstrellaEnanaBlanca(Componente padre) {
		super(padre);
		if (padre == null)
		{
			throw new IllegalStateException("El Padre no puede ser null");
		}
		parent = padre;
	}

	public void accept(CuerpoCelesteVisitor visitor) {
		visitor.visitEstrellaEnanaBlanca(this);
	}

	public Componente getParent() {
		return parent;
	}

	public void instalrEstacionSolar() {
		// TODO Auto-generated method stub		
	}
}
