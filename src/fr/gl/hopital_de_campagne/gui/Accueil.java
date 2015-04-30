package fr.gl.hopital_de_campagne.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel {
	
	public Accueil () {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Font bigFont = new Font("Arial", Font.BOLD, 30);
		Font mediumFont = new Font("Arial", Font.BOLD, 20);
		Font smallFont = new Font("Arial", Font.PLAIN, 16);
		
//		JPanel informationPanel = new JPanel();
//		informationPanel.setLayout();
//		informationPanel.setPreferredSize(new Dimension(350,200));
		
		add(Box.createVerticalStrut(210));
		JLabel label1 = new JLabel("Hôpital de Campagne");
		label1.setFont(bigFont);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label1);
		add(Box.createVerticalStrut(5));
		JLabel label2 = new JLabel("Logiciel de gestion");
		label2.setFont(mediumFont);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label2);
		add(Box.createVerticalGlue());
		JLabel label3 = new JLabel("Auteurs");
		label3.setFont(smallFont);
		add(label3);
		add(Box.createVerticalStrut(10));
		JLabel label4 = new JLabel("B. LEDEE, A. MAATAR et P. MADELNER");
		label4.setFont(smallFont);
		label4.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label4);
		add(Box.createVerticalStrut(40));
		
//		add(informationPanel);
		
		
	}

}
