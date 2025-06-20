package com.Aditya.Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
      int[] nums = new int[]{-1,0,1,2,-1,-4};
      for(List<Integer> list : tripletOptimal(nums)){
          System.out.println(list);
      }

    }

    //Brute force solution
    static List<List<Integer>> triplet(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list =  new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }

        List<List<Integer>> List =  new ArrayList<>();
        List.addAll(set);

        return List;
    }

    //Time Complexity : O(N^3)
//Space Complexity : O(t)  worst case every triplet is unique and adds up to zero then it is O(N^3)
//

//NOTE:
/* Here everytime we get a triplet a new List gets created . Then that list is stored inside the set.
On thing to observe over here is that the name of the list is same everytime we declare .
This doesn't means that the list which was pointing to a list then it starts pointing to new  list and the
previous list is derefferenced and gone for garbage collection.

Here are the Steps what is taking place :

You create a new list object: list1.

You assign it to list.

You add list1 to the set. Now the set holds a reference to list1.

In the next iteration, you again create a new list object: list2.

You assign it to the same variable name list, but now list points to list2.

You add list2 to the set. Now the set holds both list1 and list2.

➡️ No list is overwritten or lost as long as something (like the set) is still referencing it.

 */

    //Better Solution
    static List<List<Integer>> tripletBetter(int[] nums){
        Set<List<Integer>> set = new HashSet<>();
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j = i+1;j<nums.length;j++){
                k = -(nums[i] + nums[j]);
                if(set2.contains(k)){
                    List<Integer> list = new ArrayList<>(Arrays.asList(k,nums[i],nums[j]));
                    Collections.sort(list);
                    set.add(list);
                }
                set2.add(nums[j]);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        list.addAll(set);

        return list;
    }

    //Time complexity :O(N^2)
    //Space complexity:O(N^2)

    //Optimal Solution
    //Optimal Solution works for sorted array.
    static List<List<Integer>> tripletOptimal(int[] nums){
        int n = nums.length;
        List<List<Integer>> List  = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    List.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }else if(sum > 0){
                        k--;
                }else if(sum < 0){
                        j++;
                }
            }
        }

        return List;
    }
    //Time complexity:O(NlogN) + O(N * N) (approx)
    //Space complexity:O(t) -> number of triplet found . (Each list contains only three numbers therefore its constant it doesn't increase as the input increases)
}



