package cn.itcast.springmvc.model;

import java.util.Date;

public class User {
	
	public User(Double item2,Double item3) 
    { 
        this.item1=10.0;
        this.item2=item2;
        this.item3=item3;
    }

    public Double getItem1() {
		return item1;
	}
	public void setItem1(Double item1) {
		this.item1 = item1;
	}
	public Double getItem2() {
		return item2;
	}
	public void setItem2(Double item2) {
		this.item2 = item2;
	}
	public Double getItem3() {
		return item3;
	}
	public void setItem3(Double item3) {
		this.item3 = item3;
	}

	Double item1;
    Double item2;
    Double item3;

}
