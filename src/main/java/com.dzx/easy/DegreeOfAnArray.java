package com.dzx.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/15 23:12
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 第一次遍历，HashMap保存每个元素出现的频次，以及第一次出现和最后一次出现的位置， 同时记录度（最大频次）
 * 第二次遍历hashmap的keyset，遇到和度相等频次的记录，计算其头尾位置的长度，即为最小子数组长度。多个满足的取最小值。
 * 时间复杂度O(n)
 **/
public class DegreeOfAnArray {
	public int findShortestSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		int max = 1;
		for (int i=0; i<nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				List<Integer> list = map.get(num);
				list.set(0, list.get(0)+1);
				if (list.size() < 3) {
					list.add(i);
				}else{
					list.set(2, i);
				}
				max = max < list.get(0)?list.get(0):max;
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(1);
				list.add(i);
				map.put(num, list);
			}
		}
		if (max == 1) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		for (int key: map.keySet()) {
			if (map.get(key).get(0) == max) {
				int d = map.get(key).get(2) - map.get(key).get(1)+1;
				min = min>d?d:min;
			}
		}
		return min;
	}
}
