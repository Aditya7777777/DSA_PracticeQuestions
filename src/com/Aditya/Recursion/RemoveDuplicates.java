package com.Aditya.Recursion;

public class RemoveDuplicates {
    public static void main(String[] args){
        String s = "Geeks For Geeks is average";
        System.out.println(removeDuplicatesRecursion(s,0));

    }
    //This is not an efficient solution It takes O(N^2) time complexity.
    static String removeDuplicates(String s){
       for(int i = 0;i<s.length();i++){
           for(int j = i+1 ;j < s.length();j++){
               if(s.charAt(i) != s.charAt(j)){
                   s = s.substring(0,i+1) + s.substring(j,s.length());
                   break;
               }else if(i!=j && j == s.length()-1){
                   s = s.substring(0,i+1);
               }
           }
       }
       return s;
    }

    //writing a method using recursion.
    //Recursion is programming technique where the function call itself again and again
    //In order to use the recursive approach to this problem first we have to divide the problem in smaller sub-problems
    //so here the sub-problem is that we when we find a character with duplicates we have to replace all of them with one of them
    //and then the remaining duplicates will be solved by the rest of the function calls
    static String removeDuplicatesRecursion(String s,int i){
        if(i == s.length()){
            return s;
        }
        int j = i+1;
        while(j < s.length()) {
            if(s.charAt(i) != s.charAt(j)){
                s = s.substring(0,i+1) + s.substring(j,s.length());
                break;
            }else if(i!=j && j == s.length()-1){
                s = s.substring(0,i+1);
            }
            j++;
        }
        return removeDuplicatesRecursion(s,i+1);
    }

   //Solving the sum using Sliding window technique.


    }



