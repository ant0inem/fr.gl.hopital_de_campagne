package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MyTable extends  Table {
	
	private JTable jTable;
	
	public MyTable(DisplayableClass o) {
		super(o);
		String[] columnNames = new String[o.getNbAttribut()];
		for(int i = 0; i<o.getNbAttribut(); i++) columnNames[i] = o.getAttributName(i);
		Object[][] data = new Object[o.getNbElement()][o.getNbAttribut()];
		for(int i = 0; i<o.getNbElement(); i++){
			for(int j = 0; j<o.getNbAttribut(); j++){
				data[i][j]=o.getAttribut(i, j);
			}
		}
		jTable = new JTable(data, columnNames);
	}


	@Override
	public JPanel getTable() {
		JPanel p = new JPanel();
		p.add(new JScrollPane(jTable));
		return p;
	}

}
