
/*
Find out subsets whose sum equals target.
*/

import java.util.ArrayList;
import java.util.List;

public class rec_subsetsum {

    List<String> result = new ArrayList<String>() ;


    private void helper(int[] nums, int numIndx,int target,int cursum, int[] slate,int slateIndx )
    {
        //Input Validations
        //TBD

        //Backtracking cases
        if(cursum >target)
            return;

        if(cursum == target) {
            StringBuilder s = new StringBuilder() ;
            for(int i=0;i<slateIndx;i++)
                s.append(Integer.toString(slate[i])) ;
            result.add(s.toString()) ;
            return;
        }
        //Base case
        if(numIndx == nums.length)
            return;

        //Intermediate nodes case
        helper(nums,numIndx+1,target,cursum,slate,slateIndx);
        slate[slateIndx] = nums[numIndx] ;
        cursum += nums[numIndx] ;
        helper(nums,numIndx+1,target,cursum,slate,slateIndx+1);
    }

    private void canPartitionKSubsets(int[] nums, int k) {
        int[] slate = new int[nums.length+1] ;
        helper(nums,0,k,0,slate,0) ;
    }

    private void print()
    {
        for(String str:result) {
            System.out.println(str);
        }
        System.out.println();
    }
/*
Possible To Achieve Target Sum




    static boolean result = false ;
    static boolean helper(long[] arr, int arrIndex, long target, long curSum,long[] slate, int slateIndex)
    {
        //backtrack conditions
       // if(curSum >target)
         //   return result;

        if(curSum == target) {
            result = true ;
            return result;
        }

        //base condition
        if(arrIndex >= arr.length) {
            return result;
        }

        //Intermediater node
        helper(arr,arrIndex+1,target,curSum,slate,slateIndex) ;
        slate[slateIndex] = arr[arrIndex] ;
        helper(arr,arrIndex+1,target,curSum+arr[arrIndex],slate,slateIndex+1) ;

        return result ;
    }

    static boolean check_if_sum_possible(long[] arr, long k) {
        int val = 0;

        return helper(arr,val,k,val,new long[arr.length],val) ;

    }


 */

    /*
    Possible To Achieve Target Sum?

Possible To Achieve Target Sum?


Given a set of integers and a target value k, find a non-empty subset that sums up to k.


Example One

Input: [2 4 8], k = 6

Output: True

Because 2+4=6.


Example Two

Input: [2 4 6], k = 5

Output: False

Because no subset of numbers from the input sums up to 5.


Notes

Input Parameters: Function has two arguments: an array of integers (their order doesn’t matter) and the target value  k.


Output: Function must return a boolean value.


Constraints:

    1 <= size of the input array <= 18
    -10^12 <= elements of the array, k <= 10^12
     */


    static boolean result1 = false ;

    static boolean helper(long[] arr,int arrIndex,long[] slate, int slateIndex, long target, long curSum)
    {
        //base condition
        if ( arrIndex >= arr.length )
        {
            if(slateIndex == 0) return  result1 ;

            if( curSum == target ) {
                result1 = true;
                return result1;
            }
            else return result1 ;
        }

        //Intermediate node
        helper(arr,arrIndex+1,slate,slateIndex,target,curSum) ;
        slate[slateIndex] = arr[arrIndex] ;
        helper(arr,arrIndex+1,slate,slateIndex+1,target, curSum+arr[arrIndex]) ;

        return result1 ;
    }


    static   boolean check_if_sum_possible(long[] arr, long k) {

        return helper(arr,0,new long[arr.length],0,k,0)    ;

    }


    public static void main(String[] args) {
        rec_subsetsum r = new rec_subsetsum() ;
       // r.canPartitionKSubsets(new int[]{10,20},0) ;
        //r.print() ;
        //long[] arr = {10,20};
        //long[] arr = {2,4,6};
        //long[] arr = {1,-1,0} ;
        long[] arr = {0} ;
        System.out.println(check_if_sum_possible(arr,0));

    }
}