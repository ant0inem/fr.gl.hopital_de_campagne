package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class Container_containsDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idContainer_contains;

	private int quantité;

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	public int getIdContainer_contains() {
		return idContainer_contains;
	}

	public void setIdContainer_contains(int idContainer_contains) {
		this.idContainer_contains = idContainer_contains;
	}

	@OneToOne
	ContainerDao container;

	public void setContainer(ContainerDao c) {
		container = c;
	}

	public ContainerDao getContainer() {
		return container;
	}

	public Container_containsDao() {

	}

	public Container_containsDao(int quantité, ContainerDao container,
			EquipementDao equipement) {
		setQuantité(quantité);
		setContainer(container); // Container_Secteur_idSecteur ne sert à rien,
									// pas besoin de le rajouter
		setEquipement(equipement); // (contrairement à ce que le pdf indique).
	}

	@OneToOne
	private EquipementDao equipement;

	public void setEquipement(EquipementDao equipement) {
		this.equipement = equipement;
	}

	public EquipementDao getEquipement() {
		return equipement;
	}

}
