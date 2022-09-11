package hW3;

import java.util.Arrays;

public class List<T> implements IList<T> {
	
	
	private T[] list;
	private int numberofEntries;
	private boolean initialized = false;
	private static final int defaultCapacity = 0;
	
	
	public List() {
		
		@SuppressWarnings("unchecked")
		T[] templist = (T[]) new Object[defaultCapacity+1];
		list = templist;
		numberofEntries = 0;
		initialized = true;
		
		
	}

	@Override
	public void add(T newEntry) {
		
		checkInitialization();
		list[numberofEntries]= newEntry;
		numberofEntries++;
		ensureCapacity();
	}
	
	private void checkInitialization() {
		
		if(initialized == false) {
			
			throw new SecurityException("List object is not initialized");
		}
	}
	
	private void ensureCapacity() {
		int capacity = list.length-1;
		if (numberofEntries>=capacity) {
			int newCapacity = (capacity+1);
			list = Arrays.copyOf(list, newCapacity+1);
		}
	}
	
	

	@Override
	
	public void add(int newPosition, T newEntry) {
		
		checkInitialization();
		if ((newPosition>=1)&&(newPosition<=numberofEntries+1)) {
			if (newPosition<=numberofEntries) {
				makeRoom(newPosition);
			}
			list[newPosition] =newEntry;
			numberofEntries++;
			ensureCapacity();
		}else {
			throw new IndexOutOfBoundsException(
					"Given position of add's new entry is out of bounds");
			}
	}
	
	
	private void makeRoom(int newPosition) {
		
		assert ((newPosition>=1)&&(newPosition<=numberofEntries+1));
		int newIndex = newPosition;
		int lastIndex = numberofEntries;
		
		for (int i=lastIndex; i>=newIndex; i--) {
			list[i+1] = list[i];
		}
		
	}
	
	public T remove(int Position) {
		
		checkInitialization();
		
		if ((Position >= 1) && (Position <= numberofEntries )) {
			
			assert !isEmpty();
			T result = list[Position];
			if (Position < numberofEntries) {
				removeGap(Position);
			}
		numberofEntries--;
		return result;
		}else {
			
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation");
			
		}
	}
	
	private void removeGap(int position) {
		assert ((position >= 1)&&(position<numberofEntries));
		
		int removed = position;
		int last = numberofEntries;
		
		for(int i = removed; i<last; i++) {
			list[i] = list[i+1];
			}
		
	}
	@Override
	/*public T replace(int Position, T newEntry) {
		
		checkInitialization();
		
		if ((Position>=1)&& (Position<=numberofEntries)) {
			
			assert !isEmpty();
			T original = list[Position];
			list[Position] = newEntry;
			return original;
		}else {
			throw new IndexOutOfBoundsException(
					"Illegal position given to replace operation");
		}
		
	}*/
	
	public T getEntry(int Position) {
		
		checkInitialization();
		
		if((Position>=0)&&(Position<=numberofEntries)) {
			
			assert  !isEmpty();
			return list[Position];
		}else {
			throw new IndexOutOfBoundsException(
					"Illegal position given to getEntry operation");
		}
	}
	
	

	@Override
	public int getLength() {
		return numberofEntries;
	}

	@Override
	public boolean isEmpty() {
		
		return (numberofEntries == 0);
	}

	
	

}
