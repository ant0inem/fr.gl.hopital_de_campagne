package fr.gl.hopital_de_campagne.dao;
/* Backup de test/Dao.java. A la différence du fichier dans le package test,  ici,
dans chaque méthode, on crée un EntityManagerFactory et un EntityManager. (Méthode de bourrin) */

// La classe KFCDao n'est ici pas prise en compte. #DésoléPeter
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Dao_Backup {
	
	/**
	 * 
	 * @return the set of all the equipement saved in the data base
	 */
	public Dao_Backup() {		
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
		public static void addAvion(AvionDao avion) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(avion);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void addConfiguration(ConfigurationDao configuration) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(configuration);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void addContainer_contains(Container_containsDao container_contains) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(container_contains);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void addContainer(ContainerDao container) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(container);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void addEquipement(EquipementDao equipement) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(equipement);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
				
		public static void addMedicament(MedicamentDao medicament) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(medicament);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void addSecteur(SecteurDao secteur) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(secteur);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		// Suppression dans BDD
		public static void deleteAvion(AvionDao avion) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(avion);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void deleteConfiguration(ConfigurationDao configuration) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(configuration);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void deleteContainer_contains(Container_containsDao container_contains) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(container_contains);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void deleteContainer(ContainerDao container) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(container);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void deleteEquipement(EquipementDao equipement) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(equipement);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
				
		public static void deleteMedicament(MedicamentDao medicament) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(medicament);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		public static void deleteSecteur(SecteurDao secteur) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.remove(secteur);			
			em.getTransaction().commit();
			em.close();
		    factory.close();
		}
		
		
	static public void main(String[] args) {
		test();
	}
	
	static void test()
	{
	}

}
