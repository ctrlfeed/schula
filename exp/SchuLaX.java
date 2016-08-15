package exp;

public class SchuLaX extends SchuLa {
	/*
	 * @info: Diese Klasse bietet zus�tzliche Administrative und Management-Funktionen, die nicht allgemein
	 * verfuegbar sein sollen.
	 */
	
//oeffentlicher Bereich:
	public boolean changeKey(String oldKey, String newKey1, String newKey2){
		if (newKey1 == newKey2 && oldKey == masterKey){
			masterKey = newKey1;
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			return true;
		} else {
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			return false;
		}
	}
	/*
	 * @super: folgende Methoden werden der superclass uebernommen.
	 * um eine Konsistenz der Objeckte sicherzustellen wird entsprechend auf das Mutterobjeckt verwiesen.
	 * Durch die Referenzierung werden die Objekte �ber die Mutterklasse bezogen, statt in dieser Instanz separat gef�hrt zu werden.
	 */
	public Schuh[] getSchuhlist(Schuh Vergleichswert, int Limit){
		Schuh[] suchergebnis = super.getSchuhlist(Vergleichswert, Limit);
		return suchergebnis;
	}
	//Wird kein Limit mitgegeben, werden alle Ergebnisse mit mindestens einer �bereinstimmung zur�ckgegeben.
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
	public Fach[] platzfuer(int verstaumenge, boolean zusammenhaengend){
		return super.platzfuer(verstaumenge, zusammenhaengend);
	}
	public void addRegal(){
		super.addRegal();
	}
	public void addRegal(int breite, int hoehe, int kap){
		super.addRegal(breite, hoehe, kap);
	}
	public void endRegal(Regal altRegal){
		super.endRegal(altRegal);
	}
	public void addSchuh(Schuh neuerSchuh){
		super.addSchuh(neuerSchuh);
	}
	//SchuLa soll neuen Karton abbilden als neues Karton Objekt mit Inhalt und Ablageort
	//wird kein Ablageort spezifiziert, wird umlauf angenommen.
	public void addKarton(Schuh schuhzugang){ super.addKarton(schuhzugang); }
	public void addKarton(Schuh schuhzugang, Fach ablageFach){
		super.addKarton(schuhzugang, ablageFach)
	}
	public void moveKarton(Karton versetzterK, Fach neuesFach){
		super.moveKarton(versetzterK, neuesFach);
	}
	public Schuh[] Inventur(){
		return super.Inventur();
	}
//geschuetzter Bereich
	private String masterKey = "SchuLa2016";
}
