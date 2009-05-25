package org.galaxy.tapd.celestialbodys.estrellas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;

public class EstrellaEnana extends Estrella {

	private Componente parent;

	public EstrellaEnana(Componente padre) {
		super(padre);
		if (padre == null)
		{
			throw new IllegalStateException("El Padre no puede ser null");
		}
		parent = padre;
	}

	public void accept(CuerpoCelesteVisitor visitor) {
		visitor.visitEstrellaEnana(this);
	}

	public Componente getParent() {
		return parent;
	}
}
