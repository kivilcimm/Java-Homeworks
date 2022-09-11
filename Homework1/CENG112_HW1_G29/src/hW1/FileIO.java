package hW1;

import java.io.*;
//import java.util.*;
/*
 * FileIO finished.Can you check if there is any error?
 */

public class FileIO {
     
	public static InventoryBag<Item> readInventory(){
		//initialising stream and bag object
		BufferedReader inputStream;
		InventoryBag<Item> inventoryBag = new InventoryBag<>();
		
		try {
			inputStream = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\inventory.txt"));//finding the inventory file from working directory
			
			while(true) {
				String fileLine = inputStream.readLine();//looking for lines
				
				if(fileLine != null) {
					String[] line_tokens = fileLine.split(",");//splitting line tokens by comma
					//adding line tokens to new item object in order
					String item_name = line_tokens[0];
					String item_compartment = line_tokens[1];
					int item_weight = Integer.parseInt(line_tokens[2]);
					Item item = new Item(item_name,item_compartment,item_weight);
					//adding the item object into inventory bag
					inventoryBag.add(item);
					}
				else {
					break;
					}
				}
			inputStream.close();//closing the stream
			}
		
		catch(FileNotFoundException e)//error handling
		{
			System.out.println("Error occurs when open the file inventory.txt "
								+ e.getMessage());
			System.exit(0);
		}
		catch(IOException e)//error handling
		{
			System.out.println("Error reading from file");
			System.exit(0);
		}
		return inventoryBag;//returning inventory bag to the call
	}
}
