package hw4;

public class Restaurant implements Comparable<Restaurant> {
	
	private String name;
	private double rating;
	private String cuisine;
	private int deliveryTime;
	
	public Restaurant() 
	{
		name = null;
		rating = 0;
		cuisine = null;
		deliveryTime = 0;
	}
	
	public Restaurant(String rname, double rrating, String rcuisine, int rdelivery) 
	{
		name = rname;
		rating = rrating;
		cuisine = rcuisine;
		deliveryTime = rdelivery;
	}
	//not sure what the following three is doing different from set methods
	public void updateCuisine(String category) {
		cuisine = category;
	}
	
	public void updateRating(double score) {
		rating = score;
	}
	
	public void updateDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	//get-sets
	
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getCuisine() {
		return cuisine;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	
	@Override
	public int compareTo(Restaurant o) {
		
		if(rating > o.rating)
			return 1;
		else if (rating == o.rating)
			return 0;
		else
			return -1;
	}
	
	public int compareTo(int otherDel) {
		if (deliveryTime > otherDel)
			return -1;
		else if(deliveryTime == otherDel)
			return 0;
		else 
			return 1;
	}
}
