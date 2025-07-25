package com.Aditya.Array;

public class MaxProduct {
    public static void main(String[] args){
      int[] nums = new int[]{-2,0,-1};
      int ans = maxProductOptimal(nums);

      System.out.print(ans);
    }

    //Brute force solution
    static int maxProduct(int[] nums){
        int ans = 0;
        int n = nums.length;

        for(int i = 0;i<n;i++){
            int product = nums[i];
            for(int j = i+1;j<n;j++){
                product = product * nums[j];

                if(ans < product){
                    ans = product;
                }
            }
        }
        return ans;
    }
    //Time complexity : O(N^2)
    //Space complexity : O(1)

    //Optimal solution
    static int maxProductOptimal(int[] nums){
        int prefixProduct = 1;
        int suffixProduct= 1;

        int maxi = Integer.MIN_VALUE;
        int n  = nums.length;

        for(int i = 0;i<n;i++){
            if(prefixProduct == 0) prefixProduct = 1;
            if(suffixProduct == 0) suffixProduct = 1;

            prefixProduct = prefixProduct * nums[i];
            suffixProduct = suffixProduct * nums[n-i-1];

            maxi = Math.max(maxi,Math.max(prefixProduct,suffixProduct));
        }

        return maxi;
    }

    //Time complexity : O(N)
    //Space complexity : O(1)
}
