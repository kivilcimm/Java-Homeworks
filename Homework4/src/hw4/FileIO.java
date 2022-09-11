package hw4;

import java.io.*;

public class FileIO {
	
	public static String[] readFile(){
		
		BufferedReader inputStream;
		String[] lineList = new String[50];
		
		try {
			inputStream = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\CENG112_HW4.csv"));
			int i = 0;
			while(true) {
				
				String fileLine = inputStream.readLine();
				if(fileLine != null) {
					lineList[i] = fileLine;
				}
				else {
					break;
				}
			}
			inputStream.close();
		}
		catch(FileNotFoundException e)//error handling
		{
			System.out.println("Error occurs when open the file CENG112_HW4.csv"
								+ e.getMessage());
			System.exit(0);
		}
		catch(IOException e)//error handling
		{
			System.out.println("Error reading from file");
			System.exit(0);
		}
		return lineList;
		
	}
	
	public static RatingTree<Restaurant> creatingRatingTree(){
		
		String[] fileList = readFile();
		RatingTree<Restaurant> rRatingTree = new RatingTree<>();
		
		for(int i=0 ; i<fileList.length; i++) {
			
			String line = fileList[i];
			String[] line_tokens = line.split(",");
			
			String rname = line_tokens[3];
			double rRating = Double.parseDouble(line_tokens[4]);
			String rCuisine = line_tokens[5];
			int rDelivery = Integer.parseInt(line_tokens[6]);		
			
			Restaurant restaurant = new Restaurant(rname,rRating,rCuisine,rDelivery);
			rRatingTree.add(restaurant);
			
		}
		return rRatingTree;
	}
	
	public static PriceTree<Food> creatingPriceTree(){
		
		String[] fileList = readFile();
		PriceTree<Food> fPriceTree = new PriceTree<>();
		
		for(int i=0 ; i<fileList.length; i++) {
			
			String line = fileList[i];
			String[] line_tokens = line.split(",");
			
			String fname = line_tokens[0];
			double fPrice = Double.parseDouble(line_tokens[1]);
			int fStock = Integer.parseInt(line_tokens[2]);		
			String rname = line_tokens[3];
			
			Food food = new Food(fname, fPrice, rname, fStock);
			fPriceTree.add(food);
			
		}
		return fPriceTree;
	}
	
	public static DeliveryTree<Restaurant> creatingDeliveryTree(){
		
		String[] fileList = readFile();
		DeliveryTree<Restaurant> rDeliveryTree = new DeliveryTree<>();
		
		for(int i=0 ; i<fileList.length; i++) {
			
			String line = fileList[i];
			String[] line_tokens = line.split(",");
			
			if(line_tokens[5].equalsIgnoreCase("pizza")) {
				
				String rname = line_tokens[3];
				double rRating = Double.parseDouble(line_tokens[4]);
				int rDelivery = Integer.parseInt(line_tokens[6]);		
				String rCuisine = line_tokens[5];
				
				Restaurant restaurant = new Restaurant(rname,rRating,rCuisine,rDelivery);
				rDeliveryTree.add(restaurant);
			}
			
			
		}
		return rDeliveryTree;
	}
	
	public static StockTree<Food> creatingStockTree(){
		
		String[] fileList = readFile();
		StockTree<Food> fStockTree = new StockTree<>();
		
		for(int i=0 ; i<fileList.length; i++) {
			
			String line = fileList[i];
			String[] line_tokens = line.split(",");
			
			if(line_tokens[5].equalsIgnoreCase("coffee")) {
				
				String fname = line_tokens[0];
				double fPrice = Double.parseDouble(line_tokens[1]);
				int fStock = Integer.parseInt(line_tokens[2]);		
				String rname = line_tokens[3];
				
				Food food = new Food(fname, fPrice, rname, fStock);
				fStockTree.add(food);
			}
			
			
		}
		return fStockTree;
	}
}
