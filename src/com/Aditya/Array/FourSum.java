package com.Aditya.Array;

import java.util.*;

public class FourSum {
    public static void main(String[] args){
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 8;

        for(List<Integer> e : fourSumOptimal(nums,target)){
            System.out.println(e);
        }
    }

    //Brute force solution
    static List<List<Integer>> fourSum(int[] nums,int target){
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    for(int l = k+1;l<n;l++){
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target){
                            List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(set);

        return list;
    }

    //Time complexity:O(N^4)
    //Space Complexity:O(t)


    //Better Solution
    static List<List<Integer>> fourSumBetter(int[] nums,int target){
      int n = nums.length;
      int l = 0;
      Set<List<Integer>> set = new HashSet<>();

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                Set<Integer> set2  = new HashSet<>();
                for(int k = j+1;k<n;k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    l = target-sum;
                    if(set2.contains(l)){
                        List<Integer> list = new ArrayList<>(Arrays.asList(l,nums[i],nums[j],nums[k]));
                        Collections.sort(list);
                        set.add(list);
                    }
                    set2.add(k);
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(set);

        return list;

    }

    //Time complexity:O(N^3)
    //Space complexity:O(N^3)

    //Optimal Solution
    static List<List<Integer>> fourSumOptimal(int nums[],int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> List = new  ArrayList<>();

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int k = j+1;
                int l = n-1;

                while(k<l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else {
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        List.add(list);
                        k++;
                        l--;
                        while(k < n && nums[k] == nums[k-1]) k++;
                        while(l > 0 && nums[l] == nums[l-1]) l--;
                    }
                }
            }
        }

        return List;
    }

}
