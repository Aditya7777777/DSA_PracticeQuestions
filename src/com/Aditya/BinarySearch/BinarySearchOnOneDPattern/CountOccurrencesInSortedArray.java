package com.Aditya.BinarySearch.BinarySearchOnOneDPattern;

public class CountOccurrencesInSortedArray {
    public static void main(String[] args){
        int[] nums = new int[]{1, 1, 2, 2, 2, 2, 2, 3};
        int ans = numsberOfOccurences(nums,2);

        System.out.println(ans);

    }

    static int numsberOfOccurences(int[] nums, int target) {

        int firstIndx = leftSearch(nums,target);
        int lastIndx = rightSearch(nums,target);

        int ans = lastIndx - firstIndx + 1;

        return ans;
    }

    //LeftSearch
    static int leftSearch(int[] nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int first = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return first;
    }

    static int rightSearch(int[] nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int last = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }

        return last;
    }
}
