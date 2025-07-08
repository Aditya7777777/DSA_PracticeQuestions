package com.Aditya.Array;

//Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
//
//
//
//Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
//
//
//Examples:
//Input: nums = [3, 5, 4, 1, 1]
//
//Output: [1, 2]
//
//Explanation: 1 appears two times in the array and 2 is missing from nums

import java.util.Arrays;

public class FindRepeatingAndMissingNumber {
    public static void main(String[] args){
      int[] nums = new int[]{1, 2, 3, 6, 7, 5, 7};
      int[] ans = new int[2];
      ans = findingNumbersBetter(nums);
      System.out.print(ans[0] +" " + ans[1]);

    }

    //Brute force solution
    static int[] findNumbers(int[] nums){
        Arrays.sort(nums);
        int[] ans = new int[2];
        int n = nums.length;
        int duplicateNum = 0;
        int missingNum = 0;
        //finding the duplicate number
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    ans[0] = nums[i];
                }
            }
        }

        //finding the missing number
        for(int i = 0;i<n;i++){
            if(  i > 0  &&  (nums[i] == nums[i-1] + 2)){
                ans[1] = nums[i]-1;
            }
        }

        return ans;
    }

    //Time complexity:O(NlogN) + O(N^2) + O(N) -> O(N^2)]
    //Space complexity:O(N)

    //Better approach
    static int[] findingNumbersBetter(int[] nums){
        int[] ans = new int[2];
        int n  = nums.length;
        int[] hashArray = new int[n+1];

        //counting the numbers present in the nums using hasArray
        for(int i = 0;i<n;i++){
            hashArray[nums[i]] = hashArray[nums[i]] + 1;
        }

        //finding the missing and repeating numbers
        for(int i = 0;i<n+1;i++){
            if(hashArray[i] == 2){
                ans[0] = i;
            }

            if(hashArray[i] == 0){
                ans[1] = i;
            }
        }

        return ans;
    }

    //Time complexity : O(N)
    //Space complexity : O(N)


}
