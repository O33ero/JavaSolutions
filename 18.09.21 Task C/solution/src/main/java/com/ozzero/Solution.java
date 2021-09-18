package com.ozzero;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Solution 
{
    public static void main( String[] args )
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        MyClass[] arr = new MyClass[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new MyClass(s.nextInt(), i);
        }
        s.close();


        int[] result = dist(n, k, arr);


        for(int now : result) {
            System.out.print(now + " ");
        }
    }

    public static int[] dist(int n, int k, MyClass[] arr) {
        // MyClass[] sortedArr = new MyClass[n]; 
        // arr.toArray(sortedArr);
        Arrays.sort(arr, new MyComparator());

        // Collections.sort(arr, new MyComparator());

        int index = -1;
        int nowValue = -1;
        int result[] = new int[n];

        for(int i = 0; i < n; i++){
            nowValue = arr[i].value;
            index = arr[i].index;
             
            int deltaL = 1;
            int deltaR = 1;
            for(int j = 0; j < k; j++) {

                if (i - deltaL < 0) {
                    result[index] += arr[i + deltaR].value - nowValue;
                    deltaR++;
                    continue;
                }
                if (i + deltaR > n - 1) {
                    result[index] += nowValue - arr[i - deltaL].value;
                    deltaL++;
                    continue;
                }

                if ((nowValue - arr[i - deltaL].value <= arr[i + deltaR].value - nowValue)) {
                    result[index] += nowValue - arr[i - deltaL].value;
                    deltaL++;
                }
                else {
                    result[index] += arr[i + deltaR].value - nowValue;
                    deltaR++;
                }
            }
            
        }

        return result;
    }

    static class MyComparator implements Comparator<MyClass>{
        @Override
        public int compare(MyClass o1, MyClass o2) {
            if (o1.value == o2.value)
                return 0;
            else if (o1.value > o2.value)
                return 1;
            else 
                return -1;
        }
    }

    static class MyClass {
        int value = 0;
        int index = 0;
        MyClass(int v, int i) {
            value = v;
            index = i;
        }
    }
}

