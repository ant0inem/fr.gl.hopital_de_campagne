package fr.gl.hopital_de_campagne.dao;
// La classe KFCDao n'est ici pas prise en compte. #DésoléPeter
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Dao {
	
	/**
	 * 
	 * @return the set of all the equipement saved in the data base
	 */
	public Dao() {
	
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
	
		
		
		
		
	static public void main(String[] args) {
		test();
	}
	
	static void test()
	{
	}

}
