package com.Aditya.Array;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args){
        int[] arr = new int[]{3,4,5,1,2};
        int index = 0;
        int count = 0;
        int[] check = new int[arr.length];

        for(int i = 0; i< arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                index = i+1;
            }
        }

        for(int i = 0;i<arr.length-index;i++){
            check[i] = arr[index+i];
        }

        for(int i = 0;i<index;i++){
            check[arr.length-index+i] = arr[i];
        }


    }
}
