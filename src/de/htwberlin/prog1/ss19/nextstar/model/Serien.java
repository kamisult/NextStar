/**
 * 
 */
package de.htwberlin.prog1.ss19.nextstar.model;

import java.util.Date;
import java.util.List;

/**
 * @author Kamila Sultanova
 */
public class Serien extends Produktion {

	private int episoden;

	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID der Serie
	 * @param titel            der Titel der Serie
	 * @param produktionsDatum das Datum der Serie
	 * @param episoden         die Anzahl der Episoden der Serie
	 */
	public Serien(String id, String titel, Date produktionsDatum, int episoden) {
		super(id, titel, produktionsDatum);
		this.episoden = episoden;
	}

	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID der Serie
	 * @param titel            der Titel der Serie
	 * @param produktionsDatum das Datum der Serie
	 * @param stars            die Stars die in der Serie mitspielen
	 * @param regisseure       die Regiesseure der Serie
	 * @param authoren         die Authoren der Serie
	 * @param genres           die Liste der Genres der Serie
	 * @param szene            die Liste der Szenen in dieser Serie
	 * @param episoden         die Anzahl der Episoden der Serie
	 */
	public Serien(String id, String titel, Date produktionsDatum, List<Person> stars, List<Person> regisseure,
			List<Person> authoren, List<String> genres, List<Szene> szene, int episoden) {
		super(id, titel, produktionsDatum, stars, regisseure, authoren, genres, szene);
		this.setEpisoden(episoden);
	}

	/**
	 * Die Methode gibt den Wert der Variable episoden zurück.
	 * 
	 * @return der Wert der Variable episoden
	 */
	public int getEpisoden() {
		return episoden;
	}

	/**
	 * Der Wert der Variable episoden wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param episoden neuer Wert überschreibt episoden
	 */
	public void setEpisoden(int episoden) {
		this.episoden = episoden;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\tepisoden=" + episoden + " [Serie]";

	}

}
