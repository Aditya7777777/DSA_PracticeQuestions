package com.Aditya.Recursion.Backtracking;


//The numbers in the comments written inside the function represents how the code was scripted
//if step1 is there then that is first thing that was scripted inside the code for NQueens
public class NQueens {
    public static void main(String[] args){
        int n = 4;
        boolean[][] board =  new boolean[n][n];
        System.out.println(queens(board,0));
    }

    //Step1: Declaration of the function of NQueens
    //       The following function will return the number of solution where the arrangement of the queens are possible inside a matrix
    //       The below given function prints and also displays the board.
    static int queens(boolean[][] board,int row){
    //Step2: Declaration of the base condition
        if(row == board.length){
            display(board);
            System.out.println();
            return 1; //we had returned one for count
        }

        int count = 0;

        //Step4:Placing Queen and checking for every row and col
        //for loop to iterate from Oth index to last index which is board.length-1
        for(int col = 0; col < board.length;col++){
//            Step5 : Place the Queen if it is safe
               if(isSafe(board,row,col)){
                   board[row][col] = true;
                   count += queens(board,row+1);
                   board[row][col] = false;
               }
        }

        return count;
    }

    //Step6: Making isSafe() method.
   //        This method returns boolean value to show whether it is safe to place the queen at current position or not
    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for(int i = 0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        //Diagonal left
        //maxLeft variable represents maximum times you can go left diagonally
        int maxLeft = Math.min(row,col);
        //As there is only maxLeft times you can go left therefore perform the operation
        //that is written inside the for loop for maxLeft times.
        //And the operation that is performed is to check if there is a queen
        //diagonally on the left hand side of the current queen
        //if the queen is present then return false.
        for(int i = 1;i <= maxLeft;i++){
           //When we go diagonally on the left hand side then row and col decreases
          if(board[row-i][col-i]){
              return false;
          }
        }

        //Diagonal Right
        int maxRight = Math.min(row,board.length-col-1);
        for(int i = 1;i <= maxRight;i++){
            //When we go diagonally on the right hand side then row decreases and col increases.
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    //Step3:Declaration of display function
    private static void display(boolean[][] board){
    //Step4: Using for loop to display the board and the Queens placed in them .
        for(boolean[] row : board){
            for(boolean element :  row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}

//Time Complexity : O(N!)
//Space Complexity : O(N*N)


