package hw4;

public class BinaryNode<T> {
	
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode()
	{
		this(null);
	}
	
	public BinaryNode(T dataPortion)
	{
		this(dataPortion, null, null);
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
									 BinaryNode<T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public BinaryNode<T> getLeft()
	{
		return leftChild;
	}
	
	public BinaryNode<T> getRight()
	{
		return rightChild;
	}
	
	public void setLeft(BinaryNode<T> newLeftChild)
	{
		leftChild = newLeftChild;
	}
	
	public void setRight(BinaryNode<T> newRightChild)
	{
		rightChild = newRightChild;
	}
	
	public boolean hasLeft() 
	{
		return leftChild != null;
	}
	
	public boolean hasRight()
	{
		return rightChild != null;
	}
	
	public boolean isLeaf()
	{
		return (leftChild == null) && (rightChild == null);
	}
	
	public BinaryNode<T> copy()
	{
		BinaryNode<T> newRoot = new BinaryNode<>(data);
		
		if (leftChild != null)
			newRoot.setLeft(leftChild.copy());
		if (rightChild != null)
			newRoot.setRight(rightChild.copy());
		return newRoot;
	}
	//getheight
	//getnumberofnodes
}
