package com.dzx.medium;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/8 19:15
 * 最长回文子串
 *
 **/
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		int longest = 0;
		String sub = "";
		for (int i=0; i<s.length()-1; i++) {
			String sub1 = palindromicSubLen(s, i, i);
			String sub2 = palindromicSubLen(s,i,i+1);
			int max = Math.max(sub1.length(), sub2.length());
			if (max > longest) {
				longest = max;
				sub = sub1.length()>sub2.length()?sub1:sub2;
			}
		}
		return sub;
	}

	private String palindromicSubLen(String s, int left, int right) {
		char[] chars = s.toCharArray();
		if (chars[left] != chars[right]) {
			return "";
		}
		while (left>=0 && right<s.length() && chars[left] == chars[right]) {
			left --;
			right++;
		}
		left++;
		right--;
		return s.substring(left, right+1);
	}
}
