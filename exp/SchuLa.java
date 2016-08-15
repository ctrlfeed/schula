package exp;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class SchuLa extends File implements Serializable{
	/*
	 * @author: Carl L. Fritze
	 * @ansatz: SchuLa bildet den Single-point-of-Access, also den ausgewiesenen Anknuepfpunkt für 
	 * alle Bestandteile, die nicht zwingender Bestandteil der Software selbst sind.
	 * Nutzer sollen in der Lage sein, mittels der oeffentlichen Methoden dieser Klasse die gewuenschten
	 * Aktionen durchzuführen. Dies soll Folgendes bezwecken:
	 * 	- einfachere Anbindung von Komponenten (etwa GUI, andere Systemschnittstellen)
	 *  - Konsistenz: da Einzelheiten der Software nicht gezielt ansteuerbar sind, sollen Manipulationen der Inhalte vermieden werden.
	 *  - Transparenz: Entwicklern soll einfacher gemacht werden, den Quelltext nachzuvollziehen, in dem einzelne Szenarien gezielt verfolgt werden koennen.
	 *  
	 * @aufbau: jede Klasse von SchuLa ist jeweils in zwei Bereiche unterteilt:
	 * 	1. oeffentliche Methoden: zu erkennen an dem Kennzeichen "public" stellen diese eine Komponente
	 * 	   des Programmes dar, die von außen ueber den Aufruf der Klasse direkt angesteuert werden koennen.
	 *  2. geschützter Bereich: in diesem Bereich sind anschließend Konstanten, Variablen, Funktionen 
	 *     und Methoden definiert, die nur für die Software ansteuerbar sein sollen.
	 *     In diesem Bereich sollte das Access Level "public" gemieden werden.
	 *     Grundsaetzlich sollten Datenelemente nicht direkt auf public gesetzt werden. Ebenso sollte eine
	 *     Aenderung der gespeicherten Informationen nur ueber die Methoden der Klasse SchuLa oder entsprechend
	 *     geschuetzte Methoden der Einzelklassen zugelassen werden. Ein solcher Schutz kann etwa die Forderung
	 *     einer schwer zu erratenden Zeichenkette als notwendiger Parameter für diese kritischen Routinen sein,
	 *     die wiederum selbst als privates Datenelement in der Klasse gespeichert wird.
	 */
	
public SchuLa(URI uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}
	//oeffentlicher Bereich: 
	/*
	 * @getSchuhList(): erhalte ein Feld von Schuhen (eine Liste) von Schuhen, die im System gespeichert sind.
	 * Mitgegeben werden soll ein Wert der Klasse Schuh, in dem alle gesuchten Merkmale ausgeprägt sind, die Anderen leer.
	 * Die Methode gibt Schuhe sortiert nach Anzahl der übereinstimmenden Merkmale maximal in Länge des Limits zurück.
	 * Ist Limit auf "0" gesetzt, werden alle Schuhe mitgegeben, die in mindestens einem Merkmal übereinstimmen.
	 * Diese Option ist geschuetzt, da sie sich laufzeitkritisch auswirken kann. (siehe unten)
	 */
	public Schuh[] getSchuhlist(Schuh Vergleichswert, int Limit){
		Hashtable<String, Integer> resultset = new Hashtable<String, Integer>();
		for (Entry entry : schuhkatalog.entrySet()) {
			//nur vorraetige Exemplare pruefen
			if (((Schuh) entry.getValue()).getAnzahl() > 0){
				Schuh siterate = (Schuh) entry.getValue();
				//die Zahl der übereinstimmenden Merkmale wird festgehalten, um eine Sortierung vornehmen zu können.
				int score = 0;
				if ((siterate.getMarke() == Vergleichswert.getMarke()) && (siterate.getMarke() != null)){
					score +=1;
				}
				if ((siterate.getGroesse() == Vergleichswert.getGroesse()) && (siterate.getGroesse() != 0)){
					score +=1;
				}
				if ((siterate.getStil() == Vergleichswert.getStil()) && (siterate.getStil() != null)){
					score +=1;
				}
				if ((siterate.getFarbe() == Vergleichswert.getFarbe()) && (siterate.getFarbe() != null)){
					score +=1;
				}
				if ((siterate.getName() == Vergleichswert.getName()) && (siterate.getName() != null)){
					score +=1;
				}
				if (score > 0){
					resultset.put(siterate.getID(), score);
				}
			}
			//bei Ergebnislimitierung, entferne den verschiedensten Suchwert
			if ((Limit > 0) &&(resultset.size() > Limit)){
				String leastcommon = null;
				int least = 6;
				for (String resultID : resultset.keySet()) {
					if (resultset.get(resultID) < least){
						leastcommon = resultID;
						least = resultset.get(resultID);
					}
				}
				resultset.remove(leastcommon);
			}
			//trimmen ende, prüfe nächstes Element
		}
		//durchsuchen des Schuhkataloges und vorraetiger Elemente abgeschlossen.
		//das ergebnis wird aus der variablen Hashtable in ein Feld fixer Größe überführt.
		ArrayList<Schuh> suchergebnis = new ArrayList<Schuh>();
		for (String resID : resultset.keySet()){
			//in Liste einsortieren, neue Elemente groesserer aehnlichkeit weiter nach vorn.
			//iterator durch die Liste
			int posi = 0;
			//setze einfuegepunkt weiter, wenn element gleich viele oder weniger uebereinstimmungen hat.
			while (resultset.get(resID) > resultset.get(suchergebnis.get(posi).getID()) && posi > suchergebnis.size()) {
				++posi;
			}
			suchergebnis.add(posi, schuhkatalog.get(resID));
		}
		return ((Schuh[]) suchergebnis.toArray());
	}
	//Ein Schuh soll mittels einer SchuhID oder KartonID auffindbar sein.
	//Welche Form Identifier sollte dabei von der Funktion selbst evaluiert werden.
	public Fach[] finde(String Identifier){
		Fach[] gefundenIn = null;
		return gefundenIn;
	}
	public Fach[] platzfuer(int verstaumenge, boolean zusammenhaengend){
		ArrayList<Fach> resultset = null;
		for (Regal reg : lagerplatz.values()) {
			//bevorzugtes Verstauen in einem Regal
			if (reg.getFreiplatz(reg.getFreiraum()) >= verstaumenge || !zusammenhaengend){
				for (Fach fach : reg.getFreiraum()) {
					if (resultset.size() < verstaumenge)
					resultset.add(fach);
				}
			}
		}
		//wenn es nicht möglich gewesen sein sollte die Verstaumenge in einem Regal unter zu bringen,
		//wäre zu erwarten, dass "resultset" nicht mit Fächern gefüllt wäre. Für den Fall sollte eine nicht zusammenhängende Variante gewählt werden.
		if (resultset.size() < verstaumenge && zusammenhaengend){
			return platzfuer(verstaumenge-resultset.size(),false);
		} else {
			System.out.println("Unzureichend Lagerplatz für diese Menge.");
		}
		return (Fach[]) (resultset.toArray());
	}
	
//geschuetzte Objekte:
	/*
	 * @path: Dies markeirt den Speicherort, in dem SchuLa serialisiert wird und von wo SchuLa geladen wird.
	 */
	private File thisishome;
	/* 
	 * @Itr: Um eine eindeutige, instanzweite Identifizierung zu ermöglichen, wird fuer alle wiederkehrende Elemente 
	 * je eine fortlaufende Nummer gefuehrt, die allerdings nicht direkt vergeben wird. Stattdessen ist sie ueber 
	 * eine jeweilige ID generierende Methode geschützt automatisiert abrufbar (siehe untern)
	 */
	
	//fortlaufende Nummer fuer Karton-IDs (=Anzahl unterscheidbarer Kartons im System seit Installation)
	private static int KartonItr;
		
	//fortlaufende Nummer fuer unterscheidbare Schuhe (Anzahl verschiedenartiger Schuhe um mindestens 1 Merkmal)
	private static int SchuhItr;
	
	/*
	 * @Regal: fortlaufende Nummer fuer Regale erlaubt eine eindeutige Identifizierung (per Namensgebung) fuer Regale
	 * Faecher werden systematisch vergeben. Es wird unterstellt, dass ein Regal gleichgrosse rechtwinklige Faecher
	 * umfasst. Diese werden mittels Entfernung vertikaler und horizontaler Entfernung von einer der Kanten nummeriert.
	 * Dazu wird bei Anlage des Regals jedem Fach ein Zeilen und ein Spaltenwert zur Identifikation zugeordnet.
	 * Bei unterschiedlich großen Fächern sind mehrere separate "fiktiv getrennte" Regale zu erfassen.
	 */
	private static int RegalItr;
	
	/*
	 * @Lager: Das Lager wird mittels einer Hashtable von String(RegID) und dem Regal selbst abgebildet.
	 * Die Entscheidung zu dieser Umsetzung lässt sich wie folgt begründen:
	 *  + Eine Hashtable ist beliebig um Elemente erweiterbar und bietet somit einen klaren Vortiel hinsichtlich
	 *    der Flexibilität und Erweiterbarkeit gegenüber Feldern
	 *  + Über eine Hashtable kann gezielt nach einem bestimmten Element innerhalb des Objektes gesucht werden.
	 *  + Eine Hashtable laesst einen Parallelen Zugriff zu. Unter dem Gedanken, dass perspektivisch mehrere Anfragen
	 *    parallel gestellt würden, ließe dies einen performanten Vorteil zu.
	 *  + Eine Hashtable sichert von sich aus, dass sie lückenfrei bleibt und sichert somit Konsistenz.
	 *  Als Werte wurden die Klassen Regal und Schuh (unmittelbar) gewählt, da so das Objekt direkt referenziert wird und somit
	 *  die verwalteten Objekte nicht als separate Objekte und Klassen außerhalb der Umgebung ansteuerbar sein muessen.
	 *  Als Key wurde jeweils die Regal-ID gewaehlt, um so die Transparenz über die Klassen zu halten.
	 *  Ein Regal, wie ein Schuh ist dabei grundsätzlich durch die jeweilige ID eindeutig identifizierbar.
	 *    
	 */
	private static Hashtable<String, Regal> lagerplatz;
	
	private static Hashtable<String, Schuh> schuhkatalog;
	
	//Zugriff im Package notwendig:
	/*
	 * @umlauf:  Defnition zweier Pseudo-regale, als unbestimmter Ort, an dem Schuhkartons verweilen können,
	 * allerdings dann nicht gezielt findbar sind. (trotzdem noch im Unternehmen, etwa in der Auslage oder Anprobe)
	 * Veräußerte Kartons werden dem Fach abgang zugeordnet, sodass die Kartons mit abgangsdatum nachvollziehbar 
	 * weiterhin erfasst sind.
	 */
	static Fach umlauf;
	static Fach abgang;
	
// geschuetzte Methoden:
	/*
	 * @ID-Vergabe:  
	 */
	protected static String generateKartonID(){
		return Integer.toString(++KartonItr, 16) + "K";
	}
	protected static String generateSchuhID(){
		return Integer.toString(++SchuhItr, 16) + "S";
	}
	protected static String generateRegalID(){
		return Integer.toString(++RegalItr, 16) + "R";
	}

	/*
	 * @addRegal: Eine Neue Instanz eines Regals wird per Konstruktor aufgerufen und
	 * anschließend in die Verwaltung Lagerplatz unmittelbar aufgenommen.
	 * Das neu erfasste Regal ist dadurch zur Speicherung von Objekten verfügbar. 
	 */
	void addRegal(){
		Regal r = new Regal();
		lagerplatz.put(r.getID(), r);
	}
	void addRegal(int breite, int hoehe, int kap){
		Regal r = new Regal(breite, hoehe, kap);
		lagerplatz.put(r.getID(), r);
	}
	void endRegal(Regal altRegal){
		if (altRegal.isEmpty()) {
			lagerplatz.remove(altRegal.getID());
		} else {
			System.out.println("In dem Regal befinden sich noch Elemente. Bitte entferne diese, um das Regal anschließend zu löschen.");
		}
	}
	/*
	 * @addSchuh(): hinzufügen einer neuen Schuh-instanz als Eigenschaftskombination, der dann Kartons zugeordnet werden können.
	 */
	void addSchuh(Schuh eingabeschuh){
		Schuh s = new Schuh(eingabeschuh.getStil(),eingabeschuh.getGroesse(),eingabeschuh.getFarbe(),eingabeschuh.getStil(),eingabeschuh.getName());
		schuhkatalog.put(s.getID(), s);
	}
	/*
	 * addKarton(... ): Nehme einen neuen Karton in den Bestand auf/bilde ihn in dem System ab.
	 * Ohne spezifizierten Rückgabewert findet, wird der Ort "umlauf" angenommen.
	 */
	void addKarton(Schuh schuhzugang){
		Karton k = new Karton(schuhzugang);
	}
	//funktional Reihenfolge: der Karton wird erst ins Unternehmen aufgenommen und dann dem Fach zugewiesen.
	void addKarton(Schuh schuhzugang, Fach initialort){
		Karton k = new Karton(schuhzugang);
		k.ablegen(initialort);
	}
	void moveKarton(Karton versetzterK, Fach neuesFach){
		versetzterK.ablegen(neuesFach);
	}
	/*
	 * @getSchuhList(null):Wird kein Limit mitgegeben, werden alle Ergebnisse mit mindestens einer 
	 * Übereinstimmung zurückgegeben. (Inventur) -- geschuetzt da Laufzeitkritisch
	 */
	Schuh[] Inventur(){
		return this.getSchuhlist();
	}
	Schuh[] getSchuhlist(){
		//ergbenis wird zunaechst in groessenvariabler ArrayList zwischengespeichert.
		ArrayList<Schuh> suchergebnis = new ArrayList<Schuh>();
		for (Entry entry : schuhkatalog.entrySet()) {
			//nur vorraetige Exemplare pruefen
			if (((Schuh) entry.getValue()).getAnzahl() > 0){
				Schuh siterate = (Schuh) entry.getValue();
				suchergebnis.add(siterate);
			}
		}
		//keine Sortierung der Ergebnisse
		return ((Schuh[]) suchergebnis.toArray());
	}


}