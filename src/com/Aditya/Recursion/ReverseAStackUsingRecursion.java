package com.Aditya.Recursion;
import java.util.Stack;

public class ReverseAStackUsingRecursion {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("Stack before reversing it.");
        for(int e : s){
            System.out.print(e+" ");
        };
        System.out.println();

        reverseWithoutTempStack(s);

        System.out.println("The stack after reversing it.");
        for(int e : s){
            System.out.print(e+" ");
        };

    }


    //with the help of a  temporary stack
    static Stack<Integer> reverse(Stack<Integer> s , Stack<Integer> temp){
        if(s.empty()){
            return temp;
        }
        temp.push(s.pop());

       return reverse(s,temp);

    }


    static void insertAtBottom(Stack<Integer> s, int x){
        if(s.empty()){
            s.push(x);
        }else{
            int a = s.pop();
            insertAtBottom(s,x);
            s.push(a);
        }
    }
    //without the help of the temporary stack
    static void reverseWithoutTempStack(Stack<Integer> s){
        if(!s.empty()){
            int x = s.pop();
            reverseWithoutTempStack(s);
            insertAtBottom(s,x);
        }
    }


}
