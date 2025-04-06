package com.Aditya.Patterns;

/*
 *****
 *****
 *****
 *****
 *****
*/
public class FirstPattern {
    public static void main(String[] args){
        //We are not using or creating a method because a method is created when we want to reuse certain lines of code
        //that perform a particular function. Here in this code we are not going to print the above given pattern again and again
        // So, we will just write the code of the pattern inside the main method.

        for(int i = 0 ; i<5;i++){
            for(int j = 0 ; j<4;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
