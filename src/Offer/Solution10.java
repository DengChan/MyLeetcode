package Offer;

import java.util.HashMap;

public class Solution10 {
    public int fib(int n) {
        int[] tmp = new int[n+1];
        tmp[0] = 0;
        tmp[1] = 1;
        tmp[2] = 1;
        for (int i=3;i<=n;i++){
            tmp[i] = (int) ((tmp[i-1]%(1e9+7) + tmp[i-2]%(1e9+7)) % (1e9+7));
        }
        return tmp[n];
    }

}
