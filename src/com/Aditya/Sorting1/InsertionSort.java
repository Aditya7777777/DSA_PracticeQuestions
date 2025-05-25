package com.Aditya.Sorting1;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = new int[]{13, 46, 24, 52, 20, 9};
        InsertionSort(arr);
        for(int e : arr){
            System.out.print(e + "  ");
        }

    }

    static void InsertionSort(int[] arr){
        //what we are doing in insertion sort:
        /* In this sorting technique we are first comparing two consecutive elements and if
        the next element turns out to be greater than the previous element then we swap that
        element backwards to it's correct position .
        * */

        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]  > arr[i+1]){
                for(int j = i+1 ;j > 0;j--){
                    if(arr[j] < arr[j-1]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                }
            }
        }
    }
}
