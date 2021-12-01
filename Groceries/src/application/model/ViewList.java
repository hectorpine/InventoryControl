package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewList {
	
	ArrayList<Item> inventory;
	
	public ViewList() {
		
		inventory = parseSheet();
	}
	
	public ArrayList<Item> parseSheet(){
		ArrayList<Item> scan = new ArrayList<Item>();
		
		
		File log = new File("data/groceries.csv");
		
		String line = new String();
		
		try {
			Scanner view = new Scanner(log);
			while(view.hasNextLine() != false) {
				
				line = view.nextLine();
				String[] token = line.split(",");
								
				String id = token[0];
				int idInt = Integer.parseInt(id);
				String name = token[1];
				String quant = token[2];
				int quantity = Integer.parseInt(quant);
				String priceIn = token[3];
				double price = Double.parseDouble(priceIn);
				
				
				Item item = new Item(idInt,name,quantity,price);
				scan.add(item);
					
				}

			view.close();
			
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return scan;
	}
	

		
	public String toString() {
		
		String all = new String();
		
		for(Item i:inventory) {
			
			all = all + i;
		}
		
		
		return all;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	

}
