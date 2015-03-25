package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.*;

public class Avion_has_ContainerDao {
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
}
