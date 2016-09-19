package edu.zju.chwl.drools;

/**
 * Created by a590450 on 2 Jun 2016.
 *
 */
public class Mem {
	
	private double usagePercent;
	public Mem(double usagePercent) {
		super();
		this.usagePercent = usagePercent;
	}
	public double getUsagePercent() {
		return usagePercent;
	}
	public void setUsagePercent(double usagePercent) {
		this.usagePercent = usagePercent;
	}
	@Override
	public String toString() {
		return "Mem [usagePercent=" + usagePercent + "]";
	}
}
