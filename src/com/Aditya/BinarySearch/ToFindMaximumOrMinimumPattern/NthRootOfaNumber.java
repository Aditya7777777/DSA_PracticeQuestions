package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;


class Animal{
    String type;

    Animal(String s){
        this.type = s;
    }
    static String animalType(String s){
        return s;
    }
}
public class NthRootOfaNumber {
    public static void main(String[] args){

    }

    //Brute force
    static int NthRoot(int N,int M) {
        for(int i = 1;i<M;i++){
            if(Math.pow(i,N) == M){
                return i;
            }
        }

        return -1;
    }

    //Optimal using Binary search
    static int NthRootOptimal(int n,int m){
         int low = 1;
         int high = m;

         while(low < high){
             int mid =  low + (high - low)/2;
             double ans  = Math.pow(mid,n);
             if(ans == m){
                 return mid;
             }else if(ans  > m){
                 high = mid-1;
             }else{
                 low = mid+1;
             }
         }

         return -1;
    }
}
