package com.Aditya.BinarySearch.FindingTheMaxOfMinAndMinOfMaxPattern;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr =  new int[]{7,2,5,10,8};
        int ans = splitArrayOptimal(arr,2);
        System.out.println(ans);

    }


    //Brute force
    static int splitArray(int[]arr,int m){
        int low = findingMax(arr);
        int high = sum(arr);

      for(int i = low;i <= high;i++){
          if(split(arr,i) > m){
              continue;
          }else{
              return i;
          }
      }

      return -1;
    }

    static int split(int[] arr,int MaxSumOfPartition){
        //this method returns the number of partition after assigning the elements inside the array according to the
        //maximum sum given in the input (sumOfPartition)
        
        int noOfPartition = 1;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum > MaxSumOfPartition){
                noOfPartition++;
                sum = arr[i];
            }
        }
        
        return noOfPartition;
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

    static int sum(int[] arr){
        int sum = 0;
        for(int i = 0;i < arr.length;i++){
            sum = sum + arr[i];
        }

        return sum;
    }

    //Time complexity : O(sum-max) * O(N) -> O((sum-max) * N)
    //Space complexity : O(1)

    //optimal solution
    static int splitArrayOptimal(int[] arr,int m){
        int low =  findingMax(arr);
        int high = sum(arr);
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int currPartition = split(arr,mid);

            if(currPartition <=  m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return ans;
    }

    //Time complexity : O(log(sum - maxELe) * N)
    //Space complexity : O(1)
}
