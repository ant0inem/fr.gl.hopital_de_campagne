package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class SecteurDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String secteurName;

	private String secteurLieu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSecteurName() {
		return secteurName;
	}

	public void setSecteurName(String secteurName) {
		this.secteurName = secteurName;
	}

	public String getSecteurLieu() {
		return secteurLieu;
	}

	public void setSecteurLieu(String secteurLieu) {
		this.secteurLieu = secteurLieu;
	}

	public SecteurDao() {

	}

	public SecteurDao(String secteurName, String secteurLieu) {
		setSecteurName(secteurName);
		setSecteurLieu(secteurLieu);
	}

}
