package com.dzx.sort;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/8 16:05
 * 快排
 **/
public class QuickSort {
	public int[] sort(int[] arr) {
		qs(arr, 0, arr.length);
		return arr;
	}

	public void qs(int[] arr, int left, int right) {
		if (right-left < 1) {
			return;
		}
		int i=left,j=right;
		int basic = arr[left];
		int index = left;
		boolean desc = true;
		while (i < j) {
			if (!desc) {
				i++;
				if (arr[i]>basic) {
					arr[index] = arr[i];
					index = i;
					desc = true;
				}
			}else {
				j--;
				if (arr[j] < basic) {
					arr[index] = arr[j];
					index = j;
					desc = false;
				}
			}
		}
		arr[i] = basic;
		this.qs(arr, left, i);
		this.qs(arr, i+1, right);
	}
}
