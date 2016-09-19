package edu.zju.chwl.drools;

/**
 * Created by a590450 on 2 Jun 2016.
 *
 */
public class Temperature {
	
	private double temp;

	public Temperature(double temp) {
		super();
		this.temp = temp;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Temperature [temp=" + temp + "]";
	}	

}
