package fr.gl.hopital_de_campagne.test;
// La classe KFCDao n'est ici pas prise en compte. #DésoléPeter
import java.util.ArrayList;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Dao {
	public EntityManager em;
	/**
	 * 
	 * @return the set of all the equipement saved in the data base
	 */
	public Dao(EntityManager em) {	
		this.em = em;
	}
		
		// Getters. Retournent les listes d'objets.
		public List<EquipementDao> getAllEquipementDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from EquipementDao", fr.gl.hopital_de_campagne.dao.EquipementDao.class);
			return query.getResultList();
		}
		
		public List<AvionDao> getAllAvionDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from AvionDao", fr.gl.hopital_de_campagne.dao.AvionDao.class);
			return query.getResultList();
		}
		
		public List<ConfigurationDao> getAllConfigurationDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from ConfigurationDao", fr.gl.hopital_de_campagne.dao.ConfigurationDao.class);
			return query.getResultList();
		}

		public List<Container_containsDao> getAllContainer_containsDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from Container_containsDao", fr.gl.hopital_de_campagne.dao.Container_containsDao.class);
			return query.getResultList();
		}
		
		public List<MedicamentDao> getAllMedicamentDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from MedicamentDao", fr.gl.hopital_de_campagne.dao.MedicamentDao.class);
			return query.getResultList();
		}
		
		public List<SecteurDao> getAllSecteurDao(EntityManager em) {
			Query query = em.createNativeQuery("select * from SecteurDao", fr.gl.hopital_de_campagne.dao.SecteurDao.class);
			return query.getResultList();
		}
	
		// Insertion dans BDD
		public void addAvion(AvionDao avion) {
			em.getTransaction().begin();
			em.persist(avion);			
			em.getTransaction().commit();
		}
		
		public void addConfiguration(ConfigurationDao configuration) {
			em.getTransaction().begin();
			em.persist(configuration);			
			em.getTransaction().commit();
		}
		
		public void addContainer_contains(Container_containsDao container_contains) {
			em.getTransaction().begin();
			em.persist(container_contains);			
			em.getTransaction().commit();
		}
		
		public void addContainer(ContainerDao container) {
			em.getTransaction().begin();
			em.persist(container);			
			em.getTransaction().commit();
		}
		
		public void addEquipement(EquipementDao equipement) {
			em.getTransaction().begin();
			em.persist(equipement);			
			em.getTransaction().commit();
		}
				
		public void addMedicament(MedicamentDao medicament) {
			em.getTransaction().begin();
			em.persist(medicament);			
			em.getTransaction().commit();
		}
		
		public void addSecteur(SecteurDao secteur) {
			em.getTransaction().begin();
			em.persist(secteur);			
			em.getTransaction().commit();
		}
		
		// Suppression dans BDD
		public void deleteAvion(AvionDao avion) {
			em.getTransaction().begin();
			em.remove(avion);			
			em.getTransaction().commit();
		}
		
		public void deleteConfiguration(ConfigurationDao configuration) {
			em.getTransaction().begin();
			em.remove(configuration);			
			em.getTransaction().commit();
		}
		
		public void deleteContainer_contains(Container_containsDao container_contains) {
			em.getTransaction().begin();
			em.remove(container_contains);			
			em.getTransaction().commit();
		}
		
		public void deleteContainer(ContainerDao container) {
			em.getTransaction().begin();
			em.remove(container);			
			em.getTransaction().commit();
		}
		
		public void deleteEquipement(EquipementDao equipement) {
			em.getTransaction().begin();
			em.remove(equipement);			
			em.getTransaction().commit();
		}
				
		public void deleteMedicament(MedicamentDao medicament) {
			em.getTransaction().begin();
			em.remove(medicament);			
			em.getTransaction().commit();
		}
		
		public void deleteSecteur(SecteurDao secteur) {
			em.getTransaction().begin();
			em.remove(secteur);			
			em.getTransaction().commit();
		}
		
		
	static public void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
		EntityManager em = factory.createEntityManager();
		Dao dao = new Dao(em);
		// Ici, on peut appeler des méthodes du dessus.
		SecteurDao secteur = new SecteurDao("Nom du secteur", "New-York");
		dao.addSecteur(secteur);
		ArrayList<SecteurDao> secteurs = new ArrayList<SecteurDao>();
		secteurs.add(secteur);
		
		ContainerDao container = new ContainerDao(1,2,3,4,5,6,7,8,"Désignation", "Observation", "Module", "Priorité",secteurs);
		dao.addContainer(container);
		
		
		EquipementDao equipement = new EquipementDao(2,3,4,"EQUIPEEEEEMENT","Description",6,"Type","Nature",1000);
		dao.addEquipement(equipement);
		ArrayList<EquipementDao> equipements = new ArrayList<EquipementDao>();
		equipements.add(equipement);
		
		Container_containsDao container_contains = new Container_containsDao(500,container,equipements);
		dao.addContainer_contains(container_contains);
		
		MedicamentDao medicament = new MedicamentDao("Doliprane", "Test", 15, "1 par jour", "Test", "Teeest", "Lot 52",equipement);
		dao.addMedicament(medicament);
		
		
		// 
		em.close();
		factory.close();
	}
	

}
