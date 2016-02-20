package edu.zju.chwl.tdd;

public class Money implements Expression{
	//币种
	private String currency;
	//面值
	private int amount;
	
	public Money(int amount,String currency){
		this.amount=amount;
		this.currency=currency;
	}
	
	public static Money dollar(int amount){
		return new Money(amount,"USD");
	}
	
	public static Money franc(int amount){
		return new Money(amount,"CHF");
	}
	
	public Expression times(int time){
		return new Money(amount*time,currency);
	}
	
	@Override
	public boolean equals(Object obj){
		Money money = (Money) obj;
		return amount==money.amount&&currency.equals(money.currency());
	}

	public String currency() {
		return currency;
	}
	
	public int amount() {
		return amount;
	}
	
	public Expression plus(Expression addend){
		return new Sum(this,addend);
	}

	public Money reduce(Bank bank,String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount/rate,to);
	}
}
