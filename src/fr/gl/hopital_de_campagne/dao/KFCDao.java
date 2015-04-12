package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class KFCDao {
	@Id
	@GeneratedValue
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
	
	public KFCDao(int idKFC, String kfcProduit, int kfcPrix) {
		setIdKFC(idKFC);
		setKfcProduit(kfcProduit);
		setKfcPrix(kfcPrix);
	}
	

	
}
