package business;

import java.util.*;

public class CompositeProduct extends MenuItem{
	private List<MenuItem> listaCProd=new ArrayList<MenuItem>();

	public CompositeProduct(int id, String nume, float pret, List<MenuItem> listaCProd) {
		super(id, nume, pret);		
		super.setPret(computePrice());
		this.listaCProd = listaCProd;
	}
	
	public List<MenuItem> getListaCProd() {
		return listaCProd;
	}

	public void setListaCProd(List<MenuItem> listaCProd) {
		this.listaCProd = listaCProd;
		super.setPret( computePrice() );
	
	}
	
	public void adaugaProdus(MenuItem prod) {
		listaCProd.add(prod);
	}
	
	public void stergeProdus(MenuItem prod) {
	
		for (int i = 0; i < listaCProd.size(); i++) {
			if (listaCProd.get(i).getNume().equals(prod)) {
				listaCProd.remove(i);
				i--;
			}
		}
		
	}

	public float computePrice() {
		
		float pretTotal = 0;
		for(MenuItem prod: listaCProd)
			pretTotal=pretTotal+prod.getPret();
		return pretTotal;
	}
	
	public String[] toStringDateChef() {
		String[] a = new String[3];
		a[0] = String.valueOf(super.getId());
		a[1] = super.getNume();
		a[2] = String.valueOf(computePrice());
		
		return a;
	}
	
	public String[] toStringDate() {
		String[] a = new String[4];
		a[0] = String.valueOf(super.getId());
		a[1] = super.getNume();
		a[2] = String.valueOf(computePrice());
		a[3]="=>";
		for(MenuItem mi : listaCProd) {
			a[3]+= mi.getNume()+",";
		}
		return a;
	}
	


}
