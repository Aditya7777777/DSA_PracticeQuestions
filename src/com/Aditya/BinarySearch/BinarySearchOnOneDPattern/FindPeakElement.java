package com.Aditya.BinarySearch.BinarySearchOnOneDPattern;

public class FindPeakElement {
    public static void main(String[] args){
      int[] arr = new int[]{1,2,3,1};
      int ans = findingPeak(arr);
      System.out.println(ans);
    }

    static int findingPeak(int[]arr){
        int low  = 0;
        int high = arr.length-1;

        while(low < high){
            int mid =  low + (high-low)/2;

            if(mid == 0 && arr[mid] >  arr[mid+1]){
                return mid;
            }else if(mid == arr.length-1 && arr[mid] > arr[mid-1]){
                return mid;
            }else if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }else if(arr[mid] > arr[mid+1]){
                high = mid-1;
            }
        }

        return low;
    }
}
