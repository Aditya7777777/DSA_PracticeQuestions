package com.Aditya.Array;

//Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
//
//What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
public class CountInversion {
    public static void main(String[] args){
        int[] a = new int[]{5, 4, 3, 2, 1};
        int[] nums1 = new int[]{3,3,5,6};
        int[] nums2 = new int[]{2,2,4,4,8};
        int n = 5;
        int ans = sort(a, 0, n - 1, 0);
        System.out.print(ans);


    }

    //Brute force solution
    static int numberOfInversion(int[] a,int n){
        int count = 0;

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(a[i] > a[j]){
                    count++;
                }
            }
        }
        return count;
    }

    //Time complexity : O(N^2)
    //Space complexity: O(1)

    //Optimized solution using merge sort

    static int  merge(int arr[], int l, int m, int r,int count)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        count = count + sortedCount(L,R,count);

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return count;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static int sort(int arr[], int l, int r,int count)
    {
        if (l >= r) {
          return count;
        }

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
             int count1 = sort(arr, l, m,count);
             int count2 = sort(arr, m + 1, r,count);

            // Merge the sorted halves
            int count3 = merge(arr, l, m, r,count);

            return count1+count2+count3;
    }

    static int sortedCount(int[] nums1,int[] nums2,int count){
        int left = 0;
        int right = 0;

        while(left < nums1.length && right < nums2.length){
            if(nums1[left] > nums2[right]){
                count = count + (nums1.length - 1 - left)+1;
                right++;
            }else{
                left++;
            }
        }

        return count;
    }

    //Time complexity:O(NlogN)
    //Space complexity : O()

}
