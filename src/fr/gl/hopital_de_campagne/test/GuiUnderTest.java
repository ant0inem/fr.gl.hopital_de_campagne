package fr.gl.hopital_de_campagne.test;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.gl.hopital_de_campagne.gui.DisplayableClass;
import fr.gl.hopital_de_campagne.gui.MyTable;
import fr.gl.hopital_de_campagne.gui.Table;
import fr.gl.hopital_de_campagne.gui.VueGestionBdD;

public class GuiUnderTest {

	public static void main(String[] args) {
		JFrame w = new JFrame();
		VueGestionBdD vue = new VueGestionBdD();
		
		
		DisplayableClass content = new SampleDisplayableClass();
		Table table = new MyTable(content);
		
		JPanel pane = new JPanel();
		pane.setBackground(Color.GREEN);
		
		vue.setDisplayableClass(content);
		
		w.setContentPane(vue);
//		w.setContentPane(pane);
//		w.setContentPane(table.getTable());
		w.setSize(800, 600);
		w.setVisible(true);
	}

}
