package fr.gl.hopital_de_campagne.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuGUI {
	
    private JMenuBar menuBar = new JMenuBar();
    
    public MenuGUI(ActionListener l){
    	this.buildMenu(l);
    }
    
    public void buildMenu(ActionListener l) {

        JMenu menu1 = new JMenu("Déconnection");

        JMenuItem closeProg = new JMenuItem("Arrêter le logiciel");
        closeProg.setActionCommand("closeProg");
        closeProg.addActionListener(l);
        menu1.add(closeProg);
        
        /*
        JMenuItem logOutUser = new JMenuItem("Déconnection de l'utilisateur");
        logOutUser.setActionCommand("logOutUser");
        logOutUser.addActionListener(this);
        menu1.add(logOutUser);

        JMenuItem changeUser = new JMenuItem("Changer l'utilisateur");
        changeUser.setActionCommand("changeUser");
        changeUser.addActionListener(this);
        menu1.add(changeUser);
        */
        
        
        JMenu menu2 = new JMenu("Modes d'affichage");

        JMenuItem viewContainer = new JMenuItem("Afficher les colis");
        viewContainer.setActionCommand("viewContainer");
        viewContainer.addActionListener(l);
        menu2.add(viewContainer);

        JMenuItem viewMed = new JMenuItem("Afficher les médicaments");
        viewMed.setActionCommand("viewMed");
        viewMed.addActionListener(l);
        menu2.add(viewMed);
        
        JMenuItem viewObject = new JMenuItem("Afficher les équipements");
        viewObject.setActionCommand("viewObject");
        viewObject.addActionListener(l);
        menu2.add(viewObject);
        
        
        /*
        JMenuItem viewConfig = new JMenuItem("Afficher une configuration");
        viewConfig.setActionCommand("viewConfig");
        viewConfig.addActionListener(this);
        menu2.add(viewConfig);
        */
        

//        JMenu menu3 = new JMenu("Menu FastFood");
//
//        JMenuItem KFC = new JMenuItem("KFC");
//        KFC.setActionCommand("KFC");
//        KFC.addActionListener(l);
//        menu3.add(KFC);
        
        
        
        
        JMenu menu4 = new JMenu("Mission");

        JMenuItem viewPreparePlane = new JMenuItem("Préparer un embarquement");
        viewPreparePlane.setActionCommand("viewPreparePlane");
        viewPreparePlane.addActionListener(l);
        menu4.add(viewPreparePlane);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
//        menuBar.add(menu3);
        menuBar.add(menu4);


    }

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	
	
	
}
