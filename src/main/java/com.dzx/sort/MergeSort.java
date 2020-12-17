package com.dzx.sort;

import java.util.Arrays;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/8 15:15
 * 归并排序
 **/
public class MergeSort {
	public int[] sort(int[] list) {
		if (list.length <= 1) {
			return list;
		}
		int[] left = sort(Arrays.copyOfRange(list, 0, list.length/2));
		int[] right = sort(Arrays.copyOfRange(list, list.length/2, list.length));
		int i=0,j=0,k=0;
		int[] result = new int[list.length];
		while (k<result.length) {
			if (i>= left.length) {
				result[k] = right[j];
				j++;
			} else if (j>=right.length || left[i] < right[j]) {
				result[k] = left[i];
				i++;
			}else {
				result[k] = right[j];
				j++;
			}
			k++;
		}
		return result;
	}
}
