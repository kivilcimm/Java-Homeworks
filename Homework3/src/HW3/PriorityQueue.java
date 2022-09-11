package hW3;

public class PriorityQueue<T extends Comparable<? super T>> implements IQueue<T>{
	
	private T[] priorityQueue;
	private int frontIndex;
	private int backIndex;
	//private boolean initialized = false;
	private static final int defaultCapacity = 50;
	
	
	@SuppressWarnings("unchecked")
	public PriorityQueue()
	{
		priorityQueue = (T[]) new Comparable[defaultCapacity+1];
		frontIndex = 0;
		backIndex = defaultCapacity;
		//initialized = true;
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int capacity)
	{
		priorityQueue = (T[]) new Object[capacity+1];
		frontIndex = 0;
		backIndex = capacity;
		//initialized = true;
	}
	

	@Override
	public boolean isEmpty() {
		
		boolean is_empty = false;
		
		if (frontIndex == (((backIndex+1))% priorityQueue.length)) {
			
			is_empty = true;
		}
		return is_empty;
	}

	@Override
	public int getSize() {//needed?
		return priorityQueue.length;
	}

	@Override
	public void clear() {
		priorityQueue = null;
		frontIndex = 0;
		backIndex = 0;
	}

	@Override
	public void enqueue(T newEntry) {//must be changed to be able to insert according to priority

		ensureCapacity();

		if (isEmpty())
		{
			priorityQueue[frontIndex] = newEntry;
			backIndex = (backIndex+1) % priorityQueue.length;
		}
		else 
		{
			int c = 0;
			for(int i = 0; i <backIndex;i++) {
				if(priorityQueue[i].compareTo(newEntry) < 0) {
					for(int j = backIndex; j >= i; j--) {
						priorityQueue[j+1] = priorityQueue[j];
					}
					priorityQueue[i] = newEntry;
					backIndex = (backIndex+1) % priorityQueue.length;
					return;
				}
				c++;
			}
			
			priorityQueue[c] = newEntry;
			backIndex = (backIndex+1) % priorityQueue.length;
			
			
			/*while(priorityQueue[i].compareTo(newEntry) >= 0) {
				i++;
			}
			for(int j = backIndex; j >= i; j--) {
				priorityQueue[j+1] = priorityQueue[j];
			}
			priorityQueue[i] = newEntry;
			backIndex = (backIndex+1) % priorityQueue.length;*/
		}
	}


	private void ensureCapacity() {

		if (frontIndex == ((backIndex +2) % priorityQueue.length)) {
			
			T[] oldQ = priorityQueue;
			int oldSize = oldQ.length;
			int newSize = 2 * oldSize;
			
			
			@SuppressWarnings("unchecked")
			T[] tempQ = (T[]) new Object[newSize];
			priorityQueue = tempQ;
			
			for (int i=0 ; i<oldSize-1;i++) {
				
				priorityQueue[i] = oldQ[frontIndex];
				frontIndex = (frontIndex+1) % oldSize;
				
			}
			
			frontIndex = 0;
			backIndex = oldSize-2;
		}
	}

	@Override
	public T getFront() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException();
			}
		
		else { return priorityQueue[frontIndex];}
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException();
			}
		else {
			T front = priorityQueue[frontIndex];
			priorityQueue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % priorityQueue.length;
			return front;
		}
	}
	

	
	//take computation and sort them according to priority in simulation
	
}
