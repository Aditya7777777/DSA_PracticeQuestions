package com.Aditya.BinarySearch.FindingTheMaxOfMinAndMinOfMaxPattern;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
      int[] arr = new int[]{0,3,4,7,9,10};
      int cows = 4;

      int ans = aggressiveCows(arr,4);
        System.out.println(ans);
    }

    //Brute force solution
    static int aggressiveCows(int[] arr,int k){
        Arrays.sort(arr);
        int max = findingMax(arr);
        int min = findingMin(arr);

        for(int i = 1;i<max-min;i++){
            if(canWePlace(arr,i,k)){
                continue;
            }else{
                return i-1;
            }
        }

        return -1;
    }

    static boolean canWePlace(int[] arr, int minDist,int cows){
        int  prevCow = arr[0];
        cows = cows-1;
        for(int i = 0;i<arr.length;i++){
            if((arr[i] - prevCow) >= minDist){
                cows--;
                prevCow= arr[i];
                if(cows == 0) break;
            }else{
                continue;
            }
        }

        if(cows !=0){
            return false;
        }

        return true;
    }

    static int findingMax(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

    static int findingMin(int[] arr){
        int min = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        return min;
    }

    //Time complexity : O(N) + O(N) + O(NlogN) + (O(max-min) *  O(N)) -> (O(max-min) *  O(N))
    //Space complexity : O(1)


    //Optimal Solution
    static int aggressiveCowsOptimal(int[] arr,int k){
        Arrays.sort(arr);
        int max = findingMax(arr);
        int min = findingMin(arr);
        int ans = 0;

        int low = min;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWePlace(arr,mid,k)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    //Time complexity  : O(log(max-min)) * O(N) + O(NlogN) --> O(NlogN)


}
