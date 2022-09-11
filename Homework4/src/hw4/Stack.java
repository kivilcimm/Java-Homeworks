package hw4;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T>{
	
	private class Node{
		
		private T data;
		private Node pre;
		
		
		public Node getPre() {
			return pre;
		}
		public void setPre(Node pre) {
			this.pre = pre;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	
	public Stack() {
		this.top = null;

	}
	
	@Override
	public void push(T newEntry) {
		
		Node temp = new Node();
		temp.setData(newEntry);
		temp.setPre(top);
		top = temp;
		
	}

	@Override
	public T pop() {
		Node temp = new Node();
		if(top == null) {
			throw new EmptyStackException();
		}
		temp = top;
		top = top.getPre();
		return temp.getData();
	}

	@Override
	public T peek() {
		if(!isEmpty()) {
			return top.getData();
		}
		else {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}
	}

	@Override
	public boolean isEmpty() {
		return (top==null);
	}

	@Override
	public void clear() {
		top = null;
		
	}
	
	
	
	

}
