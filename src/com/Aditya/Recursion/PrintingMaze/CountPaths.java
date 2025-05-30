package com.Aditya.Recursion.PrintingMaze;

//Count the number of path in a 3x3 matrix till the goal state
//   0  1  2
//0
//1
//2        g

//count the paths from 0,0  till 2,2
public class CountPaths {
    public static void main(String[] args){
        int ans = count(0,0);
        System.out.print(ans);
    }
    static int count(int r, int c){
        if(r == 2 || c == 2){
            return 1;
        }

        int x = count(r+1,c);
        int y = count(r,c+1);

        return x+y;

    }
}
