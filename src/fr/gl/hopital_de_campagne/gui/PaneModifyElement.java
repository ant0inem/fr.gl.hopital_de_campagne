package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PaneModifyElement extends JPanel {
	
	public PaneModifyElement(DisplayableClass o, ActionListener l) {
		
		super(new BorderLayout());
		
		JPanel south = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		JButton modifyButton = new JButton("Modifier");
		modifyButton.setActionCommand("modifier_Elt_BdD");
		modifyButton.addActionListener(l);
		JButton deleteButton = new JButton("Supprimer");
		deleteButton.setActionCommand("supprimer_Elt_BdD");
		deleteButton.addActionListener(l);
		
		south.add(modifyButton);
		south.add(deleteButton);
		
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
