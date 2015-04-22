package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.test.SampleDisplayableClass;

public class VueGestionChargement extends JPanel {
	
	private Table tableUsedContainer;
	private Table tableUnusedContainer;
	private PaneLoadsSummary pane1;
	
	/**
	 * Create the panel.
	 */
	public VueGestionChargement(Controleur l) {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		tableUsedContainer = new MyTable(new SampleDisplayableClass(), l);
		center.add(tableUsedContainer.getTable());
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		
		JButton addElement = new JButton(">>");
		buttons.add(addElement);
		
		JButton removeElement = new JButton("<<");
		buttons.add(removeElement);
		
		center.add(buttons);
		
		tableUnusedContainer = new MyTable(new SampleDisplayableClass(), l);
		center.add(tableUnusedContainer.getTable());
		
		add(center, BorderLayout.CENTER);
		
		pane1 = new PaneLoadsSummary(l);
		add(pane1, BorderLayout.SOUTH);
		
	}

}
