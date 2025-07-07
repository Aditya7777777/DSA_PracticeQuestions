package com.Aditya.Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args){
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
       mergeOptimal2(nums1,1,nums2,0);
       for(int e : nums1){
           System.out.print(e + " ");
       }
    }

    //Brute force solution
    static void merge(int[] nums1,int m,int[] nums2,int n){
        if(nums2.length == 0){
            return;
        }

        //declaring two pointers
        int i = 0;
        int j = 0;

        int k = 0;

        int[] temp = new int[m];

        //copying elements of nums1 into temp
        for(int z = 0;z<m;z++){
            temp[z] = nums1[z];
        }//end of for loop


        while(i <m && j<n){
            if(temp[i] >= nums2[j]){
                nums1[k] = nums2[j];
                j++;
                k++;
            }else{
                nums1[k] = temp[i] ;
                i++;
                k++;
            }
        }

        while(k < m  && i < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }

        while(k < m && i  < m){
            nums1[k] = temp[i];
            i++;
            k++;
        }


    }

    //Time complexity : O(N)
    //Space complexity : O(N)


//    Optimal Solution
   static void mergeOptimal(int[] nums1 , int m,int[] nums2,int n){
        int i = n-1;
        int j = 0;

        while(i  >= 0 && j < n){
            if(nums1[i] > nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                i--;
                j++;
            }else{
                break;
            }

        }

        Arrays.sort(nums1,0,n);
        Arrays.sort(nums2);
        j = 0;

        for(int z = n ; z < n+m;z++){
            nums1[z] = nums2[j];
            j++;
        }
   }
//   Time complexity : O(NLogN)
//    Space complexity O(1)

    //Ceil method


    private static void swapGreater(int[] nums1,int[] nums2 ,int indx1, int indx2){
      if(nums1[indx1] > nums2[indx2]){
          int temp = nums1[indx1];
          nums1[indx1] = nums2[indx2];
          nums2[indx2]  = temp;
      }
    }

    //interchange n and m
    static void mergeOptimal2(int[] nums1,int n,int[] nums2 , int m){
        int len = (n+m);
        int gap = (len/2) + (len%2);

        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                //nums1 and nums2
                if(left < n && right >=n){
                  swapGreater(nums1,nums2,left,right-n);
                }
                //nums2 and nums2
                else if(left >= n){
                    swapGreater(nums2,nums2,left-n,right-n);
                }
                //nums1and nums1
                else{
                    swapGreater(nums1,nums1,left,right);
                }

                left++;right++;
            }

            if(gap == 1) break;
            gap = (gap/2) + (gap%2);

        }

        int k = 0;

        for(int i = n;i<n+m;i++){
            nums1[i] = nums2[k];
            k++;
        }

    }

    //Time complexity:O(log(n+m) * O(n+m)) + O(m)
    //Space complexity:O(1)
}
