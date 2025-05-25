package com.Aditya.Array;

public class MaximumSubArrayUsingKandanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
      maxSubArrayPrint(arr);
    }
    //Brute force Solution
    static int maxSubArray(int[] nums) {
        int ans = 0;
        int sum  = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum > ans){
                    ans = sum;
                }
            }
            sum = 0;
        }

        return ans;
    }

    //Optimize Solution
    static int maxSubUsingKadaneAlgorithm(int[] arr){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum > maxi){
                maxi = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }

        return maxi;
    }

    //If the interviewer says to print the sub-array along with the maximum sum
    static void maxSubArrayPrint(int[] nums){
        int maxi = Integer.MIN_VALUE;
        int sum  = 0;
        int start = 0;
        int end = 0;

        for(int i  = 0;i < nums.length;i++){
            sum = sum + nums[i];

            if(sum > maxi){
                maxi = sum;
                end = i;
            }

            if(sum < 0){
                sum = 0;
            }

            if(sum == 0){
                start = i+1;
            }
        }

        for(int i = start;i<end+1;i++){
            System.out.print(nums[i]+" ");
        }


    }
}


