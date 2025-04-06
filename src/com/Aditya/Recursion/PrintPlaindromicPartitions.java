package com.Aditya.Recursion;

public class PrintPlaindromicPartitions {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        for (int e : productExceptSelf(nums)) {
           System.out.println(e);
        }
        ;
    }
    static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int n = 1;
        for(int i = 0 ;i < nums.length;i++){
            for(int j = 0 ; j < nums.length;j++){
                if(j != i){
                    n = n * nums[j];
                }
            }
            answer[i] = n;
            n = 1;
        }

        return answer;
    }

}

