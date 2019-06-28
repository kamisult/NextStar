/**
 *
 */
package de.htwberlin.prog1.ss19.nextstar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import de.htwberlin.prog1.ss19.nextstar.model.Accessoires;
import de.htwberlin.prog1.ss19.nextstar.model.Assets;
import de.htwberlin.prog1.ss19.nextstar.model.Film;
import de.htwberlin.prog1.ss19.nextstar.model.Kleidung;
import de.htwberlin.prog1.ss19.nextstar.model.Person;
import de.htwberlin.prog1.ss19.nextstar.model.Produktion;
import de.htwberlin.prog1.ss19.nextstar.model.Schmuck;
import de.htwberlin.prog1.ss19.nextstar.model.Serien;
import de.htwberlin.prog1.ss19.nextstar.model.Set;
import de.htwberlin.prog1.ss19.nextstar.model.Szene;

/**
 * @author Kamila Sultanova
 */
public class MenuHandler {

	private static Scanner scanner = new Scanner(System.in);

	private static SimpleDateFormat datumformat = new SimpleDateFormat("dd/MM/yyyy");
	private static ProduktionsManager produktionsManager = new ProduktionsManager();
	private static Produktion produktion;

	
	public static void main(String[] args) {

		while (true) {
			showMenu();
			int choice = readUserInput();
			handle(choice);
			System.out.println("====================");
		}
	}

	/**
	 * Die Methode list eine Zahl über die Tastatur ein.
	 * 
	 * @return choice die eingelesene Zahl
	 */
	private static int readUserInput() {
		System.out.print("Bitte, geben Sie die Nummer des Menüeintrages ein:\t");
		int choice = scanner.nextInt();
		return choice;
	}

	/**
	 * Diese Methode führt den Benutzer durch die Menüführung
	 * 
	 * @param choice ist die Menünummer die der Benutzer auswählt
	 */
	private static void handle(int choice) {

		switch (choice) {
		case 1:
			addProduction();
			break;
		case 2:
			erstelleSzene();
			break;
		case 3:
			erstelleSet();
			break;
		case 4:
			assetAnlegen();
			break;
		case 5:

			System.out.println("Nicht implementiert. Siehe neue Aufgabenstellung");
			break;

		case 6:
			List<Produktion> produktionsliste = produktionsManager.getProduktionsliste();

			System.out.println(
					"Wählen Sie nun die Produktion mittels ID aus, zu der alle Szene und Sets ausgegeben werden soll.");
			for (Produktion produktion : produktionsManager.getProduktionsliste()) {
				if (produktion instanceof Film) {
					Film film = (Film) produktion;
					System.out.println(film.toString());
				}
				if (produktion instanceof Serien) {
					Serien serien = (Serien) produktion;
					System.out.println(serien.toString());
				}
			}
			String produktionID = scanner.next();

			List<Szene> szenenListe = ausgabeSzeneInProduktion(produktionID, produktionsliste);
			if (szenenListe.isEmpty() == true) {
				System.out.println(
						"Die Produktion mit der ID '" + produktionID + "' enthält keine Szenen und keine Sets");
			} else {
				ausgabeSetInSzene(szenenListe);
			}

			break;
		case 7:
			// Alle Informationen einer Produktion anzeigen
			System.out.println("Nicht implementiert. Siehe neue Aufgabenstellung");
			break;
		case 8:
			System.out.println("Nicht implementiert. Siehe neue Aufgabenstellung");
			break;
		case 9:
			System.out.println("Nicht implementiert. Siehe neue Aufgabenstellung");
			break;
		case 10:
			System.out.println("Das Programm wird beendet.");
			System.exit(0);
			break;
		default: {
			System.out.println("Ungültige Eingabe. Bitte Ihre Eingabe überprüfen");
			showMenu();
		}
		}
	}

	/**
	 * Die Methode ersllt eine neue Produktion mit allen ihren Eigenschaften. Dabei
	 * wird für jede PRoduktion unterschieden ob es sich um ein Film- oder
	 * Serienproduktion handelt. Weiterhin müssen in der Produktion mindestens 1
	 * Star, mind. 1 Regiesseur und mind. 1 Author zugeordnet sein.
	 */
	private static void addProduction() {

		System.out.println("Produktion anlegen - Stammdaten");
		String idProduktion = erstelleID();
		System.out.println("Geben Sie den Title für die Produktion ein.");
		String title = scanner.next();
		System.out.println(
				"Geben Sie den Produktionsdatum in folgendem Format (dd/mm/yyyy) ein. Benutzen Sie das Symbol '/' für die Trennenung bsp: 28/06/2019");
		String datumEingabe = scanner.next();
		while (datumEingabe.substring(2, 3).equals("/") == false || datumEingabe.substring(5, 6).equals("/") == false) {
			System.out.println("ERROR: Die Eingabe für das Datum ist falsch.");
			System.out.println(
					"INFO: Bitte geben Sie den Produktionsdatum in folgendem Format (dd/mm/yyyy) ein. Benutzen Sie das Symbol '/' für die Trennenung bsp: 28/06/2019\"");
			datumEingabe = scanner.next();
		}
		Date datum = null;
		try {
			datum = datumformat.parse(datumEingabe);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		System.out.println("Bitte geben Sie 0 für Filmproduktion und 1 für Serienproduktion ein");
		int art = scanner.nextInt();
		while (art != 0 && art != 1) {
			System.out.println("Eingabefehler: Bitte geben Sie 0 für Filmproduktion und 1 für Serienproduktion ein");
			art = scanner.nextInt();
		}

		if (art == 0) {
			System.out.println("Ein Film wird produziert");
			System.out.println("Geben Sie bitte die Zeitdauer in Stunden an.");
			int zeitdauer = scanner.nextInt();

			produktion = new Film(idProduktion, title, datum, zeitdauer);
			System.out.println("Filmproduktion wurde angelegt");

		}
		if (art == 1) {
			System.out.println("Eine Serie wird produziert");
			System.out.println("Geben Sie bitte die Anzahl der Episonden an.");
			int episoden = scanner.nextInt();

			produktion = new Serien(idProduktion, title, datum, episoden);

			System.out.println("Serienproduktion wurde angelegt");
		}

		System.out.println("Wie viele Stars möchten Sie zu der Produktion einfügen?");
		int anzahlPersonen = scanner.nextInt();
		while (anzahlPersonen <= 0) {
			System.out.println("Bitte fügen Sie mindestens einen Star zu der Produktion hinzu.");
			anzahlPersonen = scanner.nextInt();
		}
		List<Person> stars = erstellePersonen(anzahlPersonen);
		produktion.setStars(stars);

		System.out.println("Wie viele Autohren möchten Sie zu der Produktion einfügen?");
		anzahlPersonen = scanner.nextInt();
		while (anzahlPersonen <= 0) {
			System.out.println("Bitte fügen Sie mindestens einen Author zu der Produktion hinzu.");
			anzahlPersonen = scanner.nextInt();
		}
		List<Person> authoren = erstellePersonen(anzahlPersonen);
		produktion.setAuthoren(authoren);

		System.out.println("Wie viele Regiesseure möchten Sie zu der Produktion einfügen?");
		anzahlPersonen = scanner.nextInt();
		while (anzahlPersonen <= 0) {
			System.out.println("Bitte fügen Sie mindestens einen Regiesseur zu der Prioduktion hinzu.");
			anzahlPersonen = scanner.nextInt();
		}
		List<Person> regiesseure = erstellePersonen(anzahlPersonen);
		produktion.setRegisseure(regiesseure);

		System.out.println("Geben Sie nun die Genres getrennt mit einem Komma ein");
		String genres = scanner.next();
		if (genres.contains(",")) {
			String[] genreArray = genres.split(","); // Action,Drama,SciFi => [0]= Action, [1] = Drama, [2]= SciFi
			produktion.setGenres(Arrays.asList(genreArray));
		} else {
			List<String> genresList = new LinkedList<>();
			genresList.add(genres);
			produktion.setGenres(genresList);
		}

		produktionsManager.produktionEinfuegen(produktion);

	}

	// (02) Eine Szene erstellen und zum Produktion zuweisen.
	/**
	 * Die Methode erstellt eine Szene und weisst diese zu einer Produktion zu in
	 * dem man die ID der Produktion eingibt.
	 */
	public static void erstelleSzene() {
		System.out.println("Szene anlegen und zu der Produktion zuordenen");
		String id = erstelleID();
		Szene szene = new Szene(id);

		System.out.println("Wählen Sie nun die Produktion mittels ID aus, zu der die Szene zugeordnet werden soll.");
		// Ausgabe der Filme und Serie in der Konsole
		for (Produktion produktion : produktionsManager.getProduktionsliste()) {
			if (produktion instanceof Film) {
				Film film = (Film) produktion;
				System.out.println(film.toString());
			}
			if (produktion instanceof Serien) {
				Serien serien = (Serien) produktion;
				System.out.println(serien.toString());
			}
		}

		String prodID = scanner.next();
		Produktion produktion = null;
		boolean szeneInListeEnthalten = istSzeneZugeordnet(szene);

		if (szeneInListeEnthalten == true) {
			System.out.println("ERROR: Die Szene ist bereits einer Produktion zugeordnet!");
		}

		for (Produktion p : produktionsManager.getProduktionsliste()) {
			if (p.getId().equals(prodID)) {
				produktion = p;
			}
		}

		if (produktion != null) {
			if (produktion.einfuegenSzene(szene) == true) {
				System.out.println(
						"INFO: Die Szene mit ID: " + szene.getId() + " wurde erfolgreich zu der Produktion zugeordnet");
			} else {
				System.out.println(
						"ERROR: Die Szene mit ID: " + szene.getId() + " wurde nicht zu der Produktion zugeordnet");
			}
		}
	}

	/**
	 * Die Methode überprüft ob eine Szene bereits zu einer Produktion zugeordnet
	 * wurde.
	 * 
	 * @param szene die Szene die überprüft wurd ob diese bereits zugeordnet wurde.
	 * @return true wenn die Szene bereits zugeordnet wurde sonst false
	 */
	private static boolean istSzeneZugeordnet(Szene szene) {

		for (Produktion p : produktionsManager.getProduktionsliste()) {
			for (Szene suchSzene : p.getSzene()) {
				if (suchSzene.getId().equals(szene.getId())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Die Methode erstellt eine eindeutige ID für jedes Objekt.
	 * 
	 * @return id die erstellte ID
	 */
	public static String erstelleID() {
		String id = UUID.randomUUID().toString().split("-")[4];
		return id;
	}

	// 3. Menupunkt: Set (ID, Star) anlegen und Szene zuordnen
	/**
	 * Die Methode erstellt ein Set und weist diese zu eine Szene zu
	 */
	public static void erstelleSet() {
		System.out.println("Set wird angelegt und Szene zuordnen");
		String setID = erstelleID();

		Person star = erstellePerson();

		Set set = new Set(setID);
		set.setStar(star);

		System.out.println("Wählen Sie nun die Szene mittels ID aus, zu der das Set zugeordnet werden soll.");
		List<Produktion> produktionsliste = produktionsManager.getProduktionsliste();
		for (Produktion produktion : produktionsliste) {
			List<Szene> szenenListe = produktion.getSzene();
			for (Szene szene_ : szenenListe) {
				System.out.println(szene_.ausgabeSzeneOhneSet());
			}
		}
		String szeneID = scanner.next();
		boolean szeneGefunden = false;

		for (Produktion produktion : produktionsliste) {
			List<Szene> szenenListe = produktion.getSzene();
			for (Szene s : szenenListe) {
				if (s.getId().equals(szeneID)) {
					szeneGefunden = true;
					s.einfuegenSet(set);

				}
			}
		}
		while (szeneGefunden == false) {
			for (Produktion produktion : produktionsliste) {
				List<Szene> szenenListe = produktion.getSzene();
				for (Szene s : szenenListe) {
					System.out.println(s.toString());
				}
			}
			System.out.println("ERROR: Zu der eingegebene Szenen id konnte keine Szene gefunden werden");
			System.out.println("Geben Sie erneut eine id ein");
			szeneID = scanner.next();
			for (Produktion produktion : produktionsliste) {
				List<Szene> szenenListe = produktion.getSzene();
				for (Szene s : szenenListe) {
					if (s.getId().equals(szeneID)) {
						szeneGefunden = true;
						s.einfuegenSet(set);
					}
				}
			}

		}

		System.out.println("Das Set wurde erfolgreich zu der Szene zugeordnet");

	}

	// 4. Menupunkt: Asset anlegen
	/**
	 * Die Methode erstellt ein Asset und weisst diese zu einem Set zu. Der User
	 * muss sich zwischen den Assets 'Kleidung, Schmuck und Accessoires' entscheiden
	 * 
	 */
	public static void assetAnlegen() {
		System.out.println("Assets werden angelegt");

		System.out.println("Was möchten Sie anlegen?");
		System.out.println("1\tKleidung");
		System.out.println("2\tSchmuck");
		System.out.println("3\tAccessoires");

		int menupunkt = scanner.nextInt();
		while (menupunkt <= 0 || menupunkt >= 4) {
			System.out.println("ERROR: Der eingegebene Menupunkt existiert nicht!");
			System.out.println("Bitte erneut ein Menupunkt auswählen");
			menupunkt = scanner.nextInt();
		}
		Assets assets = null;
		switch (menupunkt) {
		case 1:
			System.out.println("Ein Kleidung wird aufgenommen!");
			String kleidungID = erstelleID();
			System.out.println("Welche Farbe soll die Kleidung haben?");
			String farbeKleidung = scanner.next();
			System.out.println("Welche Größe hat die Kleidung? (...,S,M,L,XL,...)");
			String groesse = scanner.next();
			System.out.println("Welchen Typ hat die Kleidung?");
			String typ = scanner.next();
			assets = new Kleidung(kleidungID, farbeKleidung, groesse, typ);
			break;
		case 2:
			System.out.println("Ein Schmuckstück wird aufgenommen!");
			String schmuckID = erstelleID();
			System.out.println("Welche Farbe soll der Schmuck haben?");
			String farbeSchmuck = scanner.next();

			System.out.println("Welche Schmuckart hat der Schmuck?");
			String schmuckart = scanner.next();
			assets = new Schmuck(schmuckID, farbeSchmuck, schmuckart);
			break;

		case 3:

			System.out.println("Ein Accessoire wird aufgenommen!");
			String accessoiresID = erstelleID();
			System.out.println("Welche Farbe soll das Accessoire haben?");
			String farbeAccessoire = scanner.next();

			System.out.println("Welche Accessoireart hat der Accessoire?");
			String accessoiresArt = scanner.next();
			assets = new Accessoires(accessoiresID, farbeAccessoire, accessoiresArt);

			break;

		default:
			break;
		}

		System.out.println("Wählen Sie nun das Set mittels ID aus, zu der das Asset zugeordnet werden soll.");
		List<Produktion> produktionsliste = produktionsManager.getProduktionsliste();
		alleSetsAusgeben(produktionsliste);

		String setID = scanner.next();

		boolean setGefunden = setGefundenUndGespeichert(setID, produktionsliste, assets);

		while (setGefunden == false) {
			// Ausgabe von Sets
			alleSetsAusgeben(produktionsliste);

			System.out.println("ERROR: Zu der eingegebene Szenen id konnte keine Szene gefunden werden");
			System.out.println("Geben Sie erneut eine id ein");
			setID = scanner.next();
			setGefunden = setGefundenUndGespeichert(setID, produktionsliste, assets);

		}

	}

	/**
	 * Die Methode sucht nach einer konkreten Set in einer Produktion und ordnet ein
	 * konkretes Assets zu dem Set zu.
	 * 
	 * @param setID            die ID der gesuchten Set
	 * @param produktionsListe die Liste der Produktionen die durchsucht wird
	 * @param assets           das Asset das zu dem Set zugeordnet wird
	 * @return true wenn das Asset erfolgreich eingefügt wurde sonst false
	 */
	private static boolean setGefundenUndGespeichert(String setID, List<Produktion> produktionsliste, Assets assets) {

		for (Produktion produktion : produktionsliste) {
			List<Szene> szenenListe = produktion.getSzene();
			for (Szene szene : szenenListe) {
				List<Set> setList = szene.getSets();
				for (Set set : setList) {
					if (set.getId().equals(setID)) {

						set.einfuegenAsset(assets);
						System.out.println("INFO: Das Asset wurde erfolgreich zum Set " + set.getId() + " zugeordnet");
						return true;
					}
				}
			}
		}
		return false;
	}

	// 4. Menupunkt: Asset anlegen
	/**
	 * Die Methode listet alle Sets und gibt die in Konsole aus
	 * 
	 * @param produktionsliste die Liste der Produktionen die durchsucht wird
	 */
	public static void alleSetsAusgeben(List<Produktion> produktionsliste) {
		for (Produktion produktion : produktionsliste) {
			List<Szene> szenenListe = produktion.getSzene();
			for (Szene s : szenenListe) {
				List<Set> setList = s.getSets();
				for (Set set : setList) {
					System.out.println(set.toString());
				}
			}
		}
	}

	// (06) Alle Szenen und Sets einer Produktion anzeigen
	/**
	 * Die Methode erstellt eine Liste an Szene die einer Produktion zugeorgnet
	 * wurden und gibt diese zurück
	 * 
	 * @param produktionID     die ID der Produktion wonach gesucht wird
	 * @param produktionsListe die Liste der Produktionen die durchsucht wird
	 * @return szeneList die Liste aller Szenen die zu einer Produktion zugeordnet
	 *         wurden.
	 */
	public static List<Szene> ausgabeSzeneInProduktion(String produktionID, List<Produktion> produktionsListe) {
		for (Produktion produktion : produktionsListe) {
			if (produktion.getId().equals(produktionID)) {
				List<Szene> szeneList = produktion.getSzene();
				return szeneList;
			}
		}

		return null;
	}

	// (06) Alle Szenen und Sets einer Produktion anzeigen
	/**
	 * Die Methode zeigt alle Szenen und Sets einer Produktion an
	 * 
	 * @param szeneList die Liste der Szenen die durchsucht werden
	 */
	public static void ausgabeSetInSzene(List<Szene> szeneList) {
		for (Szene szene : szeneList) {
			System.out.println(szene.ausgabeSzeneOhneSet());
			List<Set> setListe = szene.getSets();
			for (Set set : setListe) {
				System.out.println(set.toString());
			}
		}
	}

	// (06) Alle Szenen und Sets einer Produktion anzeigen
	/**
	 * Die Methode erstellt eine Liste an Sets ein und gibt diese zurück
	 * 
	 * @param szeneList die Liste der Szenen die durchsucht werden
	 * @return alleSetsInProduktion die Liste aller Szenen und Set die zu einer
	 *         Produktion zugeordnet wurden.
	 */
	public static List<Set> setsInSzene(List<Szene> szeneList) {
		List<Set> alleSetsInProduktion = new LinkedList<>();
		for (Szene szene : szeneList) {
			System.out.println(szene.ausgabeSzeneOhneSet());
			List<Set> setListe = szene.getSets();
			for (Set set : setListe) {
				alleSetsInProduktion.add(set);
			}
		}
		return alleSetsInProduktion;
	}

	/**
	 * Die Methode erstellt eine Person und gibt diese zurück
	 * 
	 * @return person die erstellte Person
	 */
	public static Person erstellePerson() {
		String id = erstelleID();
		System.out.println("Bitte geben Sie den Vornamen der Person ein");
		String vorname = scanner.next();
		System.out.println("Bitte geben Sie den Nachnamen der Person ein");
		String nachname = scanner.next();

		Person person = new Person(id, vorname, nachname);
		return person;
	}

	/**
	 * Die Methode erstellt eine gewisse Anzahl an Personen. Fügt diese in die Liste
	 * ein und gibt diese zurück
	 * 
	 * @param anzahlPersonen die Anzahl der Personen die erstellt werden
	 * @return personenListe die List mit den Personen
	 */
	public static List<Person> erstellePersonen(int anzahlPersonen) {
		List<Person> personenListe = new LinkedList<Person>();
		for (int i = 0; i < anzahlPersonen; i++) {
			System.out.println((i + 1) + " Star wird angelegt");
			Person person = erstellePerson();
			personenListe.add(person);
		}
		return personenListe;
	}

	/**
	 * Die Methode zeigt das Menu auf der Konsole
	 */
	private static void showMenu() {
		String menuItems[] = { "(01)\tProduktion anlegen", "(02)\tSzene anlegen und Produktion zuordnen",
				"(03)\tSet anlegen und Szene zuordnen", "(04)\tAsset anlegen",
				"(05)\tAlle Assets einer Produktion anzeigen", "(06)\tAlle Szenen und Sets einer Produktion anzeigen",
				"(07)\tAlle Informationen einer Produktion anzeigen", "(08)\tAssets einer Produktion nach Star suchen",
				"(09)\tAlle Szenen wo ein Asset genutzt wurde", "(10)\tBeenden" };

		System.out.println("\nNextStar Asset Manager 1.0\n");

		for (int i = 0; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}
	}

}
