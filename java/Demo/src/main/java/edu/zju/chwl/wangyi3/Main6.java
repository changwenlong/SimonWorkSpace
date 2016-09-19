package edu.zju.chwl.wangyi3;

import java.util.*;

/**
 * 注意点：运算过程中需模1000000007，不然就算使用Long，也会越界
 * 层次遍历时，善用hashMap避免重复添加
 * @author chwl
 * @Date 2016年9月10日 下午1:24:39
 */
public class Main6 {
	static final int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLong()){
			long n = in.nextLong();
			LinkedList<Long> list = new LinkedList<Long>();
			HashMap<Long, Boolean> map = new HashMap<Long,Boolean>();
			map.put(n, true);
			list.add( n);
			int cnt = 0;
			boolean flag =false;
			while(!list.isEmpty()&&cnt<=100000&&!flag){
				int size = list.size();
				for(int i=0;i<size;i++){
					Long val = list.pop();
					if(val%MOD==0){
						flag=true;
						System.out.println(cnt);
						break;
					}else{
						long val1 = (val*4+3)%MOD;//别忘了模上1000000007
						if(map.get(val1)==null){
							list.offer(val1);
							map.put(val1, true);
						}
						long val2 = (val*8+7)%MOD;
						if(map.get(val2)==null){
							list.offer(val2);
							map.put(val2, true);
						}
						
					}
				}
				cnt++;
			}
			if(!flag){
				System.out.println(-1);
			}
			
		}
	}	
}
/*
125000000
1000000007
289869954
 */
