package fr.gl.hopital_de_campagne.gui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MyTable extends JPanel implements Table {
	
	private JTable jTable;
	private ArrayList<DisplayableClass> elements;
	
	public MyTable(DisplayableClass o) {
		String[] columnNames = new String[o.getNbAttribut()];
		for(int i = 0; i<o.getNbAttribut(); i++) columnNames[i] = o.getAttributName(i);
		Object[][] data = new Object[o.getNbElement()][o.getNbAttribut()];
		for(int i = 0; i<o.getNbElement(); i++){
			for(int j = 0; j<o.getNbAttribut(); j++){
				data[i][j]=o.getAttribut(i, j);
			}
		}
		jTable = new JTable(data, columnNames);
		elements = new ArrayList<>();
	}

	@Override
	public DisplayableClass getElement(int i) throws IndexOutOfBoundsException {
		return elements.get(i);
	}

	@Override
	public void setElement(int i, DisplayableClass o) {
		elements.set(i, o);

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
