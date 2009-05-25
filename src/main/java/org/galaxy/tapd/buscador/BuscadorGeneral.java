package org.galaxy.tapd.buscador;

import java.util.ArrayList;
import java.util.List;

import org.galaxy.tapd.Galaxia;
import org.galaxy.tapd.SistemaSolar;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.humanos.Humanos;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitorFinder;
import org.galaxy.tapd.visitors.Visitable;

public class BuscadorGeneral {
	
	public BuscadorGeneral() {
	}
	
	/**
	 * Busca algun cuerpo celeste en particular en toda la galaxia
	 * @param galaxia
	 * @param visitor
	 * @return
	 */
	public List<CuerpoCeleste> obtenerBusqueda(Galaxia galaxia,CuerpoCelesteVisitorFinder visitor)
	{
		for (SistemaSolar sistemaSolar : galaxia.getSistemaSolares())
		{
			for (Visitable visitable : sistemaSolar.getCuerposCelestes())
			{
				visitable.accept(visitor);
			}
		}
		return visitor.obtenerResultado();
	}

	/**
	 * Busca cuerpos celeste que cumplen con ciertas condiciones en 
	 * los Sistemas Solares en particular
	 * @param galaxia
	 * @param humanos
	 * @return
	 */
	public List<CuerpoCeleste> obtenerBusqueda(Galaxia galaxia,Humanos humanos)
	{
		List<CuerpoCeleste> resultList = new ArrayList<CuerpoCeleste>();
		CuerpoCelesteVisitorFinder visitor = null;
		for (SistemaSolar sistemaSolar : galaxia.getSistemaSolares())
		{
			visitor = humanos.getBuscadorDestinosEnGalaxia();
			for (Visitable visitable : sistemaSolar.getCuerposCelestes())
			{
				visitable.accept(visitor);
			}
			resultList.addAll(visitor.obtenerResultado());
		}
		return resultList;
	}
}
