package hW2;

public class Table  implements IProduct{
	
	private boolean stored;
	private boolean sold;
	private boolean man;
	
	public boolean isManufactured(IQueue<IProduct> factoryLine , IProduct product) {
		this.man = factoryLine.getBack().getClass() == product.getClass();
		return this.man;
	}
	public boolean isStored(IStack<IProduct> warehouse,IProduct product){
		this.stored =warehouse.peek().getClass() == product.getClass();
		return this.stored;
	}
	public boolean isSold(IQueue<IProduct> soldThings, IProduct product){
		this.sold = soldThings.getBack().getClass() == product.getClass();
		return sold;
	}
	
	public String getName() {
		 
		return ("Table");
		
	}


}
