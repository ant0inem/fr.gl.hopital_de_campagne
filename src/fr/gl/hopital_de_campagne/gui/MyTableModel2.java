package fr.gl.hopital_de_campagne.gui;

import javax.swing.table.AbstractTableModel;

/**
 * Contient les informations a afficher dans nos tableaux. Permet de gerer
 * le comportement des cellules du tableau.
 * @author bruno
 *
 */
public class MyTableModel2 extends AbstractTableModel {
	
	private DisplayableClass dc;
	
	public MyTableModel2(DisplayableClass dc) {
		setDc(dc);
	}

	public DisplayableClass getDc() {
		return dc;
	}

	public void setDc(DisplayableClass dc) {
		this.dc = dc;
	}

	@Override
	public int getColumnCount() {
		return getDc().getNbAttribut();
	}

	@Override
	public int getRowCount() {
		return getDc().getNbElement();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getDc().getAttribut(rowIndex, columnIndex);
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public String getColumnName(int col) {
        return getDc().getAttributName(col);
    }

}
