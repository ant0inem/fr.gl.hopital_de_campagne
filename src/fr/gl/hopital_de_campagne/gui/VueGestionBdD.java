package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class VueGestionBdD extends JPanel {

	/**
	 * Create the panel.
	 */
	public VueGestionBdD() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.SOUTH);
		
		JPanel addItemPane = new JPanel();
		tabbedPane.addTab("Ajouter un �l�ment", null, addItemPane, null);
		
		JPanel editPane = new JPanel();
		tabbedPane.addTab("Modifier/Supprimer un �l�ment", null, editPane, null);

	}

}
