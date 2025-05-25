package com.Aditya.Array;

public class UnionOfTwoArrays {
    public static void main(String[] args){
        //to find the union of two sorted array
        int[] arr1 = new int[]{1,2,9,10};
        int[] arr2 = new int[]{5,6,7};
        int[] unionArr = new int[arr1.length+arr2.length];

        int i = 0;//for arr1
        int j = 0;//for arr2
        int k = 0;//for unionArr

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                unionArr[k] = arr1[i];
                i++;
            }else{
                unionArr[k] = arr2[j];
                j++;
            }
            k++;
        }

        //adding the remaining elements of arr1
        while(i < arr1.length){
            unionArr[k] = arr1[i];
            i++;
            k++;
        }

        //adding the remaining elements of arr2
        while(j < arr2.length){
            unionArr[k] = arr2[j];
            j++;
            k++;
        }

        //printing the union array
        for(int e : unionArr){
            System.out.print(e + " ");
        }

    }
}
