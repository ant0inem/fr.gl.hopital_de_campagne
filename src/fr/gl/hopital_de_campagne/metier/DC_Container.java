package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.SecteurDao;

public class DC_Container implements DisplayableClass {

	private String[] columnNames = { "ID", "module", "secteur", "N° du colis",
			"Désignation génerique du colis", "long", "larg", "haut",
			"volume (m3)", "Poids (kg)", "Observations" };
	private List<ContainerDao> cont_List = new ArrayList<ContainerDao>();
	private static DC_Container instance = null;

	public static DC_Container getInstance(List<ContainerDao> cont_List) {
		if (instance == null) {
			instance = new DC_Container(cont_List);
		}
		return instance;
	}

	public static DC_Container getInstance() {
		if (instance == null) {
			instance = new DC_Container(null);
		}
		return instance;
	}

	private DC_Container(List<ContainerDao> cont_List) {
		setMed_List(cont_List);
	}

	public List<ContainerDao> getCont_List() {
		return cont_List;
	}

	public void setMed_List(List<ContainerDao> cont_List) {
		this.cont_List = cont_List;
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
		if (cont_List != null) {
			nbElement = getCont_List().size();
		}
		return nbElement;
	}

	@Override
	public Object getAttribut(int i, int j) {
		ContainerDao cont = getCont_List().get(i);
		Object o = null;

		switch (j) {

		case 0:
			o = cont.getIdContainer();
			break;
		case 1:
			o = cont.getContainerModule();
			break;
		case 2:
			o = cont.getSecteur();
			break;
		case 3:
			o = cont.getContainerNumber();
			break;
		case 4:
			o = cont.getContainerDesignationGenerique();
			break;
		case 5:
			o = cont.getContainerLength();
			break;
		case 6:
			o = cont.getContainerWidth();
			break;
		case 7:
			o = cont.getContainerHeight();
			break;
		case 8:
			o = cont.getContainerVolumeMax();
			break;
		case 9:
			o = cont.getContainerWeightMax();
			break;
		case 10:
			o = cont.getContainerObservation();
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
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 1:
			type = DisplayableClass.STRING_TYPE;
			break;
		case 2:
			type = DisplayableClass.SECTEUR_TYPE;
			break;
		case 3:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 4:
			type = DisplayableClass.STRING_TYPE;
			break;
		case 5:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 6:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 7:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 8:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 9:
			type = DisplayableClass.INTEGER_TYPE;
			break;
		case 10:
			type = DisplayableClass.STRING_TYPE;
			break;

		}
		return type;
	}

	@Override
	public void ajouter_Elt_BdD(List<Object> list, Dao dao) {
		ContainerDao container = new ContainerDao();
		
		if(list.size()==11) {
			container.setContainerModule((String) list.get(1)); 
			container.setSecteur((SecteurDao) list.get(2));
			container.setContainerNumber(Integer.parseInt(Long.toString((long) list.get(3)))); 
			container.setContainerDesignationGenerique((String) list.get(4)); 
			container.setContainerLength(Integer.parseInt(Long.toString((long) list.get(5))));
			container.setContainerWidth(Integer.parseInt(Long.toString((long) list.get(6))));
			container.setContainerHeight(Integer.parseInt(Long.toString((long) list.get(7))));
			container.setContainerVolumeMax(Integer.parseInt(Long.toString((long) list.get(8))));
			container.setContainerWeightMax(Integer.parseInt(Long.toString((long) list.get(9))));
			container.setContainerObservation((String) list.get(10));
		}
		
		dao.addContainer(container);
		this.getCont_List().add(container);

	}

	@Override
	public void modifier_Elt_BdD(int id, List<Object> list, Dao dao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer_Elt_BdD(Object o, Dao dao) {
		dao.deleteContainer((ContainerDao) o);
		this.getCont_List().remove(o);
	}

	@Override
	public Object getObject(int index) {
		return this.getCont_List().get(index);
	}

}
