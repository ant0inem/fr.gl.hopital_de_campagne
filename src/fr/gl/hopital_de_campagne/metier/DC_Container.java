package fr.gl.hopital_de_campagne.metier;

import java.util.ArrayList;

import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;

public class DC_Container implements DisplayableClass {

	private String[] columnNames = { "idContainer", "containerNumber",
			"containerLength", "containerWidth", "containerHeight",
			"containerVolumeMax", "containerVolumeUsed", "containerWeightMax",
			"containerWeightUsed", "containerDesignationGenerique",
			"containerObservation", "containerModule", "containerPriority" };
	private ArrayList<ContainerDao> cont_List = new ArrayList<ContainerDao>();
	private static DC_Container instance = null;

	
	public static DC_Container getInstance(ArrayList<ContainerDao> cont_List){
		if (instance == null){
			instance = new DC_Container(cont_List);
		}
		return instance;
	}
	
	public static DC_Container getInstance(){
		if (instance == null){
			instance = new DC_Container(null);
		}
		return instance;
	}
	
	private DC_Container(ArrayList<ContainerDao> cont_List) {
		setMed_List(cont_List);
	}

	public ArrayList<ContainerDao> getCont_List() {
		return cont_List;
	}

	public void setMed_List(ArrayList<ContainerDao> cont_List) {
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
			o = cont.getContainerNumber();
			break;
		case 2:
			o = cont.getContainerLength();
			break;
		case 3:
			o = cont.getContainerWidth();
			break;
		case 4:
			o = cont.getContainerHeight();
			break;
		case 5:
			o = cont.getContainerVolumeMax();
			break;
		case 6:
			o = cont.getContainerVolumeUsed();
			break;
		case 7:
			o = cont.getContainerWeightMax();
			break;
		case 8:
			o = cont.getContainerWeightUsed();
			break;
		case 9:
			o = cont.getContainerDesignationGenerique();
			break;
		case 10:
			o = cont.getContainerObservation();
			break;
		case 11:
			o = cont.getContainerModule();
			break;
		case 12:
			o = cont.getContainerPriority();
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
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			type = 1;
			break;
		case 9:
		case 10:
		case 11:
		case 12:
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
