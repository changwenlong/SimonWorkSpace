package edu.zju.chwl;

import org.junit.Test;

public class SortDemo {

	@Test
	public void test() {
		int [] a={1,3,7,8,6,5,4,2};
		insertSort1(a);				
	}
	public void insertSort(int[] a){
		   
		   int b;
		   for(int i=1;i<a.length;i++){
			   
			   b=a[i];
			   int j;
			   for(j=i-1;j>=0;j--){
				   if(a[j]>b){
					   a[j+1]=a[j];
				   }else{
					   a[j+1]=b;
					   break;
				   }
				  
			   }
		   }
		   for(int c:a){
			   System.out.print(c+" ");
		   }
	   }
	
	void insertSort1(int[] a){
		   
		   int b;
		   for(int i=1;i<a.length;i++){
			   
			   b=a[i];
			   int j;
			   for(j=i-1;j>=0&&(b>a[j]);j--){
				   a[j+1]=a[j];
				  
			   }
			    a[j+1]=b;
		   }
		   
		   //System.out.print(a[3]+" ");
		   for(int c:a){
			   System.out.print(c+" ");
		   }
	   }


	@Test
	public void testStr(){
		String s1="abc";
		String s2="bc";
		String s3="a"+s2;
		System.out.println(s1.equals(s3));
		System.out.println(s1=="abc");
		System.out.println(s1==s3);
		System.out.println(s2=="bc");
	}
	@Test
	public void testSwap(){
		Integer i=new Integer(3),j=new Integer(5);
		swap(i,j);
		System.out.println("i="+i+"\nj="+j);
	}
	private void swap(Integer i,Integer j) {
		Integer temp=i;
		i=j;
		j=temp;	
		System.out.println("i="+i+"\nj="+j);
	}
	
	@Test
	public void testSwap1(){
		int i=3,j=5;
		swap1(i,j);
		System.out.println("i="+i+"\nj="+j);
	}
	private void swap1(int i,int j) {
		int temp=i;
		i=j;
		j=temp;	
		System.out.println("i="+i+"\nj="+j);
	}
	@Test
	public void testSwap2(){
		Integer[] a={3,5};
		swap2(a[0],a[1]);
		System.out.println("a[0]="+a[0]+";a[1]="+a[1]);
	}
	private void swap2(Integer i,Integer j) {
		Integer temp=i;
		i=j;
		j=temp;	
		System.out.println("i="+i+"\nj="+j);
	}
	@Test
	public void testSwap3(){
		StringBuilder i=new StringBuilder("3");
		StringBuilder j=new StringBuilder("5");
		swap3(i,j);
		System.out.println("i="+i+";j="+j);
	}
	private void swap3(StringBuilder i,StringBuilder j) {
		i.append("3");
		j.append("5");
		System.out.println("i="+i+";j="+j);
	}
}
