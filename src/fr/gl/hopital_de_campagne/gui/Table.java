package fr.gl.hopital_de_campagne.gui;

import java.util.List;

import javax.swing.JPanel;

public abstract class Table {
	
	public Table(DisplayableClass o) {
		
	}
	
	public abstract JPanel getTable();
	
	public abstract int getIndexOfSelectedRow();
	
	public abstract List<Object> getValuesOfRow(int rowIndex);

}
