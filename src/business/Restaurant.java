package business;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

public class Restaurant extends Observable implements RestaurantProcessing {
	private List<Order> comenzi = new ArrayList<Order>();
	private HashMap<Order, ArrayList<MenuItem>> comenzii;
	private List<MenuItem> meniu;	
	private int i=0;
	private int j=0;
	
	Observer chef;
	Observer waiter;
	
	public Restaurant() {
		meniu = new ArrayList<MenuItem>();
		comenzii = new HashMap<Order, ArrayList<MenuItem>>();
	}
	
	@Override
	public MenuItem selectMenuItem(int id) {
		for (MenuItem prod : meniu) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}

	@Override
	public void addBaseProduct( String numeProd, float pretProd) {
		BaseProduct BP=new BaseProduct(++i,numeProd,pretProd);
		meniu.add(BP);
	}

	@Override
	public void addCompositeProduct(String numeProd, String composite,float pret) {
		ArrayList<MenuItem> produse = new ArrayList<MenuItem>();
		
		for (String comp : composite.split(" ")) {
			//if(comp=="/") break;
			int id = Integer.parseInt(comp);
			System.out.println(id);
			MenuItem mI = selectMenuItem(id);
			produse.add(mI);
		}
		int id1=++i;
		CompositeProduct CP = new CompositeProduct(id1, numeProd,pret,produse);
		System.out.println(CP.computePrice());
		pret=CP.computePrice();
		meniu.add(CP);
		
		
	}


	@Override
	public void deleteMenuItem(int id) {
		MenuItem mI=selectMenuItem(id);
		meniu.remove(mI);
		
	}

	@Override
	public void editMenuItem(int id, String nume, float pret, String composite) {
		MenuItem mI=selectMenuItem(id);
		ArrayList<MenuItem> produse=new ArrayList<MenuItem>();
		
		mI.setNume(nume);
		mI.setPret(pret);		
		
	}


	@Override
	public void createNewOrder(int nrMasa, String date, String composite) {
		ArrayList<MenuItem> produse = new ArrayList<MenuItem>();
		Order comanda = new Order(++j,nrMasa, date);
		
		for (String prod : composite.split(" ")) {
			int id = Integer.parseInt(prod);
			MenuItem mI = selectMenuItem(id);
			produse.add(mI);
		}
		
		comenzii.put(comanda, produse);
		setChanged();
		notifyObservers(produse);
		
	}
	
	public String[][] getDataOrder() {

		String[][] data = new String[comenzii.size()][4];

		Iterator<Entry<Order, ArrayList<MenuItem>>> it = comenzii.entrySet().iterator();

		Order aux1 = null;
		ArrayList<MenuItem> aux2 = null;
		String aux3 = null;
		int aux4 = 0;

		while (it.hasNext()) {

			Map.Entry<Order, ArrayList<MenuItem>> pair = (Map.Entry<Order, ArrayList<MenuItem>>) it.next();
			aux1 = (Order) pair.getKey();
			aux2 = (ArrayList<MenuItem>) pair.getValue();
			aux3="";
			int price = 0;

			for (MenuItem menuItem : aux2) {
				aux3 += menuItem.getNume() + "  ";
				price += menuItem.getPret();
				
			}

			data[aux4][0] = aux1.getIdComanda() + "";
			data[aux4][1] = aux1.getNrMasa() + "";
			data[aux4][2] = aux3;
			data[aux4++][3] = price + "";
		}

		return data;
	}
	
	
	@Override
	public List<MenuItem> getMeniu() {
		return meniu;
	}
	
	@Override
	public void setMeniu(ArrayList<MenuItem> meniu) {
		this.meniu = meniu;
	}
	
	public Order selectComanda(int id) {
		for (Order a : comenzi)
			if (a.getIdComanda() == id)
				return a;
		return null;
	}
	
	
	
	@Override
	public void generateBill(int orderId) {
		Order a = null;
		ArrayList<MenuItem> items = null;
		for (Order o : comenzi) {
			if (o.getIdComanda() == orderId) {
				items = comenzii.get(o);
				a = o;
			}
		}
		
		try {
			FileWriter fileWriter = new FileWriter("Order" + a.getIdComanda() + ".txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println("Nota de plata pt masa nr: " + a.getNrMasa());
			
			for (MenuItem i : items) {
				printWriter.println(i.getNume() + "=" + i.computePrice());
			}
			
			float price = 0;
			Order order2 = selectComanda(orderId);
			
			items = comenzii.get(order2);

			for (MenuItem mi : items) {
				price += mi.computePrice();
			}
						
			printWriter.println("Total=" + price);
			printWriter.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
