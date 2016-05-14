package edu.zju.chwl.offer.add;

/**
 * 字符流中第一个不重复字符
 * @author chwl
 * @Date 2016年4月16日 下午11:41:30
 */
public class FirstAppearingOnce {
	
	private int[] hash = new int[128];
	private String str="";
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(hash[ch]==0){
        	str+=ch;
        }
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	char ch = '#';
    	for(int i=0;i<str.length();i++){
    		if(hash[str.charAt(i)]==1){
    			ch =  str.charAt(i);
    			break;
    		}
    	}
    	return ch;
    }
    
}
