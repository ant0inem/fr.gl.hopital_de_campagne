package fr.gl.hopital_de_campagne.dao;

import java.util.List;

import javax.persistence.*;

@Entity
public class ContainerDao {
	@Id
	@GeneratedValue
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

	@OneToMany
	@JoinColumn(name = "idSecteur")
	private List<SecteurDao> secteurs;

	public void setSecteurs(List<SecteurDao> secteurs) {
		this.secteurs = secteurs;
	}

	public List<SecteurDao> getSecteurs() {
		return secteurs;
	}
	
	
}
