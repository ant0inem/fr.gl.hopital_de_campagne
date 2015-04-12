package fr.gl.hopital_de_campagne.gui;

import java.util.List;

import javax.swing.JPanel;

public abstract class Table {
	
	public Table(DisplayableClass o) {
		
	}
	
	/**
	 * Returns the JPanel which contains the table.
	 * @return the JPanel
	 */
	public abstract JPanel getTable();
	
	/**
	 * Returns the index of the first selected row, 
	 * -1 if no row is selected.
	 * @return the index of the first selected row
	 */
	public abstract int getIndexOfSelectedRow();
	
	/**
	 * 
	 * @param rowIndex index of a row
	 * @return the list of object which represent the specify row
	 */
	public abstract List<Object> getValuesOfRow(int rowIndex);
	
	/**
	 * 
	 * @param rowIndex index of a row
	 */
	public abstract void setSelectedRow(int rowIndex);

}
