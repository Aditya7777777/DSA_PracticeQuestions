//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

    }

    static int maxSubArray(int[] nums) {
        int ans = 0;
        int sum  = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum > ans){
                    ans = sum;
                }
            }
            sum = 0;
        }

        return ans;
    }


}