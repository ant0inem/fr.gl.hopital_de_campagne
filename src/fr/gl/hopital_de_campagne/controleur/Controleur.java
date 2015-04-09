package fr.gl.hopital_de_campagne.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.MenuGUI;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;


public class Controleur implements ActionListener, KeyListener, PropertyChangeListener{
	
	private JFrame mainWindow;

	public Controleur() {
		
		mainWindow = new JFrame();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
		mainWindow.setJMenuBar((new MenuGUI(this)).getMenuBar());
	}
	
	public void displayContent(DisplayableClass o) {
		mainWindow.setContentPane(new VueGestionBdD(o, this));
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
			break;
			
		case "modifier_Elt_BdD" :
			break;
			
		case "supprimer_Elt_BdD" :
			break;
			
		case "viewContainer" :
			/*
			 * shows the containers in the table (1 ligne for each container)
			 */
			break;
			
		case "viewMed" :
			/*
			 * shows only the meds in the table 
			 */
			break;
			
		case "viewObject" :
			/*
			 * shows all objects in the table
			 */
			break;
		}
		
	}	

}