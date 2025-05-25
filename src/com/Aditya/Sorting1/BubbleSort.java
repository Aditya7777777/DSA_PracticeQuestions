package com.Aditya.Sorting1;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,5,3,2,1,6,9};

        BubbleSort(arr);

        for(int e : arr){
            System.out.print(e+" ");
        }
    }

    static void BubbleSort(int[] arr){
        int k = 0;
        for (int j = arr.length-1; j >= 0 ; j--) {
            int index = 0;
            int max = 0;

            for (int i = 0; i < arr.length-k; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }

            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
            k++;
        }
    }


    
}
