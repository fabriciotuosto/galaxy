package org.galaxy.tapd.celestialbodys.planetas;



import org.galaxy.tapd.Componente;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;

public class PlanetaGaseoso extends Planeta{

	private Componente parent;

	public PlanetaGaseoso(Componente padre) {
		super(padre);
		if (padre == null)
		{
			throw new IllegalStateException("El Padre no puede ser null");
		}
		parent = padre;
	}

	private Float densidadGases;
	private Integer promedioHuracanesAlAno;
	private Float deuterioEnAtmosfera;
	
	public void accept(CuerpoCelesteVisitor visitor) {
		visitor.visitPlanetaGaseoso(this);
	}

	public Componente getParent() {
		return parent;
	}
	
	public Float getDensidadGases() {
		return densidadGases;
	}

	public void setDensidadGases(Float densidadGases) {
		this.densidadGases = densidadGases;
	}

	public Float getDeuterioEnAtmosfera() {
		return deuterioEnAtmosfera;
	}

	public void setDeuterioEnAtmosfera(Float deuterioEnAtmosfera) {
		this.deuterioEnAtmosfera = deuterioEnAtmosfera;
	}

	public Integer getPromedioHuracanesAlAno() {
		return promedioHuracanesAlAno;
	}

	public void setPromedioHuracanesAlAno(Integer promedioHuracanesAlAno) {
		this.promedioHuracanesAlAno = promedioHuracanesAlAno;
	}
}
