package com.Aditya.Recursion;

public class CountGoodNumbers {
    static int M = 1_000_000_007;
    public static void main(String[] args){
        int n = 1924;
        int n1 = countGoodNumbers(n);
        System.out.println(n1);


    }

    static int countGoodNumbers(long n) {
        //the below two formulas is to calculate even number of positions as well as odd number of position
        //irrespective whether n is even or odd.
        long e  = (n+1)/2;// 5 even numbers
        long o  =  n/2;//4 prime numbers

        long x = ((pow(5,e)) * pow(4,o)) % M ;
        return (int)x;
    }
    //for this particular case the power will never be negative
    static long pow(long num,long n){
        //The below method of finding the power is correct but when the input value is large then
        //loop iterates for long time and because of that time limit get's exceeded.
        // long ans = 1;
        // for(int i = 0;i<n;i++){
        //   ans = ans*num;
        //   ans = ans % M;
        // }
        num = num%M;
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            System.out.println(num);
            return pow((num * num), n/2) ;
        }else{
            System.out.println(num);
            return num * pow(num,n-1) ;
        }
    }
}
