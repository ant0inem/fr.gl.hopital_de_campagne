package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.*;

public class MedicamentDao {

	@Id
	@GeneratedValue
	private int idMedicament;

	public int getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}
	
	@ManyToOne
	@JoinColumn(name = "idEquipement")
	EquipementDao equipement;

	public void setEquipement(EquipementDao e) {
		equipement = e;
	}

	public EquipementDao getEquipement() {
		return equipement;
	}

}
