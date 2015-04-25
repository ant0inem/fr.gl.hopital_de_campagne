package fr.gl.hopital_de_campagne.gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.dao.AvionDao;

@SuppressWarnings("serial")
public class PaneLoadsSummary extends JPanel {
	
	public PaneLoadsSummary (ActionListener l) {
		BoxLayout mainLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		super.setLayout(mainLayout);
		
		add(Box.createHorizontalStrut(30));
		
		JPanel pane1 = new JPanel();
		pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));
		
		JPanel ligne1 = new JPanel();
		ligne1.setLayout(new BoxLayout(ligne1, BoxLayout.X_AXIS));
		ligne1.add(new JLabel("Type d'avion :"));
		ligne1.add(Box.createHorizontalGlue());
		JComboBox<AvionDao> typesAvion = new JComboBox<AvionDao>((Vector<AvionDao>) Controleur.getInstance().getAllAvionDao());
		ligne1.add(typesAvion);
		
		JPanel ligne2 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne2.setLayout(new BoxLayout(ligne2, BoxLayout.X_AXIS));
		ligne2.add(new JLabel("Volume disponible (en m3) :"));
		ligne2.add(Box.createHorizontalStrut(20));
		JTextField planeVolumeField = new JTextField();
		planeVolumeField.setEditable(false);
		ligne2.add(planeVolumeField);
		
		JPanel ligne3 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.X_AXIS));
		ligne3.add(new JLabel("Capacité max (en tonnes) :"));
		ligne3.add(Box.createHorizontalStrut(20));
		JTextField planeMaxLoad = new JTextField();
		planeMaxLoad.setEditable(false);
		ligne3.add(planeMaxLoad);
		
		pane1.add(Box.createVerticalStrut(20));
		pane1.add(ligne1);
		pane1.add(Box.createVerticalStrut(5));
		pane1.add(ligne2);
		pane1.add(Box.createVerticalStrut(5));
		pane1.add(ligne3);
		pane1.add(Box.createVerticalStrut(20));
		add(pane1);
		add(Box.createHorizontalStrut(30));
		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
		
		JPanel ligne4 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne4.setLayout(new BoxLayout(ligne4, BoxLayout.X_AXIS));
		ligne4.add(new JLabel("Nombre de colis à charger :"));
		ligne4.add(Box.createHorizontalStrut(20));
		JTextField numberContainerField = new JTextField();
		numberContainerField.setEditable(false);
		ligne4.add(numberContainerField);
		
		JPanel ligne5 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne5.setLayout(new BoxLayout(ligne5, BoxLayout.X_AXIS));
		ligne5.add(new JLabel("Volume nécessaire (en m3) :"));
		ligne5.add(Box.createHorizontalStrut(20));
		JTextField usedVolumeField = new JTextField();
		usedVolumeField.setEditable(false);
		ligne5.add(usedVolumeField);
		
		JPanel ligne6 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne6.setLayout(new BoxLayout(ligne6, BoxLayout.X_AXIS));
		ligne6.add(new JLabel("Poids nécessaire (n tonnes) :"));
		ligne6.add(Box.createHorizontalStrut(20));
		JTextField usedWeightField = new JTextField();
		usedWeightField.setEditable(false);
		ligne6.add(usedWeightField);

		pane2.add(Box.createVerticalStrut(20));
		pane2.add(ligne4);
		pane2.add(Box.createVerticalStrut(5));
		pane2.add(ligne5);
		pane2.add(Box.createVerticalStrut(5));
		pane2.add(ligne6);
		pane2.add(Box.createVerticalStrut(20));
		add(pane2);
		add(Box.createHorizontalStrut(30));
	}

}
