package edu.zju.chwl.offer.add;

import org.junit.*;

//字符串转化为int
public class StrToInt {
	
    public int strToInt(String str) {
    	//输入为"", "+" 和"-"都返回0值
        if(str.isEmpty()||(!str.matches("\\+\\d+")&&!str.matches("-\\d+")&&!str.matches("\\d+"))){
        	return 0;
        }
        long sum;
        boolean minus;
        if(str.matches("-\\d+")){
        	minus=true;
    		str=str.substring(1);
    		sum=transfer(str,minus);
        }else{
        	minus=false;
        	if(str.matches("\\+\\d+")){
        		str=str.substring(1);
        	}
    		sum=transfer(str,minus);
        }
       
        return (int)sum;
    }    

    private long transfer(String str, boolean minus) {
    	//可能出现溢出的情况，所有用long来接收值
		long sum=0;
		for(int i=0;i<str.length();i++){
			sum = sum*10+new Integer(str.charAt(i)-'0'); 
		}
		return minus?sum*-1:sum;
	}

	@Test
    public void matchTest(){
    	Assert.assertTrue("+0".matches("\\+\\d+"));
    	Assert.assertTrue("-2".matches("-\\d+"));
    	Assert.assertTrue("123".matches("\\d+"));
    }
	
	@Test
    public void transfer(){
    	Assert.assertEquals(123,transfer("123", false));
    	Assert.assertEquals(-123,transfer("123", true));
    }
	
	@Test
    public void strToInt(){
    	Assert.assertEquals(123,strToInt("123"));
    	Assert.assertEquals(-123,strToInt("-123"));
    }
}
