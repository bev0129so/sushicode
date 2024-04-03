package com.pg.programmercarl.tree;

/**
 * @author luojx
 * @date 2024/3/27 9:41
 */
public class ReverseTree {
    public TreeNode invertTree(TreeNode root) {
        return traverse(root);
    }
    
    public TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = traverse(node.left);
        TreeNode right = traverse(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
