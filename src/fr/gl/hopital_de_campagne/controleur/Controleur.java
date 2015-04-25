package fr.gl.hopital_de_campagne.controleur;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.gl.hopital_de_campagne.dao.AvionDao;
import fr.gl.hopital_de_campagne.dao.ConfigurationDao;
import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.SecteurDao;
import fr.gl.hopital_de_campagne.gui.MenuGUI;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;
import fr.gl.hopital_de_campagne.gui.VueGestionChargement;
import fr.gl.hopital_de_campagne.metier.*;



public class Controleur implements ActionListener, KeyListener, PropertyChangeListener, ListSelectionListener{
	
	private JFrame mainWindow;
	private DisplayableClass dc;
	private DC_Container usedContainers;
	private DC_Container unusedContainers;
	private ConfigurationDao configurationEmbarquement;
	private static Controleur instance = null;
	private int vueActive = -1;
	public static int VUE_ERREUR = -1;
	public static int VUE_GESTION_BDD = 1;
	public static int VUE_GESTION_CHARGEMENT = 2;
	private VueGestionBdD vueGestionBdD;
	private VueGestionChargement vueGestionChargement;
	private Dao dao;

	public static Controleur getInstance() {
		if (instance == null){
			instance = new Controleur();
		}
		return instance;
	}
	
	private Controleur() {
		initialiserWindow();
		dao = new Dao();
	}
	
	public void initialiserWindow(){
		mainWindow = new JFrame("Hôpital de campagne");
		mainWindow.setSize(800, 600);
		mainWindow.setMinimumSize(new Dimension(400,400));
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setJMenuBar((new MenuGUI(this)).getMenuBar());
		mainWindow.setVisible(true);
	}
	
	public void displayContent(DisplayableClass o) {
		vueGestionBdD = new VueGestionBdD(o, this);
		mainWindow.setContentPane(vueGestionBdD);
		mainWindow.revalidate();
		vueActive = Controleur.VUE_GESTION_BDD;
	}
	
	public void displayPreparePlane() {
		configurationEmbarquement = new ConfigurationDao();
		usedContainers = new DC_Container(configurationEmbarquement);
		unusedContainers = DC_Container.getUnusedContainers(configurationEmbarquement, dao);
		vueGestionChargement = new VueGestionChargement(this, dao, usedContainers, unusedContainers);
		mainWindow.setContentPane(vueGestionChargement);
		mainWindow.revalidate();
		vueActive = Controleur.VUE_GESTION_CHARGEMENT;
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		
		switch(action){
		
		case "ajouter_Elt_BdD" :
			if(vueGestionBdD!=null) {
				dc.ajouter_Elt_BdD(vueGestionBdD.getCurrentAddFields(), dao);
				vueGestionBdD.revalidate();
			}
			break;
			
		case "modifier_Elt_BdD" :
			if(vueGestionBdD!=null) {
				dc.modifier_Elt_BdD(vueGestionBdD.getSelectedObject(), vueGestionBdD.getCurrentModifyFields(), dao);
				vueGestionBdD.revalidate();
			}
			break;
			
		case "supprimer_Elt_BdD" :
			if(vueGestionBdD!=null) {
				dc.supprimer_Elt_BdD(vueGestionBdD.getSelectedObject(), dao);;
				vueGestionBdD.revalidate();
			}
			break;
			
		case "embarquerColis":
			if (vueGestionChargement.getSelectedUnusedContainer() != null) {
				this.usedContainers.addContainer(vueGestionChargement
						.getSelectedUnusedContainer());
				this.unusedContainers.removeContainer(vueGestionChargement
						.getSelectedUnusedContainer());
				vueGestionChargement.revalidate();
			}
			break;

		case "retirerColis":
			if (vueGestionChargement.getSelectedUsedContainer() != null) {
				this.unusedContainers.addContainer(vueGestionChargement
						.getSelectedUsedContainer());
				this.usedContainers.removeContainer(vueGestionChargement
						.getSelectedUsedContainer());
				vueGestionChargement.revalidate();
			}
			break;
			
		case "viewContainer" :
//			dc = DC_Container.getInstance(dao.getAllContainerDao());
			dc = null; //flush
			dc = new DC_Container(dao.getAllContainerDao());
			this.displayContent(dc);
			break;
			
		case "viewMed" :
			dc = null; //flush
			dc = DC_Medicament.getInstance(dao.getAllMedicamentDao());
			this.displayContent(dc);
			break;
			
		case "viewObject" :
			dc = null; //flush
			dc = DC_Equipement.getInstance(dao.getAllEquipementDao());
			this.displayContent(dc);
			break;
			
		case "KFC" :
			dc = null; //flush
			dc = DC_KFC.getInstance();
			this.displayContent(dc);
			break;
			
		case "viewPreparePlane" :
			this.displayPreparePlane();
			break;	
			
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(vueActive == Controleur.VUE_GESTION_BDD) {

			int rowIndex = vueGestionBdD.getSelectedRow();
			vueGestionBdD.setCurrentModifyFields(vueGestionBdD.getValuesOfRow(rowIndex));

		}
		
	}	
	
	public List<SecteurDao> getAllSecteurDao() {
		return dao.getAllSecteurDao();
	}

	public List<ContainerDao> getAllContainerDao() {
		return dao.getAllContainerDao();
	}
	
	public List<AvionDao> getAllAvionDao() {
		return dao.getAllAvionDao();
	}

}