package com.Aditya.Array;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args){
       int[] nums = new int[]{1,2,3,-3,1,1,1,4,2,-3};
       int ans = subarraySumOptimal(nums,3);
       System.out.println(ans);
    }

    //Brute force solution
    static int subarraySum(int[] arr,int k){
        int sum = 0;
        int max = 0;

        for(int i = 0;i<arr.length;i++ ){
            for(int j = i;j<arr.length;j++){
                sum = sum + arr[j];
                if(sum == k){
                    max++;
                }
            }
            sum = 0;
        }

        return max;
    }

    //Time Complexity : O(N^2)
    //Space Complexity: O(1)

    //Optimal Solution
    //This solution is similar to the solution of  Longest Sub-Array with sum  == k
    //Here just two changes are made
    //1. instead of adding prefixSum and Index inside the Hash map we will store prefixSum and Count
    //2. key-value 0,1 will already be added inside the HashMap
    static int subarraySumOptimal(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        map.put(0,1);
        for(int i = 0;i<arr.length;i++){
            prefixSum = prefixSum+arr[i];

            if(map.containsKey(prefixSum-k)){
                count = count+map.get(prefixSum-k);
            }

            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, 1);
            }else{
                map.put(prefixSum,map.get(prefixSum)+1);
            }
        }

        return count;
    }
//    Time complexity : O(NlogN) if it is an ordered map
//    if it is an unordered map then the time complexity is O(N)
//    if collision happens then the time complexity becomes O(N^2)

//    Space Complexity :O(N)

//    Suppose if the array only contains positives and nonzero elements then the answer will be

}
