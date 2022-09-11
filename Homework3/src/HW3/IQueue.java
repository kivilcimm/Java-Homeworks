package hW3;


public interface IQueue<T extends Comparable<? super T>> { 
		
		
		public void enqueue(T newEntry);
		
		public T getFront() throws EmptyQueueException;
		
		public T dequeue() throws EmptyQueueException;//remove highest priority
		
		public boolean isEmpty();
		
		public int getSize();
		
		public void clear();

}
