package fr.gl.hopital_de_campagne.gui;

import java.lang.Object;
import java.util.List;

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
	 * ! Attention, le nombre d attributs doit etre identique pour tous les
	 * instances d une meme DisplayableClass !
	 * @return nombre d attribut a afficher
	 */
	public abstract int getNbElement();

	/**
	 * 
	 * @param j indice de la colonne, i indice de la ligne
	 * @return valeur a afficher a la ieme ligne
	 */
	public abstract Object getAttribut(int i, int j);
	
	/**
	 * 
	 * @param i indice de la colonne
	 * @return nom de la valeur a la ieme colonne
	 */
	public abstract String getAttributName(int i);
	
	/**
	 * ! Attention, le type d attributs doit etre identique pour tous les
	 * instances d une meme DisplayableClass !
	 * @param i indice de la colonne
	 * @return type de la valeur de la colonne
	 */
	public abstract int getAttributType(int i);
	
	
	/**
	 * add an element to the DB
	 */
	public abstract void ajouter_Elt_BdD(List<String> list);
	
	/**
	 * modifies the element with the ID id in the DB
	 * @param id
	 */
	public abstract void modifier_Elt_BdD(int id, List<String> list);

	/**
	 * removes the element with the ID id from the DB
	 * @param id
	 */
	public abstract void supprimer_Elt_BdD(int id);
}
