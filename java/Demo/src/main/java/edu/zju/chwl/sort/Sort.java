package edu.zju.chwl.sort;

public class Sort {

	public static void main(String[] args) {
		int[] arr={36,25,48,12,25,65,43,57};
		//选择排序
//		selectSort(arr);
		//插入排序
//		insertSort(arr);
		//冒泡排序
		bubbleSort(arr);

	}
	
	//插入排序
	public static void insertSort(int[] a) {
		int len=a.length;
		int temp,i,j;
		for(i=1;i<len;i++){
			temp=a[i];
			for(j=i-1;j>=0&&(temp<a[j]);j--){
				a[j+1]=a[j];
			}
			a[j+1]=temp;
			printArray(a);
		}
		
	}

	public static void printArray(int[] a) {
		for(int item:a){
			System.out.print(item+" ");
		}
		System.out.println();
	}

	//选择排序
	public static void selectSort(int [] arr){
		int len=arr.length;
		int flag,temp,i,j;
		for(i=0;i<len;i++){
			flag=i;
			for(j=i+1;j<len;j++){
				if(arr[j]<arr[flag]){
					flag=j;
				}					
			}
			temp=arr[flag];
			arr[flag]=arr[i];
			arr[i]=temp;
			printArray(arr);
		}
		
	}	
	
	//冒泡排序
	public static void bubbleSort(int [] a){
		int len=a.length;
		int temp,i,j;
		for(i=0;i<len-1;i++){
			for(j=1;j<len-i;j++){
				if(a[j-1]>a[j]){
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}					
			}
			printArray(a);
		}
		
	}


}
