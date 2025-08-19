package com.Aditya.BinarySearch.BinarySearchIn2DArray;
/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
**/
public class FindAPeakElement {
    public static void main(String[] args) {
      int[][] mat = new int[][]{{4,2,1,3},
              {2,9,7,6},
              {5,3,6,2},
              {1,2,0,3},
              {4,3,1,7},
              {5,2,3,2}};

        int[] arr = findPeakGrid(mat);
        for(int e : arr){
            System.out.println(e);
        }
    }

    public static int largestNum(int[][] mat,int row,int col){
        int max = 0;
        int indx = 0;
        for(int i = 0;i<row;i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                indx = i;
            }
        }

        return indx;
    }

    public static  int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = largestNum(mat,n,mid);

            int left = mid-1 >= 0 ? mat[row][mid-1]:-1;
            int right = mid+1 < m ? mat[row][mid+1]:-1;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }else if(mat[row][mid] <  left){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return new int[]{-1,-1};
    }

}

//Time complexity : O(n*log(m))
//space complexity : O(1)
