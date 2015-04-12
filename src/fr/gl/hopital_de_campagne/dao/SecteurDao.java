package fr.gl.hopital_de_campagne.dao;
// DONE
import java.util.List;

import javax.persistence.*;

@Entity
public class SecteurDao {
	@Id
	@GeneratedValue
	private int idSecteur;
	

	private String secteurName;
	private String secteurLieu;

	public int getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
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
	
	public SecteurDao(int idSecteur, String secteurName, String secteurLieu) {
		setIdSecteur(idSecteur);
		setSecteurName(secteurName);
		setSecteurLieu(secteurLieu);
	}

	
}
