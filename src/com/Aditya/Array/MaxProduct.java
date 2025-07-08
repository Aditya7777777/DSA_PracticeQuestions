package com.Aditya.Array;

public class MaxProduct {
    public static void main(String[] args){
      int[] nums = new int[]{-2,0,-1};
      int ans = maxProduct(nums);

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
}
