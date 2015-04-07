package fr.gl.hopital_de_campagne.dao;
// RESTE Container_Secteur_idSecteur à écrire.

import javax.persistence.*;

@Entity
public class Container_containsDao {

	@OneToOne
	@JoinColumn(name = "idContainer")
	ContainerDao container;

	public void setContainer(ContainerDao c) {
		container = c;
	}

	public ContainerDao getContainer() {
		return container;
	}
	
	@OneToMany
	@JoinColumn(name = "idEquipement")
	EquipementDao equipement;

	public void setEquipement(EquipementDao e) {
		equipement = e;
	}

	public EquipementDao getEquipement() {
		return equipement;
	}
}
