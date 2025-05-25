package com.Aditya.Sorting1;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{35,50,15,25,80,20,90,45};
        quickSort(arr,0,arr.length-1);
        for(int e : arr){
            System.out.print(e + " ");
        }

    }

    static void swap(int[] arr,int i,int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    static void quickSort(int[] arr,int start,int end){
     //Base condition
        if(start == end){
            return;
        }

        int pivot  = start;
        int i = start + 1;
        int j = end;

        while(i<j){
            //increment i until arr[i] > arr[pivot]
            while(arr[i] < arr[pivot]){
                i++;
            }

            //decrement j until arr[j] < arr[pivot]
            while(arr[j] > arr[pivot]){
                j--;
            }

            if(i<j){
                swap(arr,i,j);
            }
        }

        swap(arr,i-1,pivot);

        quickSort(arr,0,i-1);
        quickSort(arr,i+1,end);

    }

  
}
