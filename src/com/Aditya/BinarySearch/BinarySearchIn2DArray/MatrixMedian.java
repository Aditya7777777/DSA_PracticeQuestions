package com.Aditya.BinarySearch.BinarySearchIn2DArray;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,7,9,11},
                {2,3,4,5,10},
                {9,10,12,14,16}};

        int ans = median(matrix,matrix[0].length,matrix.length);
        System.out.println(ans);
    }



    static int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        //finding the highest and the lowest element inside the matrix
        for(int i = 0;i< n;i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][m-1]);
        }

        int req = (n*m)/2;
        //performing Binary search form range low to high
        while(low <= high){
            int mid = low + (high - low)/2;
            int smallerAndEqualThanMid = countOfNumbers(matrix,mid);
            if(smallerAndEqualThanMid <= req){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }

        return low;
    }

    static int countOfNumbers(int[][] matrix,int x){
        int count = 0;
        //traversing row wise to calculate no of elements less than upperBound
        for(int i = 0;i<matrix.length;i++){
            count+= upperBound(matrix,x,i);
        }
        return count;
    }

    static int upperBound(int[][] matrix,int num,int row) {
        //Finding number which is just greater than mid.
        int low = 0;
        int high = matrix[0].length - 1;

        int ans = matrix[0].length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[row][mid] > num) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}


//Time complexity : O(log(10^9)) for median function
//                  n * log(m) for both upperBound and countOfNumbers function
//Total time complexity : O(log(10^9)) * n * log(m)