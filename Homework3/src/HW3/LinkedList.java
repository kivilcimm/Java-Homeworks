package hW3;

public class LinkedList<T> implements IList<T>{
      
	
	 private Node firstNode;
	 private int numberofEntries;
	 
	 public LinkedList() {
		 
		 initializeDataFields();
	 }
	 private void initializeDataFields() {
		 
		 firstNode = null;
		 numberofEntries = 0;
	 }
	 
	private Node getNodeAt(int givenPosition) {
			 
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberofEntries);
			 
		Node currentNode = firstNode;
			 
		for(int i =1 ; i < givenPosition; i++) {
			currentNode = currentNode.getNextNode();
			}
		assert currentNode != null;
		return currentNode;
			 
		 }
		 
	 @Override
	public void add(T newEntry) {
			Node newNode = new Node(newEntry);
			
			if(isEmpty()) {
				firstNode = newNode;
			}
			else {
				
				Node lastNode = getNodeAt(numberofEntries);
				lastNode.setNextNode(newNode);
			}
			numberofEntries++;
		}
	 
	@Override
	public void add(int newPosition, T newEntry) {
		
		if((newPosition >= 1) && (newPosition <= numberofEntries+1)) {
			
			Node newNode = new Node(newEntry);
			
			if(newPosition == 1) {
				
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else {
				
				Node nodeBefore = getNodeAt(newPosition -1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberofEntries++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal position");
		}
	}
	 

    @Override
	public T remove(int Position) {
    	T result = null;
    	if((Position >= 1) && (Position <= numberofEntries)) {
    		
    		assert !isEmpty();
    		if (Position == 1) {
    			result =firstNode.getData();
    			firstNode = firstNode.getNextNode();
    		}
    		else {
    			Node nodeBefore = getNodeAt(Position -1);
    			Node nodeToRemove = nodeBefore.getNextNode();
    			result = nodeToRemove.getData();
    			Node nodeAfter = nodeToRemove.getNextNode();
    			nodeBefore.setNextNode(nodeAfter);
    		}
    		numberofEntries--;
    		return result;
    	}
    	else {
    		throw new IndexOutOfBoundsException("Illegal position");
    	}
    }
			

		
	@Override
	public T getEntry(int Position) {
		if ((Position >= 1) && (Position <= numberofEntries)) {
			
			assert !isEmpty();
			return getNodeAt(Position).getData();
			
		}
		else {
			throw new IndexOutOfBoundsException(
					"Illegal position");
		}
		
	}
		
	@Override
	public int getLength() {
			return numberofEntries;
		}

	@Override
	public boolean isEmpty() {
		boolean result;
		if(numberofEntries == 0)
		{
			assert firstNode == null;
			result = true;
		}
		else {
			assert firstNode != null;
			result = false;
		}
		return result;
		}

	 
	 
	 private class Node{
		 
		 private T data;
		 private Node next;
		 
		 private Node(T dataPortion) {
			 this(dataPortion, null);
			 
		 }
		 private Node(T dataPortion, Node nextNode) {
			 
			 data = dataPortion;
			 next = nextNode;
		 }
		 
		 private T getData() {
			 
			 return data;
		 }
		 
		 private void setData(T newData) {
			 
			 data = newData;
		}
		 
		 private Node getNextNode() {
			 
			 return next;
		 }
		 
		 private void setNextNode(Node nextNode) {
			 
			 next = nextNode;
		 }
	 }
	 

	

}
