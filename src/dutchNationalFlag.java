

/*
Dutch National Flag

Dutch National Flag


Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.


Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.


This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).


Example

Input: [G, B, G, G, R, B, R, G]

Output: [R, R, G, G, G, G, B, B]


There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.


Notes

Input Parameters: An array of characters named balls, consisting of letters from {‘R’, ‘G’, ‘B’}.


Output: Return type is void. Modify the input character array by rearranging the characters in-place.


Constraints:

    1 <= n <= 100000
    Do this in ONE pass over the array - NOT TWO passes, just one pass.
    Solution is only allowed to use constant extra memory.
 */


public class dutchNationalFlag {
    public static void swap(char[] balls, int left, int right)
    {
        char temp = balls[left] ;
        balls[left] = balls[right] ;
        balls[right] = temp ;
    }

    public static void dutch_flag_sort(char[] balls) {

        int rp = 0;
        int bp = balls.length-1 ;
        int i = 0 ;
        while(i<=bp)
        {
            if(balls[i] == 'G') {
                i++ ;
            }
            else if(balls[i] == 'R') {
                swap(balls,i,rp) ;
                rp++ ;
                i++ ;
            }
            else if(balls[i] == 'B') {
                swap(balls,i,bp) ;
                bp-- ;
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(lexicographicString(new String("zuckerberg"), new String("twain")));
        // merger_first_into_second(new int[] {1,2,3},new int[] {4,5,6,0,0,0});

        //dutch_flag_sort(new char[] {'G','B','G','G','R','B','R','G'}) ;
        // 8 G B G G R B R G
    }
}
