package edu.zju.chwl.offer.timeandspace;

import java.util.ArrayList;

import org.junit.*;


public class MoreThanHalfNumber {

	/**
	 * 查找数组中出现次数超过数组长度一半的数
	 * @author a590450
	 * @date 30 Mar 2016 15:18:09
	 */
	public int moreThanHalfNum(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int len = array.length;
		int value = findKth(array, 0, len - 1, len / 2);
		int count = 0;
		for (int item : array) {
			if (item == value) {
				count++;
			}
		}
		if (count > len / 2) {
			return value;
		}
		return 0;
	}
	
	//最小的k个数
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
        if(input==null||input.length==0||k>input.length){
        	return list;
        }
        findKth(input,0,input.length-1,k-1);
        for(int i=0;i<k;i++){
        	list.add(input[i]);
        }
        return list;
    }
    
	/**
	 * 查找排序后，位置为k的数
	 * @param array
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	private int findKth(int[] array,int start,int end,int k){
		if(start==end){
			return array[start];
		}
		int pos = partition(array,start,end);
		if(pos==k){
			return array[pos];
		}else if(pos>k){
			return findKth(array,start,pos-1,k);
		}else{
			return findKth(array,pos+1,end,k);
		}
	}

	public void quickSort(int[] array,int start,int end){
		if(start<=end){
			return;
		}
		int pos = partition(array,0,array.length-1);
		quickSort(array,start,pos-1);
		quickSort(array, pos+1, end);
	}
	
	
	//快排的partition基本实现
	private int partition(int[] array, int start, int end) {
		// 保存小于最后一个数的位置
		int small = start - 1;
		for (int i = start; i < end; i++) {
			// 与最后一个元素比较
			if (array[i] < array[end]) {
				small++;
				if (i != small) {
					swap(array, i, small);
				}
			}
		}
		small++;
		swap(array, small, end);
		return small;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	@Test
	public void quickSort(){
		int[] array = new int[] { 1,4,2,3,5,6 };
		quickSort(array,0,array.length-1);
	}
	

	@Test
	public void testMoreThanHalfNum() {
		int[] array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		Assert.assertEquals(2, moreThanHalfNum(array));
	}

	@Test
	public void testMoreThanHalfNumNotExists() {
		int[] array = new int[] { 1, 2, 3, 2, 4, 2, 5, 2, 3 };
		Assert.assertEquals(0, moreThanHalfNum(array));
	}
	
	@Test
	public void testGetLeastNumbers() {
		int[] array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(getLeastNumbers(array,9));
	}
	
	
}
