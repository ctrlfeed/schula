package exp;

import java.sql.Timestamp;

public class Karton extends Schuh{
	private Fach adresse = null;
	private String kartonID;
	private Timestamp zugegangen;
	public Karton(Fach adr){
		this.adresse = adr;
		this.zugegangen = new Timestamp(System.currentTimeMillis());
		this.kartonID = getKartonID();
	}
}
