package com.Aditya.Recursion;


//This problem will get solved very easily with iterative approach rather than recursive method
/*
In the two declaration of the array :
int[] arr = new int[]{1,2,3,4,5,6};
int[] arr = {1,2,3,4,5,6};

In both of the cases the array gets stored in the same way in the memory.
*/
public class CheckIfTheArrayIsSorted {
    public static void main(String[] args){
        int arr[] = {20, 20, 78, 98, 99, 97};

        System.out.println(CheckIfTheArrayIsSortedRecursion(arr,0));

    }

    static boolean CheckIfTheArrayIsSorted(int[] arr){
        for(int i = 0 ;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }

        return true;
    }

    static boolean CheckIfTheArrayIsSortedRecursion(int[] arr,int i){
        if(i == arr.length-1){
            return true;
        }

        if(arr[i] > arr[i+1]){
            return false;
        }

        return CheckIfTheArrayIsSortedRecursion(arr,++i);
    }
}
