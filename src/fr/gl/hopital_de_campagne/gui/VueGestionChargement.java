package fr.gl.hopital_de_campagne.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.dao.AvionDao;
import fr.gl.hopital_de_campagne.dao.ConfigurationDao;
import fr.gl.hopital_de_campagne.dao.ContainerDao;
import fr.gl.hopital_de_campagne.dao.Dao;
import fr.gl.hopital_de_campagne.metier.DC_Container;

@SuppressWarnings("serial")
public class VueGestionChargement extends JPanel {

	private Table tableUsedContainer;
	private Table tableUnusedContainer;
	private PaneLoadsSummary pane1;
	private JComboBox<ConfigurationDao> configurationSelection;

	/**
	 * Create the panel.
	 */
	public VueGestionChargement(Controleur l, Dao dao,
			DC_Container usedContainers, DC_Container unusedContainers) {

		setLayout(new BorderLayout(0, 0));
		Font titleFont = new Font("Arial", Font.PLAIN, 20);

		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));

		JPanel centerLeft = new JPanel();
		centerLeft.setLayout(new BoxLayout(centerLeft, BoxLayout.Y_AXIS));
		JPanel titre1Panel = new JPanel(new FlowLayout());
		JLabel titre1 = new JLabel("Colis non embarqués");
		titre1.setFont(titleFont);
		titre1Panel.add(titre1);
		centerLeft.add(titre1Panel);
		centerLeft.add(Box.createVerticalStrut(27));
		tableUnusedContainer = new MyTable(unusedContainers, l);
		centerLeft.add(tableUnusedContainer.getTable());
		center.add(centerLeft);

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

		JPanel centerRight = new JPanel();
		centerRight.setLayout(new BoxLayout(centerRight, BoxLayout.Y_AXIS));
		JPanel titre2Panel = new JPanel(new FlowLayout());
		JLabel titre2 = new JLabel("Colis embarqués");
		titre2.setFont(titleFont);
		titre2Panel.add(titre2);
		centerRight.add(titre2Panel);
		JPanel configurationLigne = new JPanel();
		configurationLigne.setLayout(new BoxLayout(configurationLigne, BoxLayout.X_AXIS));
		configurationSelection = new JComboBox<ConfigurationDao>(
				(Vector<ConfigurationDao>) Controleur.getInstance()
						.getAllConfigurationDao());
		configurationLigne.add(configurationSelection);
		JButton saveConfigurationButton = new JButton("Sauvegarder");
		configurationLigne.add(saveConfigurationButton);
		centerRight.add(configurationLigne);
		tableUsedContainer = new MyTable(usedContainers, l);
		centerRight.add(tableUsedContainer.getTable());
		center.add(centerRight);

		add(center, BorderLayout.CENTER);

		pane1 = new PaneLoadsSummary(l);
		add(pane1, BorderLayout.SOUTH);

	}

	public ContainerDao getSelectedUsedContainer() {
		return (ContainerDao) tableUsedContainer
				.getElementAt(tableUsedContainer.getIndexOfSelectedRow());
	}

	public ContainerDao getSelectedUnusedContainer() {
		return (ContainerDao) tableUnusedContainer
				.getElementAt(tableUnusedContainer.getIndexOfSelectedRow());
	}

	@Override
	public void revalidate() {
		super.revalidate();
		if (tableUsedContainer != null)
			tableUsedContainer.revalidate();
		if (tableUnusedContainer != null)
			tableUnusedContainer.revalidate();
	}

	public void setPlaneVolumeText(String planeVolumeText) {
		pane1.setPlaneVolumeText(planeVolumeText);
	}

	public void setPlaneMaxLoad(String planeMaxLoad) {
		pane1.setPlaneMaxLoad(planeMaxLoad);
	}

	public void setNumberContainerText(String numberContainerText) {
		pane1.setNumberContainerText(numberContainerText);
	}

	public void setUsedVolumeText(String usedVolumeText) {
		pane1.setUsedVolumeText(usedVolumeText);
	}

	public void setUsedWeightText(String usedWeightText) {
		pane1.setUsedWeightText(usedWeightText);
	}

	public AvionDao getCurrentSelectedPlane() {
		return pane1.getCurrentSelectedPlane();
	}

}
