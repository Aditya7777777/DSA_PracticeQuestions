package com.Aditya.Array;

public class ReversePairs {
    public static void main(String[] args){
      int[] nums = new int[]{1,3,2,3,1};
      int ans = reversePairsOptimized(nums,0,nums.length-1,0);
      System.out.print(ans);
    }

    //Brute force
    static int ReversePairs(int[] nums){
        int count = 0;
        int n = nums.length;

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i] > 2 * nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    //Time complexity : O(N);
    //Space complexity : O(1)

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
    static int reversePairsOptimized(int arr[], int l, int r,int count)
    {
        if (l >= r) {
            return count;
        }

        // Find the middle point
        int m = l + (r - l) / 2;

        // Sort first and second halves
        int count1 = reversePairsOptimized(arr, l, m,count);
        int count2 = reversePairsOptimized(arr, m + 1, r,count);

        // Merge the sorted halves
        int count3 = merge(arr, l, m, r,count);

        return count1+count2+count3;
    }

    static int sortedCount(int[] nums1,int[] nums2,int count){
        int left = 0;
        int right = 0;

        while(left < nums1.length && right < nums2.length){
            if(nums1[left] > 2 * nums2[right]){
                count = count + (nums1.length - 1 - left)+1;
                right++;
            }else{
                left++;
            }
        }

        return count;
    }

    //Time complexity : O(NlogN)
    //Space complexity: O(N) + O(logN) -> O(N)

}

