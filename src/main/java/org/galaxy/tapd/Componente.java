package org.galaxy.tapd;

public interface Componente {
	static final String END= System.getProperty("line.separator");
	static final String TAB = "\t";
	public Componente getParent();
	public String getNombre();
}
