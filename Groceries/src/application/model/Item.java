package application.model;

public class Item {
	
	int id;
	String name;
	int quantity;
	double price;
	
	
	public Item(int id, String name, int quantity, double price) {
		
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	public String toString() {
		
		return this.id +" "+ this.name + "\nQuantity: "+ this.quantity + " Price: " + this.price+"\n______________________\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuantity() {
		
		return this.quantity + "";
	}
	
	public String getPrice() {
		
		return this.price +"";
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
