package data;

import java.io.*;
import java.util.*;

import business.*;

public class RestaurantSerializator {
	static String filename="C:\\date\\ut\\an2\\sem2\\TP\\tema4_Restaurant\\meniu.ser";
	static FileOutputStream fileOut;
	static FileInputStream fileIn;
	public static void write(TreeSet<MenuItem> menu) {
		
		try {
			fileOut = new FileOutputStream(filename);
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(fileOut);
				out.writeObject(menu);
				out.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		} catch (FileNotFoundException e1) {

		}

	}

	@SuppressWarnings("unchecked")
	public static TreeSet<MenuItem> read() {
		TreeSet<MenuItem> menu=null;
		
		try {
			fileIn = new FileInputStream(filename);
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(fileIn);
				try {
					menu = (TreeSet<MenuItem>) in.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block

				}

				in.close();
				fileIn.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}

		return menu;
	}
}

