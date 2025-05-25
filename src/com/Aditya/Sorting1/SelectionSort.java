package com.Aditya.Sorting1;

public class SelectionSort {
    public static void main(String[] args){
       int[] arr = new int[]{64,25,12,22,11};
       SelectionSort(arr);
       for(int e : arr){
           System.out.print(e+ " ");
       }
    }

    static void SelectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n-1;i++){
            int min = arr[i+1];
            int index = i+1;
            for(int j = i+1;j<n;j++){
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            if(arr[i] > arr[index]) { //swap the elements only if the element at the pivot is greater than the element that is found during the
                                      // iteration done in the i+1 to arr.length of the array
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
