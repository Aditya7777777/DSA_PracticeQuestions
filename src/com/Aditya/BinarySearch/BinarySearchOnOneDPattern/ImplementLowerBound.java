package com.Aditya.BinarySearch.BinarySearchOnOneDPattern;


//Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

//Example 1:
//Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
//Result: 1
//Explanation: Index 1 is the smallest index such that arr[1] >= x.


public class ImplementLowerBound {
    public static void main(String[] args){
        int[] nums = new int[]{3,5,8,15,19};
        int ans = lowerBound(nums,5,9);
        System.out.println(ans);
    }

    static int lowerBound(int[] arr,int n,int x){
        int low = 0;
        int high = n-1;
        int ans = 0;

        while(low < high){
            int mid = low + (high-low)/2;

            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

}


//Time complexity: O(logN)
//Space complexity : O(1)
