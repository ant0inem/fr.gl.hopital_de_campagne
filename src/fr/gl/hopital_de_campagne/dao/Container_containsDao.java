package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.*;

@Entity
public class Container_containsDao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@JoinColumn(name = "idContainer")
	ContainerDao container;

	public void setContainer(ContainerDao c) {
		container = c;
	}

	public ContainerDao getContainer() {
		return container;
	}

	public Container_containsDao() {
		
	}
	
	public Container_containsDao(int quantit�,
			ContainerDao container, List<EquipementDao> equipements) {
		setQuantit�(quantit�);
		setContainer(container);                    // Container_Secteur_idSecteur ne sert � rien, pas besoin de le rajouter
		setEquipements(equipements);				// (contrairement � ce que le pdf indique).
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
