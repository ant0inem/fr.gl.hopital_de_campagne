package fr.gl.hopital_de_campagne.controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.MenuGUI;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;
import fr.gl.hopital_de_campagne.metier.*;



public class Controleur implements ActionListener, KeyListener, PropertyChangeListener{
	
	private JFrame mainWindow;
	private DisplayableClass dc;
	private static Controleur instance = null;

	public static Controleur getInstance() {
		if (instance == null){
			instance = new Controleur();
		}
		return instance;
	}
	
	private Controleur() {
		initialiserWindow();
	}
	
	public void initialiserWindow(){
		mainWindow = new JFrame();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainWindow.setJMenuBar((new MenuGUI(this)).getMenuBar());
	}
	
	public void displayContent(DisplayableClass o) {
		mainWindow.setContentPane(new VueGestionBdD(o, this));
		mainWindow.revalidate();
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
			dc.ajouter_Elt_BdD(list);
			break;
			
		case "modifier_Elt_BdD" :
			break;
			
		case "supprimer_Elt_BdD" :
			break;
			
		case "viewContainer" :
			dc = DC_Container.getInstance();
			this.displayContent(dc);
			break;
			
		case "viewMed" :
			dc = DC_Medicament.getInstance();
			this.displayContent(dc);
			break;
			
		case "viewObject" :
			dc = DC_Equipement.getInstance();
			this.displayContent(dc);
			break;
			
		case "KFC" :
			dc = DC_KFC.getInstance();
			this.displayContent(dc);
			break;
		}
		
	}	

}