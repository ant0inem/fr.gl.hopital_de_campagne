package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.KFCDao;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;

public class DC_KFC implements DisplayableClass {

	private String[] columnNames = { "idKFC", "kfcProduit",
			"kfcPrix"};
	private ArrayList<KFCDao> kfc_List = new ArrayList<KFCDao>();
	private static DC_KFC instance = null;

	
	public static DC_KFC getInstance(ArrayList<KFCDao> kfc_List){
		if (instance == null){
			instance = new DC_KFC(kfc_List);
		}
		return instance;
	}
	
	public static DC_KFC getInstance(){
		if (instance == null){
			instance = new DC_KFC(null);
		}
		return instance;
	}
	
	private DC_KFC(ArrayList<KFCDao> kfc_List) {
		setMed_List(kfc_List);
	}

	public ArrayList<KFCDao> getKfc_List() {
		return kfc_List;
	}

	public void setMed_List(ArrayList<KFCDao> kfc_List) {
		this.kfc_List = kfc_List;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	@Override
	public int getNbAttribut() {
		return getColumnNames().length;
	}

	@Override
	public int getNbElement() {
		int nbElement = 0;
		if (kfc_List != null) {
			nbElement = getKfc_List().size();
		}
		return nbElement;
	}

	@Override
	public Object getAttribut(int i, int j) {
		KFCDao kfc = getKfc_List().get(i);
		Object o = null;

		switch (j) {

		case 0:
			o = kfc.getIdKFC();
			break;
		case 1:
			o = kfc.getKfcProduit();
			break;
		case 2:
			o = kfc.getKfcPrix();
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
		// 1 = int, 2 = String
		switch (i) {
		case 0:
		case 2:
			type = 1;
			break;
		case 1:
			type = 2;
			break;
		}
		return type;
	}

	@Override
	public void ajouter_Elt_BdD(List<Object> list, Dao dao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier_Elt_BdD(int id, List<Object> list, Dao dao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer_Elt_BdD(int id, Dao dao) {
		// TODO Auto-generated method stub
		
	}

}