package com.Aditya.search;

public class LinearSearch {
    public static void main(String[] args){
        //In this approach we iterate throughout the array using for loop and return the index of the element which we are searching in an array
        int[] arr = new int[]{1,2,3,6,4,6,8,8};
        int search = 9;
        int ans = linearSearch(arr,search);

        if(ans >= 0){
            System.out.println("The element is present at the index "+ ans);
        }else{
            System.out.println("The search element doesn't present in the array");
        }
    }

    static int linearSearch(int[] arr,int search){

        for(int i = 0;i<arr.length;i++){
            if(arr[i] == search){
                return i;
            }
        }

        return -1;
    }
}
