package com.Aditya.BinarySearch.FindingTheMaxOfMinAndMinOfMaxPattern;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
     int[] arr = new int[]{25,46,28,49,24};
        int ans = minimumNumberOfPagesOptimal(arr,4);
        System.out.println(ans);

    }

    //Brute force linear search
    static int minimumNumberOfPages(int[] arr,int m){
        int low = findingMax(arr);
        int high = sum(arr);
        int countStudents = 0;

        for(int i = low;i<=high;i++){
            countStudents = suitableNoOfPages(arr,i);

            if(countStudents == m){
                return i;
            }
        }

        return -1;
    }

    static int suitableNoOfPages(int[] arr,int pages){
        //this function return the number of students after allocating the pages which is present in the input (pages)
        int noOfStudents = 1;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(sum > pages){
                noOfStudents++;
                sum = arr[i];
            }
        }

        return noOfStudents;
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

    //Time complexity : O(high-low) * O(N)
    //Space complexity : O(1)

    //Optimal solution:Binary Search
    static int minimumNumberOfPagesOptimal(int[] arr,int m){
        int low = findingMax(arr);
        int high = sum(arr);
        int ans = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(suitableNoOfPages(arr,mid) <= m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }


}