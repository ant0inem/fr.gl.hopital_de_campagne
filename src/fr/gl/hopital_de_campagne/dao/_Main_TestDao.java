package fr.gl.hopital_de_campagne.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class _Main_TestDao {
				
		static public void main(String[] args) {
			test();
		}
		
		static void test()
		{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet GL");
			
			EntityManager em = factory.createEntityManager();
			
			SecteurDao s = new SecteurDao();
			
			s.setSecteurName("Secteur 45");
			s.setSecteurLieu("En Allemagne, vers Dortmund");
			
			
			
			MedicamentDao m = new MedicamentDao();
			
			/* emprunt doit d�finir le lien d'association */
			/* car la table emprunt g�re la cl� �trang�re */
			e.setLecteur(l);
			
			ArrayList<Ouvrage> lo = new ArrayList<Ouvrage>();
			
			OuvrageNumerique on = new OuvrageNumerique();
			on.setTitle("Hollywood Vampires");
			on.setFormat(Format.MP3);
			
			lo.add(on);
			
			Ouvrage o = new Ouvrage();
			o.setTitle("Soumission");
			
			lo.add(o);
			
			/* idem. l'objet emprunt g�re le lien d'association*/
			e.setOuvrages(lo);
			
			em.getTransaction().begin();
			
			em.persist(l);
			
			em.persist(o);
			
			em.persist(on);
			
			em.persist(e);
			
			em.getTransaction().commit();
			
			/* le lien d'association est sauvegard� */
			/* le lien r�ciproque peut �tre mis � jour automatiquement*/
			em.refresh(l);
			
			em.refresh(o);
			
			System.out.println(o.getEmprunts().get(0));
			
			Query tq = em.createNativeQuery("select * from Emprunt", Emprunt.class);
			List result = tq.getResultList();
			Emprunt empt = (Emprunt) result.get(0);
			
			TypedQuery<Emprunt> tp = em.createQuery("select e from Emprunt e", Emprunt.class);
			List<Emprunt> le = tp.getResultList();
		}	
		
	
}
