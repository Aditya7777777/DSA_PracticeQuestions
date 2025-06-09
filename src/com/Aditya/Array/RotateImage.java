package com.Aditya.Array;

public class RotateImage {
    public static void main(String[] args){
      int[][] matrix = new int[][]{{1,2,3},
              {4,5,6},
              {7,8,9}};


      rotateOptimal(matrix);
      print(matrix);
    }

    //Brute Force Solution
    static void rotate(int[][] matrix){
      int n = matrix.length;
      int[][] temp = new int[n][n];
      //copying the elements from the input matrix to temporary matrix at their respective places
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                temp[j][n-1-i] = matrix[i][j];
            }
        }

        //copy all the elements of the temporary matrix to original matrix
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }

    static void print(int[][] matrix){
        for(int[] element : matrix){
            for(int e : element){
                System.out.print(e + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

//    TimeComplexity : O(N*M)
//    Space Complexity : O(N*M)

    //Optimal Solution
    static void rotateOptimal(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i<matrix.length;i++){
            for(int j = i;j < matrix[0].length;j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int i = 0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }


    static void reverse(int[] arr){
        int n = arr.length;
        if(n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n-i-1];
                arr[n-i-1] = temp;
            }
        }else{
            for (int i = 0; i <= n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n-i-1];
                arr[n-i-1] = temp;
            }
        }
    }

    //Time Complexity : O(N*M)
    //Space Complexity : O(1)


}
