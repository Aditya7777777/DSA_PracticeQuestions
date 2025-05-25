package com.Aditya.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args){
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> list = new ArrayList<>();
        list = combinationSum(candidates,target);

        for(List<Integer> e: list){
            System.out.print(e+" ");
        }

    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> List = new ArrayList<>();
        int index = 0;
         helper(candidates,index,target,list,List);
         return List;

    }

    private static void helper(int[] candidates,int index, int target, List<Integer> list,List<List<Integer>> List) {

           if(target == 0){
               List.add(new ArrayList<>(list)); //List.add(list) just adds a reference to the list and List.add(new ArrayList<>(list)); adds copy of the list
               return;
           }
           if(index> candidates.length-1){
               return;
           }
            if(target-candidates[index] >= 0) {
                list.add(candidates[index]);
                 helper(candidates, index, target - candidates[index], list , List);
                list.remove(Integer.valueOf(candidates[index]));//You're using list.remove(candidates[index]), which tries to remove an element at a specific index, because Java's ArrayList.remove(int index) removes an element by position, not by value.
                //so here we passed an Object rather than integer. if we pass the integer it will try to look at the position not the value which we are trying to remove .
            }

            helper(candidates,index+1,target,list,List);
    }
}
