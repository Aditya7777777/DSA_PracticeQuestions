import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        int[] arr =  new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7};
        Arrays.sort(arr);

        for(int e : arr){
            System.out.print(e + " ");
        }
    }
}
