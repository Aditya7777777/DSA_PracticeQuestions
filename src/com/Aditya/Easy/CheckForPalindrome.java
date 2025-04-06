package com.Aditya.Easy;

public class CheckForPalindrome {
    //we create a method only when we want to use a code multiple times so here the method reverse we are not going to use multiple times ,so we will
    // write the whole code inside the main method.
    public static void main(String[] args){
        String str = "madam";
        String original = str;
        String reverseString = "";
        while(str.length()>0){
            int i = str.length()-1;
            reverseString  = reverseString + str.charAt(i);
            str = str.substring(0,str.length()-1);
        }

        if(reverseString.equals(original) ){
            System.out.println("The given string is a palindrome ");
        }else {
            System.out.println("The given String is not a palindrome ");
        }
    }

//    static String reverse(String s){
//        String reverseString = "";
//        while(s.length()>0){
//            int i = s.length()-1;
//            reverseString  = reverseString + s.charAt(i);
//            s = s.substring(0,s.length()-1);
//        }
//
//        return reverseString;
//    }
}
