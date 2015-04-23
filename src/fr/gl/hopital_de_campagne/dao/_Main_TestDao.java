package fr.gl.hopital_de_campagne.dao;

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
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Projet_GL");
			
			EntityManager ms = factory.createEntityManager();
			
			ArrayList<SecteurDao> ss = new ArrayList<SecteurDao>();
			SecteurDao s = new SecteurDao();
			s.setSecteurName("Secteur 45");
			s.setSecteurLieu("En Allemagne, vers Dortmund");
			ss.add(s);
			
			ArrayList<EquipementDao> es = new ArrayList<EquipementDao>();
			EquipementDao e = new EquipementDao();
			e.setEquipementLength(1);
			e.setEquipementHeight(2);
			e.setEquipementNom("Tente");
			e.setEquipementDescription("Ceci est une description");
			e.setEquipementWeight(3);
			e.setEquipementType("Youuuh");
			e.setEquipementNatureColis("Empoisonné");
			e.setEquipementValue(9999);
			es.add(e);
			
			MedicamentDao m = new MedicamentDao();
			m.setMedicamentFamille("Antalgiques");
			m.setMedicamentDCI("Wtf");
			m.setMedicamentQuantitéParBoite(100);
			m.setMedicamentDosage("3 comprimés par jour");
			m.setMedicamentDLU("10/04/2015");
			m.setMedicamentDotationU7("Wttttf");
			m.setMedicamentLot("330953905");
			
			AvionDao a = new AvionDao();
			ConfigurationDao cfg = new ConfigurationDao();
			ContainerDao c = new ContainerDao();
			Container_containsDao cc = new Container_containsDao();
			cc.setQuantité(300);
			
			/* Clés étrangères */
			cfg.setAvion(a);
			cfg.setContainer(c);
			
//			c.setSecteur(s);
			
			cc.setContainer(c);
			/*cc.setEquipements(es);*/
			
			
			//Reste la clé étrangère Container_Secteur_idSecteur de Container_contains
			m.setEquipement(e);
			
			
			/* Persist */

			ms.getTransaction().begin();
			
			ms.persist(e);
			
			ms.persist(m);
			
			ms.getTransaction().commit();
			
			/* le lien d'association est sauvegard� */
			/* le lien r�ciproque peut �tre mis � jour automatiquement*/
			ms.refresh(e);
			
			
			System.out.println(m.getEquipement());
			
			Query tq = ms.createNativeQuery("select * from MedicamentDao", fr.gl.hopital_de_campagne.dao.MedicamentDao.class);
			List result = tq.getResultList();
			MedicamentDao medt = (MedicamentDao) result.get(1);
			
			TypedQuery<MedicamentDao> mt = ms.createQuery("select m from MedicamentDao m", fr.gl.hopital_de_campagne.dao.MedicamentDao.class);
			List<MedicamentDao> mmt = mt.getResultList();
		}	
		
	
}
