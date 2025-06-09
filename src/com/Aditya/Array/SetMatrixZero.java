package com.Aditya.Array;

public class SetMatrixZero {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,1,1,1},
                {1,0,1,1},
                {1,1,0,1},
                {0,1,1,1}};

        setZeroesOptimal(matrix);
        for(int[] element : matrix){
            for(int e : element){
                System.out.print(e +" ");
            }
            System.out.println();
        }
    }
    //Brute Force Solution
    static void setZeroes(int[][] matrix){
        //making the rows and column to -1 wherever we find zero
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows(matrix,i);
                    cols(matrix,j);
                }
            }
        }

        //Replacing -1 with zero
         for(int i = 0;i<matrix.length;i++){
                    for(int j = 0;j<matrix[0].length;j++){
                        if(matrix[i][j] == -1){
                            matrix[i][j] = 0;
                        }
                    }
         }
    }

    static void rows(int[][] matrix,int i){
        for(int j = 0;j<matrix[0].length;j++){
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }

    static void cols(int[][] matrix,int j){
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }

    //Time Complexity :O(NxM)XO(N+M) + O(N+M) = O(N+Mx(NxM)) which is around O(N^3)
    //Space complexity : O(1)

    //Better Solution
    static void setZeroesBetter(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        //Marking rows and col with the help of arrays
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        //Making respective rows and cols to zero
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
    //Time complexity : O(NxM)
    //SpaceComplexity :O(N + M)

    static void setZeroesOptimal(int[][] matrix){
        int col1 = 1;
        int n = matrix.length;
        int m = matrix[0].length;

        //marking of rows and columns
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    if(j == 0){
                        col1 = 0;
                    }else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }

       //Traversing through the first column and making corresponding columns to zero
        for(int j = 1;j<m;j++){
            if(matrix[0][j] == 0){
                colsOptimal(matrix,j);
            }
        }

        //Traversing through the first column and making corresponding rows to zero
        for(int i = 0;i < n;i++){
            if(matrix[i][0] == 0){
                rowsOptimal(matrix,i);
            }
        }

        //if cols1 = 0 which represents the first column then make the first column to zero
        if(col1 == 0){
            for(int i = 0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
    }

    static void rowsOptimal(int[][] matrix,int i){
        for(int j = 0;j<matrix[0].length;j++){
          matrix[i][j] = 0;
        }
    }

    static void colsOptimal(int[][] matrix,int j){
        for(int i = 0;i<matrix.length;i++){
                matrix[i][j] = 0;
        }
    }
    //Optimal Time and Space Complexity
    //Time complexity : O(3 * (N*M))
    //Space Complexity : O(1)
}
