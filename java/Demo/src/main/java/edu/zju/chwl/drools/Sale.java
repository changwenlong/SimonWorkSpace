package edu.zju.chwl.drools;

public class Sale {
	private Integer amount;
	private Integer quantity;
	public Sale(Integer amount, Integer quantity) {
		super();
		this.amount = amount;
		this.quantity = quantity;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
