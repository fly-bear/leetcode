package com.dzx;

import java.util.LinkedList;
import java.util.Queue;

/*
    完全二叉树检查,先求最左子节点深度,前几层必须全满,最后一层不能有子节点,本身全靠左.深度优先遍历
 */
public class MediumCheckCompletenessTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int deepth = 0;
        TreeNode point = root;
        while (point.left != null) { // 找到最左节点的最深层
            deepth++;
            point = point.left;
        }
        queue.offer(root);
        int now = 0;
        int count = 1;
        boolean stop = false;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (now < deepth-1 && (p.left == null || p.right == null)) {
                return false;
            }else if (now < deepth-1) { // 必须满节点
                queue.offer(p.left);
                queue.offer(p.right);
                count += 2;
            }else if (now == deepth - 1){
                if (stop) { // 必须全靠左, 中间断了后面就不能有
                    if (p.left != null || p.right != null) {
                        return false;
                    }
                }
                if (p.left == null) { // 后面不能再有了
                    stop = true;
                    if (p.right != null) {
                        return false;
                    }
                }else if (p.right == null) {
                    queue.offer(p.left);
                    stop = true;
                }else {
                    queue.offer(p.left);
                    queue.offer(p.right);
                }

            }else if (now == deepth) {
                if (p.left != null || p.right != null) {
                    return false;
                }
            }else if (now > deepth) {
                return false;
            }
            if (count >= Math.pow(2, now)) {
                now++;
                count = 1;
            }
        }
        return true;
    }
}

class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
