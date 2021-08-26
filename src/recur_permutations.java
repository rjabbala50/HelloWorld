/*
https://leetcode.com/problems/permutations/
Permutations
*/


import java.util.ArrayList;
import java.util.HashSet;

public class recur_permutations {

        ArrayList<String> result = new ArrayList<>() ;

        public void print()
        {
            for(String list:result) {
                System.out.println(list);
            }
            System.out.println();
        }

        private void swap(char[] num,int left, int right)
        {
            char temp = num[left] ;
            num[left] = num[right] ;
            num[right] = temp ;
        }

    public void helperNoDuplicates(String num,int indx, char[] slate)
    {
        if(indx == num.length()) {
            result.add(new String(slate)) ;
            return ;
        }
        HashSet<Character> visited = new HashSet<Character>() ;

        for(int k=indx;k<num.length();k++) {
            if(visited.contains(slate[k])) continue;
            else  {
                visited.add(slate[k]) ;
            }
            swap(slate,indx,k) ;
            helperNoDuplicates(num,indx+1,slate);
            swap(slate,indx,k) ;
        }
    }
        public void helper(String num,int indx, char[] slate)
        {
            if(indx == num.length()) {
                result.add(new String(slate)) ;
                return ;
            }
            for(int k=indx;k<num.length();k++) {
                if(k!=indx)
                    swap(slate,indx,k) ;
              helper(num,indx+1,slate);
                if(k!=indx)
                    swap(slate,indx,k) ;
            }
        }

        public void permute(String nums) {
            char[] slate = nums.toCharArray() ;
            helper(nums,0,slate) ;
            //helperNoDuplicates(nums,0,slate); ;
        }

        public static void main(String[] args) {
            recur_permutations r = new recur_permutations() ;
            r.permute(new String("12")); ;
            r.print() ;
        }
}
