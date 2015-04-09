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
		mainWindow.setContentPane(new VueGestionBdD(o));
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}