package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;

public class FindSmallestDivisorAndGetThreshold {
    public static void main(String[] args) {
      int[] arr =  new int[]{1,2,5,9};
      int ans =  smallestDivisorOptimal(arr,6);
        System.out.println(ans) ;
    }

    //Brute force

    //Brute force
//    m --> the number of bouquets needed.
//    k --> the number of flowers each bouquet should have .
    static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int ans = -1;

        int max = findingMax(nums);
        int min = 1;
        boolean executed = false;

        for(int i = min;i<=max;i++){
            if(summation(nums,i,threshold)){
                if(!executed){
                    ans = i;
                    executed = true;
                }else  if(ans >  i) {
                    ans = i;
                }
            }
        }
        return ans;
    }

    //Time complexity : O((max - min +1) * N)
    //Space complexity  :O(1)

    private static boolean summation(int[] arr,int num,int threshold){
        int sum = 0;
        int n = arr.length;


        for(int i = 0;i<n;i++){
            int res = (int)Math.ceil((double)arr[i]/num);
            sum += res;
        }

        if(sum <= threshold){
            return true;
        }

        return false;
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



    static int smallestDivisorOptimal(int[] nums, int threshold) {
        int n = nums.length;
        int ans = -1;

        int max = findingMax(nums);
        int min = 1;

        int low  =  min;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(summation(nums,mid,threshold)){
                ans = mid;
                high =  mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    //Time complexity : O(log(max - min + 1) * N)
    //Space complexity : O(1)

}
