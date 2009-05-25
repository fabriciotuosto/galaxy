package org.galaxy.tapd.celestialbodys.estrellas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.visitors.Visitable;

public abstract class Estrella extends CuerpoCeleste implements Visitable{
	public Estrella(Componente padre) {
		super(padre);
	}

	private Float diametro;
	private Float temperatura;
	private Integer promedioTormentasSolares;
	private Integer distanciaAlCentroDeGalaxia;
	
	public float getDiametro() {
		return diametro;
	}
	
	public void setDiametro(float diametro) {
		this.diametro = diametro;
	}
	
	public Integer getDistanciaAlCentroDeGalaxia() {
		return distanciaAlCentroDeGalaxia;
	}
	
	public void setDistanciaAlCentroDeGalaxia(Integer distanciaAlCentroDeGalaxia) {
		this.distanciaAlCentroDeGalaxia = distanciaAlCentroDeGalaxia;
	}
	
	public Integer getPromedioTormentasSolares() {
		return promedioTormentasSolares;
	}
	
	public void setPromedioTormentasSolares(Integer promedioTormentasSolares) {
		this.promedioTormentasSolares = promedioTormentasSolares;
	}
	
	public float getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
}
