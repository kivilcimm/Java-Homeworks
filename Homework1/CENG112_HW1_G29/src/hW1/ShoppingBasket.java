package hW1;

public class ShoppingBasket<T> implements IBag<T> {
	
	private T[] BagArr;
	private int number_entries;
	public final int MAX_SIZE = 2000;
	
	@SuppressWarnings("unchecked")
	public ShoppingBasket() {
		BagArr = (T[]) new Object[20]; //Initialise the bag array as fixed size,and of type Item
	    number_entries=0;

	}

	@Override
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

	@Override
	public boolean isEmpty() {//counting entries, when 0, returning true
		
		boolean is_empty = false;
		if (number_entries==0) {
			is_empty=true;
			return is_empty;
		}
		return(is_empty);
	}

	@Override
	public boolean isFull() {//probably never will return true in normal conditions, but here it is
		
		boolean is_full = false;
		if (number_entries>=BagArr.length) {//counting entries, when over 20, returning true
			is_full=true;
			return is_full;
		}
		return(is_full);
	}

	@Override
	public boolean contains(T item) {//return true if finds something that is equal
		
		for(int i = 0; i <number_entries ; i++ ){
			if(BagArr[i].equals(item))
				return true;
		}
		return false;
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {//if target bag is not empty, and the item is not null, adds it to the target bag
		if((item != null)&&(targetBag != null)) {
			this.remove(item);
			return targetBag.add(item);
		}
		return false;
	}

	@Override
	public T removeByIndex(int index) {//removes the entry in the index
		if(index<0 || index>20)//return null if out of bounds
			return null;
		T item = BagArr[index];
		BagArr[index] = null;
		T tmp = null;
		for (int i = index; i < number_entries-1; i++) {//shifting all entries to the left
			tmp = BagArr[i+1];
			BagArr[i] = tmp;
			BagArr[i+1] = null;
		}
		number_entries--;
		return item;
	}

	@Override
	public T remove() {//removes the last item
		number_entries--;
		T tmp = (T) BagArr[number_entries];
		BagArr[number_entries] = null;
		return tmp;
	}

	@Override
	public T remove(T item) {//finds the specific item and removes it
		if(this.contains(item)) {
			int i = this.getIndexOf(item);//get the index of specific item
			if(BagArr[i].equals(item))
				return this.removeByIndex(i);//remove it by index if contains
		}
		return null;
	}

	@Override
	public int getItemCount() {//counts entries
		return number_entries;
	}

	@Override
	public int getIndexOf(T item) {//gets the index of specific item
		if(this.contains(item)) {
			for(int i = 0; i < 20; i++){
				if(BagArr[i].equals(item))
					return i;
			}
		}
		return 0;
	}

	@Override
	public void displayItems() {//displays the basket contents splitted by comma
		for(int i = 0; i < number_entries; i++ ) {
			System.out.print(BagArr[i].toString().split("  ")[0]+",");
		}
	}

	@Override
	public void dump() {//nulls all the bag entries
		for(int i=0;i < 20;i++)
			BagArr[i] = null;
	}

}
