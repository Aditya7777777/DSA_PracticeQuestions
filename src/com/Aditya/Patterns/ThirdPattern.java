package com.Aditya.Patterns;

/*

 *****
 ****
 ***
 **
 *

 */

public class ThirdPattern {
    public static void main(String[] args){
        /* Above pattern is  just the reverse of the Second pattern. Here the outer for loop will run  5
        times but in this case the pattern is upside down of the Second pattern , so in the first row
        5 stars will get printed , then 4 stars will get printed in the second row , and so on .

        If we observe the outer for loop then the value of i is initialized to 5 and gets decremented  by 1 for each
        subsequent rows . So, even by running the outer for loop in reverse manner the number of iterations will be the same
        which indicates the number of rows, then one question may  arise  why we have run the for loop in reverse manner.

        The answer is that we want to use the value variable i to run the inner for loop.
        when i = 5 the inner for loop runs 5 times
        when i = 4 then inner for loop runs 4 times
        ... & so on.
         That's how we wanted the inner for loop should iterate , so that it can print the stars according to the pattern .
        */

        for(int i = 5 ; i > 0;i--){
            for(int j = 0 ; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
