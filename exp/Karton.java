package exp;

import java.io.Serializable;
import java.sql.Timestamp;

public class Karton extends Schuh implements Serializable{
	private Fach adresse = null;
	private String kartonID;
	private Timestamp zugang = null;
	private Timestamp abgang;
	private Schuh inhalt;
	
// Konstruktoren

	public Karton(){ 
		this.zugang = new Timestamp(System.currentTimeMillis());
		this.kartonID = SchuLa.generateKartonID();
		this.ablegen(SchuLa.umlauf);
	}
	public Karton(Schuh ofTyp){
		this();
		this.inhalt = ofTyp;
	}

// oeffentliche Methoden
	 public Fach getFach(){
		return this.adresse;
	}
	public boolean isVorhanden(){
		Timestamp now = new Timestamp(System.currentTimeMillis());
		return ((this.zugang != null) && (this.abgang.after(now)));
	}
	public String getID(){
		return this.kartonID;
	}
//geschuetzte Methoden
	//
	void ablegen(Fach whereto) throws fachvollException {
		try {
			this.adresse.nehme(this);
			whereto.belegen(this);
			this.adresse = whereto;
		} catch (Exception e){
			System.out.println("Dieser Karton kann nicht versetzt werden: " + e.getMessage());
		} finally {
			
		}
	}
	void remove(){
		this.abgang = new Timestamp(System.currentTimeMillis());
		this.ablegen(SchuLa.abgang);
	}
	public Schuh getInhalt(){
		return this.inhalt;
	}
	
}
