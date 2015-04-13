package fr.gl.hopital_de_campagne.test;

import java.util.ArrayList;

import javax.swing.JFrame;

import fr.gl.hopital_de_campagne.controleur.Controleur;
import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.VueGestionChargement;
import fr.gl.hopital_de_campagne.metier.*;
import fr.gl.hopital_de_campagne.dao.*;

public class GuiUnderTest {

	public static void main(String[] args) {
		test2();
	}
		
	private static void test2() {
		JFrame w = new JFrame();
		w.setContentPane(new VueGestionChargement(Controleur.getInstance()));
		w.setSize(800, 600);
		w.setVisible(true);
		
	}

	public static void test1() {
//		JFrame w = new JFrame();
//		VueGestionBdD vue = new VueGestionBdD();
//		
//		
//		DisplayableClass content = new SampleDisplayableClass();
		
		EquipementDao eq1 = new EquipementDao(5, 4, 2, "eq1", "test",
				 42, "type", "tout", 0);
		EquipementDao eq2 = new EquipementDao(5, 4, 2, "eq2", "test",
				 42, "type", "tout", 0);
		ArrayList<EquipementDao> aL_eq = new ArrayList<EquipementDao>();
		aL_eq.add(eq1);
		aL_eq.add(eq2);
		
		DisplayableClass content = DC_Equipement.getInstance(aL_eq);
//		Table table = new MyTable(content);
//		
//		JPanel pane = new JPanel();
//		pane.setBackground(Color.GREEN);
//		
//		vue.setDisplayableClass(content);
//		
//		w.setContentPane(vue);
//		w.setContentPane(pane);
//		w.setContentPane(table.getTable());
//		w.setSize(800, 600);
//		w.setVisible(true);
		
		Controleur c = Controleur.getInstance();
		c.displayContent(content);
	}

}
