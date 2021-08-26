

/*
https://leetcode.com/problems/generate-parentheses/
Generate All parentheses
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class rec_generateAllParenthesis {

    List<String> result = new ArrayList<String>() ;

    public void helper (char[] slate, int slateIndx,int left, int right, int pCount)
    {
        //Backtracking
       if(left < right || left >pCount || right > pCount)
            return;

        //Base condition
        if(left==right && left==pCount) {
            result.add(new String(slate));
            return;
        }

        //Intermediate Nodes
        slate[slateIndx] = '(' ;
        helper(slate,slateIndx+1,left+1,right,pCount);
        slate[slateIndx] = ')' ;
        helper(slate,slateIndx+1,left,right+1,pCount);
    }

    public List<String> generateParenthesis(int n) {

        char[] slate = new char[2*n] ;
        helper(slate,0,0,0,n) ;
        return result;
    }

    public void print()
    {
        for(String s : result)
            System.out.println(s);
        System.out.println();
    }


    static ArrayList<String> result1 = new ArrayList<>();

    static void helper(int n,int open, int close,char[] slate, int slateIndex)
    {
        //backtracking
       // if(n<0) return ;

        if( open < close || open>n || close>n)
       //if( open>n || close>n)
         return ;

        //Base case
        if( open==close &&  open==n )
        {
            result1.add(new String(slate)) ;
            return ;
        }

        //Intermediate case
        slate[slateIndex] = '(' ;
        helper(n,open+1,close,slate,slateIndex+1) ;
        slate[slateIndex] = ')' ;
        helper(n,open,close+1,slate,slateIndex+1) ;
    }

    static String[] find_all_well_formed_brackets(int n) {
        helper (n,0,0,new char[2*n],0) ;

        String[] output = new String[result1.size()]  ;
        for(int i=0; i<result1.size();i++)
            output[i] = result1.get(i) ;
        return output ;
    }

    public static void main(String[] args) {
        rec_generateAllParenthesis r = new rec_generateAllParenthesis() ;
       // r.generateParenthesis(2) ;
       // r.print();

        String[] res = find_all_well_formed_brackets(1) ;
         for(String s:res)
             System.out.println(s);
    }
}
