package com.pg.programmercarl.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luojx
 * @date 2024/3/6 10:27
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        while (true) {
            while (n != 0) {
                int k = n % 10;
                res += k * k;
                n = n / 10;
            }
            if (set.contains(res)) {
                return false;
            }
            if (res == 1) {
                return true;
            }
            set.add(res);
            n = res;
            res = 0;
        }
    }
}
