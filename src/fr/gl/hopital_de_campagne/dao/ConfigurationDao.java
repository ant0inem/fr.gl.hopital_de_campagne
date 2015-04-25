package fr.gl.hopital_de_campagne.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ConfigurationDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConfiguration;

	private String avionName;
	private String destination;
	private String dateDepart;
	private String dateRetour;
	private String typeMission;

	@OneToMany
	List<ContainerDao> containers;

	@OneToOne
	AvionDao avion;
	
	public ConfigurationDao() {

	}

//	public ConfigurationDao(String avionName, String destination,
//			String dateDepart, String dateRetour, String typeMission,
//			ContainerDao container, AvionDao avion) {
//		setAvionName(avionName);
//		setDestination(destination);
//		setDateDepart(dateDepart);
//		setDateRetour(dateRetour);
//		setTypeMission(typeMission);
//		setContainer(container);
//		setAvion(avion);
//	}
	
	public void addContainer(ContainerDao container) {
		List<ContainerDao> containers = getContainers();
		containers.add(container);
		setContainers(containers);
	}
	
	public void removeContainer(ContainerDao container) {
		List<ContainerDao> containers = getContainers();
		containers.remove(container);
		setContainers(containers);
	}
	
	public int getContainersNumber() {
		return this.getContainers().size();
	}
	
	public int getVolumeNecessary() {
		int x = 0;
		for(ContainerDao container:this.getContainers()) {
			x+=container.getContainerVolumeMax();
		}
		return x;
	}
	
	public int getWeightNecessary() {
		int x = 0;
		for(ContainerDao container:this.getContainers()) {
			x+=container.getContainerWeightMax();
		}
		return x;
	}

	@Override
	public String toString() {
		return this.getAvionName();
	}

	public void setContainers(List<ContainerDao> c) {
		containers = c;
	}

	public List<ContainerDao> getContainers() {
		if(containers==null) containers = new ArrayList<ContainerDao>();
		return containers;
	}

	public void setAvion(AvionDao a) {
		avion = a;
	}

	public AvionDao getAvion() {
		return avion;
	}

	public int getIdConfiguration() {
		return idConfiguration;
	}

	public void setIdConfiguration(int idConfiguration) {
		this.idConfiguration = idConfiguration;
	}

	public String getAvionName() {
		if(avionName==null) return "Configuration sans nom";
		return avionName;
	}

	public void setAvionName(String avionName) {
		this.avionName = avionName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getTypeMission() {
		return typeMission;
	}

	public void setTypeMission(String typeMission) {
		this.typeMission = typeMission;
	}

}
