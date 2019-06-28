/**
 * 
 */
package de.htwberlin.prog1.ss19.nextstar;

import java.util.LinkedList;
import java.util.List;

import de.htwberlin.prog1.ss19.nextstar.model.Produktion;

/**
 * @author Kamila Sultanova
 */
public class ProduktionsManager {

	private List<Produktion> produktionsliste;

	/**
	 * Die Methode setzt die List der Produktionen druch die übergebene Liste
	 * 
	 * @param produktionsliste die neue Produktionsliste
	 */
	public void setProduktionsliste(List<Produktion> produktionsliste) {
		this.produktionsliste = produktionsliste;
	}

	/**
	 * Fügt ein spezifisches Element in die List der Produktionen ein.
	 * 
	 * @param produktion die Produktion die in die Liste eingefügt wird.
	 * @return true wenn es erfolgreich eingefügt wurde sonst false.
	 */
	public boolean produktionEinfuegen(Produktion produktion) {
		if (produktion != null) {
			this.produktionsliste.add(produktion);
			return true;
		} else {
			System.out.println(
					"Fehler: Die Produktion konnte nicht in Liste eingefügt werden. Die Produktion ist nicht initialisiert");
			return false;
		}
	}

	/**
	 * Der Konstruktore instaziert die List der Produktionen mit einer leeren Liste.
	 */
	public ProduktionsManager() {
		this.produktionsliste = new LinkedList<Produktion>();
	}

	/**
	 * Die Methode gibt die List der Produktionen zurück
	 * 
	 * @return the produktionsliste
	 */
	public List<Produktion> getProduktionsliste() {
		return produktionsliste;
	}
}
