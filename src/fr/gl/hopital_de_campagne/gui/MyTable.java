package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import fr.gl.hopital_de_campagne.metier.DisplayableClass;

public class MyTable extends  Table {
	
	private JTable jTable;
	private TableModel tableModel;
	private JScrollPane s;
	
	public MyTable(DisplayableClass o, ListSelectionListener l) {
		super(o);
		/*String[] columnNames = new String[o.getNbAttribut()];
		for(int i = 0; i<o.getNbAttribut(); i++) columnNames[i] = o.getAttributName(i);
		Object[][] data = new Object[o.getNbElement()][o.getNbAttribut()];
		for(int i = 0; i<o.getNbElement(); i++){
			for(int j = 0; j<o.getNbAttribut(); j++){
				data[i][j]=o.getAttribut(i, j);
			}
		}
		jTable = new JTable(new MyTableModel(data, columnNames));
		*/
		tableModel = new MyTableModel(o);
		jTable = new JTable(tableModel);
		jTable.getSelectionModel().addListSelectionListener(l);

	}


	@Override
	public JPanel getTable() {
		JPanel p = new JPanel(new BorderLayout());
		s = new JScrollPane(jTable);
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true);
		jTable.setColumnSelectionAllowed(false);
		p.add(s, BorderLayout.CENTER);
		return p;
	}


	@Override
	public int getIndexOfSelectedRow() {
		return jTable.getSelectedRow();
	}


	@Override
	public List<Object> getValuesOfRow(int rowIndex) {
		List<Object> listOfObject = new ArrayList<Object>();
		for(int i=0; i<tableModel.getColumnCount(); i++) {
			listOfObject.add(tableModel.getValueAt(rowIndex, i));
		}
		return listOfObject;
	}


	@Override
	public void setSelectedRow(int rowIndex) {
		jTable.setRowSelectionInterval(rowIndex, rowIndex);
		
	}
	
	public void revalidate() {
		SwingUtilities.updateComponentTreeUI(s);
	}

}
