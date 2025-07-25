package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args){
//        int[] bloomDay = new int[]{7,7,7,7,12,7,7};
//        int ans = minDaysUsingBinarySearch(bloomDay,2,3);
//        System.out.println(ans);
        int a = 4;
        int b = 1;

        System.out.println(a/b);
    }

    //Brute force
//    m --> the number of bouquets needed.
//    k --> the number of flowers each bouquet should have .
    static  int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(n< m * k){
            return -1;
        }

        int max = findingMax(bloomDay);
        int min = findingMin(bloomDay);

         for(int i = min;i<=max;i++){
             if(possible(bloomDay,i,m,k)){
                return  i;
             }
         }
         return -1;
    }

    private static boolean possible(int[] arr,int day,int m,int k){
        int count = 0;
        int minBouquet = 0; //--> this variable stores the number of bouquet that can be formed on a particular day.
        int n = arr.length;


        for(int i = 0;i<n;i++){
            if(arr[i] <= day){
                count++;
            }else{
                minBouquet += (count/k);
                count = 0;
            }
        }
        minBouquet += (count/k);

        if(minBouquet >= m){
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

    static int findingMin(int[] arr){
        int min = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        return min;
    }

    //Time complexity: O((max - min + 1)  * N )
    //Space complexity : O(1)

    //Optimal
    static  int minDaysUsingBinarySearch(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(n< m * k){
            return -1;
        }

        int max = findingMax(bloomDay);
        int min = findingMin(bloomDay);
        int low = min;
        int high = max;
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }


        return ans;
    }

    //Time complexity : O (log(max-min+1) * N)
    //Space complexity : O(1)

}
