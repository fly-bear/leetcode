package com.dzx.medium;

import com.dzx.TreeNode;

/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/14 22:41
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 找到节点和其父节点
 * 若左右子树均为空，删除父节点的子节点（不能直接将子节点的指针置null  !!!!!）
 * 若左子树不为空，右旋，右子树接到左子树的最右叶子节点
 * 若右子树不为空，左旋，左子树接到右子树的最左叶子节点
 **/
public class DeleteNodeInABst {
	TreeNode father = null;
	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode target = find(root, key);
		if (target == null) {
			return root;
		}
		if (target.left != null) {
			rightRoatate(target);
		}else if (target.right != null) {
			leftRoatate(target);
		}else {
			if (father == null) {
				return null;
			}
			if (target == father.left) {
				father.left = null;
			}else {
				father.right = null;
			}
		}
		return root;
	}

	void leftRoatate(TreeNode root) {
		TreeNode right = root.right;
		if (right.left == null) {
			root.val = right.val;
			root.right = right.right;
			right = null;
		}else {
			TreeNode last = right.left;
			while (last.left != null) {
				last = last.left;
			}
			root.val = right.val;
			root.right = right.right;
			last.left = root.left;
			root.left = right.left;
			right = null;
		}
	}

	void rightRoatate(TreeNode root) {
		TreeNode left = root.left;
		if (left.right == null) {
			root.val = left.val;
			root.left = left.left;
			left = null;
		}else {
			TreeNode last = left.right;
			while (last.right != null) {
				last = last.right;
			}
			root.val = left.val;
			root.left = left.left;
			last.right = root.right;
			root.right = left.right;
			left = null;
		}
	}

	TreeNode find(TreeNode root, int key) {
		if (root==null) {
			return null;
		}
		if (root.val == key) {
			return root;
		}
		if (key < root.val && root.left != null) {
			father = root;
			TreeNode left = find(root.left, key);
			if (left != null) {
				return left;
			}
		}
		if (key > root.val && root.right != null) {
			father = root;
			TreeNode right = find(root.right, key);
			if (right != null) {
				return right;
			}
		}
		return null;
	}
}
