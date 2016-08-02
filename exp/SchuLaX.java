package exp;

public class SchuLaX extends SchuLa {
	/*
	 * @ueber: Diese Klasse bietet zusätzliche Administrative und Management-Funktionen, die nicht allgemein-gueltig
	 * verfuegbar sein sollen.
	 * Sie sind dadurch durch ein Kennwort (siehe private String MasterKey unten) geschützt.
	 * Diese Klasse erlaubt trotzdem die Nutzung aller Funktionen, die SchuLa zulässt.
	 */
	
//oeffentlicher Bereich:
	/*
	 * @super: folgende Methoden werden der superclass uebergeben.
	 */
	public Schuh[] getSchuhlist(Schuh Vergleichswert, int Limit){
		Schuh[] suchergebnis = super.getSchuhlist(Vergleichswert, Limit);
		return suchergebnis;
	}
	//Wird kein Limit mitgegeben, werden alle Ergebnisse mit mindestens einer Übereinstimmung zurückgegeben.
	public Schuh[] getSchuhlist(Schuh Vergleichswert){
		Schuh[] suchergebnis = super.getSchuhlist(Vergleichswert, 0);
		return suchergebnis;
	}
	
	//Ein Schuh soll mittels einer SchuhID oder KartonID auffindbar sein.
	//Welche Form Identifier sollte dabei von der Funktion selbst evaluiert werden.
	public Fach[] finde(String Identifier){
		Fach[] gefundenIn = super.finde(Identifier);
		return gefundenIn;
	}
}
