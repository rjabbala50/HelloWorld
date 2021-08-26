
/*
Write a function that reverses a string. The input string is given as an array of characters char[].
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        You may assume all the characters consist of printable ascii characters.
        Example 1:
        Input: ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
*/

public class reversestring {
    public static void main(String[] args) {
        String s = new String("Raj") ;
        reverseString(s.toCharArray());
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        char c ;
        for(;i<=j;i++,j--) {
            c= s[i] ;
            s[i] =s[j] ;
            s[j] = c ;
        }
        for (char k:s)
            System.out.println(k);
    }
}
