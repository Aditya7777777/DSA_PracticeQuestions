package com.Aditya.Array;

import java.util.HashMap;
import java.util.Map;

//This Question is similar to longest SubArray
public class LargestSubArrayWithSumZero {
    public static void main(String[] args){
       int[] nums = new int[]{6, -2, 2, -8, 1, 7, 4, -10};
        int n = largestSubArrayOptimal(nums);

        System.out.println(n);
    }

    //Optimal Solution is Hashing
    //If the solution contains negatives and zeros then the Hashing is the optimal otherwise we can use pointers method
    static int largestSubArrayOptimal(int[] nums){
       int n = nums.length;
       int sum = 0;
       int length = 0;
       int res = 0;

        Map<Integer,Integer>  map = new HashMap<>();
       for(int i = 0;i<n;i++){
          sum = sum + nums[i];

          if(sum == 0){
              res = i+1;
          }

          if(map.containsKey(sum)){
              length = i - map.get(sum);
              if(res < length){
                  res = length;
              }
          }

           if(!map.containsKey(sum)){
               map.put(sum,i);
           }

       }

       return res;
    }

    //Time complexity : O(N)(average case) O(N^2) (worst case : when collision occurs)
    //Space complexity : O(N)
}
