package hW2;

public interface IProduct {
	
	
	public boolean isManufactured(IQueue<IProduct> factoryLine , IProduct product);
	
	public boolean isStored(IStack<IProduct> warehouse,IProduct product);
	
	public boolean isSold(IQueue<IProduct> soldThings, IProduct product);
	
	public String getName(); // to print name of products

}
