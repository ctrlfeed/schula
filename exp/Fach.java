package exp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Fach extends Regal implements Serializable{
	private String bezeichner;
	private int kapazitaet;
	private Timestamp letzterZugriff;
	private ArrayList<Karton> inhalte;
	
	protected Fach(String bez,int kap){
		this.kapazitaet = kap;
		this.bezeichner = bez;
	}
	public String getID(){
		return super.getID()+"."+this.getID();
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
	public void nehme(Karton aufnahmewert){
		try {
			inhalte.remove(aufnahmewert);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Der Karton " + aufnahmewert.getID() + " ist nicht in diesem Fach und kann nicht entfernt werden.");
		}
	}
}
