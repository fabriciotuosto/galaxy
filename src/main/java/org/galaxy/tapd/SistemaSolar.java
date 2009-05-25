package org.galaxy.tapd;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;

public class SistemaSolar implements Componente{

	private String nombre;
	private List<CuerpoCeleste> celestialBodys;
	private Componente parent;
	
	public SistemaSolar(Componente parent2) {
		super();
		this.parent = parent2;
		celestialBodys = new ArrayList<CuerpoCeleste>();
	}

	public void addCelestialBody(CuerpoCeleste celestial)
	{
		celestialBodys.add(celestial);
	}
	
	public List<CuerpoCeleste> getCuerposCelestes()
	{
		return celestialBodys;
	}
	public Componente getParent(){
		return parent;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre());
		sb.append(END);
		for (Componente bodys : celestialBodys)
		{
			sb.append(TAB);
			sb.append(TAB);
			sb.append(bodys.getNombre());
			sb.append(END);
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(celestialBodys);
		builder.append(nombre);
		return builder.hashCode();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String string) {
		this.nombre = string;
	}
}
