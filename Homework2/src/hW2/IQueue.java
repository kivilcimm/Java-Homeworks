package hW2;

public interface IQueue<T> { 
	
	
	public void enqueue(T newEntry);
	
	public T getFront() throws EmptyQueueException;
	
	public T dequeue() throws EmptyQueueException;

	public boolean isEmpty();
	
	public T getBack(); ///*we add this method to more easily reach final element of the queue 
}
/*
 * first in - first out
 * enqueue:
 *     backIndex = (backIndex+1)%queue.length
 *     queue[backIndex]=newEntry
 *     
 *getFront:
 *      return queue[frontIndex]
 *      
 *dequeue:
 *       T front = queue[frontIndex]
 *       queue[frontIndex]=null
 *       frontIndex = (frontIndex+1)%queue.length
 *       return front
 *   
 *isEmpty:
 *    return frontIndex ==((backIndex+1)%queue.length)
 * 
 */
