package fr.gl.hopital_de_campagne.controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.dao.SecteurDao;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.MenuGUI;
import fr.gl.hopital_de_campagne.gui.Table;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;
import fr.gl.hopital_de_campagne.gui.VueGestionChargement;
import fr.gl.hopital_de_campagne.metier.*;



public class Controleur implements ActionListener, KeyListener, PropertyChangeListener, ListSelectionListener{
	
	private JFrame mainWindow;
	private DisplayableClass dc;
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
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainWindow.setJMenuBar((new MenuGUI(this)).getMenuBar());
	}
	
	public void displayContent(DisplayableClass o) {
		vueGestionBdD = new VueGestionBdD(o, this);
		mainWindow.setContentPane(vueGestionBdD);
		mainWindow.revalidate();
		vueActive = this.VUE_GESTION_BDD;
	}
	
	public void displayPreparePlane() {
		vueGestionChargement = new VueGestionChargement(this);
		mainWindow.setContentPane(vueGestionChargement);
		mainWindow.revalidate();
		vueActive = this.VUE_GESTION_CHARGEMENT;
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
			ArrayList<String> list = new ArrayList<String>();
			dc.ajouter_Elt_BdD(list, dao);
			break;
			
		case "modifier_Elt_BdD" :
			break;
			
		case "supprimer_Elt_BdD" :
			break;
			
		case "viewContainer" :
			dc = DC_Container.getInstance(dao.getAllContainerDao());
			this.displayContent(dc);
			break;
			
		case "viewMed" :
			dc = DC_Medicament.getInstance(dao.getAllMedicamentDao());
			this.displayContent(dc);
			break;
			
		case "viewObject" :
			dc = DC_Equipement.getInstance(dao.getAllEquipementDao());
			this.displayContent(dc);
			break;
			
		case "KFC" :
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
		
		if(vueActive == this.VUE_GESTION_BDD) {

			int rowIndex = vueGestionBdD.getSelectedRow();
			vueGestionBdD.setCurrentModifyFields(vueGestionBdD.getValuesOfRow(rowIndex));

		}
		
	}	
	
	public List<SecteurDao> getAllSecteurDao() {
		return dao.getAllSecteurDao();
	}

}