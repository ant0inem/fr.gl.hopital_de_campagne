package fr.gl.hopital_de_campagne.dao;
// RESTE Container_Secteur_idSecteur à écrire.

import java.util.List;

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
	private List<EquipementDao> equipements;

	public void setEquipements(List<EquipementDao> equipements) {
		this.equipements = equipements;
	}

	public List<EquipementDao> getEquipements() {
		return equipements;
	}
}
