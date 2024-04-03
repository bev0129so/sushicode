package com.pg.programmercarl.hashmap;

/**
 * @author luojx
 * @date 2024/3/6 10:12
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for (char c : s.toCharArray()) {
            sc[c-'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            tc[c-'a'] += 1;
        }
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
