package fr.gl.hopital_de_campagne.gui;

import javax.swing.table.AbstractTableModel;

/**
 * Contient les informations a afficher dans nos tableaux. Permet de gerer
 * le comportement des cellules du tableau.
 * @author bruno
 *
 */
public class MyTableModel extends AbstractTableModel {
	
	Object[][] data;
	String[] columnNames;
	
	public MyTableModel(Object[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
	}

	@Override
	public int getColumnCount() {
		if(data == null) return 0;
		if(data[0] == null) return 0;
		return data[0].length;
	}

	@Override
	public int getRowCount() {
		if(data == null) return 0;
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public String getColumnName(int col) {
        return columnNames[col].toString();
    }

}
