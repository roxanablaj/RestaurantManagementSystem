package business;

import java.util.*;

public interface RestaurantProcessing {
	public MenuItem selectMenuItem(int id);
	
	public void addBaseProduct( String name, float pret);
	public void addCompositeProduct(String name, String composite,float pret);
	
	public void editMenuItem(int id, String name, float pret, String composite);	
	public void deleteMenuItem(int id);
		
	public void createNewOrder(int nrMasa, String date, String composite);
	public String[][] getDataOrder();
	
	public void generateBill(int orderId);
	
	public List<MenuItem> getMeniu();
	public void setMeniu(ArrayList<MenuItem> meniu);

}
