package org.galaxy.tapd;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.galaxy.tapd.buscador.BuscadorArrakisVisitor;
import org.galaxy.tapd.buscador.BuscadorGeneral;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.humanos.Humanos;

public class Galaxia implements Componente{

	private List<SistemaSolar> sistemas;
	private String nombre;
	
	public Galaxia(String nombre) {
		this.nombre = nombre;
		sistemas = new ArrayList<SistemaSolar>();
	}
	
	public void addSistemaSolar (SistemaSolar sistema)
	{
		sistemas.add(sistema);
	}
	
	public List<SistemaSolar> getSistemaSolares()
	{
		return sistemas;
	}
	
	public List<CuerpoCeleste> obtenerPosibleArrakist(){
		BuscadorGeneral buscadorArrakis = new BuscadorGeneral();
		return buscadorArrakis.obtenerBusqueda(this,new BuscadorArrakisVisitor());
	}
	
	public List<CuerpoCeleste> obtenerPosiblesDestinos(Humanos humanos){
		BuscadorGeneral buscador = new BuscadorGeneral();
		return buscador.obtenerBusqueda(this,humanos);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNombre());
		sb.append(END);
		sb.append(END);
		for (SistemaSolar sis : sistemas)
		{
			sb.append(TAB);
			sb.append((sis.toString()));
			sb.append(END);
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(sistemas);
		return builder.hashCode();
	}

	public Componente getParent() {
		return null;
	}

	public String getNombre() {
		return nombre;
	}
}
