package com.Aditya.Recursion.Backtracking;

//Print all the paths where all directions are considered
//Similar Question present in PrintingMaze package but not related to backtracking
public class AllPaths {
    public static void main(String[] args){
        boolean[][] maze =  new boolean[][]{{true,true,true},
                {true,true,true},
                {true,true,true}};
        int n = maze.length;
        int[][] path = new int[n][n];
        printPaths("",maze,0,0,path,1);
    }
    //Representation of directions
    //Left -> L
    //Right -> R
    //Up -> V
    //Down -> D
    static void allPaths(String s,boolean[][] maze, int r, int c){
        //Base Condition
        if(r == maze.length-1 &&  c == maze[0].length-1){
            System.out.println(s);
            return;
        }

        //check whether the provided block is true or false. If false then return
        if(!maze[r][c]){
            return;
        }

        //if the block is not false then make it false considering that this block has been passed
        maze[r][c] = false;

        //Right
        if(c < maze[0].length-1) {
            allPaths(s + 'R', maze, r, c + 1);
        }
        //Down
        if(r < maze.length-1) {
            allPaths(s + 'D', maze, r + 1, c);
        }
        //Up
        if(r > 0){
            allPaths(s+'U',maze,r-1,c);
        }
        //Left
        if(c > 0){
            allPaths(s+'L',maze,r,c-1);
        }

        //Remove the changes that had been made to the block so that other paths could be tracked
        maze[r][c] = true;
    }

    //This is BackTracking.

    //Now print the matrix as well as the path
    static void printPaths(String s,boolean[][] maze,int r,int c,int[][]path,int step) {
        //Base Condition
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] e  : path){
                for(int x : e){
                    System.out.print(x+" ");
                }
                System.out.println();
            }
            System.out.println(s);
            System.out.println("---- ---- ---- ---- ");
            return;
        }

        //check whether the provided block is true or false. If false then return
        if (!maze[r][c]) {
            return;
        }

        //if the block is not false then make it false considering that this block has been passed
        maze[r][c] = false;
        path[r][c] = step;

        //Right
        if (c < maze[0].length - 1) {
            printPaths(s + 'R', maze, r, c + 1,path,step+1);
        }
        //Down
        if (r < maze.length - 1) {
            printPaths(s + 'D', maze, r + 1, c,path,step+1);
        }
        //Up
        if (r > 0) {
            printPaths(s + 'U', maze, r - 1, c,path,step+1);
        }
        //Left
        if (c > 0) {
            printPaths(s + 'L', maze, r, c - 1,path,step+1);
        }

        //Remove the changes that had been made to the block so that other paths could be tracked
        maze[r][c] = true;
        path[r][c] = 0;
     }
}

