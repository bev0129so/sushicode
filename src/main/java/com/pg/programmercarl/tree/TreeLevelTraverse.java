package com.pg.programmercarl.tree;

import java.util.*;

/**
 * @author luojx
 * @date 2024/3/27 9:16
 */
public class TreeLevelTraverse {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            double mean = sum * 1.0 / size;
            list.add(mean);
        }
        return list;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root
     * @return {@code Node}
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    Node peek = queue.peek();
                    node.next = peek;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 二叉树的最大深度
     * 
     * @param root
     * @return int
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int cntNode = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cntNode += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return cntNode;
    }
    
    public int countNodesRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodesRecursion(root.left);
        int right = countNodesRecursion(root.right);
        return left + right + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight -rightHeight) > 1 ? -1: 1 + Math.max(leftHeight, rightHeight);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        buildBinaryTreePaths(root, new Stack<>(), res);
        return res;
    }
    
    private void buildBinaryTreePaths(TreeNode node, Stack<Integer> val, List<String> res) {
        val.push(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < val.size(); i++) {
                builder.append(val.get(i));
                if (i != val.size() - 1) {
                    builder.append("->");
                }
            }
            res.add(builder.toString());
            return;
        }
        if (node.left != null) {
            buildBinaryTreePaths(node.left, val, res);
            val.pop();
        }
        if (node.right != null) {
            buildBinaryTreePaths(node.right, val, res);
            val.pop();
        }
    }

    /**
     * 左叶子之和
     */
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }
        traverse(root);
        return res;
    }
    
    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                res += node.left.val;
            } else {
                traverse(node.left);
            }
        }
        if (node.right != null) {
            traverse(node.right);
        }
    }


    /**
     * https://programmercarl.com/0513.%E6%89%BE%E6%A0%91%E5%B7%A6%E4%B8%8B%E8%A7%92%E7%9A%84%E5%80%BC.html#%E6%80%9D%E8%B7%AF
     */
    int depth = 0, lv;
    int MAX_DEPTH = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (depth > MAX_DEPTH) {
                MAX_DEPTH = depth;
                lv = root.val;
            }
        }
        if (root.left != null) {
            depth++;
            findBottomLeftValue(root.left);
            depth--;
        }
        if (root.right != null) {
            depth++;
            findBottomLeftValue(root.right);
            depth--;
        }
        return lv;
    }

    /**
     * https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     * @param root
     * @param targetSum
     * @return
     */
    boolean pathSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(root.val);
        preOrderTraverse(root, stack, targetSum);
        return pathSum;
    }
    
    public void preOrderTraverse(TreeNode node, Stack<Integer> stack, int targetSum) {
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (Integer v : stack) {
                sum += v;
            }
            if (targetSum == sum) {
                pathSum = true;
            }
        }
        if (node.left != null) {
            stack.add(node.left.val);
            preOrderTraverse(node.left, stack, targetSum);
            stack.pop();
        }
        if (node.right != null) {
            stack.add(node.right.val);
            preOrderTraverse(node.right, stack, targetSum);
            stack.pop();
        }
    }


    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return paths;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(root.val);
        traversal(root, stack, targetSum);
        return paths;
    }
    
    public void traversal(TreeNode node, Stack<Integer> stack, int targetSum) {
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (Integer v : stack) {
                sum += v;
            }
            if (targetSum == sum) {
                paths.add(new ArrayList<>(stack));
            }
        }
        if (node.left != null) {
            stack.add(node.left.val);
            traversal(node.left, stack, targetSum);
            stack.pop();
        }
        if (node.right != null) {
            stack.add(node.right.val);
            traversal(node.right, stack, targetSum);
            stack.pop();
        }
    }
    
}
