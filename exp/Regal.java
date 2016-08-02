package exp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Regal extends SchuLa{
	private Hashtable<String, Fach> faecher;
	private String bezeichner;
	
	/* Konstruktoren:
	 * ohne Parameter -> Annahme der Dimensionen 1x1 und Kapazitaet 1;
	 */
	protected Regal(){
		this(1,1,1);
	}
	/*
	 * nur in einer Dimension -> Annahme der anderen Dimensionen = 1
	 */
	protected Regal(int anzahl){
		this(anzahl, 1, 1);
	}
	protected Regal(int breite, int hoehe){
		this(breite, hoehe, 1);
	}
	protected Regal(int breite, int hoehe, int kap){
		if (breite > 0 && hoehe > 0){
			this.bezeichner = generateRegalID();
			for (int i = 1; i <= breite; i++) { //Spalten im Regal
				for (int j = 0; j < hoehe; j++) { //Zeilen im Regal
					Fach f = new Fach(this.bezeichner + "." + Integer.toString(i) + "-" + Integer.toString(j), kap);
					this.faecher.put(f.name(), f);
				}
			}
		} else {
			//throw unzulaessige-dimensionen-exception
			System.out.println("ein derartiges Regal lässt sich nicht anlegen.");
		}
	}
	
	/*
	 * Methoden:
	 */
	public String name(){
		return bezeichner;
	}
	
	//ueberpruefe alle Faecher auf freie Plaetze
	public Fach[] getFreiraum(){
		List<Fach> freiFaecher = new ArrayList<Fach>();
		//freiFaecher ist das Result-Set als Variable Länge definiert...
		//Überprüfung jedes Faches, wie viele/ob noch Plätze für Kartons frei sind
		for (Fach potentialfrei : this.faecher.values()) {
			if (potentialfrei.freiraum()>0){
				freiFaecher.add(potentialfrei);
				//in dem Fach ist noch Platz, wird in mögliche Ergebnisliste aufgenommen.
			}
		}
		Fach[] effeff = new Fach[freiFaecher.size()];
		effeff = freiFaecher.toArray(effeff);
		return effeff;
	}
	public int getFreiplatz(Fach[] freiraum){
		int freiplatz=0;
		for (Fach fach : freiraum) {
			freiplatz+=fach.freiraum();
		}
		return freiplatz;
	}

}
