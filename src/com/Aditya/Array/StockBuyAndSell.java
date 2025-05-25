package com.Aditya.Array;

public class StockBuyAndSell {
    //This is done by using dynamic programming
    public static void main(String[] args){
      int[] prices = new int[]{7,1,5,3,6,4};
      int ans = maxProfit(prices);
      System.out.println(ans);

    }

    //Brute force Solution
    static int maxProfit(int[] prices){
        int max = 0;

        for(int i = 0;i<prices.length;i++){
            for(int j = i+1;j<prices.length;j++){
                int diff = prices[j] - prices[i];
                max = Math.max(diff,max);
            }
        }

        return max;
    }

    //Time Complexity : O(N^2)
    //Space Complexity:O(1)

    //optimized Solution using Dynamic Programming
    static int maxProfitOptimized(int[] prices){
        int min = prices[0];
        int profit = 0;

        for(int i = 1;i<prices.length;i++){
            int cost = prices[i] - min;
            profit = Math.max(cost,profit);
            min = Math.min(prices[i],min);
        }

        return profit;
    }

    //Time Complexity : O(N)
    //Space complexity : O(1)
}
