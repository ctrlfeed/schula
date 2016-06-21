package exp;

import java.io.Serializable;
import java.util.Hashtable;

public class Lager implements Serializable{
	
	//Festlegung lager-weiter Variablen: 
	
	//Eine Fortlaufende Nummer ueber alle Schuhmodelle wird gefuehrt
	private static int KartonItr;
	//um manipulation zu schützen, ist das abrufen einer neuen ID erlaubt, 
	//aber erhoehe den Zaehler der erfassten Modelle um 1 erhoeht...
	protected static String getKartonID(){
		return Integer.toString(++KartonItr, 16);
	}
	
	//Fortlaufende Nummer unterscheidbarer Schuharten:
	//wie für Kartons ist eine neue ID abrufbar, dabei wird der Zaehler um 1 erhoeht.
	private static int SchuhIter;
	protected static String getSchuhID(){
		return Integer.toString(++SchuhIter, 16);
	}
	private static int RegalIter;
	protected static String getRegalID(){
		return Integer.toString(++RegalIter, 16);
	}
	
	/*Abbildung des "Lagers" --> Sammlung von Regalen, durch Hashtable hier flexibel gehalten,
	 * um eine Erweiterung und dabei konsistente Haltung zu ermöglichen
	 */
	private Hashtable<String, Regal> lagerplatz;
	protected void addRegal(){
		Regal r = new Regal();
		lagerplatz.put(r.name(), r);
	}
	/*
	 * Suche nach freiem Fach: offen...
	 */
}
