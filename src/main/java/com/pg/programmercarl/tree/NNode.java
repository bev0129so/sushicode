package com.pg.programmercarl.tree;

import java.util.List;

/**
 * @author luojx
 * @date 2024/4/3 9:24
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }

    public int maxDepth(NNode root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int depth = 0;
        for (NNode child : root.children) {
            int cdepth = maxDepth(child);
            depth = Math.max(depth, cdepth);
        }
        return 1 + depth;
    }
}
