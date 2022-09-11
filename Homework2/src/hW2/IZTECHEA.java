package hW2;
import java.util.*; //to throw exception
//main class, there are two methods: main method and method to print final report.
public class IZTECHEA {
	
	        //method to write final report of products in factory line and report of sold products.
	        // according to queue method calculate number of products in queue,
	        // if queue type==0 , method print report of sold products, else method print report of products in factory line.
	public static void printReport(IQueue<IProduct> queue, IProduct[] products, int queuetype) {
		int sofa = 0,bed = 0,chair = 0,dresser = 0,table = 0,bookcase = 0;
		    
		
		
		while(!queue.isEmpty()) {
			IProduct product = null;
			try {
				product = queue.dequeue();
			} catch (EmptyQueueException e) {
				// do nothing
				
			}
			if(product.getClass() == products[0].getClass()) {
    			sofa++;
			}
			else if(product.getClass() == products[1].getClass()) {
    			bed++;
			}
			else if(product.getClass() == products[2].getClass()) {
    			chair++;
			}
			else if(product.getClass() == products[3].getClass()) {
    			dresser++;
			}
			else if(product.getClass() == products[4].getClass()) {
    			table++;
			}
			else if(product.getClass() == products[5].getClass()) {
    			bookcase++;
			}
		}
		if (queuetype == 0) {
			System.out.println("Amount of sofa sold:" + sofa);
			System.out.println("Amount of bed sold:" + bed);
			System.out.println("Amount of chair sold:" + chair);
			System.out.println("Amount of dresser sold:" + dresser);
			System.out.println("Amount of table sold:" + table);
			System.out.println("Amount of bookcase sold:" + bookcase);
		}
		else {
			System.out.println("\nREPORT:\n");
			
			System.out.println("Amount of sofa in FactoryLine:" + sofa);
			System.out.println("Amount of bed in FactoryLine:" + bed);
			System.out.println("Amount of chair in FactoryLine:" + chair);
			System.out.println("Amount of dresser in FactoryLine:" + dresser);
			System.out.println("Amount of table in FactoryLine:" + table);
			System.out.println("Amount of bookcase in FactoryLine:" + bookcase);
		}
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		// get a number from the users:
		int choice;         
		System.out.println("Enter the number of random request cycles:");
		choice = keyboard.nextInt();
		
		//Array of users names:
		String[] users = {"Marketing Analyst","Storage Chief", "Customer"};
		
		//Objects of Products:
		Sofa sofa = new Sofa();
		Bed bed = new Bed();
		Chair chair = new Chair();
		Dresser dresser = new Dresser();
		Table table = new Table();
		Bookcase bookcase = new Bookcase();
		
		//Array of products:
		IProduct[] products = {sofa, bed, chair, dresser, table, bookcase};
		
		//queues:
		FactoryLine<IProduct> factoryLine = new FactoryLine<IProduct>(); //queue for factory
		FactoryLine<IProduct> soldThings = new FactoryLine<IProduct>(); // queue for sold product
		
		//stacks:
		WareHouse<IProduct> warehouse = new WareHouse<IProduct>();//copying warehouse for controlling
		
		WareHouse<IProduct> sofaWarehouse = new WareHouse<IProduct>(); 
		WareHouse<IProduct> bedWarehouse = new WareHouse<IProduct>();
		WareHouse<IProduct> chairWarehouse = new WareHouse<IProduct>();
		WareHouse<IProduct> dresserWarehouse = new WareHouse<IProduct>();
		WareHouse<IProduct> tableWarehouse = new WareHouse<IProduct>();
		WareHouse<IProduct> bookcaseWarehouse = new WareHouse<IProduct>();

		
		for(int i=0; i<choice; i++) { 
			
			IProduct product = null; //create a product 
			
		    int user_index = rand.nextInt(users.length);  //firstly, choose a user in user array
			
		    if (user_index==0) { // if user==Marketing Analyst
		    	
				product = (products[rand.nextInt(products.length)]); // choose a random product in product array
				factoryLine.enqueue(product); // add product in factory line
				boolean manufactured = product.isManufactured(factoryLine, product); // check factory line 
				if (manufactured == true) {  // if product is manufactured and is added factory line, print SUCCESS
					System.out.println("\n"+(i+1)+".  "+users[user_index]+ " requesting " + product.getName() +", SUCCESS, "+ product.getName()
							+" is manufactured.");
				}
				else { //else print FAIL
					System.out.println("\n"+(i+1)+".  "+users[user_index]+ " requesting " + product.getName() +", FAIL, "+ product.getName()
							+" is not manufactured.");
				}
				
			}
			
		    else if (user_index==1) { // if user==Storage Chief
		    	
		    	

					try {
						product = factoryLine.dequeue(); //take a product in factory line
						if(product.getClass() == products[0].getClass()) { //if product==sofa
			    			sofaWarehouse.push((Sofa) product); //push product in sofa warehouse
			    			warehouse = sofaWarehouse; //equalize checking warehouse to current warehouse 
			    		}
			    		else if(product.getClass() == products[1].getClass()) { // if product ==bed
			    			bedWarehouse.push((Bed) product);
			    			warehouse = bedWarehouse;
			    		}
			    		else if(product.getClass() == products[2].getClass()) { //if product==chair
			    			chairWarehouse.push((Chair) product);
			    			warehouse = chairWarehouse;
			    		}
			    		else if(product.getClass() == products[3].getClass()) { //if product==dresser
			    			dresserWarehouse.push((Dresser) product);
			    			warehouse = dresserWarehouse;
			    		}
			    		else if(product.getClass() == products[4].getClass()) { //if product==table
			    			tableWarehouse.push((Table) product);
			    			warehouse = tableWarehouse;
			    		}
			    		else if(product.getClass() == products[5].getClass()) { //if product==bookcase
			    			bookcaseWarehouse.push((Bookcase) product);
			    			warehouse = bookcaseWarehouse;
			    		}
			    		
			    		boolean stored = product.isStored(warehouse,product); //check warehouse 
			    		
			    		if (stored == true) { //if product was stored rightly in warehouse, print SUCCESS
			    			System.out.println("\n"+(i+1)+".  "+users[user_index]+ " storing " + product.getName() +", SUCCESS, "
			    		          + product.getName() +" is stored.");
			    		}
			    		else { //else FAIL
			    			System.out.println("\n"+(i+1)+".  "+users[user_index]+ " storing " + product.getName() +", FAIL, "
				    		          + product.getName() +" is not stored.");
			    		}
					} catch (EmptyQueueException e) {   // if factory line is empty, throw an exception, because storage chief will not store.
						System.out.println("\n"+(i+1)+".  FactoryLine is empty!! "+users[user_index]+ " did not stored.FAIL. "
			    		          );
						
					}
		    		
		    		
		    	
		    }
		    	
				

			else if (user_index == 2) { //if user==Customer
				
				product = (products[rand.nextInt(products.length)]); //choose a random product in product list
				boolean sold = false;  //for checking
		    	if(product.getClass() == products[0].getClass()) { //if product == sofa
		    		try {
			    		soldThings.enqueue(sofaWarehouse.pop());  // pop a sofa in sofa warehouse sell it, and add soldThings queue for checking 
			    		sold = product.isSold(soldThings,product); // check product was sold or not. if product can be sold , sold==True
		    		}
		    		catch(EmptyStackException e) // if warehouse is empty
		    		{
		    			//do nothing
		    		}
		    	}
		    	else if(product.getClass() == products[1].getClass()) { //if product==bed
		    		try {
		    		
		    			soldThings.enqueue(bedWarehouse.pop());
		    			sold = product.isSold(soldThings,product);
		    		}
		    		catch(EmptyStackException e)
		    		{
		    			//do nothing
		    		}
		    	}
		    	else if(product.getClass() == products[2].getClass()) {//if product==chair
		    		try {
		    			soldThings.enqueue(chairWarehouse.pop());
		    			sold = product.isSold(soldThings,product);
		    		}
		    		catch(EmptyStackException e)
		    		{
		    			//do nothing
		    		}
		    	}
		    	else if(product.getClass() == products[3].getClass()) { //if product == dresser
		    		try {
		    			soldThings.enqueue(dresserWarehouse.pop());
		    			sold = product.isSold(soldThings,product);
		    		}
		    		catch(EmptyStackException e)
		    		{
		    			//do nothing
		    		}
		    	}
		    	else if(product.getClass() == products[4].getClass()) {//if product==table
		    		try{
		    			soldThings.enqueue(tableWarehouse.pop());
		    			sold = product.isSold(soldThings,product);
		    		}
		    		catch(EmptyStackException e)
		    		{
		    			//do nothing
		    		}
		    	}
		    	else if(product.getClass() == products[5].getClass()) {//if product==bookcase
		    		try {
		    			soldThings.enqueue(bookcaseWarehouse.pop());
		    			sold = product.isSold(soldThings,product);
		    		}
		    		catch(EmptyStackException e)
		    		{
		    			//do nothing
		    		}
		    		
		    	}
		    	
		    	
		    	if (sold == true) { //if product was sold, print SUCCESS
		    		System.out.println("\n"+(i+1)+".  "+users[user_index]+ " buying " + product.getName() +", SUCCESS, "
		    		          + users[user_index]+" bought " + product.getName()+".");
					
				}
				else { //else print FAIL
					System.out.println("\n"+(i+1)+".  "+ users[user_index]+ " buying " + product.getName() +", FAIL, "
		    		           + product.getName()+ " warehouse empty.");
					
				}
		    	
		    }
			
			
		}
		printReport(factoryLine,products,1); // call printReport method to print final report of factoryline.
		//print final report of warehouses:
		System.out.println("\nAmount of sofa in Warehouse:" + sofaWarehouse.getSize()); 
		System.out.println("Amount of bed in Warehouse:" + bedWarehouse.getSize());
		System.out.println("Amount of chair in Warehouse:" + chairWarehouse.getSize());
		System.out.println("Amount of dresser in Warehouse:" + dresserWarehouse.getSize());
		System.out.println("Amount of table in Warehouse:" + tableWarehouse.getSize());
		System.out.println("Amount of bookcase in Warehouse:" + bookcaseWarehouse.getSize()+"\n");
		printReport(soldThings,products,0); //call printReport method to print final report of sold products.
		
		keyboard.close();
		
	}

}
