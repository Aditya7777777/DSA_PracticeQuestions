package com.Aditya.BinarySearch.ToFindMaximumOrMinimumPattern;

public class KokoEatingBananas {
    public static void main(String[] args){
        int[] piles = new int[]{30,11,23,4,20};
     int ans = rateOfEatingBananasOptimal(piles,6);
     System.out.println(ans);
    }

    //Brute force solution
    static int findingMax(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        return max;
    }

    static int hours(int[] piles,int num){
        int n = 0;
        int count = 0;
        for(int i = 0;i<piles.length;i++){
            n = piles[i];
            while(n > 0){
                n = n-num;
                count++;
            }
        }

        return count;
    }
    static int rateOfEatingBananas(int[] piles,int hours){
        int max = findingMax(piles);
        int count = 0;
        int hrs = 0;
        int ans = 0;

        for(int i = 1;i <= max;i++){
            hrs = hours(piles,i);

            if(hrs == hours || hrs < hours){
                ans = i;
                break;
            }
        }

        return ans;
    }

    //optimal solution
    static int rateOfEatingBananasOptimal(int[] piles,int hours){
        int max = findingMax(piles);
        int count = 0;
        int hrs = 0;
        int ans = 0;


        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2;
            hrs = hours(piles,mid);

            if(hrs  == hours){
                ans = mid;
                break;
            }else if(hrs  < hours){
                ans = mid;
                high  = mid-1;
            }else {
                low = mid+1;
            }
        }

        return ans;
    }

    //Time Complexity : O(NlogN)
    //Space complexity : O(1)
}
