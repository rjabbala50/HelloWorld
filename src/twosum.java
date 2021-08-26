
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {


    /**
    public static int[] twoSums(int[] nums, int target)
    {
        int[] output = new int[2];

        for(int i=0;i<nums.length;i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    output[0] = i;
                    output[1] = j;
                    break;
                }
            }
        }
        return output;
    }
*/
    /*
    public static int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for ( int j=0; j<nums.length;j++)
        {
            int complement = target-nums[j];
            if(map.containsKey(complement) && map.get(complement) != j)
            //if(map.containsKey(complement))
            {
                return new int[]{j, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
*/
    public static int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<>();

        for ( int j=0; j<nums.length;j++)
        {
            int complement = target-nums[j];
            if(map.containsKey(complement) && map.get(complement) != j)
            {
                return new int[]{j, map.get(complement)};
            }
            map.put(nums[j],j);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static boolean twoSumWothTwoPointers(int[] nums, int target)
    {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1 ;
        while(left<right)
        {
            int sum = nums[left]+nums[right] ;
            if (sum== target){
                return  true;
            }
            else if (sum< target) left++  ;
            else right-- ;
        }
        return false ;
    }

    public static void main (String[] args)
    {
        System.out.println(twoSumWothTwoPointers(new int[]{4,4,8},4));
        /*
        int[] input = new int[] {4,4,8} ;
        //int[] input = new int[] {3,3} ;

        int target = 8;
        int[] out = twoSum(input,target) ;
        for ( int i =0; i<out.length;i++)
        {
            System.out.print(out[i]);
        }

         */
    }
}
