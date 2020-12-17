package com.dzx.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/12 15:05
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 动态规划 + 回溯
 **/
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		cal(nums, 0, result);
		return result;
	}

	private void cal(int[] nums, int head, List<List<Integer>> result) {
		if (head == nums.length-1) {
			result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		int temp;
		for (int i=head; i<nums.length; i++) {
			temp = nums[head];
			nums[head] = nums[i];
			nums[i] = temp;
			cal(nums, head+1, result);
			nums[i] = nums[head];
			nums[head] = temp;
		}
	}
}
