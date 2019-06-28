package de.htwberlin.prog1.ss19.nextstar.model;

import java.util.LinkedList;
import java.util.List;
/**
 * @author Kamila Sultanova
 */
public class Set {

	private Person star;
	private List<Assets> assets;
	private String id;

	/**
	 * Der Konstruktor initialisiert die Werte mit den übergebene Parameter
	 * 
	 * @param id     die ID des Sets
	 * @param star   der Star der in diesem Set mitspielt
	 * @param assets die Liste der Assets für dieses Set
	 */
	public Set(String id, Person star, List<Assets> assets) {
		this.id = id;
		this.star = star;
		this.assets = assets;
	}
	/**
	 * Der Konstruktor initialisiert die Werte mit den übergebene Parameter
	 * 
	 * @param id     die ID des Sets
	 */
	public Set(String id) {
		this.id = id;
		this.star = null;
		this.assets = new LinkedList<>();
	}
	/**
	 * Die Methode gibt den Wert des assets zurück.
	 * 
	 * @return der Wert der Variable assets
	 */
	public List<Assets> getAssets() {
		return assets;
	}

	/**
	 * Der Wert der Variable assets wird durch den Wert des Parameters überschrieben
	 * 
	 * @param assets neuer Wert überschreibt assets
	 */
	public void setAssets(List<Assets> assets) {
		this.assets = assets;
	}

	/**
	 * Die Methode fügt in die Liste der Assets einen neuen Asset ein
	 * 
	 * @param asset das Asset das in die List eingefügt wird
	 */
	public void einfuegenAsset(Assets asset) {
		if (this.assets.contains(asset) == false) {
			this.assets.add(asset);
			System.out.println("INFO: Das Asset wurde zum Set " + id + " zugeordnet");
		} else {
			System.out.println("ERROR: Das Asset wurde nicht zum Set zugeordnet");
		}
	}
	/**
	 * Die Methode gibt den Star zurück.
	 * 
	 * @return der Wert der Variable star
	 */
	public Person getStar() {

		return star;
	}

	/**
	 * Der Wert der Variable star wird durch den Wert des Parameters überschrieben
	 * 
	 * @param star der neue Star
	 */
	public void setStar(Person star) {
		if (star == null) {
			System.out.println("WARN: Star wurde nicht zum Set eingetragen");
			return;
		}

		System.out.println("INFO: Star wurde erfolgreich zum Set eingetragen");
		this.star = star;

	}

	/**
	 * Die Methode gibt den Wert des ID's zurück.
	 * 
	 * @return id die ID des Sets
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + "\tstar=" + star.getNamen() + "\tassets=" + assets.toString() + "]";

	}

}
