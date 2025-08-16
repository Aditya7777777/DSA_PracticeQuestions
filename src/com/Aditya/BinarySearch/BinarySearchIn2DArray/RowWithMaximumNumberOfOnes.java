package com.Aditya.BinarySearch.BinarySearchIn2DArray;


import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
Your task is to find the index of the row with the maximum number of ones.
Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.


Example 1:
Input Format: n = 3, m = 3,
mat[] =
1 1 1
0 0 1
0 0 0
Result: 0
Explanation: The row with the maximum number of ones is 0 (0 - indexed).

Example 2:
Input Format: n = 2, m = 2 ,
mat[] =
0 0
0 0
Result: -1
Explanation:  The matrix does not contain any 1. So, -1 is the answer.
*/
public class RowWithMaximumNumberOfOnes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0,0)));
        list.add(new ArrayList<>(Arrays.asList(0,0)));
        int ans = rowWithMax1s(list,2,2);
        System.out.println(ans);
    }

    //Optimal Solution
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int indx = n;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr.get(mid)  >= x){
                indx = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return indx;
    }
    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int count_max = 0;
        int indx = -1;

        for(int i = 0;i<n;i++) {
            int lowIndx = lowerBound(matrix.get(i),m, 1);
            int count = m - lowIndx ;
            if (count > count_max) {
                count_max = count;
                indx = i;
            }
        }

        return indx;
    }

    //Time complexity : O(n log(m))
    //space complexity : O(1)
    }
