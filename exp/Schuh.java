package exp;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Timestamp;

public class Schuh extends Lager{
	private String marke;
	private ArrayList<Karton> exemplare;
	private String schuhID;
	//finde die Anzahl der vorhandenen Exemplare
	public int getAnzahl(){
		return this.exemplare.size();
	}
	
}
