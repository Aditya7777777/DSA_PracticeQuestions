package com.Aditya.leetcode.Medium;

/*
Question :
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

/*
NOTE : the line in the question : The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
it means that ***Generally in the coding interviews or real-world problems, multiplying large numbers could exceed the integer limit--causing overflow***
But, here the problem guarantees that this problem will not occur.
You can safely multiply numbers without checking the overflow.
No, need to use long Big Integer, or special tricks to handle large numbers.
Just focus on solving the logic of the question.

 */

//learning: if we declare an array like this int[] arr = {1,2,3,4,5}; for this type fo declaration an object is formed,the object formation is done internally


public class ProductExceptSelf {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,4,5};
        for(int e : productExceptSelfOptimal(nums)){
            System.out.print(e + " " );
        }

    }

    //Brute force solution :
    static  int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int n = 1;
        for(int i = 0 ;i < nums.length;i++){
            for(int j = 0 ; j < nums.length;j++){
                if(j != i){
                    n = n*nums[j];
                }
            }

            answer[i] = n;
            n = 1;
        }

        return answer;
    }

    //intermediate solution
    static int[] productExceptSelfIntermediate(int[] nums){
        int n = nums.length;
        int[] left  = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[right.length-1] = 1;

        //storing prefix
        for(int i = 1;i<left.length;i++){
            left[i] = nums[i-1] * left[i-1];
        }//end of for loop

        //storing suffix
        for(int j = right.length-2;j>=0;j--){
            right[j] = nums[j+1] * right[j+1];
        }//end of for loop

        //multiplying the respective indices  elements of left and right
        int[] answer = new int[n];
        for(int i = 0;i<n;i++){
            answer[i] = left[i] * right[i];
        }//end of for loop

        return answer;
    }
    /*
      intermediate code
       Time Complexity: 3 * O(n) = O(n)
       Space complexity is : 3 * O(n) = O(n)
    */

    /*
    Optimal Solution :
       the optimal solution will be without declaring left and right array we can directly make changes to the answer array
    */

    //Optimal Solution code :
    //Optimal Solution
    static int[] productExceptSelfOptimal(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;


        //for loop for prefix
        for(int i = 1;i<n;i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        for(int j = n-2;j>=0;j--){
             answer[j] = answer[j] * nums[j+1];
             nums[j] = nums[j] * nums[j+1];
        }
        return answer;
    }//end of productOptimal


}
