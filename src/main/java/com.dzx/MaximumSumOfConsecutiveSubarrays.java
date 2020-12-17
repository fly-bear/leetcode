package com.dzx;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/13 17:48
 * 输入一个整数数组，有整数也有负数，数组中连续的一个或多个整数组成一个子数组，求所有子数组的最大和，要求时间复杂度O(n)
 *
 * 子数组是连续的
 * 遍历数组，若当前元素前面的最大子数组和为正数，则与此元素形成新数组，即延长。
 * 若前面的最大和子数组值为负数，则子数组延长中断，此元素单独成一数组（抛弃累赘）。
 * 只需单次遍历
 **/
public class MaximumSumOfConsecutiveSubarrays {

	private static int max = 0;
	public int solve(int[] arr) {
		if (arr == null || arr.length==0) {
			return 0;
		}
		maxInEndWith(arr, arr.length);
		return max;
	}

	private int maxInEndWith(int[] arr, int index) {
		if (index <= 1) {
			max = arr[0];
			return arr[0];
		}
		int lastMax = maxInEndWith(arr, index-1);
		if (lastMax+arr[index-1] > max) {
			max = lastMax+arr[index-1];
		}
		return lastMax<0?arr[index-1]:lastMax+arr[index-1];
	}








}
