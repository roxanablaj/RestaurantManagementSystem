package GUI;

import business.*;

public class MainClass {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
    	  	
    	AdminUI admin = new AdminUI(restaurant);
    	WaiterUI waiter = new WaiterUI(restaurant);
    	ChefUI chef = new ChefUI();
    	restaurant.addObserver(chef);
	}
}
