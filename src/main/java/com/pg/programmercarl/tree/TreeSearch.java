package com.pg.programmercarl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojx
 * @date 2024/4/3 13:20
 */
public class TreeSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }


    /**
     * https://programmercarl.com/0098.%E9%AA%8C%E8%AF%81%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     */
    public boolean isValidBST(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }
    
    public boolean traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return true;
        }
        boolean l = traversal(node.left, list);
        if (!list.isEmpty()) {
            if (node.val <= list.get(list.size() - 1)) {
                return false;
            }
        }
        list.add(node.val);
        boolean r = traversal(node.right, list);
        return l && r;
    }

    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        miniDiffTraversal(root, new ArrayList<>());
        return minDiff;
    }
    
    public void miniDiffTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        miniDiffTraversal(node.left, list);
        list.add(node.val);
        if (list.size() >= 2) {
            minDiff = Math.min(minDiff, Math.abs(list.get(list.size() - 1) - list.get(list.size() - 2)));
        }
        miniDiffTraversal(node.right, list);
    }



    int maxOc = 1;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        findModeTraversal(root, new ArrayList<>());
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
    
    public void findModeTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        findModeTraversal(node.left, list);
        list.add(node.val);
        if (list.size() == 1) {
            res.add(node.val);
        }
        if (list.size() > 1) {
            int idx = list.size() - 1;
            while (idx >= 0 && list.get(idx) == node.val) {
                idx--;
            }
            int curOcc = list.size() - idx - 1;
            if (curOcc == maxOc) {
                res.add(node.val);
            } else if (curOcc > maxOc) {
                res.clear();
                res.add(node.val);
                maxOc = curOcc;
            }
        }
        findModeTraversal(node.right, list);
    }

    /**
     * https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html
     * // TODO: 待理解, 注意p,q在树中一定存在
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p==root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * https://programmercarl.com/0235.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E6%80%9D%E8%B7%AF
     * 利用二叉搜索树的特性，看作数组，第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode big = p.val > q.val ? p : q;
        TreeNode small = p.val > q.val ? q : p;
        if (root.val >= small.val && root.val <= big.val) {
            return root;
        } else if (root.val > small.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (root.val < small.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length);
    }
    
    public TreeNode buildBST(int[] nums, int l, int r) {
        if (l >= r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, l, mid);
        node.right = buildBST(nums, mid + 1, r);
        return node;
    }
}
