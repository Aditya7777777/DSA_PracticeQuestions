package com.Aditya.Patterns;

/*

 *
 **
 ***
 ****
 *****

*/
public class SecondPattern {
    public static void main(String[] args){

        //About the inner for loop
        /*
         If we observe the above pattern  at line one there is only one star , then at line two there are two stars
         and  if we observe the subsequent lines then we can see that the i^th row has 'i' number of stars . According
         to this observation the condition of the inner for j<i is set .
         when  i = 1 then the inner for loop will run  1 time
         when i = 2 then the inner for loop will 2 times
         ... & so on .
        */
        for(int i = 1 ; i <= 5;i++){
            for(int j = 0 ; j < i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
