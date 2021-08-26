/*
3 Sum
Given an integer array arr of size n, find all magic triplets in it.
Magic triplet is a group of three numbers whose sum is zero.
Note that magic triplets may or may not be made of consecutive numbers in arr.

Example One
Input: arr = [10, 3, -4, 1, -6, 9]
Output: [“10,-4,-6”, “3,-4,1”]
Example Two
Input: arr = [12, 34, -46]
Output: [“12,-46,34”]
Example Three
Input: arr = [0, 0, 0];
Output: [“0,0,0”]
Example Four
Input: arr = [-2, 2, 0 -2, 2];
Output: [“2,-2,0”]
Notes
Input Parameters: Function has one argument: array of integers arr.
Output: Function must return an array of strings. Each string (if any) in the array must represent a unique magic
triplet and strictly follow this format: “1,2,-3” (no whitespace, one comma between numbers).

Order of the strings in the array is insignificant. Order of the integers in any string is also insignificant. For
example, if [“1,2,-3”, “1,-1,0”] is a correct answer, then [“0,1,-1”, “1,-3,2”] is also a correct answer.

Triplets that only differ by order of numbers are considered duplicates, and duplicates must not be returned. For
example, if “1,2,-3” is a part of an answer, then “1,-3,2”, “-3,2,1” or any permutation of the same numbers may not
 appear in the same answer (though any one of them may appear instead of “1,2,-3”).

Constraints:
    1 <= n <= 2000
    -1000 <= any element of arr <= 1000
    arr may contain duplicate numbers.
    arr is not necessarily sorted.

 */

import java.util.*;

public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums.length<3) return new ArrayList<>() ;
        Set<List<Integer>> result = new HashSet<> () ;
        Arrays.sort(nums);

       for(int i=0;i<nums.length-2;i++) {
           int j=i+1  ;
           int k=nums.length-1 ;
           while(j<k) {
               int sum = nums[j]+nums[k]+nums[i] ;
               if(sum == 0) {
                   result.add(Arrays.asList(nums[j++],nums[k--],nums[i])) ;
               }else if( sum <0 ) j++ ;
               else k-- ;
           }
       }
        return new ArrayList<>(result) ;
    }

    static void print(List<List<Integer>> res)
    {
        for(int i=0;i<res.size();i++)
        {
            for(int j:res.get(i)) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        //List<List<Integer>> res = threeSum.threeSum(new int[]{10, 3, -4, 1, -6, 9}) ;
        //List<List<Integer>> res = threeSum.threeSum(new int[]{12, 34, -46}) ;
        //List<List<Integer>> res = threeSum.threeSum(new int[]{0,0,0}) ;
       //List<List<Integer>> res = threeSum.threeSum(new int[]{-2, 2, 0,-2, 2}) ;
       // List<List<Integer>> res = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}) ;
        //List<List<Integer>> res = threeSum.threeSum(new int[]{0,0}) ;
        //List<List<Integer>> res = threeSum.threeSum(new int[]{0,0,0,0}) ;
       // List<List<Integer>> res = threeSum.threeSum(new int[]{-2,0,1,1,2}) ;
        List<List<Integer>> res = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}) ;
//Expected
  //      [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]

        print(res) ;
    }
}
