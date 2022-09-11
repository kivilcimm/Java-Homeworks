package hW1;

import java.util.*;


public class ShoppingApp {

	public static void main(String[] args) {
		
		//initialising arrays and objects
		FileIO io_Object = new FileIO();
		Item[] inventoryBag = io_Object.readInventory().toArray();
		ShoppingBasket<Item> shoppingBasket = new ShoppingBasket<Item>();
		VegetablesFruitsCompartment<Item> vf_Bag = new VegetablesFruitsCompartment<Item>();
		BevaragesCompartment<Item> b_Bag = new BevaragesCompartment<Item>();
		MeatsCompartment<Item> m_Bag = new MeatsCompartment<Item>();
		SnacksCompartment<Item> s_Bag = new SnacksCompartment<Item>();
		Scanner keyboard = new Scanner(System.in);
		int choice;
		
		// fridge is empty:
		int vf_weight = 0 ; 
		int m_weight = 0 ; 
		int b_weight = 0 ; 
		int s_weight = 0; 
		
		System.out.println("Welcome to The Shopping App!");
		
		while (true) {
			
			//basket is empty:
			int basket_weight= 0 ;
			//printing main menu
			System.out.println("\nPlease select an option:\r\n"
					+ "[1]Go to shopping\r\n"
					+ "[2]See the status of the fridge\r\n"
					+ "[3]Exit");
			System.out.println("Your choice:");
			choice = keyboard.nextInt();
			
			if (choice == 1) {
				//printing shopping menu
				while(true) {
					System.out.println("\nPlease select an option:\r\n"
							+ "[1]Add an item to the basket\r\n"
							+ "[2]See the basket\r\n"
							+ "[3]Finish shopping");
					System.out.println("Your choice:");
					choice = keyboard.nextInt();
					if(choice==1) {
						System.out.println("Please select an item:");
						for(int i=0; i<inventoryBag.length;i++) {
							System.out.println("[" + (i+1) + "]" + inventoryBag[i].getName());//listing inventory
							}
						System.out.println("Your choice:");
						int item_index = keyboard.nextInt();
						if(item_index < 1 || item_index > 14) {
							System.out.println("Please choose between 1-14...");//continue if out of bounds
							continue;
						}
						//adding selected item to basket
						Item item = inventoryBag[(item_index)-1];
						shoppingBasket.add(item);
						System.out.println(item.getName() + " is added to the basket");
						basket_weight += item.getWeight();
						
						//checking if max size exceeded, proceeding AFTER exceeding, that was intended.
						if(basket_weight < shoppingBasket.MAX_SIZE) {
							continue;
						}
						else {
							System.out.println("\n *****Basket is full now!!\r\n"
									+"You cannot add any more items to the basket\n"
									);
							choice=3;
						}
						}
		
					if(choice==2) {//printing basket contents
						{
							System.out.print("Basket contains:");
							shoppingBasket.displayItems();
							}
						continue;
					}
					
					if(choice==3) {//filling the fridge
						if(shoppingBasket.getItemCount()>0) {
							System.out.print("Basket contains:");
							shoppingBasket.displayItems();
							System.out.println("\n\nShopping is finished and going to fill the fridge...");
							while(shoppingBasket.getItemCount() != 0) {//while there is items in the basket
								Item basket_item = (Item) shoppingBasket.remove();//popping last item in the basket
								String compartment_of_item = basket_item.getCompartment();//looking for the items container in inventory
								
								if (compartment_of_item.equals("vegetables and fruits")) { //if veg and fruit
									if(vf_weight < vf_Bag.MAX_SIZE) {
										shoppingBasket.transferTo(vf_Bag, basket_item);
										vf_weight += basket_item.getWeight();
									}
									else {
										System.out.println("\n******" + basket_item.getName() + " cannot be added to the fridge!!");
									}
								}
								
								else if (compartment_of_item.equals("meats")) {//if meat
									if(m_weight < m_Bag.MAX_SIZE) {
										shoppingBasket.transferTo(m_Bag, basket_item);
										m_weight += basket_item.getWeight();
									}
									else {
										System.out.println("\n******" + basket_item.getName() + " cannot be added to the fridge!!");
									}
								}
								else if (compartment_of_item.equals("beverages")) {//if beverage
									if(b_weight < b_Bag.MAX_SIZE) {
										shoppingBasket.transferTo(b_Bag, basket_item);
										b_weight += basket_item.getWeight();
									}
									else {
										System.out.println("\n******" + basket_item.getName() + " cannot be added to the fridge!!");
									}
								}
								else if (compartment_of_item.equals("snacks")) {//if snack
									if(s_weight < s_Bag.MAX_SIZE) {
										shoppingBasket.transferTo(s_Bag, basket_item);
										s_weight += basket_item.getWeight();
									}
									else {
										System.out.println("\n******" + basket_item.getName() + " cannot be added to the fridge!!");
									}
								}
							}
						}
						break;//ending filling fridge and quitting to main menu
						}
					}
				continue;//returning to shopping menu
			}

			if (choice == 2) {//printing fridge capacity
				System.out.println("Remaining capacities of each compartments:\n");
				System.out.print("Vegetables and Fruits : ");
				vf_Bag.displayItems();
				System.out.print("Meats : ");
				m_Bag.displayItems();
				System.out.print("Beverages : ");
				b_Bag.displayItems();
				System.out.print("Snacks : ");
				s_Bag.displayItems();
				continue;
			}
			
			if(choice == 3) {//exiting
				System.out.println("Exit...");
				break;
			}
		}
		keyboard.close();
	}
}
