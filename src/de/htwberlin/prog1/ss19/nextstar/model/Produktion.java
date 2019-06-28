/**
 * 
 */
package de.htwberlin.prog1.ss19.nextstar.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kamila Sultanova
 */
public abstract class Produktion {

	private String id;
	private String titel;
	private Date produktionsDatum;
	private List<Person> stars;
	private List<Person> regisseure;
	private List<Person> authoren;
	private List<String> genres;
	private List<Szene> szenen;

	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID der Produktion
	 * @param titel            der Titel der Produktion
	 * @param produktionsDatum das Datum der Produktion
	 */
	public Produktion(String id, String titel, Date produktionsDatum) {

		this.id = id;
		this.titel = titel;
		this.produktionsDatum = produktionsDatum;
		this.stars = new LinkedList<>();
		this.regisseure = new LinkedList<>();
		this.authoren = new LinkedList<>();
		this.genres = new LinkedList<>();
		this.szenen = new LinkedList<>();
	}

	/**
	 * Der Konstuktor initialisiert die Variablen mit den übergebenen
	 * Parameterwerten
	 * 
	 * @param id               die ID der Produktion
	 * @param titel            der Titel der Produktion
	 * @param produktionsDatum das Datum der Produktion
	 * @param stars            die Stars die in der Produktion mitspielen
	 * @param regisseure       die Regiesseure der Produktion
	 * @param authoren         die Authoren der Produktion
	 * @param genres           die Liste der Genres der Produktion
	 * @param szenen            die Liste der Szenen der Produktion
	 */
	public Produktion(String id, String titel, Date produktionsDatum, List<Person> stars, List<Person> regisseure,
			List<Person> authoren, List<String> genres, List<Szene> szenen) {

		this.titel = titel;
		this.produktionsDatum = produktionsDatum;
		this.stars = stars;
		this.regisseure = regisseure;
		this.authoren = authoren;
		this.genres = genres;
		this.szenen = szenen;
		this.id = id;
	}

	/**
	 * Die Methode gibt den Wert der Variable titel zurück.
	 * 
	 * @return der Wert der Variable titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * Der Wert der Variable titel wird durch den Wert des Parameters überschrieben
	 * 
	 * @param titel neuer Wert überschreibt titel
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * Die Methode gibt den Wert der Variable produktionsDatum zurück.
	 * 
	 * @return der Wert der Variable produktionsDatum
	 */
	public Date getProduktionsDatum() {
		return produktionsDatum;
	}

	/**
	 * Der Wert der Variable produktionsDatum wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param produktionsDatum neuer Wert überschreibt produktionsDatum
	 */
	public void setProduktionsDatum(Date produktionsDatum) {
		this.produktionsDatum = produktionsDatum;
	}

	/**
	 * Die Methode gibt den Wert der Variable stars zurück.
	 * 
	 * @return der Wert der Variable stars
	 */
	public List<Person> getStars() {
		return stars;
	}

	/**
	 * Der Wert der Variable stars wird durch den Wert des Parameters überschrieben
	 * 
	 * @param stars neuer Wert überschreibt stars
	 */
	public void setStars(List<Person> stars) {
		if (stars != null) {
			this.stars = stars;
			System.out.println("INFO: Die Liste der Stars wurde erfolgreich ersetzt.");
		}
	}

	/**
	 * Die Methode fügt einen neuen Star in die Liste ein.
	 * 
	 * @param star der Star der in die Liste eingefügt wird.
	 * @return true wenn der Star erfolgreich eingefügt wird sonst wird false
	 *         zurückgegeben
	 */
	public boolean einfuegenStar(Person star) {
		if (stars.contains(star)) {
			System.out.println("ERROR: Der Star (" + star.getNamen() + ") ist bereits in der Liste eingetragen");
			return false;
		}
		stars.add(star);
		return true;
	}

	/**
	 * Die Methode gibt den Wert der Variable regisseure zurück.
	 * 
	 * @return der Wert der Variable regisseure
	 */
	public List<Person> getRegisseure() {
		return regisseure;
	}

	/**
	 * Der Wert der Variable regisseure wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param regisseure neuer Wert überschreibt regisseure
	 */
	public void setRegisseure(List<Person> regisseure) {
		if (regisseure != null) {
			this.regisseure = regisseure;
			System.out.println("INFO: Die Liste der Regisseure wurde erfolgreich ersetzt.");
		}
	}

	/**
	 * Die Methode fügt einen neuen Regisseur in die Liste ein.
	 * 
	 * @param regisseur der Regisseur der in die Liste eingefügt wird.
	 * @return true wenn der Regisseur erfolgreich eingefügt wird sonst wird false
	 *         zurückgegeben
	 */
	public boolean einfuegenRegisseur(Person regisseur) {
		if (regisseure.contains(regisseur)) {
			System.out.println(
					"ERROR: Der Regisseur (" + regisseur.getNamen() + ") ist bereits in der Liste eingetragen");
			return false;
		}
		regisseure.add(regisseur);
		return true;
	}

	/**
	 * Die Methode gibt den Wert der Variable authoren zurück.
	 * 
	 * @return der Wert der Variable authoren
	 */
	public List<Person> getAuthoren() {
		return authoren;
	}

	/**
	 * Der Wert der Variable authoren wird durch den Wert des Parameters
	 * überschrieben
	 * 
	 * @param authoren neuer Wert überschreibt authoren
	 */
	public void setAuthoren(List<Person> authoren) {
		if (authoren != null) {
			this.authoren = authoren;
			System.out.println("INFO: Die Liste der Authoren wurde erfolgreich ersetzt");
		}
	}

	/**
	 * Die Methode fügt einen neuen Author in die Liste ein.
	 * 
	 * @param author der Author der in die Liste eingefügt wird.
	 * @return true wenn der Author erfolgreich eingefügt wird sonst wird false
	 *         zurückgegeben
	 */
	public boolean einfuegenAuthoren(Person author) {
		if (authoren.contains(author)) {
			System.out.println("ERROR: Der Author (" + author.getNamen() + ") ist bereits in der Liste eingetragen");
			return false;
		}
		authoren.add(author);
		return true;
	}

	/**
	 * Die Methode gibt den Wert der Variable genres zurück.
	 * 
	 * @return der Wert der Variable genres
	 */
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * Der Wert der Variable genres wird durch den Wert des Parameters überschrieben
	 * 
	 * @param genres neuer Wert überschreibt genres
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	/**
	 * Die Methode gibt den Wert der Variable szene zurück.
	 * 
	 * @return die Liste der Szenen
	 */
	public List<Szene> getSzene() {
		if (this.szenen == null) {
			System.out.println("WARN: Die Liste der Szene wurde nicht initialisiert.");
		}
		return szenen;
	}

	/**
	 * Der Wert der Variable szene wird durch den Wert des Parameters überschrieben
	 * 
	 * @param szenen neuer Wert überschreibt szene
	 */
	public void setSzene(List<Szene> szenen) {
		if (szenen != null) {
			this.szenen = szenen;
			System.out.println("INFO: Die Liste der Szene wurde neu initialisiert");
		}
	}

	/**
	 * Die Methode fügt eine neue Szene in die Liste ein.
	 * 
	 * @param szene der Szene der in die Liste eingefügt wird.
	 * @return true wenn die Szene erfolgreich eingefügt wird sonst wird false
	 *         zurückgegeben
	 */
	public boolean einfuegenSzene(Szene szene) {
		if (szenen.contains(szene)) {
			System.out.println("ERROR: Der Szene (" + szene.getId() + ") ist bereits in der Liste eingetragen");
			return false;
		}
		szenen.add(szene);
		return true;
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
	 * Die Methode gibt die Vornamen und Nachnamen der Personen in der Liste (Star,
	 * Regiesseure und Authoren) zeilenweise aus
	 * 
	 * @param personen die Liste der Personen
	 * @return personennamen die Namen die zeilenweise ausgegeben werden
	 */
	private String namenausgabe(List<Person> personen) {
		String personennamen = "";
		for (int i = 0; i < personen.size(); i++) {
			Person person = personen.get(i);
			if (i < personen.size() - 1) {
				personennamen += person.getNamen() + "\n";
			} else {
				personennamen += person.getNamen();
			}
		}
		return personennamen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		String starnamen = namenausgabe(stars);
		String regiesseurnamen = namenausgabe(regisseure);
		String authornamen = namenausgabe(authoren);
		String genresAlsString = "";
		for (String genre : this.genres) {
			genresAlsString += genre + ",";
		}

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		String datum = date.format(produktionsDatum);

		String ausgabe = id + "\t" + titel + "\t" + datum + "\n\t" + starnamen + "\n\t" + regiesseurnamen + "\n" + "\t"
				+ authornamen + "\n\t" + genresAlsString;
		return ausgabe;
	}
}
