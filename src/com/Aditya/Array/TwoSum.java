package com.Aditya.Array;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,5,8,11};
        int[] ans = twoSum(arr,14);

        System.out.println(ans[0]+"  "+ ans[1]);

    }

    static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int check = 0;
        for(int i = 0;i<arr.length;i++){
            check = arr[i];
            int x = target - check;
            if(map.containsKey(x)){
                return new int[]{map.get(x),i};
            }

            map.put(check,i);
        }

        return new int[]{-1,-1};
    }
}
