package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;

import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.dao.EquipementDao;

public class DC_Equipement implements DisplayableClass {

	private String[] columnNames = { "idEquipement", "equipementLength",
			"equipementWidth", "equipementHeight", "equipementNom",
			"equipementDescription", "equipementWeight", "equipementType",
			"equipementNatureColis", "equipementValue" };
	private ArrayList<EquipementDao> eq_List = new ArrayList<EquipementDao>();

	private static DC_Equipement instance = null;

	public static DC_Equipement getInstance(ArrayList<EquipementDao> eq_List) {
		if (instance == null) {
			instance = new DC_Equipement(eq_List);
		}
		return instance;
	}
	
	public static DC_Equipement getInstance() {
		if (instance == null) {
			instance = new DC_Equipement(null);
		}
		return instance;
	}

	private DC_Equipement(ArrayList<EquipementDao> eq_List) {
		setEq_List(eq_List);
	}

	@Override
	public int getNbAttribut() {
		return getColumnNames().length;
	}

	@Override
	public int getNbElement() {
		int nbElement = 0;
		if (eq_List != null) {
			nbElement = getEq_List().size();
		}
		return nbElement;
	}

	@Override
	public Object getAttribut(int i, int j) {
		EquipementDao eq = getEq_List().get(i);
		Object o = null;

		switch (j) {

		case 0:
			o = eq.getIdEquipement();
			break;
		case 1:
			o = eq.getEquipementLength();
			break;
		case 2:
			o = eq.getEquipementWidth();
			break;
		case 3:
			o = eq.getEquipementHeight();
			break;
		case 4:
			o = eq.getEquipementNom();
			break;
		case 5:
			o = eq.getEquipementDescription();
			break;
		case 6:
			o = eq.getEquipementWeight();
			break;
		case 7:
			o = eq.getEquipementType();
			break;
		case 8:
			o = eq.getEquipementNatureColis();
			break;
		case 9:
			o = eq.getEquipementValue();
			break;
		}

		return o;
	}

	@Override
	public String getAttributName(int i) {
		return getColumnNames()[i];
	}

	@Override
	public int getAttributType(int i) {
		int type = 0;
		switch (i) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 6:
		case 9:
			type = 1;
			break;
		case 4:
		case 5:
		case 7:
		case 8:
			type = 2;
			break;
		}
		return type;
	}

	public ArrayList<EquipementDao> getEq_List() {
		return eq_List;
	}

	public void setEq_List(ArrayList<EquipementDao> eq_List) {
		this.eq_List = eq_List;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	@Override
	public void ajouter_Elt_BdD(ArrayList<String> list) {
		
	}

	@Override
	public void modifier_Elt_BdD(int id, ArrayList<String> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer_Elt_BdD(int id) {
		// TODO Auto-generated method stub
		
	}

}