package com.pg.programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojx
 * @date 2024/3/27 9:55
 */
public class SymmetricTree {

    public static void main(String[] args) {
//        [1,2,2,2,null,2]
        /**
         *          1
         *      2       2
         *    2       2
         */
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2, new TreeNode(2), null);
        TreeNode rightNode = new TreeNode(2, new TreeNode(2), null);
        root.left = leftNode;
        root.right = rightNode;

        SymmetricTree symmetricTree = new SymmetricTree();
        boolean symmetric = symmetricTree.isSymmetric(root);
        System.out.println("symmetric = " + symmetric);
    }
    public boolean isSymmetric(TreeNode root) {
        //root.left 左右中
        //root.right 右左中
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }
    
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
