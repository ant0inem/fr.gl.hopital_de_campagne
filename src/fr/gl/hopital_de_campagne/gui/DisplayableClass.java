package fr.gl.hopital_de_campagne.gui;

import java.lang.Object;

/**
 * Les instances de DisplayableClass peuvent etre afficher comme une ligne
 * d un tableau (voir Table).
 * @author Bruno
 *
 */
public interface DisplayableClass {

	
	/**
	 * ! Attention, le nombre d attributs doit etre identique pour tous les
	 * instances d une meme DisplayableClass !
	 * @return nombre d attribut a afficher
	 */
	public abstract int getNbAttribut();

	/**
	 * 
	 * @param i indice de la colonne
	 * @return valeur a afficher a la ieme ligne
	 */
	public abstract Object getAttribut(int i);
	
	/**
	 * ! Attention, le type d attributs doit etre identique pour tous les
	 * instances d une meme DisplayableClass !
	 * @param i indice de la colonne
	 * @return type de la valeur de la colonne
	 */
	public abstract int getAttributType(int i);
}
