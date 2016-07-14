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
	/*
	 * Methoden
	 */
	public void ablegen(Fach whereto) throws fachvollException {
		this.adresse.nehme(this);
		whereto.belegen(this);
		this.adresse = whereto;
	}
	public Fach whereat(){
		return this.adresse;
	}
	public boolean isUmlauf(){
		return this.adresse.equals(umlauf);
	}
	public String getID(){
		return this.kartonID;
	}
}
