

/*
https://leetcode.com/problems/letter-case-permutation/
 Given string generate upper and lower cawe of below string

 char[] = "a1b2" ;

 */


import java.util.ArrayList;
import java.util.List;

public class rec_upperAndLowerCase {
    List<String> result = new ArrayList<String>() ;

    void print()
    {
        for(String s: result)
            System.out.println(s);
        System.out.println();
    }

    private void helper(String inStr, int len, String slate, int slatelen)
    {
        if(len == inStr.length()) {
            result.add(slate);
            return;
        }
        if(Character.isDigit(inStr.charAt(len))) {
            String s = slate+inStr.charAt(len) ;

            helper(inStr,len+1,s,slatelen+1);
        }
       else {
           String s1 = slate + Character.toLowerCase(inStr.charAt(len)) ;
           helper(inStr,len+1,s1,slatelen);
            String s2 = slate + Character.toUpperCase(inStr.charAt(len)) ;
            helper(inStr,len+1,s2,slatelen);
        }
    }

    private List<String> letterCasePermutation(String str)
    {
        String slate = "";
        helper(str,0,slate,0);
        return result ;
    }

    public static void main(String[] args) {
        rec_upperAndLowerCase r = new rec_upperAndLowerCase() ;
        r.letterCasePermutation("a1b2") ;
        r.print() ;
    }
}
