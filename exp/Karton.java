package exp;

import java.sql.Timestamp;

public class Karton extends Schuh{
	private Fach adresse = null;
	private String kartonID;
	private Timestamp zugegangen;
	
	/*
	 * Konstruktoren
	 */
	public Karton(){ 
		this.zugegangen = new Timestamp(System.currentTimeMillis());
		this.kartonID = getKartonID();
		lassliegen(this);
	}
	public Karton(Fach adr){
		this();
		this.adresse = adr;
	}
	public void ablegen(Fach lastseen) throws fachvollException {
		lastseen.belegen(this);
		this.adresse = lastseen;
	}
	public Fach whereat(){
		return this.adresse;
	}
	public boolean isUmlauf(){
		return adresse.equals(umlauf);
	}
}
