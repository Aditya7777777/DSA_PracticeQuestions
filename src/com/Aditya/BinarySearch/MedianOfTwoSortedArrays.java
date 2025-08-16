package com.Aditya.BinarySearch;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
* */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
      double ans = findMedianSortedArraysOptimal(new int[]{1,3},new int[]{2});
        System.out.println(ans);
    }
    //Brute force
    static double findMedianSortedArrays(int[] nums1,int[] nums2){
       int[] arr = merge(nums1,nums2);
       int n = arr.length;
       double median = 0;

       if(n % 2 == 0){
           int mid  = n/2;
           median = (double)(arr[mid] + arr[mid-1])/2;
       }else{
           int mid = n/2;
           median = arr[mid];
       }

       return median;
    }

    static int[] merge(int[] nums1,int[] nums2){
        int i = 0;
        int j = 0;
        int k = 0;

        int[] merged = new int[nums1.length + nums2.length];

        while( i  < nums1.length && j  < nums2.length){
            if(nums1[i]  < nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        //addition of the remaining elements of nums1 to merged
        while(i  < nums1.length){
            merged[k] = nums1[i];
            i++;
            k++;
        }

        //addition of the remaining elements of nums2 to merged
        while(j  < nums2.length){
            merged[k] = nums2[j];
            j++;
            k++;
        }


        return merged;

    }

    //Time complexity  : O(m + n)
   //Space complexity : O(m + n)


    //Better Solution using Pointers
    //Approach is to find the middle elements . If the length of the array is even then we have to find two elements and if the
    //length of the array is odd then we have to find one element . So,instead of merging both the arrays we simply find the middle
    //elements using pointers.
    static double findMedianSortedArraysBetter(int[] nums1,int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        int mid = (n + m - 1) / 2;
        int el1 = 0;
        int el2 = 0;
        double median;
        int x = 0;

        if (n == 0) {
            if (m % 2 == 0) {
                return (double) (nums2[mid] + nums2[mid + 1]) / 2;
            } else {
                return nums2[mid];
            }
        }

        if (m == 0) {
            if (n % 2 == 0) {
                return (double) (nums1[mid] + nums1[mid + 1]) / 2;
            } else {
                return nums1[mid];
            }
        }


        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                if (x == mid) {
                    el1 = nums1[i];
                }

                if (x == mid + 1) {
                    el2 = nums1[i];
                }

                i++;
            } else {
                if (x == mid) {
                    el1 = nums2[j];
                }

                if (x == mid + 1) {
                    el2 = nums2[j];
                }

                j++;
            }

            x++;
        }

        while (j < m) {
            if (x == mid) el1 = nums2[j];
            if (x == mid + 1) el2 = nums2[j];
            j++;
            x++;
        }

        while (i < n) {
            if (x == mid) el1 = nums1[i];
            if (x == mid + 1) el2 = nums1[i];
            i++;
            x++;
        }


        if ((n + m) % 2 == 0) {
            median = (double) (el1 + el2) / 2;
        } else {
            median = el1;
        }

        return median;
    }

    //Time complexity : O(n+m)
    //Space complexity : O(1)

    //Optimal Solution using Binary Search
    static double findMedianSortedArraysOptimal(int[] nums1,int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int range = 0;

        double median = 0;
        if(n > m) return findMedianSortedArraysOptimal(nums2,nums1);

        int low = 0;
        int high  = n;
        int left = (n + m + 1)/2;// --> this variable tells how many elements will be on the left symmetry for both even and odd
        while(low <= high){
            int mid1 = (low+high) / 2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;

            if(mid1 < n) r1 = nums1[mid1]; //EXPLANATION BELOW :  NO 1.
            if(mid2 < m) r2 = nums2[mid2];
            if(mid1 > 0) l1 = nums1[mid1-1];
            if(mid2 > 0) l2 = nums2[mid2-1];

            if(l1 <= r2 && l2 <= r1){
                if((n+m) %2 == 0){
                    median = (double) (Math.max(l1,l2)+Math.min(r1,r2))/2 ;
                }
                else {
                    median = Math.min(l1, l2);
                }
                break;
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }

        return median;
    }


}

/*
 EXPLANATION-1 :
    Suppose the mid is pointing to the number which is greater than the last index of the array in order to include all the elements
    of the array. If this happens then we will get array index out of bounds Exception.
    for eg : suppose the array is  : 7,12,14,15
    it's range for binary search is 0 - 4
    if mid becomes 4 .
    then index will be out of bounds
* */
