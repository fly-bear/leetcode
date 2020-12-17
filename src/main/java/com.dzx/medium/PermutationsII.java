package com.dzx.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/15 23:11
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 回溯+剪枝
 **/
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums.length==0){
			List<List<Integer>> result = new ArrayList();
			result.add(new ArrayList());
			return result;
		}
		return execute(nums, 0);
	}

	private List<List<Integer>> execute(int[] nums, int index) {
		List<List<Integer>> result = new ArrayList();
		if (index==nums.length-1) {
			List<Integer> item = new ArrayList();
			item.add(nums[index]);
			result.add(item);
			return result;
		}
		int temp;
		Set<Integer> used = new HashSet();
		for(int i=index; i<nums.length;i++) {
			if(used.contains(nums[i])) {
				continue;
			}
			temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
			used.add(nums[index]);
			List<List<Integer>> subList = execute(nums, index+1);
			subList.forEach(item -> item.add(0,nums[index]));
			result.addAll(subList);
			nums[i] = nums[index];
			nums[index] = temp;
		}
		return result;
	}
}
