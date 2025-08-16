package com.Aditya.BinarySearch.FindingTheMaxOfMinAndMinOfMaxPattern;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceBetweenGasStation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        double ans = noOfGasStationRequired(arr,k);
        System.out.println(ans);
    }



    //Brute force solution
    static double[] MaxDistance(int[]arr,int[]ele,double[] track){
        double max = 0;

        for(int i = 0;i<arr.length-1;i++){
            double dist = arr[i+1] - arr[i];
            if(ele[i] != 0){
                dist = dist / (ele[i]+1);
            }

            if(max < dist){
                max = dist;
                track[0] = i;
                track[1] = max;
            }
        }

        return track;
    }

    static double minimiseMaxDistance(int[] arr, int k){
        int[] ele = new int[arr.length-1];
        double[] track = new double[2];
        double ans = 0;

        for(int i  = 1 ; i <=k+1; i++){
            double[] array  = MaxDistance(arr,ele,track);
            ele[(int)array[0]] = ele[(int)array[0]] + 1;
            ans = array[1];
        }

        double rounded = (double)Math.round(ans * 1000000) / 1000000;
        return rounded;
    }

    //TimeComplexity : O(n*K)
    //Space complexity : O(N)

    //Better solution using priority queue

    public static class Pair{
        double first;
        int second;

        Pair(double first,int second){
            this.first = first;
            this.second = second;
        }
    }

    static double minimiseMaxDistanceBetter(int[] arr, int k){
        int n = arr.length;
        int[] ele = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
      //Storing the distances inside the priority queue
        for(int i  = 0 ; i < n-1; i++){
            int dis = arr[i+1] - arr[i];
            pq.add(new Pair(dis,i));
        }
        
        for (int i = 1; i <= k; i++) {
            Pair p = pq.poll();
            ele[p.second]++;

           double  dist = p.first / 2;
           pq.add(new Pair(dist,p.second));

        }
        Pair p = pq.poll();
        double rounded = (double)Math.round((p.first) * 1000000) / 1000000;
        return rounded;
    }
    //Time complexity : O(logN * k) + O(NlogN) -> O(NlogN)
//Space complexity : O(n) + O(n) -> O(n)



    //Optimal Solution using Binary Search
    static double noOfGasStationRequired(int[] arr,int k){
        double low = 0;
        double high  = findingMax(arr);
        double ans = -1;
        double  range = 1e-6;

        while(high-low > range){
            double mid  =  low + (double)(high-low)/2;
             int count = countOfGasStation(arr,mid);

             if(count > k){
                 low = mid;
             }else if(count <= k){
                 ans = mid;
                 high = mid;
             }
        }

        return ans;
    }

    static int countOfGasStation(int[] arr,double dist){
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            //no of gas station that can be placed between two indices:
            double  diff = ((arr[i+1] - arr[i])/dist);
            if(diff % 1 == 0){
                count  = count + (int)(diff-1);
            }else {
                count = count + (int) diff;
            }
        }

        return count;
    }

    static int findingMax(int[] arr){
        //here the max is the maximum difference between two gas stations that are already present
        int max = 0;
        for(int i = 0;i<arr.length-1;i++){
            int diff = arr[i+1] - arr[i];
            if(max < diff){
                max = diff;
            }
        }

        return max;
    }

    //Time complexity : O()


    //****************Reason behind the while condition****************************
    /*Here the condition while(high-low  > 1e-6) is written because while dealing with double we can't use +1
    while eliminating the range as we are using Binary Search because we have to find the distance which is precise
    up to 10^-6 .

    to understand this consider this particular example
    arr[] = {1,2,3,4,5}
     now the range over here is form 0 to max Distance between two gas stations [0 , maxDist]
     here the maxDist is 1.

     low = 0
     high = 1

     for a distance after finding the mid is 0.5 ie mid = 0.5
     and we know that the countOfGas Station if we consider this particular distance is 4

     now if we take 0.6 then also we get 4 gas stations but we have to find the minimum so our answer should lie
     below 0.5 so we eliminate all the numbers which are greater than 0.5

     so our range becomes 0.4 to 0.5 if we consider 1 decimal place precision

     now answer could be 0.454 or 0.465463466 we don't know

     so if we find out the diff of the high - low then we can get the exact answer
     because at each time either the low or the high is getting equated with mid
     and the calculation of the mid ensures that as the iteration increases that
      many times the decimal value increases .

      and if the high - low  < 1e-6 that means that the value  of mid is becoming
      more precise than 1e-6 which we don't want and this  will also help us to
      terminate the while loop .






    * */

}


