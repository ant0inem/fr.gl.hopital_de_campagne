package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class VueGestionBdD extends JPanel {
	private JPanel center;

	/**
	 * Create the panel.
	 */
	public VueGestionBdD() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.SOUTH);
		
		JPanel addItemPane = new JPanel();
		tabbedPane.addTab("Ajouter un élément", null, addItemPane, null);
		
		JPanel editPane = new JPanel();
		tabbedPane.addTab("Modifier/Supprimer un élément", null, editPane, null);
		
		center = new JPanel();
		add(center, BorderLayout.CENTER);

	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
		add(center, BorderLayout.CENTER);
	}

}
