package org.galaxy.tapd.celestialbodys.planetas;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;

public class PlanetaRocoso extends Planeta {
	
	public PlanetaRocoso(Componente padre) {
		super(padre);
		if (padre == null)
		{
			throw new IllegalStateException("El Padre no puede ser null");
		}
		parent = padre;
	}

	public enum TipoSuelo {DESIERTO,VALLE,ESCARPADO};
	private Float porcentajeMetalesUtiles;
	private Float porcentajeElementosRadiactivos;
	private Float porcentajeAgua;
	private TipoSuelo tipoSuelo;
	private Componente parent;
	
	public void accept(CuerpoCelesteVisitor visitor) {
		visitor.vistPlanetaRocoso(this);
	}

	public Componente getParent() {
		return parent;
	}

	public Float getPorcentajeAgua() {
		return porcentajeAgua;
	}

	public void setPorcentajeAgua(Float porcentajeAgua) {
		this.porcentajeAgua = porcentajeAgua;
	}

	public Float getPorcentajeElementosRadiactivos() {
		return porcentajeElementosRadiactivos;
	}

	public void setPorcentajeElementosRadiactivos(
			Float porcentajeElementosRadiactivos) {
		this.porcentajeElementosRadiactivos = porcentajeElementosRadiactivos;
	}

	public Float getPorcentajeMetalesUtiles() {
		return porcentajeMetalesUtiles;
	}

	public void setPorcentajeMetalesUtiles(Float porcentajeMetalesUtiles) {
		this.porcentajeMetalesUtiles = porcentajeMetalesUtiles;
	}

	public TipoSuelo getTipoSuelo() {
		return tipoSuelo;
	}

	public void setTipoSuelo(TipoSuelo tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}
}
