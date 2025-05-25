package com.Aditya.Recursion;
import java.util.Arrays;

//The below given approach to solve the recursion problem is index based recursion 
public class ValidParenthesesUsingRecursion{
    public static void main(String[] args){

    }

    public boolean isValid(String s){
        //Start recursion from index 0
        return check(s,0) == s.length();
    }
    private int check(String s, int index){
        //Base condition
        if(index >= s.length()){
            return index;
        }
        if(s.charAt(index) == '{' || s.charAt(index) == '[' || s.charAt(index) == '(') {
            int nextIndex = check(s, index + 1);

            if(nextIndex < s.length()){
                if((s.charAt(index) == '{' && s.charAt(nextIndex) == '}') ||
                    (s.charAt(index) == '[' && s.charAt(nextIndex) == ']') ||
                    (s.charAt(index) == '(' && s.charAt(nextIndex) == ')')){
                     return check(s, nextIndex+1);
                }
            }
            //Invalid match and no closing bracket
            return -1;
        }else if(s.charAt(index) == '}' || s.charAt(index) == ']' || s.charAt(index) == ')'){
            return index;
        }

        return -1;
    }



}
