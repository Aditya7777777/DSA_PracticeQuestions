package com.Aditya.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,3};
        for (int e: majorityElementOptimal(nums)){
            System.out.print(e + " ");
        }
    }

    //Better Solution
    static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> Map = new HashMap<>();

        for(int i = 0;i<n;i++){
            if(Map.containsKey(nums[i])){
                Map.put(nums[i],Map.get(nums[i])+1);
            }else{
                Map.put(nums[i],1);
            }
        }

        for(HashMap.Entry<Integer,Integer> entry : Map.entrySet()){
            if(entry.getValue() > n/3){
                list.add(entry.getKey());
            }
        }


        return list;
    }
    //Time complexity:O(n)
    //Space complexity:O(n)

    //Optimal Solution
    //Similar to the moore Voting algorithm
    static List<Integer> majorityElementOptimal(int[] nums){
        int count1 = 0;
        int count2 = 0;
        int el1 = 0;
        int el2=0;
        int n = nums.length;
        List<Integer> list =  new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            if(count1 == 0 && nums[i]!= el2){
                count1 = 1;
                el1 = nums[i];
            }else if(count2 == 0 && nums[i]!= el1){
                count2 = 1;
                el2 = nums[i];
            }else if(el1 == nums[i]){
                count1++;
            }else if(el2 == nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i<n;i++){
            if(nums[i] == el1){
                count1++;
            }

            if(nums[i] == el2){
                count2++;
            }
        }

        if(count1 > n/3){
            list.add(el1);
        }

        if(count2 > n/3){
            list.add(el2);
        }

        return list;
    }

    //Time complexity : O(N)
    //Space complexity: O(N)
}

