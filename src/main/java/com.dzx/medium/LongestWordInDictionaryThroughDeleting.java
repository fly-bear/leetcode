package com.dzx.medium;

import java.util.List;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/11 22:24
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 **/
public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		String result = "";
		for (String word: d) {
			if (word.length() < result.length()) {
				continue;
			}else if (word.length() == result.length()) {
				boolean valid = false;
				for (int i=0;i<word.length();i++) {
					if (word.charAt(i)<result.charAt(i)) {
						valid = true;
						break;
					}else if (word.charAt(i)>result.charAt(i)) {
						break;
					}
				}
				if (!valid) {
					continue;
				}
			}
			int index = 0;
//			char[] cs = word.toCharArray();
			int i = 0;
			while (i<word.length()) {
				while (index < s.length()) {
					if (word.charAt(i) == s.charAt(index++)) {
						++i;
						break;
					}
				}
				if (index >= s.length()) {
					break;
				}
			}
			if (i>=word.length()) {
				result = word;
			}
		}
		return result;
	}
}
