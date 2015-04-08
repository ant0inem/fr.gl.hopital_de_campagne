package fr.gl.hopital_de_campagne.dao;
// avionName cl� primaire ??? TODO
import java.util.Date;

import javax.persistence.*;

public class ConfigurationDao {
	
	@Id
	@GeneratedValue
	private int idConfiguration;
	
	private String avionName;
	private String destination;
	private Date dateDepart;
	private Date dateRetour;
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

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getTypeMission() {
		return typeMission;
	}

	public void setTypeMission(String typeMission) {
		this.typeMission = typeMission;
	}
	
}