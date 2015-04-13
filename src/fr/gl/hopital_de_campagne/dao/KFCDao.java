package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class KFCDao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idKFC;
	private String kfcProduit;
	private int kfcPrix;
	
	
	public int getIdKFC() {
		return idKFC;
	}
	public void setIdKFC(int idKFC) {
		this.idKFC = idKFC;
	}
	public String getKfcProduit() {
		return kfcProduit;
	}
	public void setKfcProduit(String kfcProduit) {
		this.kfcProduit = kfcProduit;
	}
	public int getKfcPrix() {
		return kfcPrix;
	}
	public void setKfcPrix(int kfcPrix) {
		this.kfcPrix = kfcPrix;
	}
	
	public KFCDao(){
		
	}
	
	public KFCDao(String kfcProduit, int kfcPrix) {
		setKfcProduit(kfcProduit);
		setKfcPrix(kfcPrix);
	}
	

	
}
