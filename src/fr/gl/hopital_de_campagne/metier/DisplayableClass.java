package fr.gl.hopital_de_campagne.metier;

import java.lang.Object;
import java.util.List;

import fr.gl.hopital_de_campagne.dao.Dao;

/**
 * Les instances de DisplayableClass peuvent etre afficher comme une ligne
 * d un tableau (voir Table).
 * @author Bruno
 *
 */
public interface DisplayableClass {
	
	public static int STRING_TYPE = 0;
	public static int INTEGER_TYPE = 1;
	public static int SECTEUR_TYPE = 2;

	
	/**
	 * @return nombre d attribut a afficher
	 */
	public abstract int getNbAttribut();
	
	/**
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
	 * An attribut has a type. Types are limited
	 * to the types define in constant in the 
	 * interface DisplayableClass
	 * @param i indice de la colonne
	 * @return type de la valeur de la colonne
	 */
	public abstract int getAttributType(int i);
	
	
	/**
	 * add an element to the DB
	 */
	public abstract void ajouter_Elt_BdD(List<Object> list, Dao dao);
	
	/**
	 * modifies the element with the ID id in the DB
	 * @param id
	 */
	public abstract void modifier_Elt_BdD(Object object, List<Object> list, Dao dao);

	/**
	 * removes the element with the ID id from the DB
	 * @param id
	 */
	public abstract void supprimer_Elt_BdD(Object o, Dao dao);
	
	public abstract Object getObject(int index);

}
