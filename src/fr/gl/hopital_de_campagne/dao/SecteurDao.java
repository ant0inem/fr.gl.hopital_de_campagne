package fr.gl.hopital_de_campagne.dao;
// DONE
import java.util.List;

import javax.persistence.*;

public class SecteurDao {
	@Id
	@GeneratedValue
	private int idSecteur;

	public int getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}
	
}
