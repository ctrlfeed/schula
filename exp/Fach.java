package exp;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Fach extends Regal{
	private String bezeichner;
	private int kapazitaet;
	private Timestamp letzterZugriff;
	private ArrayList<Karton> inhalte;
	
	protected Fach(String bez,int kap){
		this.kapazitaet = kap;
		this.bezeichner = bez;
	}
	public String name(){
		return super.name()+"."+this.name();
	}
	public int freiraum(){
		return kapazitaet - inhalte.size();
	}
	public void belegen(Karton ablegewert) throws fachvollException {
		inhalte.add(ablegewert);
		if (this.freiraum() < 0) {
			throw new fachvollException();
		}
	}
}
