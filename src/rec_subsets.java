
/*
https://leetcode.com/problems/subsets/
Subsets :

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rec_subsets {
    ArrayList<String> result = new ArrayList<>() ;

    public void print()
    {
        for(String list:result) {
            System.out.println(list);
        }
        System.out.println();
    }

    public void helper(String nums, int index,char[] slate,int slateIndx)
    {
        if(index == nums.length()) {
            result.add(new String(slate,0,slateIndx)) ;
            return;
        }
        helper(nums,index+1,slate,slateIndx);
        slate[slateIndx] = nums.charAt(index) ;
        helper(nums,index+1,slate,slateIndx+1) ;
    }

     //public List<List<Integer>> subsets(int[] nums) {
     public String[] subsets(String nums) {

        helper(nums,0,new char[nums.length()],0) ;
        String [] s = new String[result.size()] ;
        for(int i=0;i<result.size();i++)
            s[i] = result.get(i) ;
        return s ;
    }

    public static void main(String[] args) {
        rec_subsets r = new rec_subsets() ;
        r.subsets(new String("xyz") ) ;
        r.print() ;
    }
}
