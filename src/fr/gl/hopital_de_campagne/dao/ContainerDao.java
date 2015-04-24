package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class ContainerDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idContainer;

	private int containerNumber;
	private int containerLength;
	private int containerWidth;
	private int containerHeight;
	private int containerVolumeMax;
	private int containerVolumeUsed;
	private int containerWeightMax;
	private int containerWeightUsed;
	private String containerDesignationGenerique;
	private String containerObservation;
	private String containerModule;
	private String containerPriority;
	private String equipementNatureColis;

	public ContainerDao() {

	}

	public ContainerDao(int containerNumber, int containerLength,
			int containerWidth, int containerHeight, int containerVolumeMax,
			int containerVolumeUsed, int containerWeightMax,
			int containerWeightUsed, String containerDesignationGenerique,
			String containerObservation, String containerModule,
			String containerPriority, SecteurDao secteur) {
		setContainerNumber(containerNumber);
		setContainerLength(containerLength);
		setContainerWidth(containerWidth);
		setContainerHeight(containerHeight);
		setContainerVolumeMax(containerVolumeMax);
		setContainerVolumeUsed(containerVolumeUsed);
		setContainerWeightMax(containerWeightMax);
		setContainerWeightUsed(containerWeightUsed);
		setContainerDesignationGenerique(containerDesignationGenerique);
		setContainerObservation(containerObservation);
		setContainerModule(containerModule);
		setContainerPriority(containerPriority);
		setSecteur(secteur);
	}
	
	@Override
	public String toString() {
		return "" + containerNumber;
	}

	public int getIdContainer() {
		return idContainer;
	}

	public void setIdContainer(int idContainer) {
		this.idContainer = idContainer;
	}

	public int getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(int containerNumber) {
		this.containerNumber = containerNumber;
	}

	public int getContainerLength() {
		return containerLength;
	}

	public void setContainerLength(int containerLength) {
		this.containerLength = containerLength;
	}

	public int getContainerWidth() {
		return containerWidth;
	}

	public void setContainerWidth(int containerWidth) {
		this.containerWidth = containerWidth;
	}

	public int getContainerHeight() {
		return containerHeight;
	}

	public void setContainerHeight(int containerHeight) {
		this.containerHeight = containerHeight;
	}

	public int getContainerVolumeMax() {
		return containerVolumeMax;
	}

	public void setContainerVolumeMax(int containerVolumeMax) {
		this.containerVolumeMax = containerVolumeMax;
	}

	public int getContainerVolumeUsed() {
		return containerVolumeUsed;
	}

	public void setContainerVolumeUsed(int containerVolumeUsed) {
		this.containerVolumeUsed = containerVolumeUsed;
	}

	public int getContainerWeightMax() {
		return containerWeightMax;
	}

	public void setContainerWeightMax(int containerWeightMax) {
		this.containerWeightMax = containerWeightMax;
	}

	public int getContainerWeightUsed() {
		return containerWeightUsed;
	}

	public void setContainerWeightUsed(int containerWeightUsed) {
		this.containerWeightUsed = containerWeightUsed;
	}

	public String getContainerDesignationGenerique() {
		return containerDesignationGenerique;
	}

	public void setContainerDesignationGenerique(
			String containerDesignationGenerique) {
		this.containerDesignationGenerique = containerDesignationGenerique;
	}

	public String getContainerObservation() {
		return containerObservation;
	}

	public void setContainerObservation(String containerObservation) {
		this.containerObservation = containerObservation;
	}

	public String getContainerModule() {
		return containerModule;
	}

	public void setContainerModule(String containerModule) {
		this.containerModule = containerModule;
	}

	public String getContainerPriority() {
		return containerPriority;
	}

	public void setContainerPriority(String containerPriority) {
		this.containerPriority = containerPriority;
	}

	@ManyToOne
	// @JoinColumn(name = "SECTEURDAO_ID")
	private SecteurDao secteur;

	public void setSecteur(SecteurDao secteur) {
		this.secteur = secteur;
	}

	public SecteurDao getSecteur() {
		return secteur;
	}

	public String getEquipementNatureColis() {
		return equipementNatureColis;
	}

	public void setEquipementNatureColis(String equipementNatureColis) {
		this.equipementNatureColis = equipementNatureColis;
	}

}
