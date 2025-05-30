package com.Aditya.Recursion.PrintingMaze;

import java.util.ArrayList;


//Print the  path in a 3x3 matrix till the goal state
//   0  1  2
//0
//1
//2        g

//print the paths from 0,0  till 2,2
public class PrintPaths {
    public static void main(String[] args){
       boolean[][] maze =  new boolean[][]{{true,true,true},
               {true,false,true},
               {true,true,true}};

        printPathsWithObstacles("",maze,0,0);
    }
    static void printingPaths(String s, int r, int c){
        //Base Condition
        if(r == 2 &&  c == 2){
            System.out.println(s);
            return;
        }


        if(r == 2){
            printingPaths(s+'R',r,c+1);
            return;
        }

        if(c == 2){
            printingPaths(s+'D',r+1,c);
            return;
        }

        printingPaths(s+'R',r,c+1);
        printingPaths(s+'D',r+1 , c);
    }

    //save the path in the list , return the list and print it
    static ArrayList<String> printingPathsII(String s, int r, int c){
        //Base Condition
        if(r == 2 &&  c == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r == 2){
           list.addAll(printingPathsII(s+'R',r,c+1));
           return list;
        }

        if(c == 2){
            list.addAll(printingPathsII(s+'D',r+1,c));
            return list;
        }

        list.addAll(printingPathsII(s+'R',r,c+1));
        list.addAll(printingPathsII(s+'D',r+1 , c));

        return list;
    }

    //write a function that also includes diagonal paths
    //Here V-> Down, H -> Right and D -> Diagonal
    static ArrayList<String> printingPathsDiagonals(String s, int r, int c){
        //Base Condition
        if(r == 2 &&  c == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r == 2){
            list.addAll(printingPathsDiagonals(s+'H',r,c+1));
            return list;
        }

        if(c == 2){
            list.addAll(printingPathsDiagonals(s+'V',r+1,c));
            return list;
        }

        list.addAll(printingPathsDiagonals(s+'H',r,c+1));
        list.addAll(printingPathsDiagonals(s+'D',r+1,c+1));
        list.addAll(printingPathsDiagonals(s+'V',r+1 , c));

        return list;
    }

    //Print the paths if there are obstacles in a way :
    //Consider an 2-D matrix as maze . If maze[r][c] == false then it is an obstacle

    static void printPathsWithObstacles(String s, boolean[][] maze,int r,int c){
        //Base Condition
        if(r == 2 &&  c == 2){
            System.out.println(s);
            return;
        }

        if(maze[r][c] == false){
            return;
        }


        if(r == 2){
            printPathsWithObstacles(s+'R',maze,r,c+1);
            return;
        }

        if(c == 2){
            printPathsWithObstacles(s+'D',maze,r+1,c);
            return;
        }

        printPathsWithObstacles(s+'R',maze,r,c+1);
        printPathsWithObstacles(s+'D',maze,r+1 , c);

    }

}
