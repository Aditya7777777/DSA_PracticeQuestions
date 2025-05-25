package com.Aditya.Array;
import java.util.HashMap;

public class LongestSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,1,1,1,3,3};
        int k = 6;
        int ans = optimalSolution(arr,k);
        System.out.print(ans);


    }
    //Brute force approach
    static int BruteForce(int[] arr,int k){
        int sum = 0;
        int max = 0;
        int count = 0;

        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                sum = sum + arr[j];
                max++;
                if(sum == k){
                    sum = 0;
                    if(count < max){
                        count = max;
                    }
                    max = 0;
                }

                if(sum > k){
                    sum = 0;
                    max = 0;
                }
            }
            sum = 0;
            max = 0;
        }

        return count;
    }

    //Better approach using Hashing
    //This solution is  optimal when the array contains zeros and negative , but in other cases it is not an optimal solution
    static int betterSolution(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int length = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            //if there is  initial sub-array which sum ups to k.
            if(sum == k){
                length = i+1;
            }

            //is there any element in HashMap equal to sum-k
            if(map.containsKey(sum-k)){
                int x  = i - map.get(sum-k);
                if(x > length){
                    length = x;
                }
            }
            //we write the condition before we put the sum and the index , for the cases when the array contains zeroes and negatives
            // when the array contains zeroes and negatives then there are the chances that the same sum value get added twice
            //and in java when the same key is added twice then copy of key is not created the same key is updated with new value .
            //What will happen because of this is that the longest sub array will not get created if we add same key with different value
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return length;

    }
    //Time complexity : O(n^2)
    //Space complexity : O(n)

    //Optimal solution
    static int optimalSolution(int[] nums, int k){
        int sum  = 0;
        int j = 0;
        int maxLength = 0;

        for(int i = 0;i<nums.length;i++){
            //we add the elements
            sum = sum + nums[i];


            while(sum > k){
                sum = sum -  nums[j];
                j++;
            }

            if(sum == k){
                int x = i-j+1;
                if(x > maxLength) {
                    maxLength = x;
                }
            }
        }

        return maxLength;
    }
    //Time complexity : O(n)
    //Space complexity: O(1)

}

