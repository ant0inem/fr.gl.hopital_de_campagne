package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;

import fr.gl.hopital_de_campagne.dao.MedicamentDao;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;

public class DC_Medicament implements DisplayableClass {

	private String[] columnNames = { "idMedicament", "medicamentFamille",
			"medicamentDCI", "medicamentQuantitéParBoite", "medicamentDosage",
			"medicamentDLU", "medicamentDotationU7", "medicamentLot" };
	private ArrayList<MedicamentDao> med_List = new ArrayList<MedicamentDao>();
	private static DC_Medicament instance = null;

	
	public static DC_Medicament getInstance(ArrayList<MedicamentDao> med_List){
		if (instance == null){
			instance = new DC_Medicament(med_List);
		}
		return instance;
	}
	
	public static DC_Medicament getInstance(){
		if (instance == null){
			instance = new DC_Medicament(null);
		}
		return instance;
	}
	
	private DC_Medicament(ArrayList<MedicamentDao> med_List) {
		setMed_List(med_List);
	}

	public ArrayList<MedicamentDao> getMed_List() {
		return med_List;
	}

	public void setMed_List(ArrayList<MedicamentDao> med_List) {
		this.med_List = med_List;
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
		if (med_List != null) {
			nbElement = getMed_List().size();
		}
		return nbElement;
	}

	@Override
	public Object getAttribut(int i, int j) {
		MedicamentDao med = getMed_List().get(i);
		Object o = null;

		switch (j) {

		case 0:
			o = med.getIdMedicament();
			break;
		case 1:
			o = med.getMedicamentFamille();
			break;
		case 2:
			o = med.getMedicamentDCI();
			break;
		case 3:
			o = med.getMedicamentQuantitéParBoite();
			break;
		case 4:
			o = med.getMedicamentDosage();
			break;
		case 5:
			o = med.getMedicamentDLU();
			break;
		case 6:
			o = med.getMedicamentDotationU7();
			break;
		case 7:
			o = med.getMedicamentLot();
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
		case 3:
			type = 1;
			break;
		case 1:
		case 2:
		case 4:
		case 5:
		case 6:
		case 7:
			type = 2;
			break;
		}
		return type;
	}

	@Override
	public void ajouter_Elt_BdD(ArrayList<String> list) {
		// TODO Auto-generated method stub
		
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
