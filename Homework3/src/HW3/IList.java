package hW3;

public interface IList<T> {
	
	/* In algorithm, some methods of IList is not required so we not implement these methods 
	 */

	public void add(T newEntry);
	
	public void add(int newPosition, T newEntry);
	
	public T remove(int Position);
	
	
	
	public T getEntry(int Position);
	
	public int getLength();
	
	public boolean isEmpty();
	
	//public T replace(int Position, T newEntry);
	
	//public T[] toArray(); 
	
	//public boolean contains(T anEntry); 
	
	//public void clear();

}
