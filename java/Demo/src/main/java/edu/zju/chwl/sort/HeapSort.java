package edu.zju.chwl.sort;



public class HeapSort {

	public static void main(String[] args) {
		int[] a={5,4,9,8,7,6,0,1,3,2};
		//堆排序
		heapSort(a);
		Sort.printArray(a);
	}

	//最小堆调整
	public static void adjustMinHeap(int[] a,int pos,int len){
		int tmp;
		int left=pos*2+1;
		int right=pos*2+2;
		//pos存在左右子结点
		if(len-1>=right){
			if(a[left]<a[right]){
				if(a[left]<a[pos]){
					tmp=a[pos];
					a[pos]=a[left];
					a[left]=tmp;
					adjustMinHeap(a,left,len);
				}
			}else{
				if(a[right]<a[pos]){
					tmp=a[pos];
					a[pos]=a[right];
					a[right]=tmp;
					adjustMinHeap(a,right,len);
				}
			}
		}else if(len-1==left){//pos存在左子节点
			if(a[left]<a[pos]){
				tmp=a[pos];
				a[pos]=a[left];
				a[left]=tmp;
			}
		}
		
	}
	
	//归并排序
	public static void heapSort(int[] a){
		int i,tmp;
		int len=a.length;
		for(i=len/2-1;i>=0;i--){//初始化，构建小顶堆 ，从len/2-1处开始调整
			adjustMinHeap(a, i, len);
		}
		for(i=len-1;i>=0;i--){
			tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			//第三个参数是是数组长度 不要用i-1
			adjustMinHeap(a, 0, i);
		}
	}

}
