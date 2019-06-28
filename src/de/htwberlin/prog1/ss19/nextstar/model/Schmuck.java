package de.htwberlin.prog1.ss19.nextstar.model;

/**
 * @author Kamila Sultanova
 */
public class Schmuck extends Assets {
	private String schmuckart;

	/**
	 * Die Methode gibt den Wert des schmuckart zurück.
	 * 
	 * @return der Wert der Variable schmuckart
	 */
	public String getSchmuckart() {
		return schmuckart;
	}

	/**
	 * Die Methode setzt den neuen Wert des schmuckart
	 * 
	 * @param schmuckart der neue Wert der Variable schmuckart
	 */
	public void setSchmuckart(String schmuckart) {
		this.schmuckart = schmuckart;
	}

	/**
	 * Der Konstruktor initialisiert die Variablen mit den Übergabeparametern
	 * 
	 * @param id         die ID des Schucks
	 * @param farbe      die Farbe des Schmucks
	 * @param schmuckart die Art des Schmucks
	 */
	public Schmuck(String id, String farbe, String schmuckart) {
		super(id, farbe);
		this.schmuckart = schmuckart;
	}

	@Override
	public String toString() {
		return super.toString() + "\tSchmuckart=" + schmuckart + "\t[Schmuck]";
	}

}
