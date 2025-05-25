package com.Aditya.Array;
import java.util.ArrayList;
import java.util.Collections;

public class LeaderInAnArray {
    public static void main(String[] args){
        int[] nums = new int[]{10,22,12,3,0,6};
        ArrayList<Integer> list = leadersOptimized(nums);
        for(int e : list){
            System.out.print(e + " ");
        }

        System.out.println();
        //Reverse of list
        Collections.reverse(list);
        for(int e : list){
            System.out.print(e + " ");
        }

    }

    //Brute force solution
    static  ArrayList<Integer> leaders(int[] nums) {
      int check = 0;
      int n = nums.length;
      ArrayList<Integer> list = new ArrayList<>();
      for(int i = 0;i < n;i++){
          for(int j = i+1 ; j<n ; j++){
              if(nums[i] < nums[j]){
                  break;
              }
              check = j;
          }

          if(check == n-1){
              list.add(nums[i]);
          }
      }
      list.add(nums[n-1]);

      return list;
    }
    //Time Complexity : O(N^2)
    //Space Complexity : O(N)

    //Optimized solution
    static ArrayList<Integer> leadersOptimized(int[] nums){
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = n-1 ; i > 0;i--) {
            if (nums[i] > maxi) {
              //nums[i] is a leader
                list.add(nums[i]);
                maxi = nums[i];
            }
        }

        return list;
    }
    //Time Complexity:O(N)
    //Space Complexity:O(N) --> To store the elements
}
