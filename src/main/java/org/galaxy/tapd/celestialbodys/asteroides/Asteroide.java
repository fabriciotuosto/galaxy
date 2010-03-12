package org.galaxy.tapd.celestialbodys.asteroides;

import org.galaxy.tapd.Componente;
import org.galaxy.tapd.celestialbodys.CuerpoCeleste;
import org.galaxy.tapd.visitors.CuerpoCelesteVisitor;
import org.galaxy.tapd.visitors.Visitable;

public class Asteroide extends CuerpoCeleste implements Visitable {

    public Asteroide(Componente padre) {
        super(padre);
        if (padre == null) {
            throw new IllegalStateException("El Padre no puede ser null");
        }
        parent = padre;
    }
    private Float diametro;
    private Integer distanciaTierra;
    private Float porcentajeMetalesUtiles;
    private Float porcentajeElementosRadiactivos;
    private Integer periodoOrbital;
    private Float porcentajeDeuterio;
    private Float porcentajeAguaSolida;
    private Componente parent;

    @Override
    public void accept(CuerpoCelesteVisitor visitor) {
        visitor.visitAsteroide(this);
    }

    @Override
    public Componente getParent() {
        return parent;
    }

    public Float getDiametro() {
        return diametro;
    }

    public void setDiametro(Float diametro) {
        this.diametro = diametro;
    }

    public Integer getDistanciaTierra() {
        return distanciaTierra;
    }

    public void setDistanciaTierra(Integer distanciaTierra) {
        this.distanciaTierra = distanciaTierra;
    }

    public Integer getPeriodoOrbital() {
        return periodoOrbital;
    }

    public void setPeriodoOrbital(Integer periodoOrbital) {
        this.periodoOrbital = periodoOrbital;
    }

    public Float getPorcentajeAguaSolida() {
        return porcentajeAguaSolida;
    }

    public void setPorcentajeAguaSolida(Float porcentajeAguaSolida) {
        this.porcentajeAguaSolida = porcentajeAguaSolida;
    }

    public Float getPorcentajeDeuterio() {
        return porcentajeDeuterio;
    }

    public void setPorcentajeDeuterio(Float porcentajeDeuterio) {
        this.porcentajeDeuterio = porcentajeDeuterio;
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
}
