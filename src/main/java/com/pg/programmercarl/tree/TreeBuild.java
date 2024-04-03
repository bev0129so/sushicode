package com.pg.programmercarl.tree;

/**
 * @author luojx
 * @date 2024/4/3 10:02
 */
public class TreeBuild {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        if (postorder.length == 1) {
            return root;
        }
        int rootPos = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }
        int splitIdx = rootPos;
        int[] lInorder = new int[splitIdx];
        int[] lPostorder = new int[splitIdx];
        int[] rInorder = new int[postorder.length - splitIdx - 1];
        int[] rPostorder = new int[postorder.length - splitIdx - 1];
        for (int i = 0; i < splitIdx; i++) {
            lInorder[i] = inorder[i];
        }
        for (int i = splitIdx + 1, j=0; i < inorder.length; i++,j++) {
            rInorder[j] = inorder[i];
        }
        for (int i = 0; i < postorder.length - 1; i++) {
            if (i < splitIdx) {
                lPostorder[i] = postorder[i];
            } else {
                rPostorder[i - splitIdx] = postorder[i];
            }
        }
        root.left = buildTree(lInorder, lPostorder);
        root.right = buildTree(rInorder, rPostorder);
        return root;
    }

    public TreeNode buildTreePI(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTreeWithPreIn(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    public TreeNode buildTreeWithPreIn(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (inBegin == inEnd) {
            return null;
        }
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        if (inEnd - inBegin == 1) {
            return root;
        }
        int splitIdx = -1;
        for (int i = inBegin; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                splitIdx = i;
                break;
            }
        }
        int inLeftBegin = inBegin;
        int inLeftEnd = splitIdx;
        int inRightBegin = splitIdx + 1;
        int inRightEnd = inEnd;
        
        int preLeftBegin = preBegin + 1;
        int preLeftEnd = preBegin + 1 + splitIdx - inBegin;
        int preRightBegin = preBegin + 1 + splitIdx - inBegin;
        int preRightEnd = preEnd;
        root.left = buildTreeWithPreIn(preorder, inorder, preLeftBegin, preLeftEnd, inLeftBegin, inLeftEnd);
        root.right = buildTreeWithPreIn(preorder, inorder, preRightBegin, preRightEnd, inRightBegin, inRightEnd);
        return root;
    }


    /**
     * https://programmercarl.com/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {
        if (begin == end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = begin; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        if (end - begin == 1) {
            return root;
        }
        root.left = constructMaximumBinaryTree(nums, begin, idx);
        root.right = constructMaximumBinaryTree(nums, idx + 1, end);
        return root;
    }

    /*
     * https://programmercarl.com/0617.%E5%90%88%E5%B9%B6%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        int val;
        if (root1 != null && root2 != null) {
            val = root1.val + root2.val;
        } else if (root1 != null) {
            val = root1.val;
        } else if (root2 != null){
            val = root2.val;
        } else {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(root1 == null ? null: root1.left, root2 == null ? null : root2.left);
        node.right = mergeTrees(root1 == null ? null: root1.right, root2 == null ? null: root2.right);
        return node;
    }

    public TreeNode mergeTreesImprove(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
    
    
    
}
