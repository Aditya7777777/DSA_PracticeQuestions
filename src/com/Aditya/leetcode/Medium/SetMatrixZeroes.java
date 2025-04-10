package com.Aditya.leetcode.Medium;
import java.util.List;
import java.util.ArrayList;

public class SetMatrixZeroes{
    public static void main(String[] args){
        int[][] matrix = new int[][]{{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        setZeroes(matrix);

        for(int i = 0;i<matrix.length;i++){
            for(int j  = 0 ;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }//main method

    //Brute force solution
    static void setZeroesBrute(int[][] matrix){
        //traversing through the matrix to find the positionn where
        //zeroes lies and storing inside the list
        List<int[]> list = new ArrayList<>();

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    int[] arr = new int[2];
                    arr[0] = i;arr[1] = j;
                    list.add(arr);
                }//if statement
            }//inner for loop
        }//outer for loop
        if(list.size() == 0){
            return;
        }else{
            //making the rows and column zero
            for(int[] arr : list){
                //making col zero
                for(int i = 0;i<matrix.length;i++){
                    matrix[i][arr[1]] = 0;
                }//column for loop

                //making rows zero
                for(int j = 0;j<matrix[0].length;j++){
                    matrix[arr[0]][j] = 0;
                }//row for loop
            }//for-each loop
        }
    }//end of method setZeroes

    //for Brute force the time complexity is : O(n*m) and Space complexity is : O(k)

    //this particular solution is not the optimal solution it's an intermediate solution.
    static void setZeroes(int[][] matrix){
        int[] row  = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        //to find the indices where the value is zero
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }//end of if
            }//inner for loop
        }//end of outer for loop

        //making rows and cols to zero
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0;j< matrix[0].length;j++){
                if(row[i] == 1 || col[j] == 1 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }//end of method setZeroes
    //for intermediate solution the time complexity is : O(m*n)
    //Space complexity is : O(m) + O(n) = O(m+n).

    //in order to make the solution in-place we have to code the solution in such a way that  the space complexity is O(1)
    //this can be achieved when we approach the solution by try to make changes inside the matrix itself rather than declaring
    //another datatype.
    //NOTE : To make the solution optimal try code first the solution for brute force approach. Then find the drawbacks of that solutions,
    // then try to optimize the code .Generally the drawbacks can be high space or time complexity.
}//end of public class
