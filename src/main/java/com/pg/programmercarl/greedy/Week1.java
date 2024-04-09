package com.pg.programmercarl.greedy;

import java.util.Arrays;

public class Week1 {

    /**
     * @param g
     * @param s
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cd = 0;
        for (int i = s.length - 1, j = g.length - 1; i >= 0 && j >= 0;) {
            if (s[i] >= g[j]) {
                cd++;
                j--;
                i--;
            } else {
                j--;
            }
        }
        return cd;
    }
}
