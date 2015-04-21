package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class MedicamentDao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMedicament;

	private String medicamentFamille;
	private String medicamentDCI;
	private int medicamentQuantitéParBoite;
	private String medicamentDosage;
	private String medicamentDLU;
	private String medicamentDotationU7;
	private String medicamentLot;

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

	public String getMedicamentFamille() {
		return medicamentFamille;
	}

	public void setMedicamentFamille(String medicamentFamille) {
		this.medicamentFamille = medicamentFamille;
	}

	public String getMedicamentDCI() {
		return medicamentDCI;
	}

	public void setMedicamentDCI(String medicamentDCI) {
		this.medicamentDCI = medicamentDCI;
	}

	public int getMedicamentQuantitéParBoite() {
		return medicamentQuantitéParBoite;
	}

	public void setMedicamentQuantitéParBoite(int medicamentQuantitéParBoite) {
		this.medicamentQuantitéParBoite = medicamentQuantitéParBoite;
	}

	public String getMedicamentDosage() {
		return medicamentDosage;
	}

	public void setMedicamentDosage(String medicamentDosage) {
		this.medicamentDosage = medicamentDosage;
	}

	public String getMedicamentDLU() {
		return medicamentDLU;
	}

	public void setMedicamentDLU(String medicamentDLU) {
		this.medicamentDLU = medicamentDLU;
	}

	public String getMedicamentDotationU7() {
		return medicamentDotationU7;
	}

	public void setMedicamentDotationU7(String medicamentDotationU7) {
		this.medicamentDotationU7 = medicamentDotationU7;
	}

	public String getMedicamentLot() {
		return medicamentLot;
	}

	public void setMedicamentLot(String medicamentLot) {
		this.medicamentLot = medicamentLot;
	}

	public MedicamentDao() {

	}

	public MedicamentDao(String medicamentFamille, String medicamentDCI,
			int medicamentQuantitéParBoite, String medicamentDosage,
			String medicamentDLU, String medicamentDotationU7,
			String medicamentLot, EquipementDao equipement) {
		setMedicamentFamille(medicamentFamille);
		setMedicamentDCI(medicamentDCI);
		setMedicamentQuantitéParBoite(medicamentQuantitéParBoite);
		setMedicamentDosage(medicamentDosage);
		setMedicamentDLU(medicamentDLU);
		setMedicamentDotationU7(medicamentDotationU7);
		setMedicamentLot(medicamentLot);
		setEquipement(equipement);
	}

}
