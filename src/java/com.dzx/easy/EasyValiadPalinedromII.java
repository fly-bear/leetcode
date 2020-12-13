package com.dzx.easy;

import java.util.Stack;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/11 21:49
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 双指针+回溯
 **/
public class EasyValiadPalinedromII {
	public boolean validPalindrome(String s) {
		if (s.length()==1) {
			return true;
		}
		int left = 0;
		int right = s.length()-1;
		int record = -1;
		char[] arr = s.toCharArray();
		boolean deleted = false;
		while(left < right) {
			if(arr[left] != arr[right]){
				if (deleted) {
					if (record == -1) {
						return false;
					}else {
						left = record;
						record = -1;
						right = s.length()-left-1;
						arr = (s.substring(0, right) + s.substring(right+1)).toCharArray();
						--right;
						continue;
					}
				}
				if(right-left<=1) {
					return true;
				}
				if(arr[left+1] == arr[right]) {
					if(arr[right-1] == arr[left]) {
						record = left;
					}
					arr = (s.substring(0,left) + s.substring(left+1)).toCharArray();
					deleted = true;
					--right;
				}else if(arr[right-1] == arr[left]) {
					arr = (s.substring(0, right) + s.substring(right+1)).toCharArray();
					--right;
					deleted = true;
					continue;
				}else {
					return false;
				}
			}
			++left;
			--right;
		}
		return true;
	}
}
