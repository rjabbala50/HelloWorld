/*
Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine
if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


 */
import java.util.ArrayList;
import java.util.List ;

public class wordbreak {

    public void print (String s, List<String> wordDict)
    {
        System.out.println("s = " + s);
        System.out.println();
        System.out.println("wordDict = " + wordDict);
        System.out.println();
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()<=0  || wordDict.isEmpty()) return false ;

        /*
        //print(s,wordDict );
        for(String i :wordDict) {
           if(!s.contains(i)) return false ;
           s = s.replace(i," " );
          // System.out.println("s = " + s);
        }
        return true ;
        */
         //Dynamic programming.
        int n = s.length() ;
        boolean[] dp = new boolean[n+1] ;
        dp[0] = true;

        for(int i=0; i<=n;i++) {
            for(int j=i-1;j>=0;j--) {
              if( dp[j] && wordDict.contains(s.substring(j,i))) {
                dp[i] = true ;
                break;
              }
            }
         }
        return dp[n] ;
    }


    //Driver code.
    public static void main(String[] args) {
        wordbreak wb = new wordbreak() ;
        boolean TEST_CASE_1 = true;
        boolean TEST_CASE_2 = true ;
        boolean TEST_CASE_3 = true ;
        boolean TEST_CASE_4 = true ;

        //Test Case - 1
        if(TEST_CASE_1)
        {
            List<String> input = new ArrayList<String>();
            input.add("leet") ;
            input.add("code1") ;
            System.out.println("args = " + wb.wordBreak("leetcode",input));
        }

        //Test CAse -2
        if( TEST_CASE_2){
            List<String> input = new ArrayList<String>();
            input.add("apple") ;
            input.add("pen") ;
            System.out.println("args = " + wb.wordBreak("applepenapple",input ));
        }

        //Test CAse -3
        if( TEST_CASE_3)
        {
            List<String> input = new ArrayList<String>();
            input.add("cats") ;
            input.add("dog") ;
            input.add("and") ;
            input.add("cat1") ;
            System.out.println("args = " + wb.wordBreak("catsandog",input ));
        }
        /*Test CASe -4
        Input: "bb"
                ["a","b","bbb","bbbb"]
        Output: false
        Expected: true */
        if( TEST_CASE_4)
        {
            List<String> input = new ArrayList<String>();
            input.add("a") ;
            input.add("b") ;
            input.add("bbb") ;
            input.add("bbbb") ;
            System.out.println("args = " + wb.wordBreak("bb",input ));
        }

    }
}
