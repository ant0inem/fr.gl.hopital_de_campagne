package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;

public interface Table {
	
	public abstract DisplayableClass getElement(int i);
	
	public abstract void setElement(int i, DisplayableClass o);
	
	public abstract JPanel getTable();

	public abstract JPanel createTable(DisplayableClass[] s);

}
