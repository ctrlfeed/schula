package exp;

import java.util.ArrayList;
import java.sql.Timestamp;

public class Schuh extends Lager{
	private String schuhID;
	private ArrayList<Karton> exemplare;
	private String marke;
	private int groesse;
	private String farbe;
	private String stil;
	private String name;
	public Schuh(){
		this.schuhID = super.getSchuhID();
	}
	public Schuh(String schuhmarke, int schuhgroesse, String schuhfarbe, String schuhart, String schuhname){
		this.schuhID = super.getSchuhID();
		this.marke = schuhmarke;
		this.groesse = schuhgroesse;
		this.farbe = schuhfarbe;
		this.stil = schuhart;
		this.name = schuhname;
	}
	//finde die Anzahl der vorhandenen Exemplare
	public int getAnzahl(){
		return this.exemplare.size();
	}
	
}
