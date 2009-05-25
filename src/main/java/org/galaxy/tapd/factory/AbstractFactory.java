package org.galaxy.tapd.factory;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;

public abstract class AbstractFactory {
	public abstract CuerpoCeleste getProduct(Componente parent);
}
