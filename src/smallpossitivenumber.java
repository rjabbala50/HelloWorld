
/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Follow up:

Your algorithm should run in O(n) time and uses constant extra space.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class smallpossitivenumber {

    public int firstMissingPositive(int[] nums) {

        Integer missing = new Integer(1) ;
        Set<Integer> spset = new HashSet<Integer>() ;

        for(int i:nums) {
            Integer k = new Integer(i) ;
            if(!spset.contains(k)) {
                if (i > 0) {
                    spset.add(k);
                }
                while (spset.contains(missing)) {
                        missing ++;
                }
            }
        }
        return missing.intValue() ;
    }

    public static void main(String[] args) {
        smallpossitivenumber sp = new smallpossitivenumber() ;
        System.out.println("firstMissingPositive = " + sp.firstMissingPositive(new int[]{1,2,4}));
        System.out.println("firstMissingPositive = " + sp.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println("firstMissingPositive = " + sp.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println("firstMissingPositive = " + sp.firstMissingPositive(new int[]{2,1}));
    }
}
