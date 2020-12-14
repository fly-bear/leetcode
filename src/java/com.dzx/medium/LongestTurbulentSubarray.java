package com.dzx.medium;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/14 22:30
 *当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 动态规划
 **/
public class LongestTurbulentSubarray {
	private int max=1;

	public int maxTurbulenceSize(int[] arr) {
		if (arr == null || arr.length==0) {
			return 0;
		}
		recurv(arr, arr.length);
		return max;
	}

	private int recurv(int[] arr, int end) {
		if(end <= 1) {
			return 1;
		}
		int last = recurv(arr, end-1);
		if (last == 1) {
			int len = arr[end-2] == arr[end-1]?1:2;
			max = max<len?len:max;
			return len;
		}
		if ((arr[end-3] < arr[end-2] && arr[end-2] > arr[end-1]) ||
			(arr[end-3] > arr[end-2] && arr[end-2] < arr[end-1])) {
			max = max<last+1?last+1:max;
			return last+1;
		}else{
			int len = arr[end-2] == arr[end-1]?1:2;
			max = max<len?len:max;
			return len;
		}
	}
}
