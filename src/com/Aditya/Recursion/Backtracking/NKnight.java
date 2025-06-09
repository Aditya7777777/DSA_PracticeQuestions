package com.Aditya.Recursion.Backtracking;

public class NKnight {
    public static void main(String[] args){
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board,0,0,n);
    }

    //Step 1: Creating a method
    static void knight(boolean[][] board,int row,int col,int knights){

        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }

        if(row == board.length-1 && col == board.length){
            return;
        }

        //if you reach at the end of the col try for next line
        if(col == board.length){
            knight(board,row+1,0,knights);
            return;
        }

        //checking whether it is safe to place the knight at the current position
        if(isSafe(board,row,col)){
            board[row][col] = true;
            knight(board,row,col+1,knights-1);
            board[row][col] = false;
        }

        //if it is not safe then increment the col
        knight(board,row,col+1,knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
       if(isValid(board,row-2,col-1)){
               if(board[row-2][col-1]){
                   return false;
               }
       }

        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                    return false;
            }
        }

        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                    return false;
            }
        }

        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                    return false;
            }
        }

        return true;
    }

    //do not repeat yourself , hence created this function
    //isValid method checks while checking the isSafe condition whether the row or the column
    //remains under the bounds
    static boolean isValid(boolean[][] board, int row,int col){
        if(row >= 0 && row < board.length && col >= 0 && col<board.length){
            return true;
        }

        return false;
    }

    //Step 2: Creating Display method
    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element :  row){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
