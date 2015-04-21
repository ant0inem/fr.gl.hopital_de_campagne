package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class Container_containsDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idContainer_contains;

	private int quantit�;

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
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

	public Container_containsDao(int quantit�, ContainerDao container,
			EquipementDao equipement) {
		setQuantit�(quantit�);
		setContainer(container); // Container_Secteur_idSecteur ne sert � rien,
									// pas besoin de le rajouter
		setEquipement(equipement); // (contrairement � ce que le pdf indique).
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
