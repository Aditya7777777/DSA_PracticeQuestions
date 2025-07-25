package com.Aditya.BinarySearch.BinarySearchOnOneDPattern;

public class NumberOfTimesTheArrayIsRotated {
    public static void main(String[] args){
      int[] arr = new int[]{4,5,6,7,0,1,2};
      int ans = rotatedNum(arr);
      System.out.println(ans);

    }

    static int rotatedNum(int[] arr){

        int start = 0;
        int end = arr.length-1;
        int count  = 0;
        int pivotIndx = 0;
        while(start <=  end){
            int mid = start + (end-start)/2;

            if(mid < arr.length-1 && arr[mid] > arr[mid+1]){
                 pivotIndx = mid+1 ;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                pivotIndx = mid;
            }else if(arr[mid] >= arr[start]){
                start = mid+1;
            }else if(arr[mid] < arr[start]){
                end = mid;
            }

        }//end of while

        count  = arr.length - pivotIndx;

        return count;
    }
}
