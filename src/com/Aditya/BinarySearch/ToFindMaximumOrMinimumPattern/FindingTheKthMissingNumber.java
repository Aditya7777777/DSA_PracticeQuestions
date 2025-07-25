package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;

public class FindingTheKthMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int k = 2;
        int ans = findingKthPositiveOptimal(arr,k);
        System.out.println(ans);
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

    //brute force
    static  int findingKthPositive(int[] arr,int k){
        int i = 0;
        int count = 0;
        int ans = 0;
        int max = findingMax(arr);
        for(int j = 1;j<max;j++){
            if(arr[i] == j){
                i++;
            }else{
                count++;
            }

            if(count == k){
                ans = j;
                break;
            }
        }

        if(count  < k){
            return arr[arr.length-1] + (k-count);
        }

        return ans;
    }

    //Time complexity : O(N)
    //Space complexity : O(1)

    //Optimal Solution / Binary Search
    static int findingKthPositiveOptimal(int[] arr,int k) {
        int low  = 0;
        int high = arr.length-1;
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;
            int missing = arr[mid]-(mid+1);
            if(missing < k){
                low  = mid+1;
            }else{
                high = mid-1;
            }
        }

//        ans = arr[high] + (k - (arr[high]-(high+1)));
        //the above equation becomes
//        ans = high + k + 1;
        //then it can become
        ans = low+k;
        return ans;

    }

    }
