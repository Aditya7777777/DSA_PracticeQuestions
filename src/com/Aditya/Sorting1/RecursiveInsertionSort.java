package com.Aditya.Sorting1;

public class RecursiveInsertionSort {
    public static void main(String[] args){
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        recursiveInsertionSort(arr,0);
        for(int e : arr){
            System.out.print(e + "  ");
        }
    }

    static void recursiveInsertionSort(int[] arr,int i){
        if(i == arr.length-1){
            return;
        }
        if(arr[i] > arr[i+1]){
            for(int j = i+1;j>0;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        i++;
        recursiveInsertionSort(arr,i);
    }
}
