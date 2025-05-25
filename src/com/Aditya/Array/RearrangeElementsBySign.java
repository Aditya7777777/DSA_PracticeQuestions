package com.Aditya.Array;

public class RearrangeElementsBySign {
    public static void main(String[] args){
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        for(int e : rearrangeArrayOptimized(nums)){
            System.out.print(e+ " ");
        }



    }

    //Better solution
    static int[] rearrangeArray(int[] nums) {
        int[] positives = new int[nums.length/2];
        int[] negatives = new int[nums.length/2];
        int i = 0, j = 0;
        for(int z = 0;z < nums.length;z++){
            if(nums[z] < 0){
                negatives[i] = nums[z];
                i++;
            }

            if(nums[z] > 0){
                positives[j] = nums[z];
                j++;
            }
        }

        //Now storing in the original array
        i = 0;j = 0;
        for(int x = 0;x < nums.length;x++){
            if(x%2 == 0){
                nums[x] = positives[i];
                i++;
            }else{
                nums[x] = negatives[j];
                j++;
            }
        }

        return nums;

    }
    //Time complexity : O(2N)
    //Space complexity : O(N)

    //Optimized solution
   static int[] rearrangeArrayOptimized(int[] nums){
        int negIndx = 1;
        int posiIndx = 0;
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0;i < n; i++){
            if(nums[i] < 0){
                ans[negIndx] = nums[i];
                negIndx += 2;
            }else{
                ans[posiIndx] = nums[i];
                posiIndx += 2;
            }
        }

        return ans;
   }
}
