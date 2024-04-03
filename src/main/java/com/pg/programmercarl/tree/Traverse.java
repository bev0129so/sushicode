package com.pg.programmercarl.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author luojx
 * @date 2024/3/26 10:03
 */
public class Traverse {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    
    public void traverse(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }

    /**
     * 非递归的前序遍历
     */
    public List<Integer> iterateTraversePreOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    /**
     * 非递归的中序遍历
     */
    public List<Integer> iterateTraverseInOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 非递归的后序遍历
     * 前序（中左右） -> 中右左 -> 左右中
     */
    public List<Integer> iterateTraversePostOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
