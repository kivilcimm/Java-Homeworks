package hw4;

public class FoodDeliverApp {

	public static void main(String[] args) {
		
		FileIO fileIO = new FileIO();
		
		Tree<Restaurant> rRatingTree = new RatingTree<>();
		Tree<Food> fPriceTree = new PriceTree<>();
		Tree<Restaurant> pizzaTimeTree = new DeliveryTree<>();
		Tree<Food> coffeeStockTree = new StockTree<>();
		
		
		System.out.println("ratings of the all restaurants");
		
	}

}
