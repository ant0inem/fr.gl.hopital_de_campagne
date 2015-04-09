package fr.gl.hopital_de_campagne.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;


public class Controleur implements ActionListener, KeyListener, PropertyChangeListener{
	
	private JFrame mainWindow;

	public Controleur() {
		
		mainWindow = new JFrame();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
		
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
		
		if("ajouter_Elt_BdD".equals(action)) {
			
		}
		
		if("modifier_Elt_BdD".equals(action)) {
			
		}
		
		if("supprimer_Elt_BdD".equals(action)) {
			
		}
		
	}	

}