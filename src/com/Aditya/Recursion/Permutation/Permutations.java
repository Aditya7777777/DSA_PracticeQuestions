package com.Aditya.Recursion.Permutation;

import java.util.ArrayList;
import java.util.List;

//Print all the permutations of String "abc" using recursion
//The nature of the method while calculating permutation is variable function call
public class Permutations {
    public static void main(String[] args){
        List<String> list  = permutationsList("","abc");
        for(String s : list){
            System.out.print(s + " ");
        }
    }
    //This method just print all the permutation
    static void permutations(String p,String up){
        //Base condition
        //As per the recursion tree when the unprocessed becomes "" then return
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        //The number of function call depends on the processed string
        //First function call calls one fx^n call  and processed String length is 0 .
        //Second function call calls two fx^n call  and processed String length is 1 .
        //Third function call calls three fx^n call  and processed String length is 2 .
        //Hence , the for loop will run for processedString.length() + 1.

        char ch = up.charAt(0);
        for(int i = 0;i<= p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }
    //Time Complexity

    //Method that return ArrayList containing the permutations
    static List<String> permutationsList(String p,String up){
        //Base condition
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }


        List<String> list = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i = 0;i<= p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            list.addAll(permutationsList(f+ch+s, up.substring(1)));
        }

        return list;
    }

}

//NOTE: substring() method in java takes O(N) time complexity . As strings are immutable in java therefore whenever an operation
//        is performed on string a new string gets created as string are immutable in java.So, the current string is copied to
//        new string and returned.
