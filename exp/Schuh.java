package exp;

import java.util.HashMap;
import java.sql.Timestamp;

public class Schuh extends Lager{
	private String marke;
	private Karton[] exemplare;
	private String schuhID;
	
	//finde die Anzahl der vorhandenen Exemplare
	public int getAnzahl(){
		return this.exemplare.length;
	}
}
