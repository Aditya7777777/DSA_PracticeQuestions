package com.Aditya.Recursion;
import java.util.Stack;
public class SortAStackUsingRecursion{
   public static void main(String[] args){
     Stack<Integer> st = new Stack<>();
     st.push(-3);
     st.push(14);
     st.push(18);
      st.push(-5);
      st.push(30);
      Sort(st);

     for(int e: st){
         System.out.print(e+" ");
     }
   }

   static void Sort(Stack<Integer> s){
      if(s.empty()){
         return ;
      }

      if(!s.empty()){
         int top  = s.pop();
         Sort(s);

         if(s.empty()){
            s.push(top);
         }else if(top > s.peek()){
            s.push(top);
         }else{
            Stack<Integer> temp = new Stack<>();
            //removing those elements which are greater than top and storing it inside temp stack
             while(!s.empty() && s.peek() > top){
                 temp.push(s.pop());
             }

             s.push(top);

             //adding the elements that are stored in the temp stack
             while(!temp.empty()){
                 s.push(temp.pop());
             }
         }

      }
   }

}
