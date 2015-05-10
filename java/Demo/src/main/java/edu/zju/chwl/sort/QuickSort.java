package edu.zju.chwl.sort;



public class QuickSort {

	public static void main(String[] args) {
		int[] a={49,38,65,97,76,13,27};
		//快速排序
		//quickSort(a, 0, a.length-1);
		//归并排序
		mergeSort(a, 2);
		quickSort(a, 4, 5);
	}

	//快速排序
	public static void quickSort(int[] a,int low,int high){
		//别忘了这个条件，否则会无限递归
		if(low>=high){
			return;
		}
		//设置两个移动指针，i指向low，j指向high
		int i=low,j=high;
		//保存比较值
		int temp=a[i];
		//保存标记位置 i向前移动一位
		int flag=i++;
		//先从high位开始比较
		boolean compareHigh=true;
		//必须使用<= 使用<的话 少比较了一次
		while(i<=j){
			//high指向的元素必须大于比较值 否则交换位置
			if(compareHigh){
				if(a[j]<temp){
					a[flag]=a[j];
					flag=j;
					compareHigh=false;
				}
				j--;
			}else{//low指向的元素必须小于比较值 否则交换位置
				if(a[i]>temp){
					a[flag]=a[i];
					flag=i;
					compareHigh=true;
				}
				i++;
			}
		}
		a[flag]=temp;
		quickSort(a,low,flag-1);
		quickSort(a, flag+1, high);
		
	}
	
	//归并排序
	public static void mergeSort(int[] a,int count){
		int len=a.length;
		//递归结束条件
		if((count-2)>len){
			return;
		}
		int times=(len+1)/count;
		int i;
		for(i=0;i<times;i++){
			mySort(a,i*count,i==times-1?(len-1):((i+1)*count-1));
		}
		Sort.printArray(a);
		mergeSort(a, count*2);
		
	}

	private static void mySort(int[] a, int i, int j) {
		//截取的数组可直接使用原先实现的快排
		//quickSort(a, i, j);	
		
		//截取的数组采用插入排序 且前一半是有序的的
		//元素个数
		int c=j-i+1;
		//前面有序元素的个数
		int sortedCount=(c+1)/2;
		//插入排序从i+sortedCount开始
		int k,h;
		for(k=i+sortedCount;k<=j;k++){
			int temp1=a[k];
			for(h=k-1;h>=i&&(a[h]>temp1);h--){
				a[h+1]=a[h];
			}
			a[h+1]=temp1;
		}
	}
}
