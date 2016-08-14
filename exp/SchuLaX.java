package exp;

public class SchuLaX extends SchuLa {
	/*
	 * @info: Diese Klasse bietet zusätzliche Administrative und Management-Funktionen, die nicht allgemein
	 * verfuegbar sein sollen.
	 */
	
//oeffentlicher Bereich:
	/*
	 * @super: folgende Methoden werden der superclass uebernommen.
	 * um eine Konsistenz der Objeckte sicherzustellen wird entsprechend auf das Mutterobjeckt verwiesen.
	 * Durch die Referenzierung werden die Objekte über die Mutterklasse bezogen, statt in dieser Instanz separat geführt zu werden.
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
	
	public newSchuh(Schuh neuerSchuh){
		Schuh closesMatch = super.getSchuhlist(neuerSchuh, 1)[0];
		
	}
//geschuetzter Bereich
}
