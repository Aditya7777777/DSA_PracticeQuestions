package com.Aditya.Sorting1;

public class RecursiveBubbleSort {
    public static void main(String[] args){
      int[] arr = new int[]{4,3,5,3,2,5};
      bubbleSort(arr,arr.length);
      for(int e : arr){
          System.out.print(e + " ");
      }
    }

    static void bubbleSort(int[] arr,int n){
        if(n == 0){
            return;
        }
        int max = 0;
        int index = 0;
        for(int i = 0;i<n;i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }

        int temp = arr[n-1];
        arr[n-1] = arr[index];
        arr[index] = temp;

        bubbleSort(arr,n-1);

    }
}
