package hW1;

public interface IBag<T> {
	//a bag interface as provided in the homework folder
	public boolean add(T newItem);
	public boolean isEmpty();
	public boolean isFull();
	public boolean contains(T item);
	public boolean transferTo(IBag<T> targetBag, T item);
	public T removeByIndex(int index);
	public T remove();
	public T remove(T item);
	public int getItemCount();
	public int getIndexOf(T item);
	public void displayItems();
	public void dump();
}
/* We were allowed to not use some of the functions, but as it wasn't clarified 
 * that we don't have to implement all the functions, we decided to implement 
 * them even if they weren't used. Specifically the dump() function. We didn't use
 * it but we did implement it.
 * 
 * */
 