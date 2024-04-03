package com.pg.programmercarl.arr.interv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luojx
 * @date 2024/3/5 8:53
 */
public class ComponentsPermutations {
    public static class TreeNode {
        TreeNode(List<Integer> val) {
            this.val = val;
        }
        List<Integer> val;
        List<TreeNode> nodes = new ArrayList<>();
    }

    int cnt = 0;

    public static void main(String[] args) {
        ComponentsPermutations cp = new ComponentsPermutations();
        Permutation permutation = new Permutation();
        List<Integer> components = Arrays.asList(1, 2, 3);
        List<List<Integer>> permute = permutation.permute(components);
        TreeNode dummy = new TreeNode(new ArrayList<>());
        for (List<Integer> list : permute) {
            dummy.nodes.add(new TreeNode(list));
        }
        for (TreeNode node : dummy.nodes) {
            cp.buildTreeNode(components, node.val, node, components.size());
        }
        System.out.println(dummy);
        cp.traverse(dummy);
        System.out.println(cp.cnt);
    }

    private void buildTreeNode(List<Integer> src, List<Integer> used, TreeNode treeNode, int total) {
        if (used.size() == total) {
            return;
        }
        List<Integer> remainingComponents = getRemainingComponents(src, treeNode, used);
        Permutation q = new Permutation();
        List<List<Integer>> permute = q.permute(remainingComponents);
        for (List<Integer> p : permute) {
            TreeNode childNode = new TreeNode(p);
            treeNode.nodes.add(childNode);
        }
        for (TreeNode child : treeNode.nodes) {
            List<Integer> tempUsed = new ArrayList<>();
            tempUsed.addAll(used);
            tempUsed.addAll(child.val);
            buildTreeNode(src, tempUsed, child, total);
        }
    }

    private static List<Integer> getRemainingComponents(List<Integer> src, TreeNode treeNode, List<Integer> used) {
        List<Integer> val = treeNode.val;
        List<Integer> res = new ArrayList<>();
        for (Integer v : src) {
            if (!val.contains(v) && !used.contains(v)) {
                res.add(v);
            }
        }
        return res;
    }

    public void traverse(TreeNode treeNode) {
        if (treeNode.nodes.isEmpty()) {
            cnt++;
            return;
        }
        for (TreeNode child : treeNode.nodes) {
            traverse(child);
        }
    }
}
