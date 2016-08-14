package exp;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.Timestamp;

public class Schuh implements Serializable{
	private String schuhID;
	private ArrayList<Karton> exemplare;
	private String marke;
	private int groesse;
	private String farbe;
	private String stil;
	private String name;
	
	public Schuh(){
		this.schuhID = SchuLa.generateSchuhID();
	}
	public Schuh(String schuhmarke, int schuhgroesse, String schuhfarbe, String schuhart, String schuhname){
		this.schuhID = SchuLa.generateSchuhID();
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
	public String getID(){
		return this.schuhID;
	}
	public String getMarke(){
		return this.marke;
	}
	public int getGroesse(){
		return this.groesse;				
	}
	public String getFarbe(){
		return this.farbe;
	}
	public String getStil(){
		return this.stil;
	}
	public String getName(){
		return this.name;
	}
}
