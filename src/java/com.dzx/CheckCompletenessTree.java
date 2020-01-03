package com.dzx;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int deepth = 0;
        TreeNode point = root;
        while (point.left != null) {
            deepth++;
            point = point.left;
        }
        queue.offer(root);
        int now = 1;
        int count = 0;
        boolean stop = false;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (now < deepth-1 && (p.left == null || p.right == null)) {
                return false;
            }else if (now < deepth-1) {
                queue.offer(p.left);
                queue.offer(p.right);
                count += 2;
            }else if (now == deepth - 1){
                if (stop) {
                    if (p.left == null && p.right != null) {
                        return false;
                    }
                }
                if (p.left == null) {
                    stop = true;
                    if (p.right != null) {
                        queue.offer(p.right);
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
            }
            if (count >= Math.pow(2, now-1)) {
                now++;
                count = 0;
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
