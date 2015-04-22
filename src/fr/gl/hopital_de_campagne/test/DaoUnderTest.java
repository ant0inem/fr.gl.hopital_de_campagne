package fr.gl.hopital_de_campagne.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.EquipementDao;
import fr.gl.hopital_de_campagne.dao.SecteurDao;

public class DaoUnderTest {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		
//		SecteurDao secteur = new SecteurDao("Nom du secteur", "Paris");
//		dao.addSecteur(secteur);
		
//		ContainerDao container = new ContainerDao(1,2,3,4,5,6,7,8,"Désignation", "Observation", "Module", "Priorité",dao.getAllSecteurDao(em).get(0));
//		dao.addContainer(container);
		
		EquipementDao equipement = new EquipementDao(2,3,4,"EQUIPEEEEEMENT","Description",6,"Type","Nature",1000);
		dao.addEquipement(equipement);



	}

}
