package com.Aditya.Array;


//Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

//Example 1:
//Input Format: A = [4, 2, 2, 6, 4] , k = 6
//Result: 4
//Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]


import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArrayWithGivenXork {
    public static void main(String[] args){
        int[] nums = new int[]{5, 6, 7, 8, 9};
        int ans = subArrayWithXorKOptimal(nums,5);
        System.out.println(ans);

    }

    //Brute force solution
    static int  subArrayWithXorK(int[] nums,int k){
        int n = nums.length;
        int count = 0;

        for(int i = 0;i<n;i++){
            int resXor = 0;
            for(int j = i;j<n;j++){
                resXor = resXor ^ nums[j];

                if(resXor == k){
                    count++;
                }
            }
        }

        return count;
    }

    //Time complexity : O(N^2)
    //Space Complexity : O(1)

    //Optimal Solution
    static int subArrayWithXorKOptimal(int[] nums,int k){
        int n = nums.length;
        int resXor = 0;
        int count = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            resXor = resXor ^ nums[i];

            if(resXor == k){
                count++;
            }

            if(map.containsKey(resXor^k)){
                count = count + map.get(resXor^k);
            }

            if(!map.containsKey(resXor)){
                map.put(resXor,1);
            }else{
                map.put(resXor,map.get(resXor)+1);
            }
        }

        return count;
    }
    //Time complexity : O(N) , O(N^2)(worst case)
    //Space complexity: O(N)
}
