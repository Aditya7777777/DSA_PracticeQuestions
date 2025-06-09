package com.Aditya.Array;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] arr =  new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7};
      int ans = longestSequenceBetter(arr);
      System.out.println(ans);
    }
    //Brute force solution
    static int longestSequence(int[] arr){
      int n =  arr.length;
      int x ;
      int longest  = 0 ;
      for(int i = 0;i<n;i++){
          x  = arr[i];
          int count = 0;
          //This loop will iterate untill there is no further consecutive numbers by linear searching in the array .
          while(linearSearch( arr, x) == true){
              x = x+1;
              count = count+1;
          }

          if(longest < count){
              longest = count;
          }
      }

      return longest;
    }

    //Time complexity : O(N^2)
    //Space Complexity : O(N)

    static boolean linearSearch(int[] arr,int x){
       for(int i = 0;i<arr.length;i++){
           if(arr[i] == x){
               return true;
           }
       }
       return false;
    }

    //Better Force Solution
    static int longestSequenceBetter(int[] arr){
        //if there are no elements inside the array
        if(arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        int count = 1;
        int max = 1;
        int n = arr.length;

        for(int i = 0;i<n;i++){
            if(i < arr.length-1 && arr[i] == arr[i+1] ){
                continue;
            }else if(i != n-1 && arr[i] + 1 == arr[i+1]  ){
                count++;
            }else{
                if(count >  max && count > 1){
                    max = count;
                    count = 1;
                }
            }

        }

        return max;
    }
}
//Time complexity = O(NlogN)
//Space Complexity  = O(1)

// Note :  Arrays.sort() distort the array which would not be liked by the interviewer

