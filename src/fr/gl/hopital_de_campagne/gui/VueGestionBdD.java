package fr.gl.hopital_de_campagne.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionListener;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.metier.DisplayableClass;

/**
 * La vue gestion base de donnees permet aux utilisateurs de voir la base 
 * de donnees et de la modifier.
 * @author bruno
 *
 */
@SuppressWarnings("serial")
public class VueGestionBdD extends JPanel {
	
	private JTabbedPane tabbedPane;
	private PaneAddElement pane1;
	private PaneModifyElement pane2;
	private Table table;

	/**
	 * Create the panel.
	 */
	private VueGestionBdD() {
		setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel addItemPane = new JPanel();
		tabbedPane.addTab("Ajouter un élément", null, addItemPane, null);
		
		JPanel editPane = new JPanel();
		tabbedPane.addTab("Modifier/Supprimer un élément", null, editPane, null);
		
		add(tabbedPane, BorderLayout.SOUTH);
		
		add(new JPanel(), BorderLayout.CENTER);

	}
	
	/**
	 * Create the panel with a specific content
	 * @param o set of element to display
	 * @param l controller in charge of the gui
	 */
	public VueGestionBdD(DisplayableClass o, Controleur l) {
		this();
		this.setDisplayableClass(o, l);
	}

	/**
	 * Display a specific content
	 * @param o set of element to display
	 * @param l controller in charge of the gui
	 */
	public void setDisplayableClass(DisplayableClass o, Controleur l) {
		table = new MyTable(o, (ListSelectionListener) l);
		add(table.getTable(), BorderLayout.CENTER);
		if(o.getNbElement()!=0) table.setSelectedRow(0);
		
		pane1 = new PaneAddElement(o, l);
		tabbedPane.setComponentAt(0, pane1);
		
		pane2 = new PaneModifyElement(o, l);
		tabbedPane.setComponentAt(1, pane2);
		if(o.getNbElement()!=0) setCurrentModifyFields(getValuesOfRow(0));
	}
	
	/**
	 * 
	 * @return the fields wrote in the PaneAddElement
	 */
	public List<Object> getCurrentAddFields() {
		return pane1.getFields();
	}
	
	/**
	 * 
	 * @return the fields wrote in the PaneModifyElement
	 */
	public List<String> getCurrentModifyFields() {
		return pane2.getFields();
	}
	
	/**
	 * Modify the field in the PaneModifyElement
	 * @param fields the set of String to write in the PaneModifyElement
	 */
	public void setCurrentModifyFields(List<Object> fields) {
		pane2.setFields(fields);
	}
	
	/**
	 * 
	 * @return index of the current selected row in the table
	 */
	public int getSelectedRow() {
		return table.getIndexOfSelectedRow();
	}
	
	public Object getSelectedObject() {
		return table.getElementAt(getSelectedRow());
	}
	
	/**
	 * 
	 * @param rowIndex index of a row
	 * @return the list of object which represent the specify row
	 */
	public List<Object> getValuesOfRow(int rowIndex) {
		return table.getValuesOfRow(rowIndex);
	}
	
	@Override
	public void revalidate() {
		super.revalidate();
		if(table!=null) table.revalidate();
	}

}
