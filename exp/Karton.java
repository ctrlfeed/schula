package exp;

import java.io.Serializable;
import java.sql.Timestamp;

public class Karton extends Schuh implements Serializable{
	private Fach adresse = null;
	private String kartonID;
	private Timestamp zugang = null;
	private Timestamp abgang;
	
// Konstruktoren

	public Karton(){ 
		this.zugang = new Timestamp(System.currentTimeMillis());
		this.kartonID = SchuLa.generateKartonID();
		this.ablegen(SchuLa.umlauf);
	}
	public Karton(Fach adr){
		this();
		this.adresse = adr;
	}

// oeffentliche Methoden
	 public void setFach(Fach whereto) throws fachvollException {
		this.adresse.nehme(this);
		whereto.belegen(this);
		this.adresse = whereto;
	}
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
	public void ablegen(Fach neuerOrt){
		this.adresse.nehme(this);
		neuerOrt.belegen(this);
		this.adresse = neuerOrt;
	}
}
