package com.Aditya.BinarySearch.FindingTheMaxOfMinAndMinOfMaxPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PaintersPartition {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 5, 5, 5));
        int k  = 2;

        int ans = countPaintersOptimal(list,k);
        System.out.println(ans);
    }
    //Brute force solution
    public static int countPainters(ArrayList<Integer> boards, int m){
     int low = Collections.max(boards);
     int high = sum(boards);

     for(int i = low;i<= high;i++){
         if(noOfPainters(boards,i) > m){
             continue;
         }else{
             return i;
         }
     }

     return -1;
    }

    //Time complexity : O(log(sum - maxELe) * N)
    //Space complexity : O(1)

    static int noOfPainters(ArrayList<Integer> list, int time){
        int noOfPainters = 1;
        int sum = 0;
        for(int i = 0;i<list.size();i++){
            sum = sum + list.get(i);
            if(sum > time){
                noOfPainters++;
                sum = list.get(i);
            }
        }

        return noOfPainters;
    }

    static int sum(ArrayList<Integer> list){
        int sum = 0;
        for(int i = 0;i<list.size();i++){
            sum = sum + list.get(i);
        }
        return sum;
    }

    //Optimal Solution
    public static int countPaintersOptimal(ArrayList<Integer> boards, int m) {
        int low = Collections.max(boards);
        int high = sum(boards);
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (noOfPainters(boards, mid) <= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

}
