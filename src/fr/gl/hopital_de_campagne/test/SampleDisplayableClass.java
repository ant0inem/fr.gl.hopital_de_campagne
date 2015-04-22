package fr.gl.hopital_de_campagne.test;

import java.util.ArrayList;
import java.util.List;

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
		return 2;
	}

	@Override
	public int getNbElement() {
		return 2;
	}

	@Override
	public void ajouter_Elt_BdD(List<String> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier_Elt_BdD(int id, List<String> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer_Elt_BdD(int id) {
		// TODO Auto-generated method stub
		
	}

}
