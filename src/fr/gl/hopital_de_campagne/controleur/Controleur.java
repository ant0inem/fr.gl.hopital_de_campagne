package fr.gl.hopital_de_campagne.controleur;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
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

public class Controleur implements ActionListener, KeyListener,
		PropertyChangeListener, ListSelectionListener {

	private JFrame mainWindow;
	private DisplayableClass dc;
	private ConfigurationDao colisEmbarques;
	private ConfigurationDao colisNonEmbarques;
	private static Controleur instance = null;
	private int vueActive = -1;
	public static int VUE_ERREUR = -1;
	public static int VUE_GESTION_BDD = 1;
	public static int VUE_GESTION_CHARGEMENT = 2;
	private VueGestionBdD vueGestionBdD;
	private VueGestionChargement vueGestionChargement;
	private Dao dao;

	public static Controleur getInstance() {
		if (instance == null) {
			instance = new Controleur();
		}
		return instance;
	}

	private Controleur() {
		// Placer l instanciation du dao avant la creation de la JFrame
		// Permet d eviter que l utilisateur puisse faire des requetes
		// alors que la base de donnees n est pas prete.
		dao = new Dao();
		initialiserWindow();
	}

	public void initialiserWindow() {
		mainWindow = new JFrame("Hôpital de campagne");
		mainWindow.setSize(800, 600);
		mainWindow.setMinimumSize(new Dimension(400, 400));
		mainWindow.setVisible(true);
		mainWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dao.closeDao();
				System.exit(0);
			}
		});
		mainWindow
				.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
		colisEmbarques = new ConfigurationDao();
		colisNonEmbarques = Controleur.getOppositeConfigurationDao(
				colisEmbarques, dao);
		vueGestionChargement = new VueGestionChargement(this, dao,
				new DC_Container(colisEmbarques), new DC_Container(
						colisNonEmbarques));
		mainWindow.setContentPane(vueGestionChargement);
		mainWindow.revalidate();
		vueActive = Controleur.VUE_GESTION_CHARGEMENT;
		colisEmbarques.setAvion(vueGestionChargement.getCurrentSelectedPlane());
		displayPlaneInformations();
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

		switch (action) {

		case "ajouter_Elt_BdD":
			if (vueGestionBdD != null) {
				dc.ajouter_Elt_BdD(vueGestionBdD.getCurrentAddFields(), dao);
				vueGestionBdD.revalidate();
			}
			break;

		case "modifier_Elt_BdD":
			if (vueGestionBdD != null) {
				dc.modifier_Elt_BdD(vueGestionBdD.getSelectedObject(),
						vueGestionBdD.getCurrentModifyFields(), dao);
				vueGestionBdD.revalidate();
			}
			break;

		case "supprimer_Elt_BdD":
			if (vueGestionBdD != null) {
				if (vueGestionBdD.getSelectedObject() != null) {
					dc.supprimer_Elt_BdD(vueGestionBdD.getSelectedObject(), dao);
					vueGestionBdD.revalidate();
				}
			}
			break;

		case "embarquerColis":
			if (vueGestionChargement.getSelectedUnusedContainer() != null) {
				ContainerDao container = vueGestionChargement
						.getSelectedUnusedContainer();
				colisEmbarques.addContainer(container);
				colisNonEmbarques.removeContainer(container);
				actualizeVueChargement();
				vueGestionChargement.revalidate();
			}
			break;

		case "retirerColis":
			if (vueGestionChargement.getSelectedUsedContainer() != null) {
				ContainerDao container = vueGestionChargement
						.getSelectedUsedContainer();
				colisEmbarques.removeContainer(container);
				colisNonEmbarques.addContainer(container);
				actualizeVueChargement();
				vueGestionChargement.revalidate();
			}
			break;

		case "choixAvion":
			displayPlaneInformations();
			colisEmbarques.setAvion(vueGestionChargement.getCurrentSelectedPlane());
			vueGestionChargement.revalidate();
			break;

		case "viewContainer":
			dc = null; // flush
			dc = new DC_Container(dao.getAllContainerDao());
			this.displayContent(dc);
			break;

		case "viewMed":
			dc = null; // flush
			dc = DC_Medicament.getInstance(dao.getAllMedicamentDao());
			this.displayContent(dc);
			break;

		case "viewObject":
			dc = null; // flush
			dc = DC_Equipement.getInstance(dao.getAllEquipementDao());
			this.displayContent(dc);
			break;

		case "KFC":
			dc = null; // flush
			dc = DC_KFC.getInstance();
			this.displayContent(dc);
			break;

		case "viewPreparePlane":
			this.displayPreparePlane();
			break;

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (vueActive == Controleur.VUE_GESTION_BDD) {

			int rowIndex = vueGestionBdD.getSelectedRow();
			vueGestionBdD.setCurrentModifyFields(vueGestionBdD
					.getValuesOfRow(rowIndex));

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
	
	public List<ConfigurationDao> getAllConfigurationDao() {
		List<ConfigurationDao> allConfiguration = new Vector<ConfigurationDao>();
		allConfiguration.add(colisEmbarques);
		allConfiguration.addAll(dao.getAllConfigurationDao());
		return allConfiguration;
	}

	public static ConfigurationDao getOppositeConfigurationDao(
			ConfigurationDao configuration, Dao dao) {
		List<ContainerDao> unusedContainers = dao.getAllContainerDao();
		for (ContainerDao usedContainer : configuration.getContainers()) {
			unusedContainers.remove(usedContainer);
		}
		ConfigurationDao oppositeConfiguration = new ConfigurationDao();
		oppositeConfiguration.setContainers(unusedContainers);
		return oppositeConfiguration;
	}

	private void actualizeVueChargement() {
		if (vueGestionChargement != null) {
			vueGestionChargement.setNumberContainerText(Integer
					.toString(colisEmbarques.getContainersNumber()));
			vueGestionChargement.setUsedVolumeText((Integer
					.toString(colisEmbarques.getVolumeNecessary())));
			vueGestionChargement.setUsedWeightText((Integer
					.toString(colisEmbarques.getWeightNecessary())));
		}
	}

	private void displayPlaneInformations() {
		if (vueGestionChargement != null) {
			AvionDao plane = vueGestionChargement.getCurrentSelectedPlane();
			vueGestionChargement.setPlaneVolumeText(Integer.toString(plane
					.getUsableVolume()));
			vueGestionChargement.setPlaneMaxLoad(Integer.toString(plane
					.getMaxLoad()));
		}
	}
}