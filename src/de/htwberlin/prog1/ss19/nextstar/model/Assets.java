package de.htwberlin.prog1.ss19.nextstar.model;

/**
 * @author Kamila Sultanova
 */
public abstract class Assets {

	private String id;
	private String farbe;

	/**
	 * Der Konstruktor initialisiert die Variablen mit den Übergabeparametern
	 * 
	 * @param id    die ID des Assets
	 * @param farbe die Farbe des Assets
	 */
	public Assets(String id, String farbe) {
		this.id = id;
		this.farbe = farbe;
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

	/**
	 * Die Methode gibt den Wert der Variable farbe zurück.
	 * 
	 * @return der Wert der Variable farbe
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * Der Wert der Variable farbe wird durch den Wert des Parameters überschrieben
	 * 
	 * @param farbe neuer Wert überschreibt farbe
	 */
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	@Override
	public String toString() {
		return this.id + "\tFarbe=" + this.farbe;
	}

}
