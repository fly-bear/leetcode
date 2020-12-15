package com.dzx.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 两边扩展法
 */
public class CountNumberOfNiceSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		if (nums.length == 0 || k<0) {
			return 0;
		}
		if (k==0) {
			return countIfk0(nums);
		}
		int p1=0,p2=0;
		Queue<Integer> queue = new LinkedList<>();
		while (p2 < nums.length) {
			if (nums[p2]%2 != 0) {
				queue.add(p2);
			}
			if (queue.size() == k) {
				break;
			}
			p2++;
		}
		if (p2 >= nums.length) {
			return 0;
		}
		p1 = queue.poll();
		int count = 0;
		while (true) {
			int left=1, right=1;
			--p1;
			while (p1 >= 0) {
				if (nums[p1]%2!=0) {
					break;
				}
				--p1;
				++left;
			}
			++p2;
			while (p2 < nums.length) {
				if (nums[p2]%2!=0) {
					break;
				}
				++p2;
				++right;
			}
			count += left*right;
			if (p2 >= nums.length) {
				return count;
			}
			queue.add(p2);
			p1 = queue.isEmpty()?p2:queue.poll();
		}
	}

	private int countIfk0(int[] nums) {
		int p=0;
		while (p < nums.length) {
			if (nums[p]%2==0) {
				break;
			}
			++p;
		}
		if (p>=nums.length) {
			return 0;
		}
		int count = 0;
		int len = 0;
		while (p<nums.length) {
			if (nums[p]%2!=0) {
				while (len > 0) {
					count += len;
					--len;
				}
			}else {
				++len;
			}
			++p;
		}
		while (len > 0) {
			count += len;
			--len;
		}
		return count;
	}
}
