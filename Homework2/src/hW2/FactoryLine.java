package hW2;

public class FactoryLine<T> implements IQueue<T>{
	
	
	private T[] factoryLine;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int defaultCapacity = 50;
	
	
	
	@SuppressWarnings("unchecked")
	public FactoryLine() { //constructor
		
		factoryLine = (T[]) new Object[defaultCapacity+1];
		frontIndex = 0;
		backIndex = defaultCapacity;
		initialized = true;
	}
	
	
	public void enqueue(T newEntry) { //add a new element in queue
		
		checkInit();
		ensureCapacity();
		backIndex = (backIndex+1) % factoryLine.length;
		factoryLine[backIndex] = newEntry;
		
		
	}
	public T getBack() {  /*we add this method to reach final element of the queue, 
         *using this method, we can more easily check whether the products are produced or not.
         *we used this method in isManufactured method and isSold method.**/
         return factoryLine[backIndex];
         }
	
	public T getFront() throws EmptyQueueException   { //return first element in queue
		
		checkInit()	;
		
		if(isEmpty()){
			throw new EmptyQueueException();
			}
		
		else { return factoryLine[frontIndex];}
	}
	
	public T dequeue() throws EmptyQueueException { //delete first element of queue and return deleted element
		
		checkInit();
		if(isEmpty()){
			throw new EmptyQueueException();
			}
		
		else {
			
			T front = factoryLine[frontIndex];
			factoryLine[frontIndex] = null;
			frontIndex = (frontIndex+1) % factoryLine.length;
			return front;
		}	
		
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {//  double the wareHouse size

		if (frontIndex == ((backIndex +2) % factoryLine.length)) {
			
			T[] oldLine = factoryLine;
			int oldSize = oldLine.length;
			int newSize = 2 * oldSize;
			
			
			T[] tempLine = (T[]) new Object[newSize];
			factoryLine= tempLine;
			
			for (int i=0 ; i<oldSize-1;i++) {
				
				factoryLine[i] = oldLine[frontIndex];
				frontIndex = (frontIndex+1) % oldSize;
				
			}
			
			frontIndex = 0;
			backIndex = oldSize-2;
		}
	}
	
	public boolean isEmpty() { 
		boolean is_empty = false;
		
		if (frontIndex == (((backIndex+1))% factoryLine.length)) {
			
			is_empty = true;
		}
		return is_empty;
	}

	private boolean checkInit() { // I changed it public to private 
		return this.initialized;
	}
	
}

