package hW2;

import java.util.*;//used to throw exception


public class WareHouse<T> implements IStack<T> {
	
	private T[] wareHouse;
	private int topIndex;
	private int elementNumber;
	private boolean initialized = false;
	private static final int defaultCapacity =50;
	
	
	@SuppressWarnings("unchecked")
	public WareHouse() { //constructor
		wareHouse = (T[])  new Object[defaultCapacity];
		topIndex = -1; 
		elementNumber = 0;
		initialized = true;
	} 
	
	private void ensureCapacity() { // method doubles the wareHouse size
		
		if (topIndex == wareHouse.length-1) {
			
			int newSize = 2 * wareHouse.length;
			wareHouse = Arrays.copyOf(wareHouse, newSize);
			}
	}
	
	public void push(T newEntry) { //method adds a new element in wareHouse
		
		checkInit();
		ensureCapacity();
		
		wareHouse[(topIndex)+1] = newEntry;
		topIndex++;
		elementNumber++;
	}
	
	
	public T pop() { // method delete top index element in wareHouse, and return deleted element, if wareHouse is empty,throw exception
		
		checkInit();
		if(isEmpty()) {
			throw new EmptyStackException();
			}
		else {
			
			T top = wareHouse[topIndex]; 
			wareHouse[(topIndex)] = null;
			elementNumber--;
			topIndex--;
			return top;
		}
	}
	
	public T peek() { //method returns top index element, if wareHouse is empty throws exception
		
		checkInit(); 
		if (isEmpty()) {
			throw new EmptyStackException();
			}
		
		else {
			return wareHouse[(topIndex)];}
	}
	
	
	public boolean isEmpty() { //check wareHouse is empty or not
		return (elementNumber == 0);
	}
	
	public void clear() { //delete all elements in wareHouse
		for (int i=0; i<=elementNumber; i++) { 
			pop();
		}
	}
	
	private boolean checkInit() {  //check wareHouse is initialized or not
		return this.initialized;
	}
	

	public int getSize() { //return current element number in wareHouse
		return elementNumber;
	}
}
