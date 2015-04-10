package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MyTable extends  Table {
	
	private JTable jTable;
	
	public MyTable(DisplayableClass o) {
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
		jTable = new JTable(new MyTableModel2(o));

	}


	@Override
	public JPanel getTable() {
		JPanel p = new JPanel(new BorderLayout());
		JScrollPane s = new JScrollPane(jTable);
		jTable.setFillsViewportHeight(true);
		jTable.setRowSelectionAllowed(true);
		jTable.setColumnSelectionAllowed(false);
		p.add(s, BorderLayout.CENTER);
		return p;
	}

}
