package org.galaxy.tapd.celestialbodys.planetas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.visitors.Visitable;

public abstract class Planeta extends CuerpoCeleste implements Visitable{

	public Planeta(Componente padre) {
		super(padre);
	}
	private Float  diametro;
	private Integer distanciaALaTierra;
	private Float distanciaEstrellaMasCercana;
	private Integer temperatura;
	private Integer porcentajeOxigeno;
	private Integer orbita;
	
	public Float getDiametro() {
		return diametro;
	}
	public void setDiametro(Float diametro) {
		this.diametro = diametro;
	}
	public Integer getDistanciaALaTierra() {
		return distanciaALaTierra;
	}
	public void setDistanciaALaTierra(Integer distanciaALaTierra) {
		this.distanciaALaTierra = distanciaALaTierra;
	}
	public Float getDistanciaEstrellaMasCercana() {
		return distanciaEstrellaMasCercana;
	}
	public void setDistanciaEstrellaMasCercana(Float distanciaEstrellaMasCercana) {
		this.distanciaEstrellaMasCercana = distanciaEstrellaMasCercana;
	}
	public Integer getOrbita() {
		return orbita;
	}
	public void setOrbita(Integer orbita) {
		this.orbita = orbita;
	}
	public Integer getPorcentajeOxigeno() {
		return porcentajeOxigeno;
	}
	public void setPorcentajeOxigeno(Integer porcentajeOxigeno) {
		this.porcentajeOxigeno = porcentajeOxigeno;
	}
	public Integer getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
}
