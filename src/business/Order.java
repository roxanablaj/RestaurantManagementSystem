package business;

import java.util.*;

public class Order {
	private int idComanda;
	private String dataC;
	private int nrMasa;
	
	public Order(int id, int masa, String dataC) {
		this.idComanda=id;
		this.dataC=dataC;
		this.nrMasa=masa;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public int getNrMasa() {
		return nrMasa;
	}

	public void setNrMasa(int nrMasa) {
		this.nrMasa = nrMasa;
	}
	
	public String getDataC() {
		return dataC;
	}

	public void setDataC(String dataC) {
		this.dataC = dataC;
	}

	public int hashCode() {
		return idComanda;
	}
	
	public String[] toStringVector() {
		String[] a = new String[3];
		a[0] = String.valueOf(idComanda);
		a[1] = String.valueOf(nrMasa);
		a[2] = dataC;
		return a;
	}
}
