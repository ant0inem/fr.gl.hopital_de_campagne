package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PaneAddElement extends JPanel {
	
	public PaneAddElement(DisplayableClass o) {
		
		super(new BorderLayout());
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		JButton addButton = new JButton("Ajouter");
		
		south.add(addButton);
		
		this.add(south, BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		
		for(int i=0; i<o.getNbAttribut(); i++) {
			JPanel couplePane = new JPanel();
			couplePane.setLayout(new BoxLayout(couplePane, BoxLayout.Y_AXIS));
			couplePane.add(new JLabel(o.getAttributName(i)));
			couplePane.add(new JTextField());
			couplePane.setMinimumSize(new Dimension(200,40));
			couplePane.setMaximumSize(new Dimension(200,40));
			couplePane.setPreferredSize(new Dimension(200,40));
			center.add(couplePane);
			center.add(Box.createRigidArea(new Dimension(10,100)));
		}
		
		JScrollPane s = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 
		this.add(s, BorderLayout.CENTER);
		
	}

}