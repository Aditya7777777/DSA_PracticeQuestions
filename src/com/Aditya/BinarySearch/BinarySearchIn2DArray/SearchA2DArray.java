package com.Aditya.BinarySearch.BinarySearchIn2DArray;

/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
* */
public class SearchA2DArray {
    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,3,5,7},
               {10,11,16,20},
               {23,30,34,60}};

        System.out.println(searchMatrixOptimal(matrix,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
       int i  = 0;
       int j = matrix[0].length-1;

       while(i < matrix.length && j >= 0){
           if(matrix[i][j] == target){
               return true;
           }else if(matrix[i][j] > target){
               j--;
           }else{
               i++;
           }
       }

       return false;
    }
    //Time complexity : O(m*n)

    public static boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m;

        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return false;
    }

    //Time complexity : O(log(m*n))


}
