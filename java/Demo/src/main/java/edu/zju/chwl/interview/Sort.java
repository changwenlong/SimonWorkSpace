package edu.zju.chwl.interview;
/**
 * 1.问：java如何实现数组排序？
 * 答：Arrays.sort()
 * 2.问：了解过相应的JDK源码吗？是如何实现的？
 * 答：
 * java Arrays中提供了对所有类型的排序。其中主要分为Primitive(8种基本类型)和Object两大类
 * 基本类型：采用调优的快速排序；
 * 对象类型：采用改进的归并排序。（实现Comparable或提供Comparator比较器）
 * 排序优化：实现中快排和归并都采用递归方式，而在递归的底层，也就是待排序的数组长度小于7时，直接使用冒泡排序，而不再递归下去。
 * 3.选择实现快排或归并排序
 */
public class Sort {
	public static void main(String[] args) {
		int[] arr=new int[]{1,4,6,8,3,2,9};
		quickSort(arr,0,arr.length-1);
		//mergeSort(arr,0,arr.length-1);
	}
	
	public static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	
	public static int[] mergeSort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(nums, low, mid);
			mergeSort(nums, mid + 1, high);
			merge(nums, low, mid, high);
		}
		return nums;
	}

	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		while (j <= high) {
			temp[k++] = nums[j++];
		}

		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}
}


