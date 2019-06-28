/**
 * 
 */
package de.htwberlin.prog1.ss19.nextstar.model;

import java.util.Date;
import java.util.List;

/**
 * @author Kamila Sultanova
 */
public class Film extends Produktion {

	private int zeitdauer;
	
	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID des Films
	 * @param titel            der Titel des Films
	 * @param produktionsDatum das Datum des Films
	 * @param zeitdauer        die Dauer des Films in Minuten 
	 */
	
	public Film(String id, String titel, Date produktionsDatum, int zeitdauer) {
		super(id, titel, produktionsDatum);
		this.zeitdauer = zeitdauer;
	}

	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID des Films
	 * @param titel            der Titel des Films
	 * @param produktionsDatum das Datum des Films
	 * @param stars            die Stars die in dem Film mitspielen
	 * @param regisseure       die Regiesseure des Films
	 * @param authoren         die Authoren des Films
	 * @param genres           die Liste der Genres des Films
	 * @param szene            die Liste der Szenen für diesen Film
	 * @param zeitdauer        die Dauer des Films in Minuten 
	 */
	public Film(String id,String titel, Date produktionsDatum, List<Person> stars, List<Person> regisseure, List<Person> authoren,
			List<String> genres, List<Szene> szene, int zeitdauer) {
		super(id,titel, produktionsDatum, stars, regisseure, authoren, genres, szene);
		this.zeitdauer = zeitdauer;
	}
	/** 
	 * Die Methode gibt den Wert der Variable zeitdauer zurück.
	 * @return der Wert der Variable zeitdauer
	 */
	public int getZeitdauer() {
		return zeitdauer;
	}
	/** 
	 * Der Wert der Variable zeitdauer wird durch den Wert des Parameters überschrieben
	 * @param zeitdauer neuer Wert überschreibt zeitdauer 
	 */
	public void setZeitdauer(int zeitdauer) {
		this.zeitdauer = zeitdauer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+"\tZeitdauer=" + zeitdauer + " [Film]";
	}
	

}
