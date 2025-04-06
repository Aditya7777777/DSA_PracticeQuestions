package com.Aditya.Patterns;

class Solution{
    public int numberOfSteps(int num){
        int count = 0;
        while(num > 0){
            if(num %2 == 0){
                num = num/2;
            }else{
                num = num-1;
            }
            count++;
        }
        return count;
    }
}
public class Main {
    public static void main(String[] args) {
        int num = 14;
        Solution s = new Solution();
        int ans = s.numberOfSteps(num);
        System.out.println(ans);
    }
}

