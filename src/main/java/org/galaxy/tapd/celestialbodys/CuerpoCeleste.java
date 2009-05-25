package org.galaxy.tapd.celestialbodys;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.Visitable;

public abstract class CuerpoCeleste implements Componente,Visitable{
	
	public CuerpoCeleste(Componente padre)
	{
		super();	
	}
	
	@Override
	public String toString()
	{
		Componente galaxia = getParent().getParent();		
		return galaxia.toString();
	}
	
	public String getNombre()
	{
		return getClass().getSimpleName()+hashCode();	
	}
	
}
