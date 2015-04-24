package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class EquipementDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEquipement;

	private int equipementLength;
	private int equipementWidth;
	private int equipementHeight;
	private String equipementNom;
	private String equipementDescription;
	private int equipementWeight;
	private String equipementType;
	private int equipementValue;
	@OneToOne
	private Container_containsDao equipementEmplacement;

	public EquipementDao() {

	}

	public EquipementDao(int equipementLength, int equipementWidth,
			int equipementHeight, String equipementNom,
			String equipementDescription, int equipementWeight,
			String equipementType,
			int equipementValue) {

		setEquipementLength(equipementLength);
		setEquipementWidth(equipementWidth);
		setEquipementHeight(equipementHeight);
		setEquipementNom(equipementNom);
		setEquipementDescription(equipementDescription);
		setEquipementWeight(equipementWeight);
		setEquipementType(equipementType);
		setEquipementValue(equipementValue);
	}

	public int getIdEquipement() {
		return idEquipement;
	}

	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
	}

	public int getEquipementLength() {
		return equipementLength;
	}

	public void setEquipementLength(int equipementLength) {
		this.equipementLength = equipementLength;
	}

	public int getEquipementWidth() {
		return equipementWidth;
	}

	public void setEquipementWidth(int equipementWidth) {
		this.equipementWidth = equipementWidth;
	}

	public int getEquipementHeight() {
		return equipementHeight;
	}

	public void setEquipementHeight(int equipementHeight) {
		this.equipementHeight = equipementHeight;
	}

	public String getEquipementNom() {
		return equipementNom;
	}

	public void setEquipementNom(String equipementNom) {
		this.equipementNom = equipementNom;
	}

	public String getEquipementDescription() {
		return equipementDescription;
	}

	public void setEquipementDescription(String equipementDescription) {
		this.equipementDescription = equipementDescription;
	}

	public int getEquipementWeight() {
		return equipementWeight;
	}

	public void setEquipementWeight(int equipementWeight) {
		this.equipementWeight = equipementWeight;
	}

	public String getEquipementType() {
		return equipementType;
	}

	public void setEquipementType(String equipementType) {
		this.equipementType = equipementType;
	}

	public int getEquipementValue() {
		return equipementValue;
	}

	public void setEquipementValue(int equipementValue) {
		this.equipementValue = equipementValue;
	}

	public Container_containsDao getEquipementEmplacement() {
		return equipementEmplacement;
	}

	public void setEquipementEmplacement(Container_containsDao equipementEmplacement) {
		this.equipementEmplacement = equipementEmplacement;
	}

}
