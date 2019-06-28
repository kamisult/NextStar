package de.htwberlin.prog1.ss19.nextstar.model;

/**
 * @author Kamila Sultanova
 */

public class Kleidung extends Assets {

	/** Die Größe der Kleider in XXS,XS,S,M,L,XL,XXL,XXXL usw. */
	private String groesse;

	/** Der Typ der Kleidung */
	private String typ;

	/**
	 * Der Konstruktor initialisiert die Variablen mit den Übergabeparametern
	 * 
	 * @param id      die ID der Kleidung
	 * @param farbe   die Farbe der Kleidung
	 * @param groesse die Größe der Kleidung
	 * @param typ     die Art der Kleidung
	 */
	public Kleidung(String id, String farbe, String groesse, String typ) {
		super(id, farbe);

		this.groesse = groesse;
		this.typ = typ;
	}

	/**
	 * Die Methode gibt den Wert der Variable groesse zurück.
	 * 
	 * @return der Wert der Variable groesse
	 */
	public String getGroesse() {
		return groesse;
	}

	/**
	 * Der Wert der Variable groesse wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param groesse neuer Wert überschreibt groesse
	 */
	public void setGroesse(String groesse) {
		this.groesse = groesse;
	}

	/**
	 * Die Methode gibt den Wert der Variable typ zurück.
	 * 
	 * @return der Wert der Variable typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * Der Wert der Variable typ wird durch den Wert des Parameters überschrieben
	 * 
	 * @param typ neuer Wert überschreibt typ
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Override
	public String toString() {
		return super.toString() + "\tGröße=" + groesse + "\tTyp=" + typ + "\t[Kleidung]";
	}

}
