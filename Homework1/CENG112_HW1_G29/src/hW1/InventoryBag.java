package hW1;

public class InventoryBag<T> {

	private T[] BagArr;
	private int number_entries;
	
	@SuppressWarnings("unchecked")
	public InventoryBag() {
		BagArr = (T[]) new Item[20]; //Initialise the bag array as fixed size
	    number_entries=0;
	}


	public boolean add(T newItem) {//adding new item
		boolean add_result=true;
		
		if(isFull()) {
			add_result=false;
		}
		else {
			BagArr[number_entries] = newItem;//if bag isn't full, enter the newItem in the index of number_entries
			number_entries++;//incrementing number of entries	
		}
		return add_result;
		
	}

	public boolean isEmpty() {//counting entries, when 0, returning true
		boolean is_empty = false;
		
		if (number_entries==0) {
			is_empty=true;
			return is_empty;
		}
		return(is_empty);
	}

	//@Override
	public boolean isFull() {//probably never will return true in normal conditions, but here it is
		boolean is_full = false;
		if (number_entries>=BagArr.length) {//counting entries, when over 20, returning true
			is_full=true;
			return is_full;
		}
		return(is_full);
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {//returning the current bag as an array
		
		T[] result = (T[]) new Item[number_entries];//as this array wont be used for anything else, we cast Item class, as we cannot create generic array
		for (int i=0; i<number_entries; i++) {
			result[i]=BagArr[i];
		}
		return result;
	}

}