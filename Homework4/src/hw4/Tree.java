package hw4;

import java.util.Iterator;
import java.util.NoSuchElementException;

//new package or stack class import

public class Tree<T> 
{
	private class InorderIterator implements Iterator<T> {
		private StackInterface<BinaryNode<T>> nodeStack;
		private BinaryNode currentNode;
		
		public InorderIterator() {
			nodeStack = new LinkedStack<>();
			currentNode = root;
		}

		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		@Override
		public T next() {
			BinaryNode<T> nextNode = null;
			while (currentNode != null)
			{
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			
			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null;
				
				currentNode = nextNode.getRight();
			}
			else
				throw new NoSuchElementException();
			return nextNode.getData();
		}
	}

	private BinaryNode<T> root;
	
	public Tree(){
		root = null;
	}
	
	public Tree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public Tree(T rootData, Tree<T> leftTree, Tree<T> rightTree)
	{
		privateSetTree(rootData,leftTree,rightTree);
	}
	
	private void privateSetTree(T rootData, Tree<T> leftTree,
										   Tree<T> rightTree)
	{
		root = new BinaryNode<>(rootData);
		
		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeft(leftTree.root.copy());
		
		if ((rightTree != null) && !rightTree.isEmpty())
			root.setRight(rightTree.root.copy());
	}
	
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public void setTree(T rootData, Tree<T> leftTree,
									Tree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public T getRootData() {
		T rootData = null;
		
		if (root != null)
			rootData = root.getData();
		return rootData;
	}
	
	protected BinaryNode<T> getRootNode() {
		return root;
	}
	
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear( ) {
		root = null;
	}
	
	public Iterator<T> getInorderIterator(){
		return new InorderIterator();
	}
	//traverse
	
	public void iterativeInorderTraverse() 
	{
		StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
		BinaryNode<T> currentNode = root;
		
		while (!nodeStack.isEmpty() || (currentNode != null))
		{
			while (currentNode != null)
			{
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			
			if (!nodeStack.isEmpty())
			{
				BinaryNode<T> nextNode = nodeStack.pop();
				assert nextNode != null;
				currentNode = nextNode.getRight();
			}
		}
	}
}
