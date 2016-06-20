package exp;

import java.sql.Timestamp;
import java.util.HashMap;

public class Fach extends Regal{
	private String bezeichner;
	private int kapazitaet;
	private Timestamp letzterZugriff;
	private Karton[] inhalte;
	
	protected Fach(String bez,int kap){
		this.kapazitaet = kap;
		this.bezeichner = bez;
	}
	public String name(){
		return super.name()+"."+this.name();
	}
	public int freiraum(){
		return kapazitaet - inhalte.length;
	}

}
