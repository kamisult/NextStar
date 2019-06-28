package de.htwberlin.prog1.ss19.nextstar.model;

/**
 * @author Kamila Sultanova
 */

public class Accessoires extends Assets {
	private String accessoiresArt;

	/**
	 * Die Methode gibt den Wert der Variable accessoiresArt zurück.
	 * 
	 * @return der Wert der Variable accessoiresArt
	 */
	public String getAccessoiresArt() {
		return accessoiresArt;
	}

	/**
	 * Der Wert der Variable accessoiresArt wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param accessoiresArt neuer Wert überschreibt accessoiresArt
	 */
	public void setAccessoiresArt(String accessoiresArt) {
		this.accessoiresArt = accessoiresArt;
	}

	/**
	 * Der Konstruktor initialisiert die Variablen mit den Übergabeparametern
	 * 
	 * @param id             die ID des Accessoires
	 * @param farbe          die Farbe des Accessoires
	 * @param accessoiresArt die Art des Accessoires
	 */
	public Accessoires(String id, String farbe, String accessoiresArt) {
		super(id, farbe);
		this.accessoiresArt = accessoiresArt;
	}

	@Override
	public String toString() {
		return super.toString() + "\tAccessoiresart=" + accessoiresArt + "\t[Accessoires]";

	}
}
