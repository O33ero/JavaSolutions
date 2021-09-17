package com.ozzero;

import java.util.*;


public class Solution {

    public static int func(int n, int[] lst) {
        
        if (n == 0) {
            return 0;
        }

        int max = lst[n - 1];
        int delta = 0;


        for(int i = n - 1; i >= 0; i--) {
            int now = lst[i];

            if (max > (now + delta)) {
                delta += max - (now + delta);
               
                continue;
            }

            if (max < (now + delta))
                return -1;
        }

        return delta;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int lst[] = new int[n];
        for(int i = 0; i < n; i++) {
            lst[i] = s.nextInt();
        }
        s.close();

        System.out.println(func(n, lst));       
    }

}