package com.Aditya.Easy;

public class FibonacciSeries {
    public static void main(String[] args){
      int n = 10;
      int num1 = 0;
      int num2 = 1;
        int nextTerm = 0;

      for(int i = 0 ;i < n;i++){
          nextTerm = num1 + num2;
          num1 = num2;
          num2 = nextTerm;
      }

      System.out.println(nextTerm);
    }


}
