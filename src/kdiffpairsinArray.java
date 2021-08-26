/*
K-diff Pairs in an Array

Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

    0 <= i, j < nums.length
    i != j
    a <= b
    b - a == k

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2

Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2

Constraints:

    1 <= nums.length <= 104
    -107 <= nums[i] <= 107
    0 <= k <= 107

 */

import java.util.HashMap;

public class kdiffpairsinArray {
    public int findPairs(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>() ;
        for (int i=0;i< nums.length;i++) {
            for(int j=0;j<nums.length;j++) {
                if( (i!=j) && (nums[j] <= nums[j]) && (nums[i]-nums[j] == k)) {
                    hm.put(nums[j],nums[i]) ;
                }
            }
        }
       // System.out.println("hm = " + hm);
    return hm.size() ;
    }

    public static void main(String[] args) {
        kdiffpairsinArray kd = new kdiffpairsinArray() ;
        int TC_1 = 0 ;
        int TC_2 = 0 ;
        int TC_3 = 0 ;
        int TC_4 = 0 ;
        int TC_5 = 0 ;
        int TC_6 = 1 ;


        if(TC_1 == 1) {
            if(kd.findPairs(new int[]{1,2,3},2) ==1) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

        if(TC_2==1) {
            if(kd.findPairs(new int[]{3,1,4,1,5},2) == 2) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

        if(TC_3==1) {
            if(kd.findPairs(new int[]{1,2,3,4,5},1)==4) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

        if(TC_4==1) {
            if(kd.findPairs(new int[]{1,3,1,5,4},0)==1) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

        if(TC_5==1) {
            if(kd.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3},3)==2) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

        if(TC_6==1){
            if(kd.findPairs(new int[]{-1,-2,-3},1)==2) {
                System.out.println("TC PAss " );
            }
            else  {
                System.out.println("TC Fail " );
            }
        }

    }
}
