package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.dao.ConfigurationDao;
import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.metier.DC_Container;
import fr.gl.hopital_de_campagne.test.SampleDisplayableClass;

@SuppressWarnings("serial")
public class VueGestionChargement extends JPanel {
	
	private Table tableUsedContainer;
	private Table tableUnusedContainer;
	private PaneLoadsSummary pane1;
	
	/**
	 * Create the panel.
	 */
	public VueGestionChargement(Controleur l, Dao dao, DC_Container usedContainers, DC_Container unusedContainers) {
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		tableUnusedContainer = new MyTable(unusedContainers, l);
		center.add(tableUnusedContainer.getTable());
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		
		JButton addElement = new JButton(">>");
		addElement.setActionCommand("embarquerColis");
		addElement.addActionListener(l);
		buttons.add(addElement);
		
		JButton removeElement = new JButton("<<");
		removeElement.setActionCommand("retirerColis");
		removeElement.addActionListener(l);
		buttons.add(removeElement);
		
		center.add(buttons);
		
		tableUsedContainer = new MyTable(usedContainers, l);
		center.add(tableUsedContainer.getTable());
		
		add(center, BorderLayout.CENTER);
		
		pane1 = new PaneLoadsSummary(l);
		add(pane1, BorderLayout.SOUTH);
		
	}

	public ContainerDao getSelectedUsedContainer() {
		return (ContainerDao)tableUsedContainer.getElementAt(tableUsedContainer.getIndexOfSelectedRow());
	}
	
	public ContainerDao getSelectedUnusedContainer() {
		return (ContainerDao)tableUnusedContainer.getElementAt(tableUnusedContainer.getIndexOfSelectedRow());
	}
	
	@Override
	public void revalidate() {
		super.revalidate();
		if(tableUsedContainer!=null) tableUsedContainer.revalidate();
		if(tableUnusedContainer!=null) tableUnusedContainer.revalidate();
	}
	
}
