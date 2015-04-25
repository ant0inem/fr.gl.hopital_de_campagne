package fr.gl.hopital_de_campagne.dao;

import javax.persistence.*;

@Entity
public class AvionDao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAvion;
	
	private String typeAvion;
	private int maxLoad;
	private int doorSizeWidth;
	private int doorSizeHeight;
	private int cargoHoldLength;
	private int cargoHoldWidth;
	private int cargoHoldHeight;
	private int usableVolume;
	
	public AvionDao() {

	}
	
	public AvionDao(String typeAvion, int maxLoad,
			int doorSizeWidth, int doorSizeHeight, int cargoHoldLength,
			int cargoHoldWidth, int cargoHoldHeight, int usableVolume) {
		setTypeAvion(typeAvion);
		setMaxLoad(maxLoad);
		setDoorSizeWidth(doorSizeWidth);
		setDoorSizeHeight(doorSizeHeight);
		setCargoHoldLength(cargoHoldLength);
		setCargoHoldWidth(cargoHoldWidth);
		setCargoHoldHeight(cargoHoldHeight);
		setUsableVolume(usableVolume);
	}
	
	@Override
	public String toString() {
		return "" + typeAvion;
	}

	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
	public String getTypeAvion() {
		return typeAvion;
	}
	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}
	public int getMaxLoad() {
		return maxLoad;
	}
	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}
	public int getDoorSizeWidth() {
		return doorSizeWidth;
	}
	public void setDoorSizeWidth(int doorSizeWidth) {
		this.doorSizeWidth = doorSizeWidth;
	}
	public int getDoorSizeHeight() {
		return doorSizeHeight;
	}
	public void setDoorSizeHeight(int doorSizeHeight) {
		this.doorSizeHeight = doorSizeHeight;
	}
	public int getCargoHoldLength() {
		return cargoHoldLength;
	}
	public void setCargoHoldLength(int cargoHoldLength) {
		this.cargoHoldLength = cargoHoldLength;
	}
	public int getCargoHoldWidth() {
		return cargoHoldWidth;
	}
	public void setCargoHoldWidth(int cargoHoldWidth) {
		this.cargoHoldWidth = cargoHoldWidth;
	}
	public int getCargoHoldHeight() {
		return cargoHoldHeight;
	}
	public void setCargoHoldHeight(int cargoHoldHeight) {
		this.cargoHoldHeight = cargoHoldHeight;
	}
	public int getUsableVolume() {
		return usableVolume;
	}
	public void setUsableVolume(int usableVolume) {
		this.usableVolume = usableVolume;
	}
	
}
