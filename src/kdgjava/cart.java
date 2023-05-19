package kdgjava;

public class cart {
	
	private String id;
	private int orderNumber;
	private int Count;
	
	public cart(String id, int orderNumber, int count) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.Count = count;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}
	
	
	
	
}
