package hW1;

public class Item {
	//the attributes of inventory items
	private String item_name;
	private String compartment_item;
	private int item_weight;
	
	//get set functions utilise the private values
	public String getName() {
		return item_name;
	}
	public void setName(String item_name) {
		this.item_name = item_name;
	}
	public String getCompartment() {
		return compartment_item;
	}
	public void setCompartment(String compartment_item) {
		this.compartment_item = compartment_item;
	}
	public int getWeight() {
		return item_weight;
	}
	public void setWeight(int item_weight) {
		this.item_weight = item_weight;
	}
	
	public Item(String item_name, String compartment_item, int item_weight) {//constructor
		setName(item_name);
		setCompartment(compartment_item);
		setWeight(item_weight);
	}
	
	public String toString() {
		return(item_name+ "  " + compartment_item + "  " + item_weight); 
	}
	
    public boolean equals(Item comparable) {//string comparison for names, as there's no need to compare weights or compartments
    	
    	boolean eq = false;
    	String aString = (String) comparable.getName();//getting other items name
        int n = item_name.length();
        
        if (n == aString.length()) {
        	//putting strings to arrays
        	char v1[] = item_name.toCharArray();
        	char v2[] = aString.toCharArray();
        	
        	int i = 0;
        	while (n-- != 0) {//char based comparing
        		if (v1[i] != v2[i]) {
        				eq = false;
        				return eq;
        		}
        		i++;
        	}
        	eq = true;
        }
        return eq;  
    }  
}


