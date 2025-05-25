package com.Aditya.Hashing;

import java.util.*;

public class CountingFrequency {
    public static void main(String[] args){

        int[]  arr = new int[]{10,5,10,15,10,5};

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " --> " + e.getValue());
        }

    }

    static void  count(int[] arr){
        int max = 0;
        for(int i = 0 ;i < arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int[] indexArr =  new int[max+1];

        for(int  i = 0;i<arr.length;i++){
            indexArr[arr[i]]++;
        }

        for(int i = 0;i < indexArr.length;i++){
            if(indexArr[i] != 0) {
                System.out.println(i + " --> " + indexArr[i]);
            }
        }

    }

    // solution using map
    static void countMap(int[] arr){
         Map<Integer,Integer> map = new HashMap<>();

         for(int i = 0;i<arr.length;i++){
             if(map.containsKey(arr[i])) {
                 map.put(arr[i], map.get(arr[i])+1);
             }else{
                 map.put(arr[i],1);
             }
         }

         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
             System.out.println(entry.getKey()+ " " + entry.getValue());
         }

    }
}
