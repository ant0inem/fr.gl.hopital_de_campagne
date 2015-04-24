package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.ConfigurationDao;
import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.SecteurDao;

public class DC_Container implements DisplayableClass {

	private String[] columnNames = { "ID", "module", "secteur", "N° du colis",
			"Désignation génerique du colis", "long", "larg", "haut",
			"volume (m3)", "Poids (kg)", "Observations" };
	private List<ContainerDao> cont_List = new ArrayList<ContainerDao>();
//	private static DC_Container instance = null;
//
//	public static DC_Container getInstance(List<ContainerDao> cont_List) {
//		if (instance == null) {
//			instance = new DC_Container(cont_List);
//		}
//		return instance;
//	}

//	public static DC_Container getInstance() {
//		if (instance == null) {
//			instance = new DC_Container(null);
//		}
//		return instance;
//	}

	public DC_Container(List<ContainerDao> cont_List) {
		setMed_List(cont_List);
	}
	
	public DC_Container(ConfigurationDao configuration) {
		setMed_List(configuration.getContainers());
	}
	
	public static DC_Container getUnusedContainers(ConfigurationDao configuration, Dao dao) {
		List<ContainerDao> unusedContainers = dao.getAllContainerDao();
		for(ContainerDao usedContainer: configuration.getContainers()) {
			unusedContainers.remove(usedContainer);
		}
		return new DC_Container(unusedContainers);	
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
			container.setContainerNumber(Dao.objectToInteger(list.get(3))); 
			container.setContainerDesignationGenerique((String) list.get(4)); 
			container.setContainerLength(Dao.objectToInteger(list.get(5)));
			container.setContainerWidth(Dao.objectToInteger(list.get(6)));
			container.setContainerHeight(Dao.objectToInteger(list.get(7)));
			container.setContainerVolumeMax(Dao.objectToInteger(list.get(8)));
			container.setContainerWeightMax(Dao.objectToInteger(list.get(9)));
			container.setContainerObservation((String) list.get(10));
		}
		
		dao.addContainer(container);
		this.getCont_List().add(container);

	}

	@Override
	public void modifier_Elt_BdD(Object o, List<Object> list, Dao dao) {
		dao.updateContainer((ContainerDao) o, list);

	}

	@Override
	public void supprimer_Elt_BdD(Object o, Dao dao) {
		dao.deleteContainer((ContainerDao) o);
		this.getCont_List().remove(o);
	}

	@Override
	public Object getObject(int index) {
		if(index==-1) return null;
		return this.getCont_List().get(index);
	}
	
	public void addContainer(ContainerDao container) {
		this.getCont_List().add(container);
	}
	
	public void removeContainer(ContainerDao container) {
		this.getCont_List().remove(container);
	}

}
