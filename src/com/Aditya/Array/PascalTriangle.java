package com.Aditya.Array;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


/*
    For Pascal triangle there can be three types of problems
    1.Find the element in the pascal triangle at the Rth row and at the Cth position
    2.Print a particular row of the Pascal triangle
    3. Print the Pascal Triangle.
    * */

public class PascalTriangle {
    public static void main(String[] args){

    }



   //Leetcode solution
    static List<List<Integer>> generate( int numRows){
            List<List<Integer>> list = new ArrayList<>();
            return helper(list,0, numRows);
    }

    static List<List<Integer>> helper(List<List<Integer>>list,int n,int numRows){
        if(n == numRows){
            return list;
        }

        if(n == 0){
            list.add(new ArrayList<>(){{ add(1);}});
            return helper(list,n+1,numRows);
        }

        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = list.get(n-1);
        list2.add(1);
        for(int i = 0;i< list.get(n-1).size()-1;i++){
            int sum = list3.get(i)+list3.get(i+1);
            list2.add(sum);
        }
        list2.add(1);

        list.add(list2);
        return helper(list,n+1,numRows);
    }

    //Code for first Problem where we find the element at the Rth row and at the Cth position
    //Solution is simple nCr
    //NOTE : you will get the solution only when you pass R-1 and C-1 to the nCr function.


    static long nCr(int r,int c){
        long res = 1;
        for(int i = 0; i<c ; i++){
            res = res*(r - i);
            res = res/(i+1);
        }
        return res;
    }

    //Time complexity : O(C);
    //Space complexity:O(1);

    //To print a particular row
    static void printRow(int n){
        for(int i = 0;i<n;i++){
            System.out.print(nCr(n-1,i) + " ");
        }
    }




}
