package exp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Lager implements Serializable{
	
	//Festlegung von lager-weiten Variablen: 
	
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
	 * um eine Erweiterung und dabei konsistente Haltung zu ermöglichen.
	 * 
	 * Weiterhin eines "unlauf"-pseudo-regals, als unbestimmter Ort, an dem Schuhkartons verweilen können,
	 * allerdings dann nicht gezielt findbar sind. (trotzdem noch im Unternehmen,
	 * nur eben woanders als im Lager entweder also beim Kunden zur Anprobe, in Reinigung oder im Verkauf
	 * bei Verkauf, würde der Karton finalized werden.
	 */
	private Hashtable<String, Regal> lagerplatz;
	protected void addRegal(){
		Regal r = new Regal();
		this.lagerplatz.put(r.name(), r);
	}
	protected void addRegal(int breite, int hoehe, int kap){
		Regal r = new Regal(breite, hoehe, kap);
		this.lagerplatz.put(r.name(), r);
	}
	
	protected static Fach umlauf;
	
	/*
	 * Methoden:
	 */
	protected void lassliegen(Karton uberbleibsel){
		uberbleibsel.ablegen(umlauf);
	}
	public void verkaufen(Karton abgang){
		if (abgang.isUmlauf()){
			try {
				abgang.finalize();
			} catch(Exception e) {
				System.out.println(e);
			}
		}else {
			lassliegen(abgang);
		}
	}
	
	public void wegraeumen(Karton[] stauware){
		Fach[] ablage = platzfinden(stauware.length);
		for (Karton schachtel : stauware) {
			try{
				
			} catch(fachvollException f){
				
			}
		}
	}
	/*
	 * Suche nach freiem Fach: in Arbeit.....
	 */
	
	 public Fach[] platzfinden(int verstaumenge){
		ArrayList<Fach> resultset = null;
		for (Regal reg : this.lagerplatz.values()) {
			//bevorzugtes Verstauen in einem Regal
			if (reg.getFreiplatz(reg.getFreiraum()) >= verstaumenge){
				resultset.clear();
				for (Fach fach : reg.getFreiraum()) {
					resultset.add(fach);
				}
				
			}
		}	
	}
	public void wareAnnehmen(Schuh neuWare){
		
	}
}
