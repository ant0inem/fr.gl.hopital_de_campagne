package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MyTable extends JPanel implements Table {
	
	private JTable jTable;
	
	public MyTable() {
		jTable = new JTable();
	}

	@Override
	public DisplayableClass getElement(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElement(int i, DisplayableClass o) {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel getTable() {
		JPanel p = new JPanel();
		p.add(new JScrollPane(jTable));
		return p;
	}

	@Override
	public JPanel createTable(DisplayableClass[] s) {
		// TODO Auto-generated method stub
		return null;
	}

}
