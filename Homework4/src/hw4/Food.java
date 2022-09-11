package hw4;

public class Food implements Orderable, Comparable<Food>  {
	
	private String name;
	private double price;
	private int stock;
	private String restaurant;
	
	public Food() 
	{
		name = null;
		price = 0;
		stock = 0;
		restaurant = null;
	}
	
	public Food(String fname, double fPrice, String frestaurant, int fStock) 
	{
		name = fname;
		price = fPrice;
		stock = fStock;
		restaurant = frestaurant;
	}

	@Override
	public void updatePrice(double price) {
		this.price = price;	
	}

	@Override
	public void updateStock(int stock) {
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public String getRestaurant() {
		return restaurant;
	}

	@Override
	public int compareTo(Food o) {
		if(price > o.price)
			return 1;
		else if (price == o.price)
			return 0;
		else
			return -1;
	}
	
	public int compareTo(int otherStock) {
		if(stock > otherStock)
			return 1;
		else if (stock == otherStock)
			return 0;
		else
			return -1;
	}

}
