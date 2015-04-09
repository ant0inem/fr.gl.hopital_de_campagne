package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

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
		tabbedPane.addTab("Ajouter un �l�ment", null, addItemPane, null);
		
		JPanel editPane = new JPanel();
		tabbedPane.addTab("Modifier/Supprimer un �l�ment", null, editPane, null);
		
		add(tabbedPane, BorderLayout.SOUTH);
		
		add(new JPanel(), BorderLayout.CENTER);

	}
	
	public VueGestionBdD(DisplayableClass o, ActionListener l) {
		this();
		this.setDisplayableClass(o, l);
	}

	public void setDisplayableClass(DisplayableClass o, ActionListener l) {
		Table table = new MyTable(o);
		add(table.getTable(), BorderLayout.CENTER);
		
		JPanel pane1 = new PaneAddElement(o, l);
		tabbedPane.setComponentAt(0, pane1);
		
		JPanel pane2 = new PaneModifyElement(o, l);
		tabbedPane.setComponentAt(1, pane2);
	}

}
