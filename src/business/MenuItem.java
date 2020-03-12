package business;

import java.io.*;
import java.util.*;

public abstract class MenuItem implements Serializable {
	private static final long serialVersionUID=1l;
	private int id;
	private String nume;
	private float pret;

	public MenuItem(int id, String nume, float pret) {
		super();
		this.id = id;
		this.nume = nume;
		this.pret = pret;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}
	
	public float computePrice() {
		return pret;
	}
	
	public void adaugaProdus(MenuItem a) {}
	public void stergeProdus(String item) {}

		
	public String[] toStringDate() {
		String[] a = new String[3];
		return a;
	}
	
	public String[] toStringDateChef() {
		String[] a = new String[2];
		return a;
	}
}