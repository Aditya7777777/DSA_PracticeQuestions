package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;

public class CapacityToShipPacketsWithinDDays {
    public static void main(String[] args) {
      int[] weights = new int[]{3,3,3,3,3,3};
      int days = 2;
        int ans = shipWithinDaysOptimal(weights,days);
        System.out.println(ans);

    }

//     The range lies between the maximum element of the array and the sum of the whole array
//    [maxEle,EleSum]


    static int shipWithinDays(int[] weights,int days){
        int min = findingMax(weights);
        int max = sumOfArr(weights);
        int ans = 0;
        boolean executed = false;

        int minDays = 0;

        for(int i = min;i <= max ;i++){
             minDays = daysOfCap(weights,i);

             if(minDays  <= days){
                 if(!executed){
                     ans = i;
                     executed = true;
                 }else if(i < ans){
                     ans = i;
                 }

             }
        }

        return ans;
    }

    //Time complexity: O((max - min + 1)  * N )
    //Space complexity : O(1)

    static int daysOfCap(int[] arr,int cap){
        int days = 1;
        int sum = 0;

        for(int i = 0;i<arr.length;i++){
            if((sum + arr[i]) > cap){
                days++;
                sum = arr[i];

            }else{
                sum  = sum+arr[i];
            }
        }

        return days;
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

    static int sumOfArr(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum  + arr[i];
        }

        return sum;
    }

    static int shipWithinDaysOptimal(int[] weights,int days){
        int min = findingMax(weights);
        int max = sumOfArr(weights);
        int ans = 0;

        int low = min;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2;
            int minDays =  daysOfCap(weights,mid);
            if(minDays <= days){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }


        return ans;
    }

    //Time Complexity : O(NlogN)
    //Space complexity : O(1)
}
