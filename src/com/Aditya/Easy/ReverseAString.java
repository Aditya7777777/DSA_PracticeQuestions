package com.Aditya.Easy;

public class ReverseAString {
    public static void main(String[] args){
        String s = "Anna";
        String reverseString = "";
        while(s.length() > 0){
            int i =  s.length();
            reverseString = reverseString + s.charAt(i-1);
            s = s.substring(0,s.length()-1);
        }
        System.out.println(reverseString);
    }
}
