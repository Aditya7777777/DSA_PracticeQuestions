package com.Aditya.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){

        int[][] intervals  = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        for(int[] element : merge2(intervals)){
            for(int e : element){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    //Brute force
    static int[][] merge(int[][] intervals){
        int n = intervals.length;

        List<List<Integer>> list = new ArrayList<>();
        boolean[] merged = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                    if(intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]){
                        intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                        intervals[j][1] = Math.max(intervals[i][1],intervals[j][1]);

                        list.add(new ArrayList<>(Arrays.asList(intervals[j][0],intervals[j][1])));

                        merged[i] = true;
                        merged[j] = true;
                        break;
                    }
            }
        }

        for(int i = 0;i<n;i++){
            if(!merged[i]){
                list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
            }
        }



        int[][] temp = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
                temp[i][0] = list.get(i).get(0);
                temp[i][1] = list.get(i).get(1);
        }

        return temp;

    }
    //Time complexity : O(N^2)
    //Space complexity: O(2*N)


    public static int[][] merge2(int[][] intervals) {
       if(intervals.length <= 1) return intervals;

       //Step 1 : Sort the intervals based on start elements of each array of intervals
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        //Step2 Merge the intervals
        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

       for(int  i = 0;i<intervals.length;i++){
           //if current intervals overlaps with the next
           if(intervals[i][0] <= current[1]){
               current[1] = Math.max(current[1],intervals[i][1]);
           }else{
               result.add(current);
               current = intervals[i];
           }
       }

       result.add(current);

       return result.toArray(new int[result.size()][]);
    }

    //Time complexity : O(NlogN)
    //Space complexity : O(N)
}

//gpt conversation : https://chatgpt.com/c/6864a526-92e8-8002-8c8c-1967adaace73



