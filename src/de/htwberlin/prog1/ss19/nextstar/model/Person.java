package de.htwberlin.prog1.ss19.nextstar.model;
/**
 * @author Kamila Sultanova
 */
public class Person {

	private String nachname;
	private String vorname;
	private String id;

	/**
	 * Initialisiert die Variablen vorname und nachname
	 * 
	 * @param id      die eindeutige ID der Person
	 * @param vorname der Vorname der Person
	 * @param nachname der Nachname der Person
	 */
	public Person(String id, String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
	}

	/**
	 * Die Methode gibt den Wert der Variable nachname zurück.
	 * 
	 * @return der Wert der Variable nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Der Wert der Variable nachname wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param nachname neuer Wert überschreibt nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Die Methode gibt den Wert der Variable vorname zurück.
	 * 
	 * @return der Wert der Variable vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Der Wert der Variable vorname wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param vorname neuer Wert überschreibt vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Die Methode gibt den vollständigen Namen der Person zurück.
	 * 
	 * @return der vollständige Name der Person
	 */
	public String getNamen() {
		return this.vorname+","+this.nachname;
	}
	@Override
	public String toString() {
		return id +"\t"+vorname + " " + nachname;
	}

}