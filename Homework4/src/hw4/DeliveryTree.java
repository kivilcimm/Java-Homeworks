package hw4;


public class DeliveryTree <T extends Restaurant>
							extends Tree<T>
							implements IBST<T>
{
	private class ReturnObject {
		T data; 
		public ReturnObject(T entry) {
			data = entry;
		}
		public T get() {
			return data;
		}
		public void set(T entry) {
			data = entry;
		}
	}
	
	public DeliveryTree() {
		super();
	}
	
	public DeliveryTree(T rootEntry)
	{
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}
	
	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		
		return findEntry(getRootNode(), entry);
	}

	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;
		
		if (rootNode != null)
		{
			T rootEntry = rootNode.getData();
			
			if(entry.equals(rootEntry))//same instance
				result = rootEntry;
			else if (entry.compareTo(rootEntry.getDeliveryTime()) == 0)//same rating
				result = rootEntry;
			else if (entry.compareTo(rootEntry.getDeliveryTime()) < 0)
				result = findEntry(rootNode.getLeft(), entry);
			else
				result = findEntry(rootNode.getRight(), entry);

		}
		return result;
	}

	@Override
	public T add(T entry) {
		T result = null;
		
		if (isEmpty())
			setRootNode(new BinaryNode<>(entry));
		else
			result = addEntry(getRootNode(), entry);
		
		return result;
	}

	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData().getDeliveryTime());
		
		if (comparison == 0)
		{
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (comparison < 0)
		{
			if (rootNode.hasLeft())
				result = addEntry(rootNode.getLeft(), newEntry);
			else
				rootNode.setLeft(new BinaryNode<>(newEntry));
		}
		else
		{
			assert comparison > 0;
			if(rootNode.hasRight())
				result = addEntry(rootNode.getRight(), newEntry);
			else
				rootNode.setRight(new BinaryNode<>(newEntry));
		}
		return result;
	}

	@Override
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNode<T> newRoot = removeEntry(getRootNode(),entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.get();
	}

	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
		if (rootNode != null)
		{
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData.getDeliveryTime());
			if (comparison == 0)
			{
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			}
			else if(comparison < 0)
			{
				BinaryNode<T> leftChild = rootNode.getLeft();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				rootNode.setLeft(subtreeRoot);
			}
			else 
			{
				BinaryNode<T> rightChild = rootNode.getRight();
				rootNode.setRight(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
	{
		if (rootNode.hasLeft() && rootNode.hasRight())
		{
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeft();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			rootNode.setData(largestNode.getData());
			rootNode.setLeft(removeLargest(leftSubtreeRoot));
		}
		else if (rootNode.hasRight())
			rootNode = rootNode.getRight();
		else
			rootNode = rootNode.getLeft();
		return rootNode;
	}

	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRight())
		{
			BinaryNode<T> rightChild = rootNode.getRight();
			rightChild = removeLargest(rightChild);
			rootNode.setRight(rightChild);
		}
		else
			rootNode = rootNode.getLeft();
		return rootNode;
	}

	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRight())
			rootNode = findLargest(rootNode.getRight());
		return rootNode;
	}
	
}
