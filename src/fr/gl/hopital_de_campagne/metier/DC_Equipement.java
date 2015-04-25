package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Container_containsDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.EquipementDao;

public class DC_Equipement implements DisplayableClass {

	private String[] columnNames = { "ID", "Désignation",
			"Commentaire", "Type",
			"N° du colis", "Quantité" };
	private List<EquipementDao> eq_List = new ArrayList<EquipementDao>();
	
	private static DC_Equipement instance = null;

	public static DC_Equipement getInstance(List<EquipementDao> eq_List) {
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

	private DC_Equipement(List<EquipementDao> eq_List) {
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
		if(i==-1) return null;
		EquipementDao eq = getEq_List().get(i);
		Object o = null;

		switch (j) {

		case 0:
			o = eq.getIdEquipement();
			break;
		case 1:
			o = eq.getEquipementNom();
			break;
		case 2:
			o = eq.getEquipementDescription();
			break;
		case 3:
			o = eq.getEquipementType();
			break;
		case 4:
			if(eq.getEquipementEmplacement()!=null) {
				o = eq.getEquipementEmplacement().getContainer();
			}
			break;
		case 5:
			if(eq.getEquipementEmplacement()!=null) {
				o = eq.getEquipementEmplacement().getQuantité();
			}
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
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 1:
			type = DisplayableClass.STRING_TYPE;
			break;
		case 2:
			type = DisplayableClass.STRING_TYPE;
			break;
		case 3:
			type = DisplayableClass.STRING_TYPE;
			break;
		case 4:
			type = DisplayableClass.CONTAINER_TYPE;
			break;
		case 5:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		}
		return type;
	}

	public List<EquipementDao> getEq_List() {
		return eq_List;
	}

	public void setEq_List(List<EquipementDao> eq_List) {
		this.eq_List = eq_List;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	@Override
	public void ajouter_Elt_BdD(List<Object> list, Dao dao) {
		EquipementDao equipement = new EquipementDao();
		Container_containsDao emplacement = new Container_containsDao();
		
		if(list.size()==6) {
			equipement.setEquipementNom((String) list.get(1));
			equipement.setEquipementDescription((String) list.get(2));
			equipement.setEquipementType((String) list.get(3));
			equipement.setEquipementEmplacement(emplacement);
			
			emplacement.setContainer((ContainerDao) list.get(4));
			emplacement.setQuantité(Dao.objectToInteger(list.get(5)));
			emplacement.setEquipement(equipement);
		}

		dao.addEquipement(equipement, emplacement);
		this.getEq_List().add(equipement);
	}

	@Override
	public void supprimer_Elt_BdD(Object o, Dao dao) {
		dao.deleteEquipement((EquipementDao) o);
		this.getEq_List().remove(o);
		
	}
	
	@Override
	public Object getObject(int index) {
		return this.getEq_List().get(index);
	}

	@Override
	public void modifier_Elt_BdD(Object object, List<Object> list, Dao dao) {
		dao.updateEquipement((EquipementDao) object, list);
		
	}

}
