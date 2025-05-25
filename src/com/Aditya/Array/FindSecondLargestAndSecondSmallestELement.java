package com.Aditya.Array;

public class FindSecondLargestAndSecondSmallestELement {
    //The array may can contain duplicates
    public static void main(String[] args){
    }

    static int secondLargest(int[] arr){
        int largest = 0;
        int indx = 0;

        for(int i = 0;i<arr.length;i++){
            if(largest < arr[i]){
                largest = arr[i];
                indx = i;
            }
        }

        int secondlargest = 0;
        for(int i = 0;i<arr.length;i++){
            if(i !=  indx){
                if(secondlargest < arr[i] && arr[i] !=  largest){
                    secondlargest = arr[i];
                }
            }
        }

        return secondlargest;
    }

    static int secondSmallest(int[] arr){
        int small = arr[0],indx = 0;
        for(int i = 0;i<arr.length;i++){
            if(small > arr[i]){
                small = arr[i];
                indx = i;
            }
        }

        int secondSmall = arr[indx+1];
        for(int i = 0;i<arr.length;i++){
            if(i!=indx){
                if(secondSmall > arr[i] && arr[i] != small){
                    secondSmall = arr[i];
                }
            }
        }

        return secondSmall;
    }

    
}
