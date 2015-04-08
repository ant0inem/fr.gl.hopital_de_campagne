package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class VueGestionBdD extends JPanel {
	
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public VueGestionBdD() {
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel addItemPane = new JPanel();
		tabbedPane.addTab("Ajouter un élément", null, addItemPane, null);
		
		JPanel editPane = new JPanel();
		tabbedPane.addTab("Modifier/Supprimer un élément", null, editPane, null);
		
		add(tabbedPane, BorderLayout.SOUTH);
		
		add(new JPanel(), BorderLayout.CENTER);

	}

	public void setDisplayableClass(DisplayableClass o) {
		Table table = new MyTable(o);
		add(table.getTable(), BorderLayout.CENTER);
		JPanel pane1 = new PaneAddElement(o);
		tabbedPane.setComponentAt(0, pane1);
	}

}
