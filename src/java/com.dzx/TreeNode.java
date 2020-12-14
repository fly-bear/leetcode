package com.dzx;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/11 22:26
 **/
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
	}
}
