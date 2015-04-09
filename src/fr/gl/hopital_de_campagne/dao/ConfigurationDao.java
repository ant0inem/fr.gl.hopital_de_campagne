package fr.gl.hopital_de_campagne.dao;
// avionName clé primaire ???
// String dateDepart // dateRetour en Date
import java.util.Date;

import javax.persistence.*;

@Entity
public class ConfigurationDao {
	
	@Id
	@GeneratedValue
	private int idConfiguration;
	
	private String avionName;
	private String destination;
	private String dateDepart;
	private String dateRetour;
	private String typeMission;
	
	@OneToOne
	@JoinColumn(name = "idContainer")
	ContainerDao container;

	public void setContainer(ContainerDao c) {
		container = c;
	}

	public ContainerDao getContainer() {
		return container;
	}
	
	@OneToOne
	@JoinColumn(name = "idAvion")
	AvionDao avion;

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
