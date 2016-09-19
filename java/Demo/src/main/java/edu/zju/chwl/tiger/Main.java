package edu.zju.chwl.tiger;

import java.math.BigDecimal;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			for(int i=0;i<n;i++){
				BigDecimal dem = in.nextBigDecimal();
				StringBuilder str = new StringBuilder("0.");
				while(dem.compareTo(new BigDecimal(0))!=0&&str.length()<103){
					final BigDecimal TWO = new BigDecimal(2);
					final BigDecimal ONE = new BigDecimal(1);
					BigDecimal mul = dem.multiply(TWO);
					if(mul.compareTo(ONE)>=0){
						str.append(1);
						dem = mul.subtract(ONE);
					}else{
						str.append(0);
						dem = mul;
					}
				}
				if(str.length()>=103){
					System.out.println("NO");
				}else{
					System.out.println(str);
				}
			}
		}
	}	
}
