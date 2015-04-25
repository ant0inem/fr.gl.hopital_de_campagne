package fr.gl.hopital_de_campagne.gui;

import java.awt.event.ActionListener;
import java.util.Vector;

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
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel pane1 = new JPanel();
		pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));
		
		JPanel ligne1 = new JPanel();
		ligne1.setLayout(new BoxLayout(ligne1, BoxLayout.X_AXIS));
		ligne1.add(new JLabel("Type d'avion"));
		JComboBox<AvionDao> typesAvion = new JComboBox<AvionDao>((Vector<AvionDao>) Controleur.getInstance().getAllAvionDao());
		ligne1.add(typesAvion);
		
		JPanel ligne2 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne2.setLayout(new BoxLayout(ligne2, BoxLayout.X_AXIS));
		ligne2.add(new JLabel("Volume disponible :"));
		JTextField planeVolumeField = new JTextField();
		planeVolumeField.setEditable(false);
		ligne2.add(planeVolumeField);
		
		pane1.add(ligne1);
		pane1.add(ligne2);
		add(pane1);
		
		JPanel pane2 = new JPanel();
		pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
		
		JPanel ligne3 = new JPanel(new BoxLayout(this, BoxLayout.X_AXIS));
		ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.X_AXIS));
		ligne3.add(new JLabel("Volume disponible :"));
		JTextField usedVolumeField = new JTextField();
		usedVolumeField.setEditable(false);
		ligne3.add(usedVolumeField);
		
		pane2.add(ligne3);
		add(pane2);
	}

}
