package hW2;

public interface IStack<T> {
	
	public void push(T newEntry);
	
	public T pop();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void clear();
	
}
/**
 * t[] temp = (t[]) new Object[initialCapacity]
 * stack =temp
 * topIndex =-1
 * initialized =true
 * push:
 *   stack[topIndex+1] =newEntry
 *   topIndex++
 *   
 * peek:
 *   return stack[topIndex]
 *   
 * pop :
 *   T top = stack[topIndex]
 *   stack[topIndex] =null
 *   topIndex--
 *   return top
 */
