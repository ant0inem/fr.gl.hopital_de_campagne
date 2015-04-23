package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.dao.SecteurDao;
import fr.gl.hopital_de_campagne.metier.DisplayableClass;

@SuppressWarnings("serial")
public class PaneAddElement extends JPanel {
	
	private List<JComponent> champs;
	
	public PaneAddElement(DisplayableClass o, ActionListener l) {
		
		super(new BorderLayout());
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		JButton addButton = new JButton("Ajouter");
		addButton.setActionCommand("ajouter_Elt_BdD");
		addButton.addActionListener(l);
		
		south.add(addButton);
		
		this.add(south, BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		champs = new ArrayList<JComponent>();
		for(int i=0; i<o.getNbAttribut(); i++) {
			JPanel couplePane = new JPanel();
			couplePane.setLayout(new BoxLayout(couplePane, BoxLayout.Y_AXIS));
			couplePane.add(new JLabel(o.getAttributName(i)));
			JComponent champ = new JLabel("Erreur");
			
			if(o.getAttributType(i)==DisplayableClass.INTEGER_TYPE) {
				NumberFormat format = NumberFormat.getIntegerInstance();
				format.setGroupingUsed(false);
				champ = new JFormattedTextField(format);
				((JFormattedTextField) champ).setValue((long) 0);
			}
			else if(o.getAttributType(i)==DisplayableClass.STRING_TYPE) {
				champ = new JTextField();	
			}
			else if(o.getAttributType(i)==DisplayableClass.SECTEUR_TYPE) {
				champ = new JComboBox<SecteurDao>((Vector<SecteurDao>) Controleur.getInstance().getAllSecteurDao());
			}
			
			champs.add(champ);
			couplePane.add(champ);
			couplePane.setMinimumSize(new Dimension(200,40));
			couplePane.setMaximumSize(new Dimension(200,40));
			couplePane.setPreferredSize(new Dimension(200,40));
			center.add(couplePane);
			center.add(Box.createRigidArea(new Dimension(10,100)));
		}
		
		JScrollPane s = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 
		this.add(s, BorderLayout.CENTER);
		
	}
	
	public List<Object> getFields() {
		List<Object> fields = new ArrayList<Object>();
		for(JComponent champ:champs) {
			//Attention, l ordre des if est important
			if(champ instanceof JFormattedTextField) {
//				Object x = Integer.parseInt(((JFormattedTextField) champ).getText());
//				fields.add(x);
				fields.add(((JFormattedTextField) champ).getValue());
			}
			else if(champ instanceof JTextField) fields.add(((JTextField) champ).getText());
			else if(champ instanceof JComboBox<?>) fields.add(((JComboBox<?>) champ).getSelectedItem());
		}
		return fields;
	}

}
