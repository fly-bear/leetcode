package com.dzx;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/13 17:48
 * 输入一个整数数组，有整数也有负数，数组中连续的一个或多个整数组成一个子数组，求所有子数组的最大和，要求时间复杂度O(n)
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
