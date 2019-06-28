package de.htwberlin.prog1.ss19.nextstar.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kamila Sultanova
 */
public class Szene {

	/** Liste der Sets die für die Szene erstellt wurden */
	private List<Set> sets;
	/** Der Ort für die Szene */
	private String ort;
	/** Die Zeit für die Szene */
	private String zeit;
	/** Die Id für die Szene */
	private String id;

	/**
	 * Der Konstruktor erhält eine Liste von Sets, den Ort und die Zeit und weist
	 * diese den jeweiligen Variablen zu.
	 * 
	 * @param id   die eindeutige id
	 * @param sets die Liste des Sets für diese Szene
	 * @param ort  der Ort der Szene
	 * @param zeit die Zeit der Szene
	 */
	public Szene(String id, List<Set> sets, String ort, String zeit) {
		this.id = id;
		this.sets = sets;
		this.ort = ort;
		this.zeit = zeit;
	}

	/**
	 * Der Konstruktor bekommt nur die ID und erstellt damit eine Szene. Die anderen
	 * Eigenschaften können mit den Setter hinzugefügt werden.
	 * 
	 * @param id die ID der Szene
	 */
	public Szene(String id) {
		this.id = id;
		this.sets = new LinkedList<>();
		this.ort = "";
		this.zeit = "";
	}

	/**
	 * Die Methode gibt den Wert des Sets zurück.
	 * 
	 * @return der Wert der Variable sets
	 */
	public List<Set> getSets() {
		return sets;
	}

	/**
	 * Der Wert der Variable sets wird durch den Wert des Parameters überschrieben
	 * 
	 * @param sets neuer Wert überschreibt sets
	 */
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}

	/**
	 * Die Methode fügt ein Set in die Liste der Sets zu der Szene ein
	 * 
	 * @param set Das Set das zu der Szene hinzugefügt wird
	 */
	public void einfuegenSet(Set set) {
		if (set != null) {
			this.sets.add(set);
			System.out.println("INFO: Das Set wurde erfolgreich zu der Szene hinzugefügt.");
		} else {
			System.out.println("ERROR: Das Set wurde nicht zu der Szene hinzugefügt.");
		}
	}

	/**
	 * Die Methode gibt den Wert des Ortes zurück.
	 * 
	 * @return der Wert der Variable ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Der Wert der Variable ort wird durch den Wert des Parameters überschrieben
	 * 
	 * @param ort neuer Wert überschreibt ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * Die Methode gibt den Wert der Variable Zeit zurück.
	 * 
	 * @return der Wert der Variable zeit
	 */
	public String getZeit() {
		return zeit;
	}

	/**
	 * Der Wert der Variable zeit wird durch den Wert des Parameters überschrieben
	 * 
	 * @param zeit neuer Wert überschreibt zeit
	 */
	public void setZeit(String zeit) {
		this.zeit = zeit;
	}

	/**
	 * Die Methode gibt den Wert der Variable id zurück.
	 * 
	 * @return der Wert der Variable id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Der Wert der Variable id wird durch den Wert des Parameters überschrieben
	 * 
	 * @param id neuer Wert überschreibt id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + "\t" + sets + "\t" + ort + "\t" + zeit;
	}

	/**
	 * Die Methode gibt die ID, den Ort und die Zeit als String aus
	 * 
	 * @return gibt die ID, den Ort und die Zeit als String zurück
	 */
	public String ausgabeSzeneOhneSet() {
		return id + "\t" + ort + "\t" + zeit;
	}
}
