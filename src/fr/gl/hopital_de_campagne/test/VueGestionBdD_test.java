package fr.gl.hopital_de_campagne.test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;

import fr.gl.hopital_de_campagne.gui.VueGestionBdD;

public class VueGestionBdD_test {

	@Test
	public void testVueGestionBdD() {
		JFrame w = new JFrame();
		w.setContentPane(new VueGestionBdD());
		w.setSize(800, 600);
		w.setVisible(true);
	}

}
