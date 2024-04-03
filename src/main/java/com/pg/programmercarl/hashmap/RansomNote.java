package com.pg.programmercarl.hashmap;

/**
 * @author luojx
 * @date 2024/3/6 11:16
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occur = new int[26];
        for (char c : magazine.toCharArray()) {
            occur[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (occur[c - 'a'] <= 0) {
                return false;
            }
            occur[c - 'a']--;
        }
        return true;
    }
}
