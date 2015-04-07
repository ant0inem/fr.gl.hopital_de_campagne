package fr.gl.hopital_de_campagne.test;

import fr.gl.hopital_de_campagne.gui.DisplayableClass;

public class SampleDisplayableClass implements DisplayableClass {

	String[] columnNames = {"Column 1", "Column 2", "Column 3", "Column 4"};
	Object[][] data = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
	
	@Override
	public int getNbAttribut() {
		return 4;
	}

	@Override
	public Object getAttribut(int i, int j) {
		return data[i][j];
	}

	@Override
	public String getAttributName(int i) {
		return columnNames[i];
	}

	@Override
	public int getAttributType(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbElement() {
		return 2;
	}

}
