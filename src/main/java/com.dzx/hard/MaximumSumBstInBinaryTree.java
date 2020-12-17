package com.dzx.hard;

import com.dzx.TreeNode;

import java.util.Stack;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/14 23:41
 *给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *  
 * 分治法(注意，左右子树都必须是BST！！)
 **/
public class MaximumSumBstInBinaryTree {
	private int max = 0;
	public int maxSumBST(TreeNode root) {
		if (root == null) {
			return 0;
		}
		isBST(root);
		return max;
	}

	private Integer isBST(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			max = max<root.val?root.val:max;
			return root.val;
		}
		Integer left = isBST(root.left);
		Integer right = isBST(root.right);
		if (left != null && right != null &&
			(root.left == null || getRightLeaf(root.left)<root.val) &&
			(root.right==null || root.val<getLeftLeaf(root.right))) {
			int sum = left + root.val +right;
			max = max<sum?sum:max;
			return sum;
		}
		return null;
	}

	private int getLeftLeaf(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	private int getRightLeaf(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}

}
