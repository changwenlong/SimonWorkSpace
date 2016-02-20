package edu.zju.chwl.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testEquality() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertEquals(Money.franc(5),Money.franc(5));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}

	@Test
	public void testFranc() {
		fail("Not yet implemented");
	}

	@Test
	public void testTimes() {
		assertEquals(Money.dollar(10),Money.dollar(5).times(2));
		assertEquals(Money.franc(10),Money.franc(5).times(2));
	}
	
	@Test
	public void testMixedAddtion(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(result, Money.dollar(10));
		
	}
	
	@Test
	public void testSumPlusMoney(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks,tenFrancs).plus(fiveBucks);		
		assertEquals(bank.reduce(sum, "USD"), Money.dollar(15));		
	}
	
	@Test
	public void testSumTimes(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks,tenFrancs).times(2);	
		assertEquals(bank.reduce(sum, "USD"), Money.dollar(20));
		
	}
	

}
