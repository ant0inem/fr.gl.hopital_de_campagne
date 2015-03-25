package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.*;

public class ContainerDao {
	@Id
	@GeneratedValue
	private int idContainer;

	public int getIdContainer() {
		return idContainer;
	}

	public void setIdContainer(int idContainer) {
		this.idContainer = idContainer;
	}
	
	@OneToMany
	@JoinColumn(name = "idSecteur")
	SecteurDao secteur;

	public void setSecteur(SecteurDao s) {
		secteur = s;
	}

	public SecteurDao getSecteur() {
		return secteur;
	}
}
