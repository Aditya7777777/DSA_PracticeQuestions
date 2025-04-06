package com.Aditya.Recursion;
import java.util.Arrays;


//In this code which is presented by GFG , the approach towards the problem is that we check if for the following opening bracket
//it's corresponding closing bracket exists or not if it exists then check for the rest and if it does'nt exists then return false
public class ValidParenthesesUsingRecursion{
    static char findClosing(char c){
        if(c == '('){
            return ')';
        }

        if(c == '{'){
            return '}';
        }

        if(c == '['){
            return ']';
        }

        return Character.MIN_VALUE;
    }//end of find closing method

    //function to check if the parenthesis are balanced or not
    static boolean check(char[] expr,int n ){
        //Base cases
        if(n == 0){
            return true;
        }
        if(n == 1){
            return false;
        }
        if(expr[0] == ')' || expr[0] == '}' || expr[0] == ']')
            return false;

        //Search for closing bracket for first opening bracket.
        char closing = findClosing(expr[0]);

        //count is used to handle cases like
        //"((()))". We basically need to consider matching closing bracket.
        int i,count = 0;
        for(i = 1;i< n;i++){
            if(expr[i] == expr[0]){
                count++;
            }
            if(expr[i] == closing){
                if(count == 0){
                    break;
                }
                count--;
            }
        }

//If we did'nt find a closing bracket
        if(n == i){
            return false;
        }

        //if closing bracket was next to open
        if(i == 1)
            return check(Arrays.copyOfRange(expr,i+1,n),n-2);

//if closing bracket was somehere in the middle
//check in the middle part and check in the remaining part
        return check(Arrays.copyOfRange(expr,1,i),i-1) && check(Arrays.copyOfRange(expr,(i+1),n),n-i-1);
    }//end of function check

    public static void main(String[] args)
    {
        char expr[] = "[(])".toCharArray();
        int n = expr.length;
        if (check(expr, n))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }


}//end of public class

