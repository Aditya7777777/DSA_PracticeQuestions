package com.Aditya.Recursion.IndexBased;

//Merge Sort code in place
public class MergeSort {
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void mergeSort(int[] arr,int left,int right){
        if(left < right){
            int mid = left + (right - left)/2;

            //sorting of left sub-array
            mergeSort(arr,left,mid);

            //sorting of right sub-array
            mergeSort(arr,mid+1,right);

            //merging left and right sub-array
            MergeSort ms = new MergeSort();
            ms.merge(arr,left,mid,right);
        }
    }

    private  void merge(int[] arr,int left,int mid,int right){
       int n1 = mid - left + 1;
       int n2 = right-mid;

       //declaring arrays of length n1 and n2
        int[] leftArrays = new int[n1];
        int[] rightArrays  = new int[n2];

        //copying the elements of left sub-array and right sub-array in leftArrays and rightArrays
        for(int i = 0 ;i < n1;i++){
            leftArrays[i] = arr[left+i];
        }

        for(int i = 0;i <  n2;i++){
            rightArrays[i] = arr[mid+1+i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j<n2){
            if(leftArrays[i] <= rightArrays[j]){
                arr[k] = leftArrays[i];
                i++;
            }else{
                arr[k] = rightArrays[j];
                j++;
            }
            k++;
        }

        //adding the remaining elements of the left sub-array
        while(i<n1){
            arr[k] = leftArrays[i];
            i++;
            k++;
        }

        //adding the remaining elements of the right sub-array
        while(j<n2){
            arr[k] = rightArrays[j];
            j++;
            k++;
        }

    }

}

